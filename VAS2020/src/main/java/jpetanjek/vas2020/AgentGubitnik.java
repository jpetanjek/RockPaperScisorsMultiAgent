/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpetanjek.vas2020;

import java.util.Random;

/**
 *
 * @author Joc
 */
public class AgentGubitnik implements Agent{
    
    @Override
    public Pokret Izvedi(Pokret pokret) {
        Pokret returnMe=null;
        if(pokret==null){
            Random rand = new Random();
            int rand_int = rand.nextInt(2);
            switch(rand_int){
                case 0:
                    returnMe = new Kamen();
                case 1:
                    returnMe = new Skare();
                case 2:
                    returnMe = new Papir();
                default:
                    returnMe = new Kamen();
            }
        }else if(pokret.getClass()==Kamen.class){
            returnMe = new Skare();
        }else if(pokret.getClass()==Papir.class){
            returnMe = new Kamen();
        }else if(pokret.getClass()==Skare.class){
            returnMe = new Papir();
        }
        return returnMe;
    }
    
    @Override
    public String toString() {
        return "AgentGubitnik";
    }
    
}
