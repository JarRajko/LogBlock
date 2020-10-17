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

package rajko.logBlock.objects.blocks;

import rajko.logBlock.objects.Colors;
import rajko.logBlock.player.Direction;
import rajko.logBlock.player.Player;
import rajko.logBlock.world.Map;

/**
 *
 * @author Rajko
 */
public class AccessBlock extends Block {
    
    private Direction acessDirection;
    
    /**
     * Vytvori instanciu accessblocku nastavi smer texturu atp.
     * @param direction
     */
    public AccessBlock(Direction direction) {
         super("src\\rajko\\logBlock\\assets\\textures\\blocks\\accessBlock\\"+ direction.toString().toLowerCase() +".png", false, Colors.ACCESSBLOCK_NORTH.getColor());
         this.setDirection(direction);
    }

    /**
     * Posunutie bloku
     * @param direction smer ktorym sa ma blok posunut
     * @param player hrac ktory posuva blok
     * @param map mapa v ktorej sa ma objekt posunut
     * @return tento objekt sa neda nikdy posunut, vrati vzdy false
     */
    @Override
    public boolean push(Direction direction, Player player, Map map) {
        return false;
    }

    /**
     * 
     * @param player hrac ktory sa chce posunut na blok
     * @return vrati true ak ma hrac rovnaky facing ako ma blok
     * inac vrati false
     */
    @Override
    public boolean access(Player player) {
        if (player.getFacingDirection() == this.acessDirection) {
            return true;
        } else {
            return false;
        }
    }
    
    private void setDirection(Direction direction) {
        this.acessDirection = direction;
        if (direction == Direction.EAST) {
            this.setColor(Colors.ACCESSBLOCK_EAST.getColor());
        } else if (direction == Direction.WEST) {
            this.setColor(Colors.ACCESSBLOCK_WEST.getColor());
        } else if (direction == Direction.NORTH) {
            this.setColor(Colors.ACCESSBLOCK_NORTH.getColor());
        } else if (direction == Direction.SOUTH) {
            this.setColor(Colors.ACCESSBLOCK_SOUTH.getColor());
        }
    }
}
