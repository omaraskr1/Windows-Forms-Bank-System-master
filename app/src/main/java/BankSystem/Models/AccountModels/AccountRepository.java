/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Models.AccountModels;

import BankSystem.DataBaseConnection;
import BankSystem.Models.UserModels.UserModel;
import BankSystem.Models.UserModels.userRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author adel
 */
public class AccountRepository {

    private static Connection dataBase;
    private static Statement statement;

    private static void intializeDataBase() throws SQLException {
        dataBase = DataBaseConnection.getInstance();
        statement = dataBase.createStatement();
    }

    public static void createAccount(AccountModel addedAccount, UUID ownerId, String accountType, String accountSubType) throws SQLException {
        intializeDataBase();
        System.out.println("type is " + accountType);
        System.out.println("subtpye isssssssss" + accountSubType);
        System.out.println("owner is " + ownerId);
        System.out.println("added account " + addedAccount.id);
        String addAccountQuery = "insert into account values ('" + addedAccount.id + "', '" + ownerId.toString() + "', "
                + "'" + addedAccount.getBalance() + "' );";
        String addAccountTypeQuery = "insert into account_type values ('" + UUID.randomUUID() + "', '" + addedAccount.id + "', "
                + "'" + accountType + "','" + accountSubType + "' );";
        statement.execute(addAccountQuery);
        statement.execute(addAccountTypeQuery);
    }

    public static String getAccountTypeByID(UUID accountId) throws SQLException {
        intializeDataBase();
        String getAccountQuery = "select * from `account_type` where `account_id` = ? ";
        PreparedStatement prepStatment = dataBase.prepareStatement(getAccountQuery);
        prepStatment.setString(1, accountId.toString());
        ResultSet accountFromDatabase = prepStatment.executeQuery();
        String accountType = "";
        while (accountFromDatabase.next()) {
            accountType = accountFromDatabase.getString("type");
        }
        return accountType;

    }

    public static Double getBalanceById(UUID accountId) throws SQLException {
        intializeDataBase();
        String getAccountQuery = "select * from account where id=?";
        PreparedStatement prepStatment = dataBase.prepareStatement(getAccountQuery);
        prepStatment.setString(1, accountId.toString());
        ResultSet AccountFromDatabase = prepStatment.executeQuery();
        double balance = 0;
        while (AccountFromDatabase.next()) {
            balance = (AccountFromDatabase.getDouble("balance"));
        }
        return balance;
    }

    public static void updateBalanceById(UUID accountId, double balance) throws SQLException {
        String updateBalanceQuery = "UPDATE account SET balance = ? WHERE id = ? ";
        PreparedStatement prepStatment;
        prepStatment = dataBase.prepareStatement(updateBalanceQuery);
        prepStatment.setDouble(1, balance);
        prepStatment.setString(2, accountId.toString());
        prepStatment.executeUpdate();
    }

    public static UUID getOwnerIdByAccountId(UUID accountId) throws SQLException {
        intializeDataBase();
        String query = "select `user_id` from `account` where id  = ?";
        PreparedStatement prepStatment = dataBase.prepareStatement(query);
        prepStatment.setString(1, accountId.toString());
        ResultSet ownerFromDataBase = prepStatment.executeQuery();

        UUID ownerId = null;
        while (ownerFromDataBase.next()) {
            ownerId = UUID.fromString(ownerFromDataBase.getString("user_id"));
        }
        return ownerId;
    }
    public static AccountModel getAccountById(UUID accountId) throws SQLException{
        intializeDataBase();
        String query = "select * from `account` where `id`  = ?";
        PreparedStatement prepStatment = dataBase.prepareStatement(query);
        prepStatment.setString(1, accountId.toString());
        ResultSet accountFromDatabase = prepStatment.executeQuery();
        AccountModel targetAccount = AccountFactory.getType(getAccountTypeByID(accountId).toLowerCase());
        while (accountFromDatabase.next()) {
            UserModel u = userRepository.getUserById(UUID.fromString(accountFromDatabase.getString("user_id")));
            targetAccount.setOwner(u);
            targetAccount.setBalance(accountFromDatabase.getDouble("balance"));
            targetAccount.setId(UUID.fromString(accountFromDatabase.getString("id")));
        }
        return targetAccount;
    }
    public static List<String> getAllAccountsByUserNameFlatten(String userName) throws SQLException{
        intializeDataBase();
        String query = "select * from `account` where `user_id`  = ?";
        PreparedStatement prepStatment = dataBase.prepareStatement(query);
        prepStatment.setString(1, userRepository.getUserByUserName(userName).getId().toString());
        ResultSet accountsFromDatabase = prepStatment.executeQuery();
        List<String> accounts = new ArrayList<>();
        while(accountsFromDatabase.next()){
            String accountId = accountsFromDatabase.getString("id");
            accounts.add(accountId);
            accounts.add(String.valueOf(accountsFromDatabase.getDouble("balance")));
            accounts.add(getAccountTypeByID(UUID.fromString(accountId)));
        }
        return accounts;
    }
}
