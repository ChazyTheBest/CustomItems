package org.custom.items;

import java.sql.*;


public class DB
{
    private static Connection connection;

    public static void checkConnection(String host, String port, String dbname, String user, String pwd) throws SQLException
    {
        StringBuilder url = new StringBuilder("jdbc:mysql://")
                                      .append(host).append(":")
                                      .append(port).append("/")
                                      .append(dbname);

        connection = DriverManager.getConnection(url.toString(), user, pwd);
    }

    public static ResultSet get(String query) throws SQLException
    {
        return connection.createStatement().executeQuery(query);
    }

    public static PreparedStatement prepare(String query) throws SQLException
    {
        return connection.prepareStatement(query);
    }
}
