/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class LabirinthPanel extends JPanel{
    LabirinthCreator rc;
    int level=1;
   int size;
    Random rg;
    boolean [] [] blocks;
      BufferedImage canNotGo;
    BufferedImage canGo;
    BufferedImage player;
    BufferedImage backGroung;
    BufferedImage flag;
    Point finish;
    int x = 0; int y = 0;
    String roadRout="/icons/road.jpg";
    String grassRout="/icons/grass.jpg";
    String sandRout="/icons/sand.jpg";
    String swampRout="/icons/swamp.jpg";
    String waterRout="/icons/water.jpg";
    String lavaRout="/icons/lava.jpg";
    String palyerRout="/icons/man.png";
  
    LabirinthPanel(){
        rg=new Random();
        rc = new LabirinthCreator();
           regenerate();
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                requestFocus();
            }
        });
        this.addKeyListener(new KeyAdapter() {
             @Override
    public void keyPressed(KeyEvent e) {
        requestFocus();
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP){    if(y-1>=0&&blocks[y-1][x]!=false)y--; }
        else if (code == KeyEvent.VK_DOWN){ if(y+1<blocks.length&&blocks[y+1][x]!=false)y++; }
        else if (code == KeyEvent.VK_LEFT){ if(x-1>=0&&blocks[y][x-1]!=false)x--; }
        else if (code == KeyEvent.VK_RIGHT){ if(x+1<blocks[1].length&&blocks[y][x+1]!=false)x++; }
        else return;
        if(x==finish.x&&y==finish.y){
            JOptionPane.showConfirmDialog(null, "Win", "win", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
        }
        repaint();
    }
        });
    
        
    }
     private BufferedImage setScaledInstance(String path) throws IOException{
      BufferedImage temp = ImageIO.read(getClass().getResource(path));
      Image toolkitImage = temp.getScaledInstance(size, size, Image.SCALE_SMOOTH);
      BufferedImage img = new BufferedImage(size, size, 
      BufferedImage.TYPE_INT_ARGB);
      img.getGraphics().drawImage(toolkitImage, 0, 0, null);
      return img;
      }
     public void setSize(){
         if(level==1)
             size=45;
         else if(level==2)
             size=24;
         else
             size=15;
         
     }
     public void addFinish(){
        finish=new Point(blocks[1].length-2, blocks.length-2);
     }
    
    public void paintComponent(Graphics g){
    super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canNotGo, 0,0,getWidth(),getHeight(),null);
                for(int i=0; i<blocks.length; i++){
            for(int j=0; j<blocks[i].length;j++){
            if(blocks[i][j]==false)g2.drawImage(canNotGo, j*size, i*size, null);
            else if(blocks[i][j]==true) g2.drawImage(canGo, j*size, i*size, null);
           }
        }
        g2.setColor(Color.GREEN);
        Rectangle r = new Rectangle(size*finish.x,size*finish.y, size,size);
        g2.fill(r);
        g2.draw(r);
        g2.drawImage(flag, size*finish.x,size*finish.y,null);
        g2.drawImage(player, x*size, y*size, null);
    }

    public void regenerate() {
        setSize();
        rc.setSize(level);
        rc.creator();
       
        blocks=rc.getArray();
         addFinish();
        try{
            int k =rg.nextInt(3); 
            if(k==0){
        canNotGo = setScaledInstance(waterRout);
        canGo = setScaledInstance(sandRout);
        backGroung=setScaledInstance(waterRout);
            }else if(k==1){
                canNotGo = setScaledInstance(swampRout);
                canGo = setScaledInstance(grassRout);
                backGroung=setScaledInstance(swampRout);
            }else{
                canNotGo = setScaledInstance(lavaRout);
        canGo = setScaledInstance(roadRout);
        backGroung=setScaledInstance(lavaRout);
            }
            
            
        player = setScaledInstance(palyerRout);
         flag = setScaledInstance("/icons/flag.png");
        }catch(IOException e){}
        repaint();
    }
    
    
}
