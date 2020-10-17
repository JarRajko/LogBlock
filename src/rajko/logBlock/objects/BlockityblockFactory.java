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

import rajko.logBlock.objects.blocks.AccessBlock;
import rajko.logBlock.objects.blocks.Box;
import rajko.logBlock.objects.blocks.Gate;
import rajko.logBlock.objects.blocks.Grass;
import rajko.logBlock.objects.items.Key;
import rajko.logBlock.objects.items.KeyTier;
import rajko.logBlock.player.Direction;
import java.awt.Color;
import java.util.HashMap;
import java.util.function.Supplier;
import rajko.logBlock.exceptions.NoSuchObjectException;
import rajko.logBlock.objects.blocks.Brick;
import rajko.logBlock.objects.blocks.Gravel;
import rajko.logBlock.objects.blocks.Rotator;
import rajko.logBlock.objects.blocks.Sign;
import rajko.logBlock.objects.blocks.Turniket;
import rajko.logBlock.objects.blocks.TurniketRotator;
import rajko.logBlock.objects.blocks.Wall;
import rajko.logBlock.objects.items.AntiChickenLeg;
import rajko.logBlock.objects.items.AntiHammer;
import rajko.logBlock.objects.items.AntiShoes;
import rajko.logBlock.objects.items.ChickenLeg;
import rajko.logBlock.objects.items.Hammer;
import rajko.logBlock.objects.items.Shoes;

/**
 * "Tovaren" vracia zbrusu nove instancie objektov
 * @author Rajko
 */
public class BlockityblockFactory {

    private HashMap<Color, Supplier<MyObject>> instances = new HashMap<>();

    /**
     * Inicializuje HashMapu
     */
    public BlockityblockFactory() {
        this.instances.put(Colors.ACCESSBLOCK_NORTH.getColor(), () -> new AccessBlock(Direction.NORTH));
        this.instances.put(Colors.ACCESSBLOCK_WEST.getColor(), () -> new AccessBlock(Direction.WEST));
        this.instances.put(Colors.ACCESSBLOCK_SOUTH.getColor(), () -> new AccessBlock(Direction.SOUTH));
        this.instances.put(Colors.ACCESSBLOCK_EAST.getColor(), () -> new AccessBlock(Direction.EAST));
        this.instances.put(Colors.BOX.getColor(), () -> new Box());
        this.instances.put(Colors.BRICK.getColor(), () -> new Brick());
        this.instances.put(Colors.SIGN.getColor(), () -> new Sign(""));
        this.instances.put(Colors.WALL.getColor(), () -> new Wall());
        this.instances.put(Colors.GRASS_1.getColor(), () -> new Grass());
        this.instances.put(Colors.GRASS_2.getColor(), () -> new Grass());
        this.instances.put(Colors.GRAVEL.getColor(), () -> new Gravel());
        this.instances.put(Colors.ROTATOR.getColor(), () -> new Rotator());
        this.instances.put(Colors.TURNIKET.getColor(), () -> new Turniket());
        this.instances.put(Colors.TURNIKET_ROTATOR.getColor(), () -> new TurniketRotator());
        this.instances.put(Colors.GATE_TIER_1.getColor(), () -> new Gate(KeyTier.KEY_TIER_1));
        this.instances.put(Colors.ANTI_CHICKEN_LEG.getColor(), () -> new AntiChickenLeg());
        this.instances.put(Colors.CHICKEN_LEG.getColor(), () -> new ChickenLeg());
        this.instances.put(Colors.HAMMER.getColor(), () -> new Hammer());
        this.instances.put(Colors.ANTI_HAMMER.getColor(), () -> new AntiHammer());
        this.instances.put(Colors.SHOES.getColor(), () -> new Shoes());
        this.instances.put(Colors.ANTI_SHOES.getColor(), () -> new AntiShoes());
        this.instances.put(Colors.KEY_TIER_1.getColor(), () -> new Key(KeyTier.KEY_TIER_1));
    }

    /**
     * Vrati instanciu objektu podla korespondujucej farby 
     * casova komplexita 1 B-)
     * @param color zadefinovana farba objektu
     * @return instancia ktoru vrati, vracia objekt typu MyObject
     * @throws NoSuchObjectException ak ku danej farbe neexistuje ziadna instancia hodi exception
     */
    public MyObject getInstanceFromColor(Color color) throws NoSuchObjectException {
        if (this.instances.get(color) == null) {
            throw new NoSuchObjectException(color);
        }
        return this.instances.get(color).get();
    }

}
