/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lwazi.auth;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        //Create Scanner object for user input
        Scanner input = new Scanner(System.in);
        
        //Create Login object to accesss methods
        Login login = new Login();
        
        //REGISTRATION
        System .out.println("=== Registration ===");
        
        //Get user's first name 
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        
        //Get user's last name
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        
        //Get username 
        System.out.print("Enter username: ");
        String username = input.nextLine();
        
        //Get password
        System.out.print("Enter password: ");
        String password = input.nextLine();
        
        //Get cell phone number
        System.out.print("Enter cell phone number (+27):");
        String phone = input.nextLine();
        
        //Validates phone number
        if (!login.checkCellPhoneNumber(phone)) {
            System.out.println("Cell phone number is incorrectly formatted.");
            return; //Stops program if invalid
        }
        
        //Cell Phone success message 
        System.out.println("Cell phone number successfully added.");
        
        
        //Store user's name for login message later
        login.setNames(firstName, lastName);
        
        //Register user (validates username and password)
        String registerMessage = login.registerUser(username, password);
        System.out.println(registerMessage);
        
        //Stops if registration failed
       if (!registerMessage.equals("Username successfully captured.")) {
           return;
       }
       
       //LOGIN
       System.out.println("\n=== Login ===");
       
       //Asks user to login
        //3 attemps
       int attemps = 3;
       boolean success = false;
       
       while (attemps > 0) {
           
           System.out.print("Enter username: ");
           String loginUser = input.nextLine();
           
           System.out.print("Enter password: ");
           String loginPass = input.nextLine();
           
           success = login.loginUser(loginUser, loginPass);
           
           if (success) {
               break; //exit loop if correct
           } else {
               attemps--;
               System.out.println("Incorrect details. Attemps left: " + attemps);
               
           }
       }
       
       //shows final message
       String loginMessage = login.returnLoginStatus(success);
       System.out.println(loginMessage);
       
       //close scanner
       input.close();
       
        
    }
}
