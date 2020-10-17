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

import rajko.logBlock.game.Game;
import rajko.logBlock.objects.Colors;
import rajko.logBlock.player.Direction;
import rajko.logBlock.player.Player;
import rajko.logBlock.world.Map;

/**
 *
 * @author Rajko
 */
public class TurniketRotator extends Block implements IActivable {

    private Direction facingDirection;
    
    /**
     * Wyrobi ynstantny otaczcaz turniketowych
     */
    public TurniketRotator() {
        super("src\\rajko\\logBlock\\assets\\textures\\blocks\\turniketRotator\\north.png", false, Colors.TURNIKET_ROTATOR.getColor());
        this.facingDirection = Direction.NORTH;
    }

    @Override
    public boolean push(Direction direction, Player player, Map map) {
        return false;
    }

    @Override
    public boolean access(Player player) {
        return false;
    }

    @Override
    public boolean activate(Player player, Map map, Game game) {
        map.rotateTurnikets();
        return true;
    }

    /**
     * Zmeni texturu rotatora
     */
    public void changeDirection() {
        switch (this.facingDirection) {
            case NORTH:
                this.facingDirection = Direction.EAST;
                this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\turniketRotator\\east.png");
                break;
            case EAST:
                this.facingDirection = Direction.SOUTH;
                this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\turniketRotator\\south.png");
                break;
            case SOUTH:
                this.facingDirection = Direction.WEST;
                this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\turniketRotator\\west.png");
                break;
            case WEST:
                this.facingDirection = Direction.NORTH;
                this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\turniketRotator\\north.png");
                break;
        }
    }

}
