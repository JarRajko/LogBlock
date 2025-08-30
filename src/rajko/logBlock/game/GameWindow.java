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

package rajko.logBlock.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.Timer;
import rajko.logBlock.objects.MyObject;
import rajko.logBlock.player.Direction;
import rajko.logBlock.player.Player;
import rajko.logBlock.world.GameWorld;

/**
 *
 * @author Rajko Trieda kt. sa stara o interakciu medzi app a uzivatelom
 */
public class GameWindow extends JTable implements ActionListener, KeyListener, MouseListener, MouseWheelListener {

    private final Player player;
    private final GameWorld world;
    private final Timer timer;
    private final int speed = 150;//move each speed ms (can't move faster than 1)
    private int lastPressedKey = -1; //vars used to move character with holding
    private double timeHeld = 0; //key instead of pressing it, help and credit: Peter Strycek
    private double startTime; //source stary project date: approximately december 2018
    private int signDrawTime = 10;
    private int signDrawTimeCounter = 0;
    private boolean sign;

    /**
     * Vytvori nove okno pre komunikaciu s hracom a programom
     *
     * @param player Hrac
     * @param world svet
     */
    public GameWindow(Player player, GameWorld world) {
        boolean perhaps = true;
        this.timer = new Timer(5, this);
        this.player = player;
        this.world = world;
        this.setVisible(perhaps);
        this.setFocusable(true);     
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.addMouseWheelListener(this);
        this.timer.start();
        this.startTime = System.nanoTime();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //-------------------------PAINT GAME BLOCKS-------------------
        MyObject[][] board = this.world.getMapBoard();

        int horizontalTiles = 32;/*45;*/
        int verticalTiles = 20;/*24;*/
        int textureHeight = 32;
        int textureWidth = 32;
        int characterXposition = 16; //position to paint character
        int characterYposition = 10;

        for (int y = this.player.getY() - (verticalTiles); y < this.player.getY() + verticalTiles; y++) {
            for (int x = this.player.getX() - (horizontalTiles); x < this.player.getX() + horizontalTiles; x++) {
                MyObject cube = board[x][y]; //nvm kde bola chyba ale zle sa to vykreslovalo tak som prehodil x a y a uz ok
                ImageIcon block = new ImageIcon(cube.getTexturePath());
                Image image = block.getImage();

                int xPositionOfImage = (x - this.player.getX() + characterXposition) * textureWidth;
                int yPositionOfImage = (y - this.player.getY() + characterYposition) * textureHeight;

                if (cube.isTransparent()) {
                    ImageIcon grassyGrass = new ImageIcon(board[1][1].getTexturePath()); // na 1,1 je vzdy trava
                    Image grassImage = grassyGrass.getImage();
                    g2d.drawImage(grassImage, xPositionOfImage, yPositionOfImage, null);
                }

                if (x == this.player.getX() && y == this.player.getY()) { //paint player
                    g2d.drawImage(image, xPositionOfImage, yPositionOfImage, null);
                    g2d.drawImage(new ImageIcon(this.player.getPlayerTextureToPaint()).getImage(), xPositionOfImage, yPositionOfImage, null);
                } else {
                    g2d.drawImage(image, xPositionOfImage, yPositionOfImage, null);
                }
            }
        }
        //------------------------PAINT MINIMAP---------------------------------
        int xSize = 3;
        int ySize = 3;
        int xPadding = 920;
        int yPadding = 535;
        int minimapXsize = 64;
        int minimapYsize = 64;
        for (int y = this.player.getY() - (minimapYsize / 2); y < this.player.getY() + (minimapYsize / 2); y++) {
            for (int x = this.player.getX() - (minimapXsize / 2); x < this.player.getX() + (minimapXsize / 2); x++) {
                MyObject cube = board[x][y]; //nvm kde bola chyba ale zle sa to vykreslovalo tak som prehodil x a y a uz ok
                Color color = cube.getColor();
                g2d.setColor(color);

                if (y == this.player.getY() && x == this.player.getX()) {
                    g.setColor(this.player.getColor());
                }
                g2d.fillRect(((x - this.player.getX()) * xSize) + xPadding, ((y - this.player.getY()) * ySize) + yPadding, xSize, ySize);
            }
        }
        //----------------------PAINT SIGN--------------------------------------
    }

    @Override
    public void actionPerformed(ActionEvent e) { //every 1 ms
        if (!this.world.isGamePaused()) {
            this.repaint();
//            this.world.actionPerformed(e);
            if (this.lastPressedKey != -1) {
                double frameTime = (System.nanoTime() - this.startTime) / 10e5;
                this.timeHeld += frameTime;
            }

            //holding key to movecontiniously, help: Peter Strycek
            //source old project
            while (this.timeHeld >= this.speed) {
                this.timeHeld -= this.speed;
                if (this.lastPressedKey == KeyBind.KEY_UP.getKeyCode()) {
                    this.world.movePlayer(Direction.NORTH);
//                    this.player.move(Direction.NORTH);
                } else if (this.lastPressedKey == KeyBind.KEY_DOWN.getKeyCode()) {
                    this.world.movePlayer(Direction.SOUTH);
//                    this.player.move(Direction.SOUTH);
                } else if (this.lastPressedKey == KeyBind.KEY_LEFT.getKeyCode()) {
                    this.world.movePlayer(Direction.WEST);
//                    this.player.move(Direction.WEST);
                } else if (this.lastPressedKey == KeyBind.KEY_RIGHT.getKeyCode()) {
                    this.world.movePlayer(Direction.EAST);
//                    this.player.move(Direction.EAST);
                }
            }
            this.startTime = System.nanoTime();
        } else {
            //game is paused lmao 
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyBind.KEY_UP.getKeyCode() && this.lastPressedKey != KeyBind.KEY_UP.getKeyCode()) {
            this.lastPressedKey = key;
            this.timeHeld = this.speed;
        } else if (key == KeyBind.KEY_DOWN.getKeyCode() && this.lastPressedKey != KeyBind.KEY_DOWN.getKeyCode()) {
            this.lastPressedKey = key;
            this.timeHeld = this.speed;
        } else if (key == KeyBind.KEY_LEFT.getKeyCode() && this.lastPressedKey != KeyBind.KEY_LEFT.getKeyCode()) {
            this.lastPressedKey = key;
            this.timeHeld = this.speed;
        } else if (key == KeyBind.KEY_RIGHT.getKeyCode() && this.lastPressedKey != KeyBind.KEY_RIGHT.getKeyCode()) {
            this.lastPressedKey = key;
            this.timeHeld = this.speed;
        } else if (key == KeyEvent.VK_ESCAPE) { //NOTE: TODO pause game
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == this.lastPressedKey) {
            this.lastPressedKey = -1;
            this.timeHeld = 0;
        }
        this.player.restoreTextureDefaultState();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyBind.KEY_UP.getKeyCode()) {
            this.world.movePlayer(Direction.NORTH);
        } else if (e.getKeyCode() == KeyBind.KEY_DOWN.getKeyCode()) {
            this.world.movePlayer(Direction.SOUTH);
        } else if (e.getKeyCode() == KeyBind.KEY_RIGHT.getKeyCode()) {
            this.world.movePlayer(Direction.EAST);
        } else if (e.getKeyCode() == KeyBind.KEY_LEFT.getKeyCode()) {
            this.world.movePlayer(Direction.WEST);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

}
