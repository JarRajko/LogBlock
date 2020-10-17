/*
 * Copyright 2020 Rajko.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rajko.logBlock.windows.menu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Rajko
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        MainMenu m = new MainMenu();
        m.setVisible(true);
    }

    /**
     * instancuje okhno hl menu
     */
    public MainMenu() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        kredityLabel = new javax.swing.JLabel();
        koniecLabel = new javax.swing.JLabel();
        startLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setLayout(null);

        kredityLabel.setIcon(new javax.swing.ImageIcon("src/rajko/logBlock/assets/textures/menu/Kredity.png")); // NOI18N
        kredityLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kredityLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kredityLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kredityLabelMouseExited(evt);
            }
        });
        jPanel4.add(kredityLabel);
        kredityLabel.setBounds(130, 230, 224, 32);

        koniecLabel.setIcon(new javax.swing.ImageIcon("src/rajko/logBlock/assets/textures/menu/Koniec.png")); // NOI18N
        koniecLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                koniecLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                koniecLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                koniecLabelMouseExited(evt);
            }
        });
        jPanel4.add(koniecLabel);
        koniecLabel.setBounds(150, 290, 190, 32);

        startLabel.setIcon(new javax.swing.ImageIcon("src/rajko/logBlock/assets/textures/menu/Start.png")); // NOI18N
        startLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        startLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startLabelMouseExited(evt);
            }
        });
        jPanel4.add(startLabel);
        startLabel.setBounds(160, 170, 160, 32);

        jLabel1.setIcon(new javax.swing.ImageIcon("src/rajko/logBlock/assets/textures/menu/background.png")); // NOI18N
        jLabel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel1FocusGained(evt);
            }
        });
        jPanel4.add(jLabel1);
        jLabel1.setBounds(0, 0, 480, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1FocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jLabel1FocusGained
    {//GEN-HEADEREND:event_jLabel1FocusGained

    }//GEN-LAST:event_jLabel1FocusGained

    private void kredityLabelMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_kredityLabelMouseEntered
    {//GEN-HEADEREND:event_kredityLabelMouseEntered
        ImageIcon img = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\menu\\KredityA.png");
        kredityLabel.setIcon(img);
//        MusicPlayer.playSoundEffect("Menu select");
    }//GEN-LAST:event_kredityLabelMouseEntered

    private void kredityLabelMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_kredityLabelMouseExited
    {//GEN-HEADEREND:event_kredityLabelMouseExited
        ImageIcon img = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\menu\\Kredity.png");
        kredityLabel.setIcon(img);
    }//GEN-LAST:event_kredityLabelMouseExited

    private void koniecLabelMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_koniecLabelMouseEntered
    {//GEN-HEADEREND:event_koniecLabelMouseEntered
        ImageIcon img = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\menu\\KoniecA.png");
        koniecLabel.setIcon(img);
//        MusicPlayer.playSoundEffect("Menu select");
    }//GEN-LAST:event_koniecLabelMouseEntered

    private void koniecLabelMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_koniecLabelMouseExited
    {//GEN-HEADEREND:event_koniecLabelMouseExited
        ImageIcon img = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\menu\\Koniec.png");
        koniecLabel.setIcon(img);
    }//GEN-LAST:event_koniecLabelMouseExited

    private void startLabelMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_startLabelMouseEntered
    {//GEN-HEADEREND:event_startLabelMouseEntered
        ImageIcon img = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\menu\\StartA.png");
        startLabel.setIcon(img);
//        MusicPlayer.playSoundEffect("Menu select");
    }//GEN-LAST:event_startLabelMouseEntered

    private void startLabelMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_startLabelMouseExited
    {//GEN-HEADEREND:event_startLabelMouseExited
        ImageIcon img = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\menu\\Start.png");
        startLabel.setIcon(img);
    }//GEN-LAST:event_startLabelMouseExited

    private void startLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_startLabelMouseClicked
    {//GEN-HEADEREND:event_startLabelMouseClicked
        this.dispose();

        CharacterPicker chp = new CharacterPicker();
    }//GEN-LAST:event_startLabelMouseClicked

    private void koniecLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_koniecLabelMouseClicked
    {//GEN-HEADEREND:event_koniecLabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_koniecLabelMouseClicked

    private void kredityLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_kredityLabelMouseClicked
    {//GEN-HEADEREND:event_kredityLabelMouseClicked
        Credits cr = new Credits();
    }//GEN-LAST:event_kredityLabelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel koniecLabel;
    private javax.swing.JLabel kredityLabel;
    private javax.swing.JLabel startLabel;
    // End of variables declaration//GEN-END:variables
}
