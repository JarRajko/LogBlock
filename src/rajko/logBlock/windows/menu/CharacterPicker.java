package rajko.logBlock.windows.menu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import rajko.logBlock.game.Game;

/**
 * vytori novy character picker
 * @author Rajko
 */
public class CharacterPicker extends JPanel implements ActionListener {

    private String[] characters = {"betty", "george", "carrot", "coriander", "francoas", "jasmine", "pepper", "saffron", "bonny"};
    private int index = 0;
    private short number = 1;
    private short numberToPaint = 1;
    private JFrame frame;

    /**
     * INSTANCUJE CHARAKTER PICKER
     */
    public CharacterPicker() {
        this.initComponents();
        Timer timer = new Timer(100, this);

        this.frame = new JFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.frame = new JFrame();
        this.frame.setResizable(false);
        this.frame.getContentPane().add(this);
        this.frame.setSize(180, 150);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setAlwaysOnTop(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        previousLabel = new javax.swing.JLabel();
        confirmLabel = new javax.swing.JLabel();
        nextLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        previousLabel.setIcon(new javax.swing.ImageIcon("src/rajko/logBlock/assets/textures/menu/arrow1.png")); // NOI18N
        previousLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                previousLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                previousLabelMouseExited(evt);
            }
        });

        confirmLabel.setIcon(new javax.swing.ImageIcon("src/rajko/logBlock/assets/textures/menu/thick mark.png")); // NOI18N
        confirmLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmLabelMouseExited(evt);
            }
        });

        nextLabel.setIcon(new javax.swing.ImageIcon("src/rajko/logBlock/assets/textures/menu/arrow2.png")); // NOI18N
        nextLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextLabelMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("src/rajko/logBlock/assets/textures/menu/Character picker.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(previousLabel)
                .addGap(35, 35, 35)
                .addComponent(confirmLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(nextLabel)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(previousLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(confirmLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextLabel)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void previousLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_previousLabelMouseClicked
    {//GEN-HEADEREND:event_previousLabelMouseClicked
        if (this.index > 0) {
            this.index--;
        } else {
            this.index = 8;
        }
    }//GEN-LAST:event_previousLabelMouseClicked

    private void nextLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nextLabelMouseClicked
    {//GEN-HEADEREND:event_nextLabelMouseClicked
        if (this.index < 8) {
            this.index++;
        } else {
            this.index = 0;
        }
    }//GEN-LAST:event_nextLabelMouseClicked

    private void confirmLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_confirmLabelMouseClicked
    {//GEN-HEADEREND:event_confirmLabelMouseClicked
        this.frame.dispose();
        Game g = new Game("src\\rajko\\logBlock\\assets\\skins\\" + characters[index]+"\\");
    }//GEN-LAST:event_confirmLabelMouseClicked

    private void nextLabelMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nextLabelMouseEntered
    {//GEN-HEADEREND:event_nextLabelMouseEntered
        ImageIcon img = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\menu\\arrow2H.png");
        this.nextLabel.setIcon(img);
    }//GEN-LAST:event_nextLabelMouseEntered

    private void previousLabelMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_previousLabelMouseEntered
    {//GEN-HEADEREND:event_previousLabelMouseEntered
        ImageIcon img = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\menu\\arrow1H.png");
        this.previousLabel.setIcon(img);
    }//GEN-LAST:event_previousLabelMouseEntered

    private void confirmLabelMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_confirmLabelMouseEntered
    {//GEN-HEADEREND:event_confirmLabelMouseEntered
        ImageIcon img = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\menu\\thick markH.png");
        this.confirmLabel.setIcon(img);
    }//GEN-LAST:event_confirmLabelMouseEntered

    private void nextLabelMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nextLabelMouseExited
    {//GEN-HEADEREND:event_nextLabelMouseExited
        ImageIcon img = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\menu\\arrow2.png");
        this.nextLabel.setIcon(img);
    }//GEN-LAST:event_nextLabelMouseExited

    private void confirmLabelMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_confirmLabelMouseExited
    {//GEN-HEADEREND:event_confirmLabelMouseExited
        ImageIcon img = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\menu\\thick mark.png");
        this.confirmLabel.setIcon(img);
    }//GEN-LAST:event_confirmLabelMouseExited

    private void previousLabelMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_previousLabelMouseExited
    {//GEN-HEADEREND:event_previousLabelMouseExited
        ImageIcon img = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\menu\\arrow1.png");
        this.previousLabel.setIcon(img);
    }//GEN-LAST:event_previousLabelMouseExited

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (this.number == 1) {
            this.numberToPaint = 1;
            this.number++;
        } else if (this.number == 2) {
            this.numberToPaint = 2;
            this.number++;
        } else if (this.number == 3) {
            this.numberToPaint = 1;
            this.number++;
        } else {
            this.numberToPaint = 3;
            this.number = 1;
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        ImageIcon character = new ImageIcon("src\\rajko\\logBlock\\assets\\skins\\" + this.characters[index] + "/down/" + this.numberToPaint + ".png");
        ImageIcon grass = new ImageIcon("src\\rajko\\logBlock\\assets\\textures\\blocks\\grass\\light.png");
        Image image = character.getImage();
        Image image2 = grass.getImage();

        for (int x = 0; x < 6; x++) {
            for (int i = 0; i < 5; i++) {
                g.drawImage(image2, x * 32, i * 32, null);
            }
        }

        g.drawImage(image, 72, 25, null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel confirmLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nextLabel;
    private javax.swing.JLabel previousLabel;
    // End of variables declaration//GEN-END:variables
}
