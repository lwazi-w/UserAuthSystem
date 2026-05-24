/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.lwazi.auth;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class MessageTest {

    @Test
    public void testMessageLengthSuccess(){
         Message msg = new Message(
                 "1234567890",
                 "+2718693002",
                 "Hi Mike can you join us for dinner tonight");
         
         assertEquals(
                 "Message ready to send.",
                 msg.checkMessageLength()
         );
    }
    
    @Test 
    public void testMessageLengthFailure(){
        
        String longMessage =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        
        Message msg = new Message(
                "1234567890",
                "+2718693002",
                longMessage
        );                        
    }
    
    @Test
    public void testRecipientNumberSuccess(){
        
        Message msg = new Message(
                "1234567890",
                "+27186930020",
                "Hi Mike can you join us for dinner tonight"
        );
        
        assertEquals(
                "Cell phone number successfully captured.",
                msg.checkRecipientCell()
        );
    }
    
    @Test
     public void testRecipientNumberFailure(){
         
         Message msg = new Message(
                 "1234567890",
                 "0831234567",
                 "Hi Mike can you join us for dinner tonight"
         );
         
         assertTrue(
                 msg.checkRecipientCell().contains("incorrectly formatted")
         );         
     }
     
     @Test
     public void testMessageIDSuccess(){
       
         Message msg = new Message(
                "1234567890",
                "+27186930020",
                "Hi Mike can you join us for dinner tonight"
        );
         
         assertTrue(msg.checkMessageID());
         
     }
     
     @Test
     public void testMessageIDFailure(){
         
         Message msg = new Message(
                "12345678901",
                "+27186930020",
                "Hi Mike can you join us for dinner tonight"
        );
         
         assertFalse(msg.checkMessageID());
     }
     
     @Test 
     public void testMessageHash(){
         
         Message msg = new Message(
                "0012345678",
                "+27186930020",
                "Hi Mike can you join us for dinner tonight"
        );
         assertEquals(
                 "00:0:HITONIGHT",
                 msg.createMessageHash()
         );
     }
     
     @Test
     public void testSendMessage(){
         
        Message msg = new Message(
                "1234567890",
                "+27186930020",
                "Hi Mike can you join us for dinner tonight"
        );
        
        assertEquals(
                "Message successfully sent.",
                msg.sendMessage(1)
        );
     }
     
     @Test
     public void testDisgardMessage(){
         
         Message msg = new Message(
                "1234567890",
                "+27186930020",
                "Hi Mike can you join us for dinner tonight"
        );
         
         assertEquals(
                 "Press 0 to delete the message.",
                 msg.sendMessage(2)
         );
     }
     
     @Test 
     public void testStoreMessage(){
         
         Message msg = new Message(
                "1234567890",
                "+27186930020",
                "Hi Mike can you join us for dinner tonight"
        );
        
         
         assertEquals(
                 "Message successfully stored.",
                 msg.sendMessage(3)
         );
     }
     
     @Test 
     public void testReturnTotalMessage(){
         
         Message msg1 = new Message(
                "1234567890",
                "+27186930020",
                "Message One"
        );
         
         msg1.sendMessage(1);
         
         assertTrue(msg1.returnTotalMessages() >= 1);
     }
     
    
}
    
    
    
    
   
