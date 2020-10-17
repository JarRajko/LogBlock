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
 *
 * @author Rajko
 */
public abstract class MyObject {

    private final String originalTexture; //texture the block should has, i.e to revert changes after texturePath changes
    private String texturePath; //block texture
    private Color color;
    private boolean transparent;

    /**
     * Inicializuje atributy ktory by mal mat kazdy objekt ktora sa vykresluje
     *
     * @param texturePath cesta k suboru s texturou
     * @param color pri vykreslovani na minimapu
     * @param transparent boolean ci ma objekt nejake priesvitne casti
     */
    public MyObject(String texturePath, Color color, boolean transparent) {
        this.texturePath = texturePath;
        this.originalTexture = texturePath;
        this.color = color;
        this.transparent = transparent;
    }

    /**
     * Ak objekt nezabera vsetkych 32x32 pixelov tak ma priesvitne casti
     * @return true ak je priesvitny false ak nie
     */
    public boolean isTransparent() {
        return this.transparent;
    }

    /**
     * Returns current texture path
     *
     * @return
     */
    public String getTexturePath() {
        return this.texturePath;
    }

    /**
     * returns CURRENT texture of the block i.e if texture changes in game,
     * returns texture what block looks like and not what should it look like
     *
     * @return
     */
    public String getOriginaltexture() {
        return this.originalTexture;
    }

    /**
     * Farba objektu
     * @return vrati java.awt.Color faru objektu
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Nastavi cestu k texture s obrazkom
     * @param texturePath
     */
    protected void setTexturePath(String texturePath) {
        this.texturePath = texturePath;
    }

    /**
     * Nastavi farbu objektu
     * @param color
     */
    protected void setColor(Color color) {
        this.color = color;
    }
}
