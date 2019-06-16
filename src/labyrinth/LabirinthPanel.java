/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import java.awt.AlphaComposite;
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
import java.awt.event.MouseListener;
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
 Tools tools;
    LabirinthCreator rc;

   int size;
    Random rg;
    boolean [] [] blocks;
    BufferedImage canNotGo;
    BufferedImage canGo;
    BufferedImage player;
    BufferedImage backGroung;
    BufferedImage flag;
    Point finish;
    int x; int y;
    String roadRout="/icons/road.jpg";
    String grassRout="/icons/grass.jpg";
    String sandRout="/icons/sand.jpg";
    String swampRout="/icons/swamp.jpg";
    String waterRout="/icons/water.jpg";
    String lavaRout="/icons/lava.jpg";
  
    private int xHovered=-1;
    private int yHovered=-1;
    
    LabirinthPanel(Tools t){
        tools=t;
      rg=new Random();
        rc = new LabirinthCreator();
        regenerate();
        requestFocus();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                requestFocus();
            }
        });
        addMouseMotionListener(new MouseAdapter(){
             int i,j;
                    @Override
            public void mouseMoved(MouseEvent e){
                Point p = e.getPoint();
                i=p.x/size;
                j=p.y/size;
                xHovered=findStart(i);
                yHovered=findStart(j);
                repaint();
            };
        });
        addMouseListener(new MouseAdapter() {
            int i,j;

            @Override
             public void mouseClicked(MouseEvent e){
                Point p = e.getPoint();
                i=p.x/size;
                j=p.y/size;
                i=findStart(i);
                j=findStart(j);
                if(findStart(x)==i&&findStart(y)==j)
                    return;
                if(i==0&&j==0)
                    return;
                else
                 if(tools.help1){
                     blocks=rc.correctOne(i,j);
                     tools.help1=false;
                  tools.setCoins( tools.coins-=5);
                 }
                 else if(tools.help2){
                        blocks=rc.getArray();
                        tools.help2=false;
                        tools.setCoins(tools.coins-=15);
                       
                }else{
                        
                         blocks=rc.revers(i,j);}
                repaint();
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
       repaint();
        if(x==finish.x&&y==finish.y){
            JOptionPane.showConfirmDialog(null, "Win", "win", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
            //тут + остановка таймера и добавление в рекорды+открытие вы выиграли и там 2 кнопки новая игра и главное меню
         
            if(tools.level==1)
             tools.setCoins(tools.coins+=5);
            else if(tools.level==2)
             tools.setCoins(tools.coins+=7);
            else 
              tools.setCoins(tools.coins+=10); 
        }
    }
        });
    
        
    }
      private int findStart(int s){
                 if(s%3==1)
                    return s-1;
                 else if(s%3==2)
                     return s-2;
                 else
                     return s;
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
         if(tools.level==1)
             size=45;
         else if(tools.level==2)
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
            if((i-yHovered)>=0 && (i-yHovered)<3 && j==xHovered)g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
            else if( j==xHovered+3)g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            if(blocks[i][j]==false)g2.drawImage(canNotGo, j*size, i*size, null);
            else if(blocks[i][j]==true) g2.drawImage(canGo, j*size, i*size, null);
            if(i+1==blocks.length&& j%3==0)g2.drawLine(j*size,0,j*size,getHeight());
           }
             if(i%3==0)g2.drawLine(0,i*size,getWidth(),i*size);
        }
        g2.setColor(Color.GREEN);
        Rectangle r = new Rectangle(size*finish.x,size*finish.y, size,size);
        g2.fill(r);
        g2.draw(r);
        g2.drawImage(flag, size*finish.x,size*finish.y,null);
        g2.drawImage(player, x*size, y*size, null);
    }

    public void regenerate() {
        x=1;y=1;
        setSize();
        rc.setSize(tools.level);
        rc.creator();
       blocks=rc.getClone();
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
            
            
        player = setScaledInstance(tools.playerRout);
         flag = setScaledInstance("/icons/flag.png");
        }catch(IOException e){}
        repaint();
    }
   
  
    
    
}
