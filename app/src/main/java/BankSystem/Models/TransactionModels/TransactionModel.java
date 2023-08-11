/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Models.TransactionModels;

import BankSystem.Models.AccountModels.AccountModel;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author adel
 */
public class TransactionModel {

    UUID id;
    double amount;
    LocalDate date;
    String Type;

    public TransactionModel(UUID id, double amount, LocalDate date, String Type) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.Type = Type;
    }

    public TransactionModel(double amount, LocalDate date, String Type) {
        this.amount = amount;
        this.date = date;
        this.Type = Type;
    }

    TransactionModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public  double withdraw(double accountBalance, double amount) {
        double remainingBalance = accountBalance - amount;
        return remainingBalance;
    }

    public  double deposit(double accountBalance, double amount) {
        double remainingBalance = accountBalance + amount;
        return remainingBalance;
    }
}
