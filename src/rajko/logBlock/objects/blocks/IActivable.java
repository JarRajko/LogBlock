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
import rajko.logBlock.player.Player;
import rajko.logBlock.world.Map;

/**
 *
 * @author Rajko
 */
public interface IActivable {

    /**
     * Interface aktivacie bloku, kontroluje sa najprv ci sa da aktivovat
     * az potom ci sa da posunut alebo nan prejst
     * @param player hrac ktory objekt aktivoval
     * @param map mapa v ktorej sa blok nachadza
     * @param game hra ktoru blok ovplyvnuje
     * @return vracia true ak sa objekt aktivoval uspesne, false ak nie
     */
    public boolean activate(Player player, Map map, Game game);
}
