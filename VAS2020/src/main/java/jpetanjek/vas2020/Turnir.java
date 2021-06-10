/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpetanjek.vas2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Joc
 */
public class Turnir {

    List<Agent> zaObrisati = new ArrayList<Agent>();

    public void Izvedi(int brojAgenata) {
        if (brojAgenata % 2 == 0) {
            brojAgenata--;
        }
        List<Agent> lista = new ArrayList<Agent>();
        lista.add(new AgentIgrac());

        for (int i = 0; i < brojAgenata; i++) {
            Random rand = new Random();
            int rand_int = rand.nextInt(6);
            Agent returnMe=null;
            switch (rand_int) {
                case 0:
                    returnMe = new AgentCopyCat();
                    break;
                case 1:
                    returnMe = new AgentGubitnik();
                    break;

                case 2:
                    returnMe = new AgentProtuCopyCat();
                    break;

                case 3:
                    returnMe = new AgentUvijekKamen();
                    break;

                case 4:
                    returnMe = new AgentUvijekPapir();
                    break;

                case 5:
                    returnMe = new AgentUvijekSkare();
                    break;

                default:
                    returnMe = new AgentCopyCat();
                    break;
            }
            lista.add(returnMe);
        }

        while (lista.size() != 1) {
            zaObrisati = new ArrayList<Agent>();
            int brojIgara=lista.size();
            if(brojIgara %2 != 0){
                brojIgara--;
            }
            for (int i = 0; i < brojIgara; i = i + 2) {
                Odigraj(lista.get(i), lista.get(i + 1));
            }

            lista.removeAll(zaObrisati);
            
            System.out.println("Nova runda turnira!" + "\n" +"\n");
        }

        System.out.println("Pobjednik: " + lista.get(0).toString());

    }

    private void Odigraj(Agent agent1, Agent agent2) {
        Pokret pokret1 = null, pokret2 = null, odigrano1, odigrano2;
        int i = 0;
        System.out.println(agent1.toString() + " protiv " + agent2.toString());
        boolean gotovo = false;
        while (!gotovo) {
            odigrano1 = agent1.Izvedi(pokret2);
            odigrano2 = agent2.Izvedi(pokret1);

            pokret1 = odigrano1;
            pokret2 = odigrano2;
            
            System.out.println(agent1.toString() + " igra " + pokret1.toString());
            System.out.println(agent2.toString() + " igra " + pokret2.toString());

            if (pokret1.getClass() == Kamen.class && pokret2.getClass() == Kamen.class) {
                //Oboje Kamen
                System.out.println("Oboje Kamen, igram ponovo!");
            } else if (pokret1.getClass() == Skare.class && pokret2.getClass() == Skare.class) {
                //Oboje Skare
                System.out.println("Oboje Skare, igram ponovo!");
            } else if (pokret1.getClass() == Papir.class && pokret2.getClass() == Papir.class) {
                //Oboje Papir
                System.out.println("Oboje Papir, igram ponovo!");
            } else if ((pokret1.getClass() == Kamen.class || pokret2.getClass() == Kamen.class) && (pokret1.getClass() == Skare.class || pokret2.getClass() == Skare.class)) {
                //Kamen vs Skare
                //Pobjednik Kamen
                if (pokret1.getClass() == Kamen.class) {
                    System.err.println(agent1.toString() + " pobjeduje nad " + agent2.toString());
                    zaObrisati.add(agent2);
                } else {
                    zaObrisati.add(agent1);
                    System.err.println(agent2.toString() + " pobjeduje nad " + agent1.toString());
                }
                //Obrisi Skare
                gotovo = true;
            } else if ((pokret1.getClass() == Kamen.class || pokret2.getClass() == Kamen.class) && (pokret1.getClass() == Papir.class || pokret2.getClass() == Papir.class)) {
                //Kamen vs Papir
                //Pobjednik Papir
                if (pokret1.getClass() == Papir.class) {
                    zaObrisati.add(agent2);
                    System.err.println(agent1.toString() + " pobjeduje nad " + agent2.toString());
                } else {
                    zaObrisati.add(agent1);
                    System.err.println(agent2.toString() + " pobjeduje nad " + agent1.toString());
                }
                //Obrisi Kamen
                gotovo = true;
            } else if ((pokret1.getClass() == Skare.class || pokret2.getClass() == Skare.class) && (pokret1.getClass() == Papir.class || pokret2.getClass() == Papir.class)) {
                //Skare vs Papir
                //Pobjednik Skare
                if (pokret1.getClass() == Skare.class) {
                    zaObrisati.add(agent2);
                    System.err.println(agent1.toString() + " pobjeduje nad " + agent2.toString());

                } else {
                    zaObrisati.add(agent1);
                    System.err.println(agent2.toString() + " pobjeduje nad " + agent1.toString());
                }
                //Obrisi Papir
                gotovo = true;
            }
            if (i >= 5) {
                System.out.println("Ne moze se doci do pobjednika, pobjeda se daje: " + agent1.toString());
                zaObrisati.add(agent2);
                System.err.println(agent1.toString() + " pobjeduje nad " + agent2.toString());
                gotovo = true;
            }
            i++;
        }
        System.out.println("Odigrano!"+"\n");
    }
}
