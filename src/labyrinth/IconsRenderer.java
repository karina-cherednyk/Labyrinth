/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author k256
 */
public class IconsRenderer extends JLabel
                       implements ListCellRenderer {
    private final ImageIcon[] icons;
    
    public IconsRenderer() {
        this.icons = new ImageIcon[]{
        new ImageIcon(getClass().getResource("/icons/alien.png")),
        new ImageIcon(getClass().getResource("/icons/avatar.png")),
        new ImageIcon(getClass().getResource("/icons/boy.png")),
        new ImageIcon(getClass().getResource("/icons/girl.png")),
        new ImageIcon(getClass().getResource("/icons/woman.png")),
        new ImageIcon(getClass().getResource("/icons/man.png")),
        new ImageIcon(getClass().getResource("/icons/ninja.png")),
        new ImageIcon(getClass().getResource("/icons/rabbit.png"))
        };

        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setPreferredSize(new Dimension(150, 80));
        
    }

    /*
     * This method finds the image and text corresponding
     * to the selected value and returns the label, set up
     * to display the text and image.
     */
    public Component getListCellRendererComponent(
                                       JList list,
                                       Object value,
                                       int index,
                                       boolean isSelected,
                                       boolean cellHasFocus) {
         int selectedIndex = Integer.parseInt(value.toString());
         if (isSelected) {
            setBackground(Color.GRAY);
           setForeground(list.getForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        if(selectedIndex== -1) return this;
     
        //Set the icon and text.  If icon was null, say so.
        ImageIcon icon = icons[selectedIndex];
        setIcon(icon);
      
        return this;
    }
}
