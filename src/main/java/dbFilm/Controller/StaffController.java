package dbFilm.Controller;

import dbFilm.model.StaffDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StaffController {
    private Connection connection;
    private StaffDTO staffDTO;
//    private CustomerDTO customerDTO;

    public StaffController(Connection connection) {
        this.connection = connection;
    }

    public boolean insert(StaffDTO staffDTO) {
        String query = "INSERT INTO `customer`(`staff_id`, `username`, `password`, `address_id`, `store_id`) VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, staffDTO.getStaff_id());
            pstmt.setString(2, staffDTO.getUsername());
            pstmt.setString(3, staffDTO.getPassword());
            pstmt.setInt(4, staffDTO.getAddress_id());
            pstmt.setInt(5, staffDTO.getStore_id());

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    public StaffDTO auth(String username, String password) {
        String query = "SELECT * FROM `staff` WHERE `username` = ? AND `password` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                StaffDTO staffDTO = new StaffDTO();
                staffDTO.setStaff_id(resultSet.getInt("staff_id"));
                staffDTO.setUsername(resultSet.getString("username"));
                staffDTO.setPassword(resultSet.getString("password"));

                return staffDTO;
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(StaffDTO staffDTO) {
        String query = "UPDATE `staff` SET `username` = ?, `password` = ? ,,`address_id`=?, `store_id` =? WHERE `staff_id` = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, staffDTO.getUsername());
            pstmt.setString(2, staffDTO.getPassword());
            pstmt.setInt(3, staffDTO.getAddress_id());
            pstmt.setInt(4, staffDTO.getStore_id());


            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int staff_id) {
        String query = "DELETE  FROM `staff` WHERE `staff_id` = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, staff_id);

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public StaffDTO selectOne(int staff_id) {
        StaffDTO s = null;
        String query = "SELECT * FROM `staff` WHERE `staff_id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, staff_id);

            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                s = new StaffDTO();
                s.setStaff_id(resultSet.getInt("staff_id"));
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }


    public ArrayList<StaffDTO> selectAll() {
        ArrayList<StaffDTO> list = new ArrayList<>();

        String query = "SELECT * FROM `staff` ORDER BY `id`";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                StaffDTO s = new StaffDTO();
                s.setStaff_id(resultSet.getInt("staff_id"));
                s.setUsername(resultSet.getString("username"));
                s.setPassword(resultSet.getString("password"));
                s.setAddress_id(resultSet.getInt("address_id"));
                s.setStore_id(resultSet.getInt("store_id"));

                list.add(s);
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


}















