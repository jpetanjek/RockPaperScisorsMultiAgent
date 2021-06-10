/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpetanjek.vas2020;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Joc
 */
public class AgentIgrac implements Agent{
    
    @Override
    public Pokret Izvedi(Pokret pokret) {
        Pokret returnMe=null;
        
        System.out.println("Unesi pokret 1-Kamen, 2-Skare, 3-Papir: ");
        Scanner myObj = new Scanner(System.in); 
        String unos = myObj.nextLine();
        if(unos.equals("1")){
            returnMe = new Kamen();
        }else if(unos.equals("2")){
            returnMe = new Skare();
        }else if(unos.equals("3")){
            returnMe = new Papir();
        }else{
            returnMe = new Kamen();
        }
        return returnMe;
    }
    
    @Override
    public String toString() {
        return "AgentIgrac";
    }
    
}
