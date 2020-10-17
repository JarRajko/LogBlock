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
package rajko.logBlock.objects;

import java.awt.Color;

/**
 * Enumy pre farby vsetkych objektov
 * @author Rajko
 */
public enum Colors {
    ACCESSBLOCK_SOUTH(new Color(0,255,255)),
    ACCESSBLOCK_NORTH(new Color(255,255,255)),
    ACCESSBLOCK_WEST(new Color(255,255,0)),
    ACCESSBLOCK_EAST(new Color(255,0,255)),
    BOX(new Color(165,70,35)),
    BRICK(new Color(132,132,132)),
    GATE_TIER_1(new Color(105,95,95)),
    GATE_TIER_2(new Color(95,105,95)),
    GATE_TIER_3(new Color(95,95,105)),
    GATE_TIER_4(new Color(1,100,150)),
    GATE_TIER_5(new Color(100,150,2)),
    GATE_TIER_6(new Color(150,100,3)),
    GRASS_1(new Color(20,132,20)),
    GRASS_2(new Color(16,100,16)),
    GRAVEL(new Color(230,32,200)),
    ROTATOR(new Color(250,50,20)),
    SIGN(new Color(255,192,75)),
    TURNIKET(new Color(90,90,230)),
    TURNIKET_ROTATOR(new Color(0,190,65)),
    WALL(new Color(0,0,0)),
    ANTI_CHICKEN_LEG(new Color(100,0,255)),
    ANTI_SHOES(new Color(10,100,150)),
    CHICKEN_LEG(new Color(255,0,100)),
    KEY_TIER_1(new Color(255,243,21)),
    KEY_TIER_2(new Color(255,243,21)),
    KEY_TIER_3(new Color(255,243,21)),
    KEY_TIER_4(new Color(255,243,21)),
    KEY_TIER_5(new Color(255,243,21)),
    KEY_TIER_6(new Color(255,243,21)),
    SHOES(new Color(240,35,35)),
    PLAYER(new Color(230,32,32)), 
    HAMMER(new Color(255,255,150)),
    ANTI_HAMMER(new Color(150,255,255));
    
    private Color color; 
    
    Colors(Color color) {
        this.color = color;
    }
    
    /**
     * Vrati farbu daneho objektu
     * @return
     */
    public Color getColor() {
        return this.color;
    }

}
