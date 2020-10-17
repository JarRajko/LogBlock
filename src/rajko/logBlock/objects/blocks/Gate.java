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
import rajko.logBlock.objects.items.KeyTier;
import rajko.logBlock.player.Direction;
import rajko.logBlock.player.Player;
import rajko.logBlock.world.Map;

/**
 *
 * @author Rajko
 */
public class Gate extends Block implements IActivable {

    private final KeyTier tier;
    private boolean closed;

    /**
     * Vytvori novu branu 
     * @param tier tier kluca ktory dokaze branu odomknut
     */
    public Gate(KeyTier tier) { //NOTE: TODO DIFFERENT COLOURED GATES AND KEYS
        super("src\\rajko\\logBlock\\assets\\textures\\blocks\\gate\\closed_tier_1.png", true, Colors.GATE_TIER_1.getColor());
        this.tier = tier;
        
        if (tier.getTierNumber() == 2) {
            this.setColor(Colors.GATE_TIER_2.getColor());
        } else if (tier.getTierNumber() == 3) {
            this.setColor(Colors.GATE_TIER_3.getColor());
        } else if (tier.getTierNumber() == 4) {
            this.setColor(Colors.GATE_TIER_4.getColor());
        } else if (tier.getTierNumber() == 5) {
            this.setColor(Colors.GATE_TIER_5.getColor());
        } else if (tier.getTierNumber() == 6) {
            this.setColor(Colors.GATE_TIER_6.getColor());
        } 
        this.closed = true;
    }


    @Override
    public boolean push(Direction direction, Player player, Map map) {
        return false;
    }

    @Override
    public boolean access(Player player) {
        return !this.closed;
    }

    @Override
    public boolean activate(Player player, Map map, Game game) {
        if (this.closed && player.hasKey(this.tier)) {
            System.out.println("activated!");
            this.closed = false;
            this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\gate\\opened_tier_" + this.tier.getTierNumber() + ".png");
            player.removeKey(this.tier);
            return true;
        }
        return false;
    }
    
    /**
     * Info o stave brany
     * @return vrati true ak je zatvorena, false ak je otvorena
     */
    public boolean isClosed() {
        return this.closed;
    }
    
}
