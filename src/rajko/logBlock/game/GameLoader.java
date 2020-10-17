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

package rajko.logBlock.game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import rajko.logBlock.exceptions.MapNotFoundException;
import rajko.logBlock.exceptions.NoSuchObjectException;
import rajko.logBlock.objects.BlockityblockFactory;
import rajko.logBlock.world.Map;

/**
 * Trieda ktora sa stara o nacitanie dat z obrazku do mapy
 * resp zo seedu keby som to nacitaval tak
 * @author Rajko
 */
public class GameLoader {

    private String mapPath = "src\\rajko\\logBlock\\maps\\map1.png";
    private Map map;

    /**
     *  Instancuje objekt na nacitavanie dat do mapy
     * @param map pre nastavenie hodnot
     * 
     */
    public GameLoader(Map map) {
        this.map = map;
    }

    /**
     * Nastavi data z obrazku
     * @throws MapNotFoundException
     */
    public void setSeedFromPicture() throws MapNotFoundException
    {
        BufferedImage mapPicture = null;
        mapPicture = LoadMap(mapPicture);

        if (mapPicture != null) {
            System.out.println("\nMap found!\n");
            int width = 3040;
            int height = 3040;
            BlockityblockFactory factory = new BlockityblockFactory();
            int pixelsSet = 0;

            System.out.println("Checking map...");
            for (int yForImg = 0; yForImg < height; yForImg++) {//marches through the image checking for certain color
                for (int xForImg = 0; xForImg < width; xForImg++) {

                    int pixel = mapPicture.getRGB(xForImg, yForImg);
                    int red = this.getRed(pixel);
                    int green = this.getGreen(pixel);
                    int blue = this.getBlue(pixel);

                    try {
                        this.map.addToMap(factory.getInstanceFromColor(new Color(red, green, blue)), xForImg, yForImg);
                        pixelsSet++;
                    } catch (NoSuchObjectException ex) {

                    }
                    
                }

            }
            System.out.println(pixelsSet + " blocks in total loaded from map.\n");
        } else {
            throw new MapNotFoundException(this.mapPath);
        }
    }

    private BufferedImage LoadMap(BufferedImage map)//loads map from image returns bufferedimage map object 
    {
        try {// get the BufferedImage, using the ImageIO class
            map = ImageIO.read(new File(mapPath));
            return map;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //-------------------cmajznute odkialsi zo stackoverflowu asi---------------
    private int getRed(int pixel)//returns value of red  from ARGB pixel value
    {
        return (pixel >> 16) & 0xff;
    }

    private int getGreen(int pixel)//returns value of green  from ARGB pixel value
    {
        return (pixel >> 8) & 0xff;
    }

    private int getBlue(int pixel)//returns value of blue  from ARGB pixel value
    {
        return (pixel) & 0xff;
    }

    private int getAlfa(int pixel)//returns value of alfa  from ARGB pixel value THIS IS UNUSED
    {
        return (pixel >> 24) & 0xff;
    }
}
