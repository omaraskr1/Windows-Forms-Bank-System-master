/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Models.AccountModels;

/**
 *
 * @author adel
 */
public class AccountFactory {

    public static AccountModel getType(String accountType) {
        if (accountType.equals("Normal Saving Account".toLowerCase())) {
            return new SavingAccountModel();
        } else if (accountType.equals("Money Market Saving Account".toLowerCase())) {
            return new MoneyMarketAccountModel();
        } else if (accountType.equals("Normal checking Account".toLowerCase())) {
            return new CheckingAccountModel();
        } else if (accountType.equals("Certificate Deposit checking account".toLowerCase())) {
            return new CertificateDepositAccountModel();
        }
        return null;
    }
}
