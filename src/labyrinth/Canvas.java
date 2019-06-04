/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author k256
 */
public abstract class Canvas extends JPanel{
    protected int width = 720;
    protected int height = 450;
    protected int size = 30;
    protected int w=width/size; //24
    protected int h=height/size; //15
    protected int pX=1,pY=5;
    protected BufferedImage grass;
    protected BufferedImage road;
    protected BufferedImage player;
    protected BufferedImage mm;
    protected static final int WHITE = -1;
    protected static final int BLACK = -16777216;
    protected static final int U=1,R=2,D=3,L=4;
    protected int bW=5*size, bH=2*size;
    protected int[] playerMoves;
    protected Timer timer;
      public Canvas(String s,String img,int X,int Y){
    super();
    setSize(width,height);
    pX=X;pY=Y;
    playerMoves = fillArray(s);
            try {
            grass = setScaledInstance("/icons/grass.jpg");
            road = setScaledInstance("/icons/road.jpg");
            player = setScaledInstance("/icons/man.png");
            mm = ImageIO.read(getClass().getResource("/maps/"+img+".png"));
        } catch (IOException ex) {}
        timer = new Timer();
           TimerTask tt = new TimerTask() {
               private int count;
               @Override
               public void run() {
                   if(count==playerMoves.length) count=0;
                   countPlayerMoves(playerMoves[count++]);
                   repaint();
               }
           };
           timer.schedule(tt, 0, 100);
       }        
   
    
    
    
      private BufferedImage setScaledInstance(String path) throws IOException{
      BufferedImage temp = ImageIO.read(getClass().getResource(path));
      Image toolkitImage = temp.getScaledInstance(size, size, Image.SCALE_SMOOTH);
      BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
      img.getGraphics().drawImage(toolkitImage, 0, 0, null);
      return img;
      }
      
        @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
        for(int i=0; i<w; i++){
            for(int j=0;j<h;j++){
            if(mm.getRGB(i, j)==BLACK) g.drawImage(road, i*size, j*size, null);
            else g.drawImage(grass, i*size, j*size, null);
            }
            }
        g.drawImage(player, pX*size, pY*size, null);       
    }
    private void countPlayerMoves(int i){
    if(i==U) pY-=1;
    else if(i==D) pY+=1;
    else if(i==L) pX-=1;
    else if(i==R) pX+=1;
    }
    
   
     private void cout(String s){
      System.out.println(s);
     }
      private void cout(){
      System.out.println();
     }
     private int[] fillArray(String route){
     ArrayList<Integer> res = new ArrayList<>();
     Pattern p = Pattern.compile("(\\s*[URDL]\\d+\\s*)");
     Matcher m = p.matcher(route);
     String group;
     int direction;
     int count;
    while(m.find()){
    group = m.group().trim();
    direction = getDirection(group.charAt(0));
    count = Integer.parseInt(group.substring(1));
    while(count-->0) res.add(direction); 
    }
    return res.stream().mapToInt(i -> i).toArray();
     }  
     private int getDirection(char c){
     switch(c){
             case 'U': return U;
             case 'D': return D;
             case 'L': return L;
             case 'R': return R;
             default: return -1;
     }
     }
}
