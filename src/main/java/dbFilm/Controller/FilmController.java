package dbFilm.Controller;

import dbFilm.model.FilmDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmController {
    private Connection connection;
    private FilmDTO filmDTO;

    public FilmController(Connection connection) {
        this.connection = connection;
    }

    public void insert(FilmDTO filmDTO) {
        String query = "INSERT INTO `board`(`title`, `description`, `release_year`, `rental_duration`, `rental_rate` , `length`, `special_features`) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, filmDTO.getTitle());
            pstmt.setString(2, filmDTO.getDescription());
            pstmt.setInt(3, filmDTO.getRelease_year());
            pstmt.setInt(4, filmDTO.getRental_duration());
            pstmt.setDouble(5, filmDTO.getRental_rate());
            pstmt.setInt(6, filmDTO.getLength());
            pstmt.setString(7, filmDTO.getSpecial_features());


            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<FilmDTO> selectAll() {

        ArrayList<FilmDTO> list = new ArrayList<>();

        String query = "SELECT * FROM `film` ORDER BY `film_id`";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                FilmDTO f = new FilmDTO();
                f.setFilm_id(resultSet.getInt("film_id"));
                f.setTitle(resultSet.getString("title"));
                f.setDescription(resultSet.getString("description"));
                f.setRelease_year(resultSet.getInt("release_year"));
                f.setRental_duration(resultSet.getInt("rental_duration"));
                f.setRental_rate(resultSet.getDouble("rental_rate"));
                f.setLength(resultSet.getInt("length"));
                f.setSpecial_features(resultSet.getString("special_features"));


                list.add(f);
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public FilmDTO selectOne(int film_id) {


        String query = "SELECT * FROM `film` WHERE `film_id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, film_id);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                FilmDTO filmDTO = new FilmDTO();

                filmDTO.setFilm_id(resultSet.getInt("film_id"));
                filmDTO.setTitle(resultSet.getString("title"));
                filmDTO.setDescription(resultSet.getString("description"));
                filmDTO.setRelease_year(resultSet.getInt("release_year"));
                filmDTO.setRental_duration(resultSet.getInt("rental_duration"));
                filmDTO.setRental_rate(resultSet.getDouble("rental_rate"));
                filmDTO.setLength(resultSet.getInt("length"));
                filmDTO.setSpecial_features(resultSet.getString("special_features"));
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filmDTO;
    }

    public void update(FilmDTO filmDTO) {
        String query = "UPDATE `film` SET `title` = ?, `description` = ?, `release_year` = ?, `rental_duration` = ?, `rental_rate` = ?, `length` = ? , `special_features` = ? WHERE `film_id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, filmDTO.getTitle());
            pstmt.setString(2, filmDTO.getDescription());
            pstmt.setInt(3, filmDTO.getRelease_year());
            pstmt.setInt(4, filmDTO.getRental_duration());
            pstmt.setDouble(5, filmDTO.getRental_rate());
            pstmt.setInt(6, filmDTO.getLength());
            pstmt.setString(7, filmDTO.getSpecial_features());

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int film_id) {
        String query = "DELETE FROM `film` WHERE `film_id` = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, film_id);

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}









