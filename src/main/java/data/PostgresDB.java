package data;

import data.interfaces.IDB;

import javax.ws.rs.ServerErrorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IDB {

    @Override
    public Connection getConnection() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/simpledb";
        try {
            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "0000");

            return con;
        } catch (Exception e) {
            throw new ServerErrorException("Cannot connect to DB", 500);
        }
    }
}