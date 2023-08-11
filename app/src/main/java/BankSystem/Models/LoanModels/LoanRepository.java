/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Models.LoanModels;

import BankSystem.DataBaseConnection;
import BankSystem.Models.UserModels.UserModel;
import BankSystem.Models.UserModels.userRepository;
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
public class LoanRepository {
    
    private static Connection dataBase;
    private static Statement statement;
    private static String query;

    private static void intializeDataBase() throws SQLException {
        dataBase = DataBaseConnection.getInstance();
        statement = dataBase.createStatement();
    }
    public static Boolean createLoan(LoanModel addedLoan) throws SQLException {
        intializeDataBase();
        query = "insert into loan values ('" + addedLoan.getType()+ "', '" + addedLoan.getAmount()+ "', "
                + "'" + addedLoan.getStatus() + "','" + addedLoan.getDate()+ "' , '" + addedLoan.getId()+ "'"
                + " ,'" + addedLoan.getRequester().getId()+ "' );";
        return (!statement.execute(query));
    }
    public static LoanModel getLoanRequestById (UUID loanId) throws SQLException{
        intializeDataBase();
        query = "select * from `loan` where `id`   = ?";
        PreparedStatement prepStatment = dataBase.prepareStatement(query);
        prepStatment.setString(1, loanId.toString());
        ResultSet loanFromDataBase = prepStatment.executeQuery();

        LoanModel targetLoan = new LoanModel();
        while (loanFromDataBase.next()) {
            targetLoan.setId(UUID.fromString(loanFromDataBase.getString("id")));
            targetLoan.setAmount((loanFromDataBase.getDouble("amount")));
            targetLoan.setDate(LocalDate.parse(loanFromDataBase.getString("Date")));
            targetLoan.setRequester(userRepository.getUserById(UUID.fromString(loanFromDataBase.getString("user_id"))));
            targetLoan.setStatus(loanFromDataBase.getString("status"));
            targetLoan.setType(loanFromDataBase.getString("type"));
        }
        return targetLoan;
    }
    
    public static List<LoanModel>getUserLoans(String  userName) throws SQLException
    {
        intializeDataBase();
        query = "select * from `loan` where `user_id`   = ?";
        PreparedStatement prepStatment = dataBase.prepareStatement(query);
        UserModel loanRequester = new UserModel();
        loanRequester = userRepository.getUserByUserName(userName);
        prepStatment.setString(1,loanRequester.getId().toString());
        ResultSet loanFromDataBase = prepStatment.executeQuery();

        List<LoanModel> loans = new ArrayList<>();
        while (loanFromDataBase.next()) {
           LoanModel targetLoan = new LoanModel();
            targetLoan.setId(UUID.fromString(loanFromDataBase.getString("id")));
            targetLoan.setAmount((loanFromDataBase.getDouble("amount")));
            targetLoan.setDate(LocalDate.parse(loanFromDataBase.getString("Date")));
            targetLoan.setRequester(loanRequester);
            targetLoan.setStatus(loanFromDataBase.getString("status"));
            targetLoan.setType(loanFromDataBase.getString("type"));
            loans.add(targetLoan);
        }
        return loans;
    }
    public static void changeLoanStatus(String newStatus,UUID loanId) throws SQLException{
             String updateBalanceQuery = "UPDATE loan SET status = ? WHERE id = ? ";
        PreparedStatement prepStatment;
        prepStatment = dataBase.prepareStatement(updateBalanceQuery);
        prepStatment.setString(1, newStatus);
        prepStatment.setString(2, loanId.toString());
        prepStatment.executeUpdate();
        
    }
}
