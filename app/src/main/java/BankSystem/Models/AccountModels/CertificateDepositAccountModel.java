/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Models.AccountModels;

import BankSystem.Models.UserModels.UserModel;
import java.util.UUID;

/**
 *
 * @author adel
 */
public class CertificateDepositAccountModel extends SavingAccountModel{
    public CertificateDepositAccountModel(UUID id, UserModel owner, double balance, double interestRate) {
        super(id, owner, balance, interestRate);
    }

    public CertificateDepositAccountModel(UserModel owner, double balance, double interestRate) {
        super(owner, balance, interestRate);
    }

    CertificateDepositAccountModel() {
            super();
    }
    public static double calculateWithdrawPenalty(double amount)
    {
        return((amount*20)/100);
    }
    
}
