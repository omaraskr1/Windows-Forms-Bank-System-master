/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Controllers;

import BankSystem.Models.AccountModels.AccountRepository;
import BankSystem.Models.TransactionModels.TransactionModel;
import BankSystem.Models.TransactionModels.TransactionRepository;
import BankSystem.Models.UserModels.userRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

/**
 *
 * @author adel
 */
public class TransactionController {

    public static void createWithdraw(TransactionModel transaction, UUID accountId, String LoggedInUserName) throws SQLException {
        BankSystem.Models.TransactionModels.TransactionProxy tr = new BankSystem.Models.TransactionModels.TransactionProxy();

        if (tr.isTheAccountOwner(LoggedInUserName,
                userRepository.getUserById(AccountRepository.getOwnerIdByAccountId(accountId)).getUserName())) {
            double remainingBalance = tr.withdraw(AccountRepository.getAccountById(accountId).getBalance(),
                    transaction.getAmount(), AccountRepository.getAccountTypeByID(accountId));
            TransactionRepository.createTransaction(transaction, accountId);
            AccountRepository.updateBalanceById(accountId, remainingBalance);
        }
    }

    public static void createDeposit(TransactionModel transaction, UUID accountId, String LoggedInUserName) throws SQLException {
        BankSystem.Models.TransactionModels.TransactionProxy tr = new BankSystem.Models.TransactionModels.TransactionProxy();

        if (tr.isTheAccountOwner(LoggedInUserName,
                userRepository.getUserById(AccountRepository.getOwnerIdByAccountId(accountId)).getUserName())) {
            double remainingBalance = tr.deposit(AccountRepository.getAccountById(accountId).getBalance(),
                    transaction.getAmount());
            TransactionRepository.createTransaction(transaction, accountId);
            AccountRepository.updateBalanceById(accountId, remainingBalance);
        }
    }

    public static void createTransfer(TransactionModel transaction, String LoggedInUserName, UUID recieverAccountId, UUID senderAccountId) throws SQLException {
        BankSystem.Models.TransactionModels.TransactionProxy tr = new BankSystem.Models.TransactionModels.TransactionProxy();

        if (tr.isTheAccountOwner(LoggedInUserName,
                userRepository.getUserById(AccountRepository.getOwnerIdByAccountId(senderAccountId)).getUserName())) {
            double senderRemainingBalance = transaction.withdraw(AccountRepository.getAccountById(senderAccountId).getBalance(), transaction.getAmount());
            double recieverRemainingBalance = transaction.deposit(AccountRepository.getAccountById(recieverAccountId).getBalance(), transaction.getAmount());
            AccountRepository.updateBalanceById(senderAccountId, senderRemainingBalance);
            AccountRepository.updateBalanceById(recieverAccountId, recieverRemainingBalance);
            TransactionRepository.createTransaction(transaction, senderAccountId, recieverAccountId);
        }
    }

    public static Double getBalance(TransactionModel transaction,UUID accountId, String LoggedInUserName) throws SQLException {
        BankSystem.Models.TransactionModels.TransactionProxy tr = new BankSystem.Models.TransactionModels.TransactionProxy();
        if (tr.isTheAccountOwner(LoggedInUserName,
                userRepository.getUserById(AccountRepository.getOwnerIdByAccountId(accountId)).getUserName())) {
                        TransactionRepository.createTransaction(transaction, accountId);

            return AccountRepository.getBalanceById(accountId);
            
        }
        return null;
    }
 public static List<TransactionModel> getTransactionByAccountId(UUID accountId) throws SQLException
    {
        return TransactionRepository.getAllTransactionsByAccountId(accountId);
    }
    
}
