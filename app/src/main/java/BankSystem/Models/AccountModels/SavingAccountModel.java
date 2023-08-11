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
public class SavingAccountModel extends AccountModel{
    private double interestRate;
    
    public SavingAccountModel(){
               this.id = UUID.randomUUID();

    }
    public SavingAccountModel(UUID id, UserModel owner, double balance,double interestRate) {
        super(id, owner, balance);
        this.interestRate = interestRate;
    }

    public SavingAccountModel(UserModel owner, double balance,double interestRate) {
        super(owner, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
    
}
