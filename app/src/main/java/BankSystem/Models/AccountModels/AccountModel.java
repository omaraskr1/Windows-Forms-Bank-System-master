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
public abstract class AccountModel {

    UUID id;
    UserModel owner;
    double balance;

    public AccountModel() {
        this.id = UUID.randomUUID();
    }

    public AccountModel(UUID id, UserModel owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public AccountModel(UserModel owner, double balance) {
        this.id = UUID.randomUUID();
        this.owner = owner;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserModel getOwner() {
        return owner;
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
