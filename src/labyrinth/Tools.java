/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author User
 */
public class Tools {
    int coins;
    int level=1;
    String playerRout="/icons/woman.png";
    boolean onTime;
    Labyrinth main;
    boolean help1;
    boolean help2;
    HashMap<String,Integer> players; 
    String player="player";
    Timer timerUp = new Timer();
int timePassed=0;
  TimerTask tt = new TimerTask() {
               @Override
               public void run() {
                timePassed+=1;   
                main.g.timeLab.setText("TIME PASSED: "+((timePassed/60)>9?"":"0")+(timePassed/60)+":"+((timePassed%60)>9?"":"0")+(timePassed%60));
               }
           };
    public Tools(Labyrinth l) {
        players=new HashMap<>();
        main=l;
         timerUp.schedule(tt, 0, 1000);
    }
    public void setPlayer(String s){
        
      if(players.containsKey(s)){
               coins=players.get(s);
               player=s;
                main.jLabel3.setText("COINS: "+coins);
               return;
           }
       
       players.put(s, 0);
       player=s;
       coins=0;
        main.jLabel3.setText("COINS: "+coins);
    }
    public void setCoins(int c){
        players.put(player, c);
        main.jLabel3.setText("COINS: "+c);
    }
    
    
    
}
