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
public class MoneyMarketAccountModel extends CheckingAccountModel{
    private static final double withdrawPenalty = 1.5;

    MoneyMarketAccountModel() {
            super();

    }

    public static double getWithdrawPenalty() {
        return withdrawPenalty;
    }
    public MoneyMarketAccountModel(UserModel owner, double balance) {
        super(owner, balance);
    }
    
    public MoneyMarketAccountModel(UUID id, UserModel owner, double balance) {
        super(id, owner, balance);
    }
    
    
}
