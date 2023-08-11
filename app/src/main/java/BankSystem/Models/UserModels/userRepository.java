/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Models.UserModels;

import BankSystem.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 *
 * @author adel
 */
public class userRepository {

    private static Connection dataBase;
    private static Statement statement;
    private static String query;

    private static void intializeDataBase() throws SQLException {
        dataBase = DataBaseConnection.getInstance();
        statement = dataBase.createStatement();
    }

    public static Boolean createUser(UserModel registeredUser) throws SQLException {
        intializeDataBase();
        query = "insert into user values ('" + registeredUser.getId() + "', '" + registeredUser.getFirstName() + "', "
                + "'" + registeredUser.getLastName() + "','" + registeredUser.getAddress() + "' , '" + registeredUser.getSSN() + "'"
                + " ,'" + registeredUser.getPassword() + "', '" + registeredUser.getUserName() + "','" + registeredUser.getEmail() + "' );";
        return (!statement.execute(query));
    }

    public static UserModel getUserByUserName(String userName) throws SQLException {
        intializeDataBase();
        query = "select * from `user` where `user_name`   = ?";
        PreparedStatement prepStatment = dataBase.prepareStatement(query);
        prepStatment.setString(1, userName);
        ResultSet userFromDataBase = prepStatment.executeQuery();

        UserModel targetUser = new UserModel();
        while (userFromDataBase.next()) {
            targetUser.setPassword(userFromDataBase.getString("password"));
            targetUser.setId(UUID.fromString((userFromDataBase.getString("id"))));
            targetUser.setEmail(userFromDataBase.getString("Email"));
            targetUser.setSSN(userFromDataBase.getString("SSN"));
            targetUser.setAddress(userFromDataBase.getString("address"));
            targetUser.setFirstName(userFromDataBase.getString("first_name"));
            targetUser.setLastName(userFromDataBase.getString("last_name"));
            targetUser.setUserName(userFromDataBase.getString("user_name"));
        }
        return targetUser;
    }

    public static UserModel getUserById(UUID userId) throws SQLException {
        intializeDataBase();
        query = "select * from `user` where `id`   = ?";
        PreparedStatement prepStatment = dataBase.prepareStatement(query);
        prepStatment.setString(1, userId.toString());
        ResultSet userFromDataBase = prepStatment.executeQuery();

        UserModel targetUser = new UserModel();
        while (userFromDataBase.next()) {
            targetUser.setPassword(userFromDataBase.getString("password"));
            targetUser.setId(UUID.fromString((userFromDataBase.getString("id"))));
            targetUser.setEmail(userFromDataBase.getString("Email"));
            targetUser.setSSN(userFromDataBase.getString("SSN"));
                targetUser.setAddress(userFromDataBase.getString("address"));
            targetUser.setFirstName(userFromDataBase.getString("first_name"));
            targetUser.setLastName(userFromDataBase.getString("last_name"));
            targetUser.setUserName(userFromDataBase.getString("user_name"));
        }
        return targetUser;
    }

    public static String getUserNameById(UUID userId) throws SQLException {
        intializeDataBase();
        query = "select user_name from `user` where `id`= ?";
        PreparedStatement prepStatment = dataBase.prepareStatement(query);
        prepStatment.setString(1, userId.toString());
        ResultSet userFromDataBase = prepStatment.executeQuery();

        String userName = "";
        while (userFromDataBase.next()) {
            userName = userFromDataBase.getString("user_name");
        }
        return userName;
    }

}
