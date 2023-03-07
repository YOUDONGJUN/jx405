package controller;

import connector.ConnectionMaker;
import model.UserDTO;

import java.sql.*;

public class UserController {
    private Connection connection;

    public UserController(ConnectionMaker connectionMaker) {
        this.connection = connectionMaker.makeConnection();
    }

    public boolean insert(UserDTO userDTO) {
        String query = "INSERT INTO `user`(`userId`, `password`, `name`, `birthDate`, `phoneNumber`, `email`) VALUES(?, ?, ?, ?, ?,?)";
        System.out.println(userDTO.getUserId());
        System.out.println(userDTO.getPassword());
        System.out.println(userDTO.getName());
        System.out.println(userDTO.getPhoneNumber());
        System.out.println(userDTO.getEmail());
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, userDTO.getUserId());
            pstmt.setString(2, userDTO.getPassword());
            pstmt.setString(3, userDTO.getName());
            Date temp = new Date(userDTO.getBirthDate().getTime());
            pstmt.setDate(4, temp);
            pstmt.setString(5, userDTO.getPhoneNumber());
            pstmt.setString(6, userDTO.getEmail());

            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    public UserDTO auth(String userId, String password) {
        String query = "SELECT * FROM `user` WHERE `userId` = ? AND `password` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, userId);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                UserDTO userDTO = new UserDTO();
                userDTO.setUserId(resultSet.getString("userId"));
                userDTO.setPassword(resultSet.getString("password"));
                return userDTO;
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(UserDTO userDTO) {
        String query = "UPDATE `user` SET `password` = ?, `name` = ? , `phoneNumber` = ?, `email` = ? WHERE `id` = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, userDTO.getPassword());
            pstmt.setString(2, userDTO.getName());
            pstmt.setString(3, userDTO.getPhoneNumber());
            pstmt.setString(4, userDTO.getEmail());

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE  FROM `user` WHERE `id` = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDTO selectOne(int id) {
        UserDTO u = null;
        String query = "SELECT * FROM `user` WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                u = new UserDTO();
                u.setUserId(resultSet.getString("userId"));
                u.setName(resultSet.getString("name"));
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }
}


