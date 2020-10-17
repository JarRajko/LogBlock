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
import rajko.logBlock.objects.MyObject;
import rajko.logBlock.player.Direction;
import rajko.logBlock.player.Player;
import rajko.logBlock.world.Map;

/**
 *
 * @author Rajko
 */
public class Box extends Block {

    /**
     * Vytvori novy box
     */
    public Box() {
        super("src\\rajko\\logBlock\\assets\\textures\\blocks\\box\\box.png", false, Colors.BOX.getColor());
    }

    @Override
    public boolean push(Direction direction, Player player, Map map) {
        Point thisBlockLocation = player.getNextLocation(1);
        MyObject thisBlock = map.getObject(thisBlockLocation);
        Point endingBlock = this.getPointOfBlockToSwap(map, player);
        
        if (endingBlock == null) {
            return false;
        } else {
            map.swapObjects(thisBlockLocation, endingBlock);
            return true;
        }
    }

    @Override
    public boolean access(Player player) {
        return false;
    }

    private Point getPointOfBlockToSwap(Map map, Player player) {
        int counter = 0;
        
        while (counter <= player.getStrength()) {
            if (map.getObject(player.getNextLocation(counter + 1)) instanceof IFloor) {
                return player.getNextLocation(counter + 1);
            } else if (map.getObject(player.getNextLocation(counter + 1)) instanceof Box) {
                counter++;
            } else {
                return null;
            }
        }
        return null;
    }

}
