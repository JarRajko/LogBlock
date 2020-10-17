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
public class Turniket extends Block {

    private Direction acessDirection;

    /**
     * Zrusi warning ktory mi netbeans pise
     */
    public Turniket() {
        super("src\\rajko\\logBlock\\assets\\textures\\blocks\\turniket\\north.png", false, Colors.TURNIKET.getColor());
        this.acessDirection = Direction.NORTH;
    }

    @Override
    public boolean push(Direction direction, Player player, Map map) {
        return false;
    }

    @Override
    public boolean access(Player player) {
        if (player.getFacingDirection() == this.acessDirection) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Zmeni smer pristupu turniketu podla smeru hodinovych ruciciek
     */
    public void changeDirection() {
        switch (this.acessDirection) {
            case NORTH:
                this.acessDirection = Direction.EAST;
                this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\turniket\\east.png");
                break;
            case EAST:
                this.acessDirection = Direction.SOUTH;
                this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\turniket\\south.png");
                break;
            case SOUTH:
                this.acessDirection = Direction.WEST;
                this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\turniket\\west.png");
                break;
            case WEST:
                this.acessDirection = Direction.NORTH;
                this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\turniket\\north.png");
                break;
        }
    }

}
