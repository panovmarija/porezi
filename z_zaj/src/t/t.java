/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author USER
 */
public class t {
    public static void main(String[] args) {
        Date d=new Date();
        System.out.println(Integer.valueOf(new SimpleDateFormat("yyyy").format(d))<=2024);
    }
}
