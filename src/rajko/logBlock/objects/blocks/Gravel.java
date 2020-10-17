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
public class Gravel extends Block {

    private boolean state1;
    
    /**
     * Vytvori instanciu.................. Gravel-u
     */
    public Gravel() { //NOTE: TODO color
        super("src\\rajko\\logBlock\\assets\\textures\\blocks\\gravel\\state_0.png", true, Colors.GRAVEL.getColor());
    }

    @Override
    public boolean push(Direction direction, Player player, Map map) {
        return false;
    }

    @Override
    public boolean access(Player player) {
        if (this.state1) {
            this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\gravel\\state_0.png");
            this.state1 = false;
        } else {
            this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\gravel\\state_1.png");
            this.state1 = true;
        }
        return true;
    }
    
}
