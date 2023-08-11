/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Models.TransactionModels;

import BankSystem.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author adel
 */
public class TransactionRepository {

    private static Connection dataBase;
    private static Statement statement;
    private static String query;

    private static void intializeDataBase() throws SQLException {
        dataBase = DataBaseConnection.getInstance();
        statement = dataBase.createStatement();
    }

    public static void createTransaction(TransactionModel transaction, UUID accountId) throws SQLException {
        intializeDataBase();

        String addTransactionQuery = "INSERT INTO `transaction`(`id`, `type`, `amount`, `date`,"
                + " `reciever_id`, `account_id`) VALUES ('"+transaction.getId().toString()+"','"+transaction.getType()+"'"
                + ",'"+transaction.getAmount()+"','"+transaction.getDate().toString()+"','"+0+"'"
                + ",'"+accountId.toString()+"')";

        statement.execute(addTransactionQuery);
    }
     public static void createTransaction(TransactionModel transaction, UUID accountId,UUID recieverId) throws SQLException {
        intializeDataBase();

        String addTransactionQuery = "INSERT INTO `transaction`(`id`, `type`, `amount`, `date`,"
                + " `reciever_id`, `account_id`) VALUES ('"+transaction.getId().toString()+"','"+transaction.getType()+"'"
                + ",'"+transaction.getAmount()+"','"+transaction.getDate().toString()+"','"+recieverId.toString()+"'"
                + ",'"+accountId.toString()+"')";

        statement.execute(addTransactionQuery);
    }
     
     public static List<TransactionModel> getAllTransactionsByAccountId(UUID accountId) throws SQLException{
         List<TransactionModel> transactions = new ArrayList<>();
         intializeDataBase();
         String query = "select * from transaction where account_id = ?";
        PreparedStatement prepStatment = dataBase.prepareStatement(query);
        prepStatment.setString(1, accountId.toString());
        ResultSet allTransactions = prepStatment.executeQuery();
        while(allTransactions.next()){
            TransactionModel transaction= new TransactionModel(
                    UUID.fromString(allTransactions.getString("id")),allTransactions.getDouble("amount")
                    ,LocalDate.parse(allTransactions.getString("date")),allTransactions.getString("type"));
            transactions.add(transaction);
        }
        return transactions;
     }

}
