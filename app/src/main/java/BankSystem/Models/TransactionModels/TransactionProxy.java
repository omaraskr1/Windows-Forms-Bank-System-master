/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Models.TransactionModels;

import BankSystem.Models.AccountModels.AccountModel;
import BankSystem.Models.AccountModels.CertificateDepositAccountModel;
import BankSystem.Models.AccountModels.CheckingAccountModel;
import BankSystem.Models.AccountModels.MoneyMarketAccountModel;
import BankSystem.Models.AccountModels.SavingAccountModel;
import BankSystem.Models.UserModels.userRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author adel
 */
public class TransactionProxy {
    TransactionModel transaction = new TransactionModel();
    
    private boolean isPositive(double number){
        return (number>0);
    }
    private boolean hasEnoughBalance(double balance,double requiredAmount){
    return (balance>requiredAmount);
       
    }
    private double generateWithdrawalAmount(String accountType,double amount){
      if (accountType.equals("Money Market Saving Account".toLowerCase())) {
           return(MoneyMarketAccountModel.getWithdrawPenalty() + amount);
  
        } else if (accountType.equals("Certificate Deposit checking account".toLowerCase())) {
            return (CertificateDepositAccountModel.calculateWithdrawPenalty(amount) + amount);
        }
      else
            return 0;
    }
    public boolean isTheAccountOwner(String loggedInUserName,String accountOwnerUserName){
        return (loggedInUserName.equals(accountOwnerUserName));
    }
    public double withdraw( double accountBalance,double amount,String accountType){
        if(isPositive(amount) && hasEnoughBalance(accountBalance,
                generateWithdrawalAmount(accountType,amount)))
            return transaction.withdraw(accountBalance, amount);
        else
            throw new Error("amount cant be negative Or you dont have enough balance");
    }
    public double deposit(double accountBalance , double amount){
    if(isPositive(amount))
    {
        return transaction.deposit(accountBalance, amount);
    }
    throw new Error("Amount cant be negative");
    }
   
    
}
