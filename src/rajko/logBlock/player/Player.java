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

package rajko.logBlock.player;

import java.awt.Color;
import java.awt.Point;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import rajko.logBlock.objects.items.Item;
import rajko.logBlock.objects.items.Key;
import rajko.logBlock.objects.items.KeyTier;

/**
 *
 * @author Rajko
 */
public class Player {

    private Direction facing = Direction.SOUTH;
    private final String timeStartedPlaying;
    private int movementState = 1;
    private boolean carpenting;
    private boolean god; //unused
    private String skinPath;
    private int strength;
    private int agility;
    private int x;
    private int y;
    private Inventory inv;
    private PlayerActionDriver actionDriver;
    private Color color;

    /**
     * Vytvori novy vesmir
     * @param skinPath cesta k texture hraca na vykreslenie
     */
    public Player(String skinPath) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  //https://www.javatpoint.com/java-get-current-date
        LocalDateTime now = LocalDateTime.now();
        this.timeStartedPlaying = dtf.format(now);
        this.skinPath = skinPath;
        this.x = 1520;
        this.y = 1520;
        this.strength = 1;
        this.agility = 2;
        this.inv = new Inventory();
        this.actionDriver = new PlayerActionDriver();
        this.color = new Color(255, 0, 0);//Colors.PLAYER.getColor();
    }

    /**
     * zmeni smer hraca a aj texturu kera sa ma vykreslit
     * @param direction
     */
    public void move(Direction direction) {
        this.actionDriver.playerMoved(direction);
        switch (direction) {
            case SOUTH:
                this.moveDown();
                break;
            case NORTH:
                this.moveUp();
                break;
            case EAST:
                this.moveRight();
                break;
            case WEST:
                this.moveLeft();
                break;
        }
    }

    /**
     * prida si item do invetaroch
     * @param item
     */
    public void pickItem(Item item) { 
        this.actionDriver.playerPickUpItem(item);
        this.inv.addToInvetory(item);
    }

    /**
     * zvisi silu
     */
    public void raiseStrength() {
        this.actionDriver.playerStrengthIncreased();
        this.strength++;
    }

    /**
     * zvisi hybnost
     */
    public void raiseAgility() {
        this.actionDriver.playerAgilityIncreased();
        this.agility++;
    }

    /**
     * znizi silu
     */
    public void decreaseStrength() {
        if (this.strength > 1) {
            this.actionDriver.playerStrengthDecreased();
            this.strength--;
        }
    }

    /**
     * znizi hybnost
     */
    public void decreaseAgility() {
        if (this.agility > 1) {
            this.actionDriver.playerAgilityDecreased();
            this.agility--;
        }
    }

    private void moveUp() {
        this.facing = Direction.NORTH;
        this.y--;
        if (this.movementState != 3) {
            this.movementState++;
        } else {
            this.movementState = 1;
        }
    }

    private void moveDown() {
        this.facing = Direction.SOUTH;
        this.y++;
        if (this.movementState != 3) {
            this.movementState++;
        } else {
            this.movementState = 1;
        }
    }

    private void moveLeft() {
        this.facing = Direction.WEST;
        this.x--;
        if (this.movementState != 3) {
            this.movementState++;
        } else {
            this.movementState = 1;
        }
    }

    private void moveRight() {
        this.facing = Direction.EAST;
        this.x++;
        if (this.movementState != 3) {
            this.movementState++;
        } else {
            this.movementState = 1;
        }
    }

    /**
     * nastavi texturu na hraca v klude
     */
    public void restoreTextureDefaultState() {
        this.movementState = 1;
    }

    /**
     * Nastavi facing
     * @param facing facing
     */
    public void setFacing(Direction facing) {
        this.facing = facing;
    }

    /**
     * zisti startovaci cas hraca
     * @return  vrati string casu zacatku hru
     */
    public String getStartingTime() {
        return this.timeStartedPlaying;
    }

    /**
     * returns texture with selected skin and proper facing
     * @return  cesta k texture hraca 
     */
    public String getPlayerTextureToPaint() {
        return this.skinPath + this.facing.getHeading() + "\\" + this.movementState + ".png";
    }

    /**
     * 
     * @return sila hraca
     */
    public int getStrength() {
        return this.strength;
    }

    /**
     *
     * @return hzbnost hraca
     */
    public int getAgility() {
        return this.agility;
    }

    /**
     *
     * @return stav carpentingu hraca
     */
    public boolean isCarpenting() {
        return this.carpenting;
    }

    /**
     *
     * @return x suradnicu hraca
     */
    public int getX() {
        return this.x;
    }

    /**
     *
     * @return z suradnicu hraca
     */
    public int getY() {
        return this.y;
    }

    /**
     * 
     * @return smer ktorym sa hrac pozera
     */
    public Direction getFacingDirection() {
        return this.facing;
    }

    /**
     * Vrati zapuzdrenu kopiu bodu dalsieho miesta
     *
     * @return Point kde sa bude nachadzat pri dalsom pohybe
     */
    public Point getNextLocation(int distance) {
        switch (this.facing) {
            case SOUTH:
                return new Point(this.x, this.y + distance);
            case NORTH:
                return new Point(this.x, this.y - distance);
            case WEST:
                return new Point(this.x - distance, this.y);
            case EAST:
                return new Point(this.x + distance, this.y);
            default:
                System.out.println("Facing is " + this.facing + " and space is gonna blow!");
                return null;
        }
    }

    /**
     *
     * @return true ak hej false ak nem
     */
    public boolean isGod() {
        return this.god;
    }

    /**
     * vrati "immutable" object (ak nie je tak sa tvarime ze je immutable)
     * @return
     */
    public PlayerActionDriver getActionDriver() {
        return this.actionDriver;
    }

    /**
     * skontroluje ci ma hrac v inventari kluc
     * @param tier tier kluca
     * @return true ak ma false ak nema
     */
    public boolean hasKey(KeyTier tier) {
        return this.inv.hasKeyWithTier(tier);
    }

    /**
     * odoberie kluc s urciym tierom hracovi z invetaroch
     * @param tier kluc na odobranie
     */
    public void removeKey(KeyTier tier) {
        this.inv.removeKeyFromInventory(new Key(tier));
    }

    //TODO strength and agility icons  + signs

    /**
     * vrati farbu hraca
     * @return
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * nastavi mechaniku pokladania blokov (karpenting) na true
     */
    public void makeCarpenter() {
        this.carpenting = true;
    }

    /**
     * nastavi mechaniku karpentovania blokov na false
     */
    public void demakeCarpenter() {
        this.carpenting = false;
    }
}
