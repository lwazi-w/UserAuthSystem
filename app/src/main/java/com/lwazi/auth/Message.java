/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lwazi.auth;

/**
 *
 * @author Student
 */
public class Message {
    
    //Stores the unique ID made for each message
    private String messageID;
    
    //Stores the recipient's cellphone number
    private String recipient;
    
    //Stores the actual message entered by the user
    private String message;
    
    //Stores the generated message hash
    private String messageHash;
    
    //keeps track of the total number ofmessages sent
    private static int totalMessages = 0;
    
    //constructor used to create a new message object
    public Message(String messageID, String recipient, String message){
        this.messageID = messageID;
        this.recipient = recipient;
        this.message = message;
    
    }
    
    //Checks whether the recipient cellphone number is correctly formatted
    public String checkRecipientCell(){
        
        if (recipient.matches("\\+27\\d{9}")){
            return "Cell phone number successfully captured.";
        }
        return "Cell phone number is incorrectly formatted or does not include national code. Please correct the number and try again.";
        
    }
    //Checks whether the message is within the 250 character limit
    public String checkMessageLength(){
        
        if (message.length() <= 250){
            return "Message ready to send.";
        }
        int excess = message.length() - 250;
        
        return "Message exceeds 250 characters by " + excess + ", please reduce the size.";
    }
        //checks whether the generated message ID is 10 characters long
        public boolean checkMessageID() {
            
            return messageID.length() == 10;
        }
        //creates a message hash using the ID and message content
        public String createMessageHash() {
            
            String[] words = message.split(" ");
            
            String firstWord = words[0].toUpperCase();
            String lastWord = words[words.length - 1].toUpperCase();
            
            messageHash = messageID.substring(0, 2)
                    + ":"
                    + totalMessages
                    + ":"
                    + firstWord
                    + lastWord;
            
            return messageHash;
        }
        //Returns the total number of message sent
        public int returnTotalMessages(){
            
            return totalMessages;
        }
        //Allows the user to choose whether to send, discard or store a message
        public String sendMessage(int choice){
            
            switch (choice){
                
                case 1:
                    totalMessages++;
                    return "Message successfully sent.";
                case 2:
                    return "Press 0 to delete the message.";
                case 3:
                    return "Message successfully stored.";
                
                default:
                    return "Invalid option selected."; 
                 
            }
        }
        //Displays the details of the message 
        public String printMessages(){
            
            return "Message ID: " + messageID
                    + "\nMessage Hash: " + messageHash
                    + "\nRecipient: " + recipient
                    + "\nMessage: " + message;
                    
        }
    }

