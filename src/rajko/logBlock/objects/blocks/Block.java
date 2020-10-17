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

import java.awt.Color;
import rajko.logBlock.objects.MyObject;
import rajko.logBlock.player.*; //TODO: uchlacholit checkstyle
import rajko.logBlock.world.Map;

/**
 *
 * @author Rajko
 */
public abstract class Block extends MyObject {


    /**
     *
     * @param texturePath cesta k obrazku s texturou
     * @param transparent boolean ci ma blok nejake priesvitne casti
     * @param color farba bloku
     */
    protected Block(String texturePath, boolean transparent, Color color) {
        super(texturePath, color, transparent);
    }

    /**
     * Info o tom ci sa da blok posunut
     * @param direction smer ktorym sa ma posunut
     * @param player hrac ktory ho posuva
     * @param map mapa na ktorej sa posuva
     * @return vrati true ak sa da posunut, false ak nie
     */
    public abstract boolean push(Direction direction, Player player, Map map);

    /**
     * Vracia info o tom ci sa da na dany blok premiestnit
     * @param player hrac ktory sa chce na blok posunut
     * @return vrati true ak sa da na blok posunut, false ak nie
     */
    public abstract boolean access(Player player);

}
