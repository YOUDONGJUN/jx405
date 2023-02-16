package controller;

import connector.ConnectionMaker;
import model.FilmDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmController {

    private final int PAGE_SIZE = 10;
    private Connection connection;

    public FilmController(ConnectionMaker connectionMaker) {
        this.connection = connectionMaker.makeConnection();
    }

    public void insert(FilmDTO filmDTO) {
        String query = "INSERT INTO `film`(`title`, `summary`, `rating`) " +
                "VALUES(?, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, filmDTO.getTitle());
            pstmt.setString(2, filmDTO.getSummary());
            pstmt.setInt(3, filmDTO.getRating());

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<FilmDTO> selectAll(int pageNo) {
        ArrayList<FilmDTO> list = new ArrayList<>();

        String query = "SELECT * FROM `film` ORDER BY `id` DESC LIMIT ?,?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                FilmDTO f = new FilmDTO();
                f.setId(resultSet.getInt("id"));
                f.setTitle(resultSet.getString("title"));
                f.setSummary(resultSet.getString("summary"));
                f.setRating(resultSet.getInt("rating"));

                list.add(f);
            }
            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public FilmDTO selectOne(int id) {
        FilmDTO filmDTO = null;
        String query = "SELECT * FROM `film` WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                filmDTO = new FilmDTO();
                filmDTO.setId(resultSet.getInt("id"));
                filmDTO.setTitle(resultSet.getString("title"));
                filmDTO.setSummary(resultSet.getString("summary"));
                filmDTO.setRating(resultSet.getInt("rating"));

            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filmDTO;
    }

    public void update(FilmDTO filmDTO) {
        String query = "UPDATE `film` SET `title` = ?, `summary` = ?, `rating` = ? WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, filmDTO.getTitle());
            pstmt.setString(2, filmDTO.getSummary());
            pstmt.setInt(3, filmDTO.getRating());
            pstmt.setInt(4, filmDTO.getId());

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM `film` WHERE `id` = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int countTotalPage() {
        int totalPage = 0;
        String query = "SELECT COUNT(*) FROM `film`";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

            totalPage = count / PAGE_SIZE;
            if (count % PAGE_SIZE != 0) {
                totalPage++;
            }

            pstmt.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalPage;
    }

}















