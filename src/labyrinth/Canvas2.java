/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;


import javax.swing.JButton;


/**
 *
 * @author k256
 */
public class Canvas2 extends Canvas{

    JButton[] b = {new JButton("EASY"),new JButton("MEDIUM"),new JButton("HARD"),new JButton("AVATAR")};
      public Canvas2(){
        super("D2 R2 D2 R2 D4 L4 U2 R4 U2 R8 D4 R2 U5 L1 U1 L1 U2 R1 U2 L1 U2 R9 D7 L1 D2 R1 D2 L3 U1 L2 D2 R2 U5 L2 D1 L2 U1 L1 U1 L3 U5 L2 D2 L6 D1 L2","settings",1,5);
        addButtons();
       }        
 
     private void addButtons(){
     for(JButton but  : b) {
         but.setSize(bW,bH);
         add(but);
     }
     b[0].setLocation(3*size, 1*size);
     b[1].setLocation(5*size, 6*size);
     b[2].setLocation(7*size, 11*size);
     b[3].setSize(4*size, 4*size);
     b[3].setLocation(17*size, 3*size);
     }
}
