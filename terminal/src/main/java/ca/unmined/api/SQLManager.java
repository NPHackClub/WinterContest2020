package ca.unmined.api;

import java.sql.*;
import java.util.ArrayList;

public class SQLManager {

    public static ArrayList<UserUtil> getUserListFromQuery(String sql) {
        try {
            Connection conn = getConnection();
            assert conn != null;


            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            ArrayList<UserUtil> out = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String info = rs.getString("info");

                out.add(new UserUtil(id, username, password, name, info));
            }

            return out;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static UserUtil getUserFromQuery(String sql) {
        try {
            Connection conn = getConnection();
            assert conn != null;

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return new UserUtil(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("info"));
            }
            else return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void validApiKey(String key) {
        try (Connection conn = getConnection()) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void sendQuery(String sql) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void sendQuery(String sql, boolean exec) {
        try {
            Connection conn =getConnection();
            assert conn != null;

            Statement stmt = conn.createStatement();
            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String getQuery(String sql) {
        try {
            Connection conn = getConnection();
            assert conn != null;

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void fixIndices() {
        int len = Integer.parseInt(getQuery("SELECT COUNT(*) FROM site_database.user"));

        System.out.println(len);
        sendQuery("ALTER TABLE site_database.users AUTO_INCREMENT = " + (len + 1), false);
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://10.0.0.139:3306/site_database?useSSL=false";
            return DriverManager.getConnection(url, "root", "Rcal20050914%");

        } catch (IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
