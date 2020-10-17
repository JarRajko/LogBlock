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

import java.awt.Point;
import rajko.logBlock.objects.Colors;
import rajko.logBlock.player.Direction;
import rajko.logBlock.player.Player;
import rajko.logBlock.world.Map;

/**
 *
 * @author Rajko
 */
public class Brick extends Block {

    /**
     * Vytvori novy brick
     */
    public Brick() {
        super("src\\rajko\\logBlock\\assets\\textures\\blocks\\brick\\brick.png", false, Colors.BRICK.getColor());
    }

    @Override
    public boolean push(Direction direction, Player player, Map map) {
        Point thisBlockLocation = player.getNextLocation(1);

        if (map.getNeighbouringObject(thisBlockLocation, direction) instanceof IFloor) {
            map.swapObjects(thisBlockLocation, player.getNextLocation(2));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean access(Player player) {
        return false;
    }

}
