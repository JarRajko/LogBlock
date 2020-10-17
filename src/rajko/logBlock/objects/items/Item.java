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

import java.awt.Color;
import rajko.logBlock.objects.MyObject;
import rajko.logBlock.player.Player;

/**
 *
 * @author Rajko
 */
public abstract class Item extends MyObject {
    
    private boolean pickable;
    
    /**
     * Vytvori novy item
     * @param texturePath cesta k texture itemu
     * @param color farba itemu na minimape pripadne v obrazku na nacitanie
     */
    public Item(String texturePath, Color color) {
        super(texturePath, color, true);
        this.pickable = true;
    }
    
    /**
     * Vrati info o tom ci sa da zdvihnut
     * @return true ak ano false ak nie
     */
    public boolean isPickable() {
        return this.pickable;
    }
    
    /**
     * Definuje co sa ma stat po tom co item hrac zdvihne
     * @param player hrac
     */
    public abstract void pickUp(Player player);
    
}
