package controller;

import dbConn.ConnectionMaker;
import model.ReviewDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewController {
    private Connection connection;

    public ReviewController(ConnectionMaker connectionMaker) {
        this.connection = connectionMaker.makeConnection();
    }

    public void insert(ReviewDTO reviewDTO) {
        String query = "INSERT INTO `review`(`writerId`, `filmId`, `score`, `review`) " +
                "VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, reviewDTO.getWriterId());
            pstmt.setInt(2, reviewDTO.getFilmId());
            pstmt.setInt(3, reviewDTO.getScore());
            pstmt.setString(4, reviewDTO.getReview());

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ReviewDTO> selectAll() {
        ArrayList<ReviewDTO> list = new ArrayList<>();

        String query = "SELECT * FROM `review` ORDER BY `id` DESC";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                ReviewDTO r = new ReviewDTO();
                r.setId(resultSet.getInt("id"));
                r.setWriterId(resultSet.getInt("writerId"));
                r.setFilmId(resultSet.getInt("filmId"));
                r.setScore(resultSet.getInt("score"));
                r.setReview(resultSet.getString("review"));

                list.add(r);
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ReviewDTO selectOne(int id) {
        ReviewDTO reviewDTO = null;
        String query = "SELECT * FROM `review` WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                reviewDTO = new ReviewDTO();
                reviewDTO.setId(resultSet.getInt("id"));
                reviewDTO.setWriterId(resultSet.getInt("writerId"));
                reviewDTO.setFilmId(resultSet.getInt("filmId"));
                reviewDTO.setScore(resultSet.getInt("score"));
                reviewDTO.setReview(resultSet.getString("review"));
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviewDTO;
    }

    public void update(ReviewDTO reviewDTO) {
        String query = "UPDATE `review` SET `writerId` = ?, `filmId` = ?, `score` = ?, `review` = ? WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, reviewDTO.getWriterId());
            pstmt.setInt(2, reviewDTO.getFilmId());
            pstmt.setInt(3, reviewDTO.getScore());
            pstmt.setString(4, reviewDTO.getReview());
            pstmt.setInt(5, reviewDTO.getId());

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM `review` WHERE `id` = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

