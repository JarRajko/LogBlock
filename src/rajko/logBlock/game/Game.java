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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import rajko.logBlock.player.Player;
import rajko.logBlock.world.GameWorld;

/**
 *
 * @author Rajko
 */
public class Game {

    private Window win;
    private Player player;
    private GameWorld world;
    private boolean paused;
    private GameWindow gameWindow;

    /**
     * Vytvori novu instanciu hry s hracom svetom oknom a hernym oknom
     * @param playerTexturePath cesta k texture s obrazkom hraca
     */
    public Game(String playerTexturePath) {
        this.player = new Player(playerTexturePath);
        this.world = new GameWorld(this.player, this);
        this.gameWindow = new GameWindow(this.player, this.world);
        this.win = new Window(1032, 670, this.gameWindow);
    }

    /**
     * Vrati aktualny cas vo formate dd/MM/yyyy HH:mm:ss
     * @return
     */
    public String getCurrentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  //https://www.javatpoint.com/java-get-current-date
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    /**
     * Informacia o pauznuti hry
     * @return true ak je pauznuta inac false
     */
    public boolean isPaused() {
        return this.paused;
    }

    /**
     * Pauzne hru
     */
    public void pauseGame() {
        this.paused = true;
    }

    /**
     *  Odpauzne hru
     */
    public void resumeGame() {
        this.paused = false;
    }

}
