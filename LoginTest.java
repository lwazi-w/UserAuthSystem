/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lwazi.auth;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    //Username Tests


@Test 
public void testUsernameCorrect() {
    Login login = new Login();
    assertTrue(login.checkUserName("ky_1"));
}

@Test
public void testUsernameIncorrect() {
    Login login = new Login();
    assertFalse(login.checkUserName("kyle!!!!!"));
}

//Password Tests

@Test
public void testPasswordValid() {
    Login login = new Login();
    assertTrue(login.checkPasswordComplexity("Pass123!"));       
}

@Test
public void testPasswordNoUppercase() {
    Login login = new Login();
    assertFalse(login.checkPasswordComplexity("pass123!"));
}

@Test
public void testPasswordTooShort() {
    Login login = new Login();
    assertFalse(login.checkPasswordComplexity("P1!"));
}

// Cellphone Tests
@Test
public void testCellPhoneValid() {
    Login login = new Login();
    assertTrue(login.checkCellPhoneNumber("+27838968976"));
}

@Test
public void testCellPhoneInvalid() {
    Login login = new Login();
    assertFalse(login.checkCellPhoneNumber("08966553"));   
}
//Register User Tests
@Test
public void testRegisterUserSuccess() {
    Login login = new Login();
    String result = login.registerUser("ky_1", "Pass123!");
    
    assertEquals("Username successfully captured.", result);
}
@Test 
public void testRegisterUserInvalidUsername() {
    Login login = new Login();
    String result = login.registerUser("Kyle!!!!!", "Pass123!");
    
    assertTrue(result.contains("Username is not correctly formatted"));
}
@Test
public void testRegisterUserInvalidPassword() {
    Login login = new Login();
    String result = login.registerUser("ky_1", "pass");
    
    assertTrue(result.contains("Password is not correctly formatted"));
}
//Login Test
@Test 
public void testLoginSuccess() {
    Login login = new Login();
    login.setNames("Lwazi", "User");
    login.registerUser("ky_1", "Pass123!");
    
    assertTrue(login.loginUser("ky_1", "Pass123!"));
}
@Test 
public void testLoginFail() {
    Login login = new Login();
    login.registerUser("ky_1", "Pass123!");
    
    assertFalse(login.loginUser("ky_1", "wrongpass"));
}
//Login Status Test
@Test
public void testLoginStatusSuccess() {
    Login login = new Login();
    login.setNames("Lwazi", "User");
    
    String message = login.returnLoginStatus(true);
    
    System.out.println(message);
    
    assertEquals("Welcome Lwazi User it is great to see you again.", message);
}
@Test
public void testLoginStatusFail() {
    Login login = new Login();
    
    String message = login.returnLoginStatus(false);
    
    System.out.println(message);
    
    assertEquals("Username or password incorrect, please try again.", message);
        
    }
}

    
    
           
    








    







            
            



    

