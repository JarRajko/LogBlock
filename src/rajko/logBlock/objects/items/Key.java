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
public class Key extends Item {

    private KeyTier tier = null;

    /**
     * Vytvori novy kluc so zadanym parametrom
     * @param tier
     */
    public Key(KeyTier tier) {
        super("src\\rajko\\logBlock\\assets\\textures\\items\\key\\Key_tier_1.png", Colors.KEY_TIER_1.getColor());
        this.tier = tier;
        this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\items\\key\\" + this.tier.toString().toLowerCase() + ".png");

        if (tier == KeyTier.KEY_TIER_2) {
            this.setColor(Colors.KEY_TIER_2.getColor());
        } else if (tier == KeyTier.KEY_TIER_3) {
            this.setColor(Colors.KEY_TIER_3.getColor());
        } else if (tier == KeyTier.KEY_TIER_4) {
            this.setColor(Colors.KEY_TIER_4.getColor());
        } else if (tier == KeyTier.KEY_TIER_5) {
            this.setColor(Colors.KEY_TIER_5.getColor());
        } else if (tier == KeyTier.KEY_TIER_6) {
            this.setColor(Colors.KEY_TIER_6.getColor());
        }
    }

    /**
     * Vrati Tier klucu
     * @return enum klucu tieru
     */
    public KeyTier getTier() {
        return this.tier;
    }

    @Override
    public void pickUp(Player player) {
        player.pickItem(this);
    }
}
