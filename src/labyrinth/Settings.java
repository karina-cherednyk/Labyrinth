/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author k256
 */
public class Settings extends javax.swing.JFrame {

    Tools tools;

    /**
     * Creates new form Settings
     */
    public Settings(Tools t) {
        tools = t;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        canvas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        exitBut = new javax.swing.JButton();
        easyBut = new javax.swing.JToggleButton();
        mediumBut = new javax.swing.JToggleButton();
        hardBut = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        avatarBut = new javax.swing.JButton();
        timeBox = new javax.swing.JCheckBox();
        addDarkBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("UD Digi Kyokasho NK-B", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SETTINGS");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));

        exitBut.setBackground(new java.awt.Color(0, 0, 0));
        exitBut.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 24)); // NOI18N
        exitBut.setForeground(new java.awt.Color(255, 255, 255));
        exitBut.setText("EXIT");
        exitBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButActionPerformed(evt);
            }
        });

        easyBut.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(easyBut);
        easyBut.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 1, 24)); // NOI18N
        easyBut.setForeground(new java.awt.Color(255, 255, 255));
        easyBut.setText("EASY");
        easyBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyButActionPerformed(evt);
            }
        });

        mediumBut.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(mediumBut);
        mediumBut.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 1, 24)); // NOI18N
        mediumBut.setForeground(new java.awt.Color(255, 255, 255));
        mediumBut.setText("MEDIUM");
        mediumBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumButActionPerformed(evt);
            }
        });

        hardBut.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(hardBut);
        hardBut.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 1, 24)); // NOI18N
        hardBut.setForeground(new java.awt.Color(255, 255, 255));
        hardBut.setText("HARD");
        hardBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardButActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PLAYER NAME:");

        nameField.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        nameField.setText("player");

        avatarBut.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 1, 24)); // NOI18N
        avatarBut.setForeground(new java.awt.Color(255, 255, 255));
        avatarBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/man.png"))); // NOI18N
        avatarBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatarButActionPerformed(evt);
            }
        });

        timeBox.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 1, 24)); // NOI18N
        timeBox.setForeground(new java.awt.Color(255, 255, 255));
        timeBox.setText("ADD TIME LIMIT");
        timeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeBoxActionPerformed(evt);
            }
        });

        addDarkBox.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 1, 24)); // NOI18N
        addDarkBox.setForeground(new java.awt.Color(255, 255, 255));
        addDarkBox.setText("ADD DARKNESS");
        addDarkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDarkBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(exitBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(hardBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(easyBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mediumBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(timeBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(avatarBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addDarkBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(easyBut, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mediumBut, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hardBut, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(avatarBut, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDarkBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitBut)
                .addGap(35, 35, 35))
        );

        int w = 150;
        int h = 150;
        ii[0] =        (new ImageIcon(getClass().getResource("/icons/alien.png"))).getImage().getScaledInstance(w,h, Image.SCALE_SMOOTH);
        ii[1] =        (new ImageIcon(getClass().getResource("/icons/avatar.png"))).getImage().getScaledInstance(w,h, Image.SCALE_SMOOTH);
        ii[2] =        (new ImageIcon(getClass().getResource("/icons/boy.png"))).getImage().getScaledInstance(w,h, Image.SCALE_SMOOTH);
        ii[3] =        (new ImageIcon(getClass().getResource("/icons/girl.png"))).getImage().getScaledInstance(w,h, Image.SCALE_SMOOTH);
        ii[4] =        (new ImageIcon(getClass().getResource("/icons/woman.png"))).getImage().getScaledInstance(w,h, Image.SCALE_SMOOTH);
        ii[5] =        (new ImageIcon(getClass().getResource("/icons/man.png"))).getImage().getScaledInstance(w,h, Image.SCALE_SMOOTH);
        ii[6] =        (new ImageIcon(getClass().getResource("/icons/ninja.png"))).getImage().getScaledInstance(w,h, Image.SCALE_SMOOTH);
        ii[7] =        (new ImageIcon(getClass().getResource("/icons/rabbit.png"))).getImage().getScaledInstance(w,h, Image.SCALE_SMOOTH);

        avatarBut.setIcon(new ImageIcon(ii[avatarIndex]));

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canvasLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(139, 139, 139))
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButActionPerformed
        tools.main.jLabel2.setText("PLAYER: " + nameField.getText());
        tools.setPlayer(nameField.getText());
        dispose();
        tools.main.setVisible(true);

    }//GEN-LAST:event_exitButActionPerformed

    private void timeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeBoxActionPerformed
        if (timeBox.isSelected()) {
            tools.onTime = true;
        } else {
            tools.onTime = false;
        }
    }//GEN-LAST:event_timeBoxActionPerformed

    private void avatarButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatarButActionPerformed
        int w = avatarBut.getWidth();
        int h = avatarBut.getHeight();
        avatarIndex = (avatarIndex + 1) % ii.length;
        avatarBut.setIcon(new ImageIcon(ii[avatarIndex]));
        tools.playerRout = rout[avatarIndex];

    }//GEN-LAST:event_avatarButActionPerformed

    private void easyButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easyButActionPerformed
        tools.level = 1;
        mediumBut.setSelected(false);
        hardBut.setSelected(false);
    }//GEN-LAST:event_easyButActionPerformed

    private void mediumButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumButActionPerformed
        tools.level = 2;
        easyBut.setSelected(false);
        hardBut.setSelected(false);
    }//GEN-LAST:event_mediumButActionPerformed

    private void hardButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardButActionPerformed
        tools.level = 3;
        easyBut.setSelected(false);
        mediumBut.setSelected(false);
    }//GEN-LAST:event_hardButActionPerformed

    private void addDarkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDarkBoxActionPerformed
        if (addDarkBox.isSelected()) {
            tools.darkness = true;
        } else {
            tools.darkness = false;

        }
    }//GEN-LAST:event_addDarkBoxActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Settings().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox addDarkBox;
    private javax.swing.JButton avatarBut;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel canvas;
    private javax.swing.JToggleButton easyBut;
    private javax.swing.JButton exitBut;
    private javax.swing.JToggleButton hardBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton mediumBut;
    private javax.swing.JTextField nameField;
    private javax.swing.JCheckBox timeBox;
    // End of variables declaration//GEN-END:variables
int avatarIndex = 4;
    Image[] ii = new Image[8];
    String[] rout = new String[]{"/icons/alien.png", "/icons/avatar.png", "/icons/boy.png", "/icons/girl.png", "/icons/woman.png", "/icons/man.png", "/icons/ninja.png", "/icons/rabbit.png"};
}
