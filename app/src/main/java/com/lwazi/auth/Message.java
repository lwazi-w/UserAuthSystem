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
    
    //Stores all messages that have been sent 
    private static String[] sentMessages = new String[100];
    
    //Stores all the messages that have been disregarded
    private static String[] disregardedMessages = new String[100];
    
    //Stores all the messages that have been stored
    private static String[] storedMessages = new String[100];
    
    //Stores all message hashes 
    private static String[] messageHashes = new String[100];
    
    //stores all message IDs
    private static String[] messageIDs = new String[100];
    
    //stores all recipients
     private static String[] recipients = new String[100];
    
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
                    sentMessages[totalMessages] = message;
                    
                    messageIDs[totalMessages] = messageID;
                    
                    messageHashes[totalMessages] = createMessageHash();
                    
                    totalMessages++;
                    
                    return " Message successfully sent.";
                case 2:
                    disregardedMessages[totalMessages] = message;
                    
                    return "Press 0 to delete the message.";
                case 3:
                    //stores the message in the stored messages array
                    storedMessages[totalMessages] = message;
                    
                    recipients[totalMessages] = recipient;
                    
                    System.out.println("DEBUG: Stored -" + storedMessages[totalMessages]);
                    
                    messageIDs[totalMessages] = messageID;
                    
                    messageHashes[totalMessages] = createMessageHash();
                    
                    totalMessages++;
                    
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
        //Display all stored messages 
        public String displayStoredMessages() {
            
            String result = "";
            
            for (int i = 0; i < storedMessages.length; i++) {
                
                if (storedMessages[i] != null){
                    result += storedMessages[i] + "\n";
                
            }
                
               
        }
            
        return result;
        }
        //Displays the sender and recipient of all stored messages
        public String displaySendersAndRecipients(){
            
            String result = "";
            
            for (int i = 0; i < storedMessages.length; i++){
                if (storedMessages[i] != null){
                    
                    result += "Sender: Developer"
                            + ", Recipient: "
                            + recipient
                            + "\n";
                }
            }
            return result;
        }
        //displays the longest stored message
        public String displayLongestMessage(){
            
            String longest = "";
            
            for (int i = 0; i < storedMessages.length; i++){
                if (storedMessages[i] != null &&
                    storedMessages[i].length() > longest.length()){
                    
                    longest = storedMessages[i];
                }
            }
          return longest;  
        }
        //Display all message hashes
        public String displayMessageHashes(){
            
            String result = "";
            
            for (int i = 0; i < messageHashes.length; i++){
                if (messageHashes[i] != null){
                    result += messageHashes[i] + "\n";
                }
            }
            return result;
        }
        //display all message IDs
        public String displayMessageIDs(){
            
            String result = "";
            
            for (int i = 0; i < messageIDs.length; i++){
                if (messageIDs[i] != null){
                    result += messageIDs[i] + "\n";
                }
            }
            return result;
        }
        //Delete a message using its message id
        public String deleteMessage(String id){
            
            for(int i = 0; i < messageIDs.length; i++){
                if (messageIDs[i] != null && messageIDs[i].equals(id)){
                    
                    storedMessages[i] = null;
                    messageIDs[i] = null;
                    messageHashes[i] = null;
                    
                    return "Message successfully deleted.";
                }
            }
            return "Message not found.";
        }
        //Searches for a message using the message ID
        public String searchByMessageID(String id){
            
            for (int i = 0; i < messageIDs.length; i++){
                if (messageIDs[i] != null && messageIDs[i].equals(id)){
                    return "Message ID: " + messageIDs[i]
                            + "\nRecipient: " + recipients[i]
                            + "\nMessage: " + storedMessages[i];
                }
            }
            return "Message not found.";
        }
        //searches for a message using recipient number
        public String searchByRecipient(String recipientNumber){
            
            String result = "";
            
            for (int i = 0; i < recipients.length; i++){
                if (recipients[i] != null &&
                    recipients[i].equals(recipientNumber)){
                    
                    result += storedMessages[i]+ "\n";
                }
            }
            if (result.equals("")){
                return "No messages found.";
            }
             return result;
        }
        //deletes meesage by using hash
        public String deleteMessageByHash(String hash){
            
            for(int i = 0; i < messageHashes.length; i++){
                if(messageHashes[i] != null &&
                   messageHashes[i].equals(hash)){
                    
                    storedMessages[i] = null;
                    messageIDs[i] = null;
                    messageHashes[i] = null;
                    recipients[i] = null;
                    sentMessages[i] = null;
                    
                    return "Message successfully deleted.";
                }
            }
            return "Message not found.";
        }
        //displays all sent messages
        public String displaySentMessages(){
            
            String result = "";
            
            for(int i = 0; i < sentMessages.length; i++){
                if(sentMessages[i] != null){
                    result += sentMessages[i] + "\n";
                }
            }
            return result;
        }
        //Displays a report of all stored messages
        public String displayReport(){
            
            String result ="";
            
            for (int i = 0; i < storedMessages.length; i++){
                if (storedMessages[i] != null){
                    
                    result += "Message Hash: " + messageHashes[i]
                            + "\nRecipient: " + recipients[i]
                            + "\nMessage: " + storedMessages[i]
                            + "\n\n";
                }
            }
         return result;       
        }
       
}

