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

import java.util.Random;
import rajko.logBlock.objects.Colors;
import rajko.logBlock.player.Direction;
import rajko.logBlock.player.Player;
import rajko.logBlock.world.Map;

/**
 * Trava, jediny typ bloku *zatial* na ktory
 * sa mozu posuvat ostatne bloky, to zarucuje interface
 * IFloor
 * @author Rajko
 */
public class Grass extends Block implements IFloor {

    /**
     * Vytvori novu travu 
     */
    public Grass() {
        super("src\\rajko\\logBlock\\assets\\textures\\blocks\\grass\\light.png", false, Colors.GRASS_1.getColor());
        
        Random rand = new Random();
        if (rand.nextInt(3) == 2 ) { //1/3 chance to be darker grass
            this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\grass\\dark.png");
            this.setColor(Colors.GRASS_2.getColor());
        }
        
    }    

    @Override
    public boolean push(Direction direction, Player player, Map map) {
        return false;
    }

    @Override
    public boolean access(Player player) {
        return true;
    }

    /**
     * Vracia true, blok je instanciou podlahy
     * ostatne bloky sa tu mozu posuvat.
     * @return
     */
    @Override
    public boolean isFloor() {
        return true;
    }
}
