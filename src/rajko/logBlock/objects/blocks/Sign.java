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
import rajko.logBlock.player.Direction;
import rajko.logBlock.player.Player;
import rajko.logBlock.world.Map;

/**
 *
 * @author Rajko
 */
public class Sign extends Block implements IActivable {

    private String text; //dany text sa nikde nezobrazuje
    private boolean seen;
    
    /**
     * Vytvori cedulu
     * @param text text ktory ma cedula
     */
    public Sign(String text) {
        super("src\\rajko\\logBlock\\assets\\textures\\blocks\\sign\\unseen.png", true, Colors.SIGN.getColor());
        this.text = text;
    }

    @Override
    public boolean push(Direction direction, Player player, Map map) {
        return false;
    }

    @Override
    public boolean access(Player player) {
        return false;
    }

    @Override
    public boolean activate(Player player, Map map, Game game) {
        this.seen = true;
        this.setTexturePath("src\\rajko\\logBlock\\assets\\textures\\blocks\\sign\\seen.png");
        return true;
    }
    
}
