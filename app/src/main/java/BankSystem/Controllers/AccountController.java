/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.UserModels;

import BankSystem.Models.UserModels.userRepository;
import BankSystem.Models.UserModels.UserModel;
import BankSystem.Models.AccountModels.AccountModel;
import BankSystem.Models.AccountModels.AccountRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adel
 */
public class AccountController {
    public static void createAccount(AccountModel addedAccount,String ownerUserName,String accountType) throws SQLException
     {      
         String accountSubType = splitAccountTypes(accountType.toLowerCase());
            UserModel accountOwner = userRepository.getUserByUserName(ownerUserName);
           AccountRepository.createAccount(addedAccount, accountOwner.getId(), accountType, accountSubType);
            
     }
    private static String splitAccountTypes(String accountType)
    {
        if(accountType.charAt(0) == 'n')
        {
            
            if(accountType.charAt(7) == 's')
                return "saving";
            else
                return "checking";
        }
        else if(accountType.charAt(0) == 'c')
        {
            return "certificate deposit";
        }
        else{
            return "money market";
        }
    }
    public static List<String> getAllAccountsFlatten(String userName) throws SQLException{
        return AccountRepository.getAllAccountsByUserNameFlatten(userName);
    }
    
    public static AccountModel getAccountById(UUID accountId) throws SQLException{
       return AccountRepository.getAccountById(accountId);
    }
    public static String getAccountTypeById(UUID accountId) throws SQLException{
    return AccountRepository.getAccountTypeByID(accountId);
            }
}
