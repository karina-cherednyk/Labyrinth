/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import java.util.HashMap;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User
 */
public class Tools {
    int coins=20;
    int level=1;
    String playerRout="/icons/woman.png";
    boolean onTime;
    Labyrinth main;
    boolean help1;
    boolean darkness;
    boolean help2;
    HashMap<String,Integer> players; 
    String player="player";
   
    public Tools(Labyrinth l) {
        players=new HashMap<>();
        main=l;
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
    public void addWinner(){
          String time = main.g.timeLab.getText().substring(13);
                  Object[] gamer = {player,time};
        switch(level){
            case 1:{
           ((DefaultTableModel) main.r.easyTable.getModel()).addRow(gamer);
                break;}
            case 2:{
            ((DefaultTableModel) main.r.mediumTable.getModel()).addRow(gamer);    
                break;}
            default:{
          ((DefaultTableModel) main.r.hardTable.getModel()).addRow(gamer);
                     }}
    }
    //return s
    private int MINUTE = 60;
    private int halfMIN = MINUTE/2;
 
    int getTimeLeft() {
        switch(level){
        case 1: return 3*MINUTE;
        case 2: return 3*MINUTE+halfMIN;
        case 3: return 4*MINUTE;
    }
    return -1;
    }
    
}
