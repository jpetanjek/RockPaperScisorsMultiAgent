/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpetanjek.vas2020;

import java.util.Scanner;

/**
 *
 * @author Joc
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Igra Kamen, Skare, Papir");
        System.out.println("Unesi broj agenata protiv kojih zelis igrati u turniru: ");
        Scanner myObj = new Scanner(System.in); 
        String unos = myObj.nextLine();
        new Turnir().Izvedi(Integer.parseInt(unos));
        System.out.println("Hvala na igranju");
    }
}
