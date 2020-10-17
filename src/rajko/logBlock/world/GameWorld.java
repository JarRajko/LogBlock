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

package rajko.logBlock.world;

import java.awt.event.ActionEvent;
import rajko.logBlock.exceptions.MapNotFoundException;
import rajko.logBlock.game.Game;
import rajko.logBlock.game.GameLoader;
import rajko.logBlock.objects.*;
import rajko.logBlock.objects.blocks.Block;
import rajko.logBlock.objects.blocks.Box;
import rajko.logBlock.objects.blocks.IFloor;
import rajko.logBlock.objects.blocks.Turniket;
import rajko.logBlock.objects.items.Item;
import rajko.logBlock.player.*;
import rajko.logBlock.objects.blocks.IActivable;

/**
 *
 * @author Rajko
 */
public class GameWorld {

    private final Game game;
    private Map map;
    private Player player;
    private PlayerActionDriver driver;

    /**
     * vytvori novy vesmir
     * @param player hrac
     * @param game hra
     */
    public GameWorld(Player player, Game game) {
        this.map = new Map();
        this.player = player;
        this.game = game;
        this.driver = player.getActionDriver();
        
        GameLoader loader = new GameLoader(this.map);
        System.out.println("Loading from map...");
        try {
            loader.setSeedFromPicture();
            System.out.println("Load succesful!");
        } catch (MapNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Vrati kopiu hracej plochy z mapy
     *
     * @return
     */
    public MyObject[][] getMapBoard() {
        return this.map.getBoard();
    }

    /**
     * Vracia stav o pauznuti hry, true ak je hra pauznuta false ak hra nie je
     * pauznuta
     *
     * @return stav pauznutia hry
     */
    public boolean isGamePaused() {
        return this.game.isPaused();
    }

    /**
     * Definuje co sa ma stat ked sa hrac bude chciet pohnut.
     * @param direction
     */
    public void movePlayer(Direction direction) {
        this.player.setFacing(direction);
        MyObject object = this.map.getObject(this.player.getNextLocation(1)); //NOTE: nezmeni sa facing

        if (object instanceof IActivable) {
            ((IActivable)object).activate(this.player, this.map,this.game);
        }
        
        if (object instanceof Item) { //picking up items
            if (((Item)object).isPickable()) {
                ((Item) object).pickUp(this.player);
                this.map.deleteFromMap(this.player.getNextLocation(1));
                this.player.move(direction);
            }
        }
        
        if (object instanceof Block) { //Push Block
            if (((Block) object).push(direction, this.player, this.map)) {
                this.movePlayer(direction);
            }
            if (((Block) object).access(this.player)) { //Move through block
                this.player.move(direction);
                this.driver.playerMovedThroughBlock((Block)object);
            }

            if (object instanceof Turniket) { //Turnikets mechanics
                if (this.driver.getTurniketsPassed() == player.getAgility()) {
                    this.map.rotateTurnikets();
                    this.driver.resetTurniketsPassed();
                }
            } else {
                this.driver.resetTurniketsPassed();
            }
        }
        
        if (this.player.isCarpenting()) {
            if (this.map.getObject(this.player.getNextLocation(0)) instanceof IFloor) {
                this.map.addToMap(new Box(), this.player.getX(), this.player.getY());
            }
        }
 
    }
    
    /**
     * Metoda ktora sa vola kazdy "tick" nepouzita so far
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
//        this.checkBlocksAroundPlayer();
    }

    
    /**
     * Stopne hru
     */
    public void keyPausePressed() { //NOTE:TODO
        if (this.game.isPaused()) {
            this.game.resumeGame();
        } else {
            this.game.pauseGame();
        }
    }

//    private void checkBlocksAroundPlayer() {
//       
//    }

}
