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
        String input = "09-07-2000";
        boolean result = Pattern.matches("^\\d{2}-\\d{2}-\\d{4}$", input);
        System.out.println(result);
        
    }
    
    
}
