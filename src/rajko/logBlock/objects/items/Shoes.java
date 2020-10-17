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
package rajko.logBlock.objects.items;

import rajko.logBlock.objects.Colors;
import rajko.logBlock.player.Player;

/**
 *
 * @author Rajko
 */
public class Shoes extends Item {

    /**
     * Vytvori nove Nike
     */
    public Shoes() {
        super("src\\rajko\\logBlock\\assets\\textures\\items\\shoes\\Shoes.png", Colors.SHOES.getColor());
    }

    
    /**
     * Zvysi hybnost hraca. (pocet turniketov po ktorych treba prejst aby sa otocili)
     */
    @Override
    public void pickUp(Player player) {
        player.raiseAgility();
    }
    
}
