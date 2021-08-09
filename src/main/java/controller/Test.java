/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Test {
    public static void main(String[] args) {
        String input = "San pham F";
       boolean result = Pattern.matches("^[a-zA-Z0-9 ]{1,}$", input);
        System.out.println(result);
        
    }
    
    
}
