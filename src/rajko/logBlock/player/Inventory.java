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

import java.util.ArrayList;
import rajko.logBlock.objects.MyObject;
import rajko.logBlock.objects.items.Key;
import rajko.logBlock.objects.items.KeyTier;

/**
 *
 * @author Rajko
 */
public class Inventory {
    private ArrayList<MyObject> inventory;
    
    /**
     * Vytvori novu kešeňku
     */
    public Inventory() {
        this.inventory = new ArrayList<>();
    }
    
    /**
     * prida do inventara
     * @param myObject objekt
     * @return vracia true ak sa podarilo false ak nie
     */
    public boolean addToInvetory(MyObject myObject) {
        return this.inventory.add(myObject);
    }
    
    /**
     * odoberie z inventara
     * @param myObject objekt 
     * @return vracia true ak sa podarilo false ak nie
     */
    public boolean removeFromInventory(MyObject myObject) {
        return this.inventory.remove(myObject);
    }

    /**
     * skontroluje ci ma hrac v inventari kluc s urcitym tierom
     * @param tier tier na kontrolu
     * @return  vrati true ak ano, false ak nem
     */
    public boolean hasKeyWithTier(KeyTier tier) {
        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i) instanceof Key) {
                return ((Key)this.inventory.get(i)).getTier().getTierNumber() == tier.getTierNumber();
            }
        }
        return false;
    }

    /**
     * odoberie kluc s urcitym tierom z inventara
     * @param key na odobratie
     * @return vrati true ak sa podarilo false ak nie
     */
    public boolean removeKeyFromInventory(Key key) {
        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i) instanceof Key) {
                if (((Key)this.inventory.get(i)).getTier() == key.getTier()) {
                    this.inventory.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    
}
