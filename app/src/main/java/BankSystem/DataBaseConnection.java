/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author adel
 */
public class DataBaseConnection {

    private static String host = "jdbc:mysql://localhost/banksystem";
    private static String userName = "root";
    private static String password = "";
    public static Connection Instance;
    public static Connection getInstance () throws SQLException
    {
        if(Instance == null)
            Instance = DriverManager.getConnection(host, userName, password);
        return Instance;
    }
}
