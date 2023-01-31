package dbFilm.Controller;

import dbFilm.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerController {
    private Connection connection;
//    private CustomerDTO customerDTO;

    public CustomerController(Connection connection) {
        this.connection = connection;
    }

    public boolean insert(CustomerDTO customerDTO) {
        String query = "INSERT INTO `customer`(`id`, `first_name`, `last_name`, `email`, `address_id`, `create_date`, `last_update`) VALUES(?, ?, ?, ?, ? ,?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, customerDTO.getCustomer_id());
            pstmt.setString(2, customerDTO.getFirst_name());
            pstmt.setString(3, customerDTO.getLast_name());
            pstmt.setString(4, customerDTO.getEmail());
            pstmt.setInt(5, customerDTO.getAddress_id());
            pstmt.setDate(6, (Date) customerDTO.getCreate_date());
            pstmt.setDate(7, (Date) customerDTO.getLast_update());

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    public CustomerDTO auth(String first_name, String last_name) {
        String query = "SELECT * FROM `staff` WHERE `staff_id` = ? AND `first_name` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setCustomer_id(resultSet.getInt("id"));
                customerDTO.setFirst_name(resultSet.getString("first"));
                customerDTO.setLast_name(resultSet.getString("last_name"));

                return customerDTO;
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(CustomerDTO customerDTO) {
        String query = "UPDATE `customer` SET `first_name` = ?, `last_name` = ? , `email` =?, `address_id`=? WHERE `id` = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, customerDTO.getFirst_name());
            pstmt.setString(2, customerDTO.getLast_name());
            pstmt.setString(3, customerDTO.getEmail());
            pstmt.setInt(4, customerDTO.getAddress_id());


            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE  FROM `customer` WHERE `id` = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CustomerDTO selectOne(int id) {
        CustomerDTO c = null;
        String query = "SELECT * FROM `customer` WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                c = new CustomerDTO();
                c.setCustomer_id(resultSet.getInt("id"));
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }


    public ArrayList<CustomerDTO> selectAll() {
        ArrayList<CustomerDTO> list = new ArrayList<>();

        String query = "SELECT * FROM `customer` ORDER BY `id` limit 10";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                CustomerDTO c = new CustomerDTO();
                c.setCustomer_id(resultSet.getInt("customer_id"));
                c.setStore_id(resultSet.getInt("store_id"));
                c.setFirst_name(resultSet.getString("first_name"));
                c.setLast_name(resultSet.getString("last_name"));
                c.setEmail(resultSet.getString("email"));
                c.setAddress_id(resultSet.getInt("address_id"));
                c.setCreate_date(resultSet.getDate("create_date"));
                c.setLast_update(resultSet.getDate("last_update"));


                list.add(c);
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


}















