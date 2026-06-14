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
        
        //RESITRATION
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
        
        //Get password
        System.out.print("Enter cell phone number (+27):");
        String phone = input.nextLine();
        
        //Validates phone number
        if (!login.checkCellPhoneNumber(phone)) {
            System.out.println("Cell phone number is incorrectly formatted.");
            return; //Stops program if invalid
        }
        
        //Phone success message 
        System.out.println("Cell phone number successfully added.");
        
        
        //Store user's name for login message later
        login.setNames(firstName, lastName);
        
        //Register user (validates username and password)
        String registerMessage = login.registerUser(username, password);
        System.out.println(registerMessage);
        
        //Stop if registration failed
       if (!registerMessage.equals("Username successfully captured.")) {
           return;
       }
       
       //LOGIN
       System.out.println("\n=== Login ===");
       
       //Asks user to login
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
       
       //Create a test message object for QuickChat
       Message testMessage = new Message(
               "1234567890",
               "+2718693002",
               "Hi Mike can you join us for dinner tonight"
       );
       Message userMessage = testMessage;
       
       int choice = 0;
       while(choice != 7){
       
       //Welcome message for Part 2
       System.out.println("\nWelcome to QuickChat");
       
       //Displays the QuickChat menu options
       System.out.println("1. Send Messages");
       System.out.println("2. Show recently sent messages");
       System.out.println("3. Search Message by ID");
       System.out.println("4. Stored Messages");
       System.out.println("5. Search by Recipient");
       System.out.println("6. Delete Message by Hash");
       System.out.println("7. Display Report");
       System.out.println("8. Quit");
       
       //Allows the user to select a menu option
       System.out.print("\nChoose an option: ");
       choice = input.nextInt();
       
       //Process the user's menu selection
       switch (choice){
           
           //Allows the user to capture and validate a new message
           case 1:
               System.out.println("Enter recipient number: ");
               String recipient = input.next();
               
               input.nextLine(); //Clears leftover Enter key
               
               System.out.print("Enter your message: ");
               String messageText = input.nextLine();
               
               userMessage = new Message(
                       "1234567890",
                       recipient,
                       messageText
               );
               
               System.out.println(userMessage.checkRecipientCell());
               System.out.println(userMessage.checkMessageLength());
               
               System.out.println("Message Hash: "
                       +userMessage.createMessageHash());
               
               System.out.println("\nChoose what to do:");
               System.out.println("1. Send Message");
               System.out.println("2. Disgard Message");
               System.out.println("3. Store Message");
               
               int sendChoice = input.nextInt();
               
               System.out.println(userMessage.sendMessage(sendChoice));
               
               System.out.println("\nStored Messages:");
               System.out.println(userMessage.displayStoredMessages());
               
               if (sendChoice == 1){
                   System.out.println(userMessage.printMessages());
                   
                   System.out.println(
                           "\nTotal Messages sent: "
                           + userMessage.returnTotalMessages()
                   );       
               }
             
               break;
               
           case 2:
             
               System.out.println("\nRecently Sent Messages: ");
               System.out.println(userMessage.displaySentMessages());
               
               break;
               
           case 3:
               
               input.nextLine();
               
               System.out.println("Enter Message ID to search: ");
               String searchID = input.nextLine();
               
               System.out.println(userMessage.searchByMessageID(searchID));
               
               break;
               
           case 4:
               
               System.out.println("\nStored Messages:");
               System.out.println(userMessage.displayStoredMessages());
               
               System.out.println("\nMessage Hashes:");
               System.out.println(userMessage.displayMessageHashes());
                
               System.out.println("\nMessage IDs:");
               System.out.println(userMessage.displayMessageIDs());
               
               System.out.println("\nLongest Message:");
               System.out.println(userMessage.displayLongestMessage());
               
               break;
               
           case 5:
               
               input.nextLine();
               
               System.out.println("Enter recipient number: ");
               String recipientSearch = input.nextLine();
               
                System.out.println(userMessage.searchByRecipient(recipientSearch));
                
               break;
               
           case 6:
               
               input.nextLine();
                       
                System.out.println("Enter message hash: ");
                String hash = input.nextLine();
                
                System.out.println(userMessage.deleteMessageByHash(hash));
                
                break;
                
           case 7:
               
               System.out.println(userMessage.displayReport());
               break;
               
           case 8:
               
               System.exit(0);
               break;
               
           default:
               System.out.println("Invalid option.");
       }
       
      
       //input.close();
       
       
        
    }
}
    
}