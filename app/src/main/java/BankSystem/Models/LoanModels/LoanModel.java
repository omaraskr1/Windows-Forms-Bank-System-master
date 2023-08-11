/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Models.LoanModels;

import BankSystem.Models.UserModels.UserModel;
import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author adel
 */
public class LoanModel {

    private String type;
    private UUID id;
    private String status;
    private LocalDate date;
    private UserModel requester;
    private double amount;

    public LoanModel(String type, UUID id, String status, LocalDate date, UserModel requester, double amount) {
        this.type = type;
        this.id = id;
        this.status = status;
        this.date = date;
        this.requester = requester;
        this.amount = amount;
    }
    public LoanModel(){}
    public LoanModel(String type, UUID id, String status, LocalDate date, double amount) {
        this.type = type;
        this.id = id;
        this.status = status;
        this.date = date;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UserModel getRequester() {
        return requester;
    }

    public void setRequester(UserModel requester) {
        this.requester = requester;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
