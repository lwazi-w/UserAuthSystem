/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lwazi.auth;

/**
 *
 * @author Student
 */
public class Login {
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    // Username validation
    public boolean checkUserName(String username) {
        return username != null &&
                username.contains("_") &&
                username.length() <= 5;
    }     
    // Password Validation 
    public boolean checkPasswordComplexity(String password) {
    
    if (password == null) return false;
    
    boolean hasUpper = password.matches(".*[A-Z].*");
    boolean hasNumber = password.matches(".*\\d.*");
    boolean hasSpecial = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    
    return password.length() >=8 && hasUpper && hasNumber && hasSpecial;
    }
    // Cellphone Validation
    public boolean checkCellPhoneNumber(String number) {
        return number != null && number.matches("\\+27\\d{9}");
    }
    //Register user
    public String registerUser(String username, String password) {
        
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter , a number and a special character.";
        }
        
        this.username = username;
        this.password = password;
        
        return "Username successfully captured.";
    }
    // Login verification 
    public boolean loginUser(String username, String password) {
        return this.username != null &&
                this.username.equals(username) &&
                this.password.equals(password);
    }
    //Login message
    public String returnLoginStatus(boolean loginSuccess) {
        
        if (loginSuccess) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    public void setNames(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        
    }
    
    
        
        
            
    

}
    
    
    
    
    
    
   
    
    

