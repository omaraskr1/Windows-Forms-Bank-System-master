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
public class CheckingAccountModel extends AccountModel{
        
    public CheckingAccountModel(UUID id, UserModel owner, double balance) {
        super(id, owner, balance);
    }

    public CheckingAccountModel(UserModel owner, double balance) {
        super(owner, balance);
    }

    CheckingAccountModel() {
            this.id = UUID.randomUUID();

    }
}
