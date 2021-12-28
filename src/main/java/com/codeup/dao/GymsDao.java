package com.codeup.dao;

import com.codeup.models.Gyms;
import com.mysql.cj.jdbc.Driver; //added this after all was written. got from java3 assessment


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GymsDao {
    private Connection connection = null;

    public GymsDao(Config config){
        try{
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getURL(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e){
            throw new RuntimeException("Error, my man, we cannot connect to the base of all data!", e);
        }
    }

    private Gyms extract(ResultSet rs) throws SQLException{
        return new Gyms(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("type"),
                rs.getDouble("membership")
        );
    }

    private List<Gyms> createFromResultSet(ResultSet rs) throws SQLException{
        List<Gyms> gyms = new ArrayList<>();
        while (rs.next()) {
            gyms.add(extract(rs));
        }
        return gyms;
    }

    private List<Gyms> all(){
        PreparedStatement stmt = null;
        try{
            stmt = connection.prepareStatement("SELECT * FROM gym");
            ResultSet rs = stmt.executeQuery();
            return createFromResultSet(rs);
        } catch(SQLException e){
            throw new RuntimeException("Error retrieving the gyms, my dude.", e);
        }
    }

    public Long insert(Gyms gyms){
        try{
            String insertQuery = "INSERT INTO gym(name, type, membership) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, gyms.getName());
            stmt.setString(2, gyms.getType());
            stmt.setDouble(3, gyms.getMembership());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Yo mayngs, we cannot insert the gym", e);
        }
    }

    public void delete(Long id){
        try{
            String insertQuery = "DELETE FROM gym WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Deletion error of gym #" + id, e);
        }
    }
}
