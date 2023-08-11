/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Models.UserModels;

import java.util.UUID;

/**
 *
 * @author adel
 */
public class UserModel {

    private UUID id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String SSN;
    private String address;
    private String Email;

    public UserModel(UUID id, String userName, String firstName, String lastName, String password, String SSN, String address, String Email) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.SSN = SSN;
        this.address = address;
        this.Email = Email;
    }

    public UserModel(String firstName, String lastName, String address, String password, String SSN, String Email) {
        this.id = UUID.randomUUID();
        this.userName = generateUserName(firstName, id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.SSN = SSN;
        this.Email = Email;

    }

    public UserModel() {
    }

    private static String generateUserName(String firstName, UUID userId) {
        return (firstName + userId.toString().substring(0, 7));
    }

    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the SSN
     */
    public String getSSN() {
        return SSN;
    }

    /**
     * @param SSN the SSN to set
     */
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }
}
