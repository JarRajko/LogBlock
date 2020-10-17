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

import rajko.logBlock.objects.blocks.Block;
import rajko.logBlock.objects.blocks.Turniket;
import rajko.logBlock.objects.items.Item;
import rajko.logBlock.objects.items.Key;
import rajko.logBlock.objects.items.AntiChickenLeg;
import rajko.logBlock.objects.items.ChickenLeg;

/**
 *
 * @author Rajko
 */
public class PlayerActionDriver {

    private int turniketsPassed = 0;  //pocitanie aktualnych prechodov
    private int totalBlocksMoved = 0;
    private int bricksMoved = 0;
    private int boxesMoved = 0;
    private int itemsPicked = 0;
    private int keysPicked = 0;
    private int strengthIncreasedCounter = 0;
    private int strengthDecreasedCounter = 0;
    private int agilityDecreasedCounter = 0;
    private int agilityIncreasedCounter = 0;
    private int totalTurniketsPassed = 0; //pocitanie vsetkych prechodov
    private int movedNorth = 0;
    private int movedSouth = 0;
    private int movedEast = 0;
    private int movedWest = 0;

    /**
     * Zvisi pocitadlo.
     */
    public void playerStrengthIncreased() {
        this.strengthIncreasedCounter++;
    }

    /**
     * Zvisi pocitadlo.
     */
    public void playerAgilityIncreased() {
        this.agilityIncreasedCounter++;
    }

    /**
     * Zvisi pocitadlo.
     */
    public void playerStrengthDecreased() {
        this.agilityIncreasedCounter++;
    }

    /**
     * Zvisi pocitadlo.
     */
    public void playerAgilityDecreased() {
        this.agilityDecreasedCounter++;
    }

    /**
     * Zvisi pocitadlo.
     * @param direction smer ktorym sa hrac pohol
     */
    public void playerMoved(Direction direction) {
        if (direction == Direction.EAST) {
            this.movedEast++;
        } else if (direction == Direction.NORTH) {
            this.movedNorth++;
        } else if (direction == Direction.WEST) {
            this.movedWest++;
        } else if (direction == Direction.SOUTH) {
            this.movedSouth++;
        }
    }

    /**
     * Zvisi pocitadlo.
     * @param item pre item ktory hrac zobral
     */
    public void playerPickUpItem(Item item) {
        if (item instanceof Key) {
            this.itemsPicked++;
        } else if (item instanceof AntiChickenLeg) {
            this.strengthDecreasedCounter++;
        } else if (item instanceof ChickenLeg) {
            this.strengthIncreasedCounter++;
        }
    }

    /**
     * Vrati pocet
     * @return pocet prejdenych turniketov
     */
    public int getTurniketsPassed() {
        return this.turniketsPassed;
    }

    /**
     * resetuje pocitadlo turniketov
     */
    public void resetTurniketsPassed() {
        this.turniketsPassed = 0;
    }

    /**
     * zvisi pocitadlo 
     * @param block cez ktory hrac presiel
     */
    public void playerMovedThroughBlock(Block block) {
        if (block instanceof Turniket) {
            this.totalTurniketsPassed++;
            this.turniketsPassed++;
        }
    }

}
