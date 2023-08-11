/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Controllers;

import BankSystem.Models.UserModels.UserModel;
import BankSystem.Models.UserModels.userRepository;
import java.sql.SQLException;

/**
 *
 * @author adel
 */
public class UserController {

    public UserController() {
    }

    public static String login(String userName, String Password) throws SQLException {
        if ("admin".equals(userName) && "admin".equals(Password)) {
            return "admin";
        } else {
            UserModel toLoginUser = userRepository.getUserByUserName(userName);
            if (toLoginUser.getUserName().equals(userName) && toLoginUser.getPassword().equals(Password)) {
                return "user";
            } else {
                return null;
            }
        }
    }

    public static boolean createUser(UserModel registeredUser) throws SQLException {
        return (userRepository.createUser(registeredUser));
    }
}
