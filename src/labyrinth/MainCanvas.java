/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @author Karina Cherednyk
 */
public class MainCanvas extends JPanel implements KeyListener{
    //o=block 1-door 2-character
    int[][] blocks =  new int[][]{
        {0,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,1,1,1,0,0,0,0},
        {0,0,0,0,1,2,1,0,0,0,0},
        {0,0,0,0,1,1,1,0,0,0,0},
        {0,1,1,1,1,0,1,1,1,1,0},
        {0,1,3,1,0,0,0,1,4,1,0},
        {0,1,1,1,0,0,0,1,1,1,0},
        {0,0,1,1,1,0,1,1,1,0,0},
        {0,0,1,5,1,1,1,6,1,0,0},
        {0,0,1,1,1,0,1,1,1,0,0},   
        {0,0,0,0,0,0,0,0,0,0,0}    
    };
    int x=5;
    int y=0;
    int width =11;
    int height=12;
    int size=40;
    JRadioButton easyBut;
    JRadioButton mediumBut;
    JRadioButton hardBut;
    JCheckBox tLimitBut;
    JCheckBox aTipsBut;
    BufferedImage grass;
    BufferedImage road;
    BufferedImage player;
    public MainCanvas(JRadioButton e,JRadioButton m, JRadioButton h, JCheckBox t, JCheckBox a) {
        super();
        easyBut = e;
        mediumBut = m;
        hardBut = h;
        tLimitBut = t;
        aTipsBut = a;
        try {
            grass = setScaledInstance("/icons/grass.jpg");
            road = setScaledInstance("/icons/road.jpg");
            player = setScaledInstance("/icons/man.png");
        } catch (IOException ex) {
            Logger.getLogger(MainCanvas.class.getName()).log(Level.SEVERE, null, ex);
        }
        addKeyListener(this);
    }
      private BufferedImage setScaledInstance(String path) throws IOException{
      BufferedImage temp = ImageIO.read(getClass().getResource(path));
      Image toolkitImage = temp.getScaledInstance(size, size, Image.SCALE_SMOOTH);
      BufferedImage img = new BufferedImage(size, size, 
      BufferedImage.TYPE_INT_ARGB);
      img.getGraphics().drawImage(toolkitImage, 0, 0, null);
      return img;
      }
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(int i=0; i<height; i++){
            for(int j=0; j<width;j++){
            if(blocks[i][j]==0)g2.drawImage(grass, j*size, i*size, null);
            else if(blocks[i][j]==1) g2.drawImage(road, j*size, i*size, null);
            else if(blocks[i][j]==2)g2.drawString("EASY", j*size, i*size+size/2);
             else if(blocks[i][j]==3)g2.drawString("MEDIUM", j*size, i*size+size/2);
             else if(blocks[i][j]==4)g2.drawString("HARD", j*size, i*size+size/2);
             else if(blocks[i][j]==5){
                 g2.drawString("TIME", j*size, i*size+size/2);
                 g2.drawString("LIMIT", j*size, i*size+size);
             }
             else if(blocks[i][j]==6){
                 g2.drawString("ADD", j*size, i*size+size/2);
                 g2.drawString("TIPS", j*size, i*size+size);
             }
            }
        }
        g2.drawImage(player, x*size, y*size, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP){    if(y-1>=0&&blocks[y-1][x]!=0)y--; }
        else if (code == KeyEvent.VK_DOWN){ if(y+1<height&&blocks[y+1][x]!=0)y++; }
        else if (code == KeyEvent.VK_LEFT){ if(x-1>=0&&blocks[y][x-1]!=0)x--; }
        else if (code == KeyEvent.VK_RIGHT){ if(x+1<width&&blocks[y][x+1]!=0)x++; }
        else return;
             if(blocks[y][x]==2)easyBut.setSelected(true);
        else if(blocks[y][x]==3)mediumBut.setSelected(true);
        else if(blocks[y][x]==4)hardBut.setSelected(true);
        else if(blocks[y][x]==5)tLimitBut.setSelected(!tLimitBut.isSelected());
        else if(blocks[y][x]==6)aTipsBut.setSelected(!aTipsBut.isSelected());
        
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
