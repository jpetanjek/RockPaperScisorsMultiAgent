/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpetanjek.vas2020;

/**
 *
 * @author Joc
 */
public class AgentUvijekSkare implements Agent {

    @Override
    public Pokret Izvedi(Pokret pokret) {
        return new Skare();
    }
    
    @Override
    public String toString() {
        return "AgentUvijekSkare";
    }
    
}