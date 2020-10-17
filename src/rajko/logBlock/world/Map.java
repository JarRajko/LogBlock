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

package rajko.logBlock.world;

import java.awt.Point;
import rajko.logBlock.objects.MyObject;
import rajko.logBlock.objects.blocks.Grass;
import rajko.logBlock.objects.blocks.Turniket;
import rajko.logBlock.objects.blocks.TurniketRotator;
import rajko.logBlock.player.Direction;

/**
 *
 * @author Rajko
 */
public class Map {

    private final int xSize = 3040;
    private final int ySize = 3040;
    private final MyObject[][] board = new MyObject[this.xSize][this.ySize];

    /**
     * Vytvori mapu s rozmerom 3040 x 3040
     */
    public Map() {
        this.fillWithGrass();
    }

    /**
     * Vrati zapuzdrenu kopiu 2D pola blokov
     *
     * @return 2 D pole blokov
     */
    public MyObject[][] getBoard() {
        MyObject[][] temp = new MyObject[this.ySize][this.xSize];
        for (int y = 0; y < this.ySize; y++) {
            for (int x = 0; x < this.xSize; x++) {
                temp[y][x] = this.board[y][x];
            }
        }
        return temp;
    }

    /**
     * Vrati objekt z mapy na zadanych suradniciach
     *
     * @param p point na mape :grin:
     * @return objekt zo zadanych suradnic
     */
    public MyObject getObject(Point p) {
        return this.board[(int)p.getX()][(int)p.getY()];
    }

    /**
     * vrati susedny objekt z mapy
     * @param p miesto podovneho objektu
     * @param direction smer na ktorom je sused
     * @return susedny objetk
     */
    public MyObject getNeighbouringObject(Point p, Direction direction) {
        switch (direction) {
            case EAST:
                return this.board[(int)p.getX() + 1][(int)p.getY()];
            case SOUTH:
                return this.board[(int)p.getX()][(int)p.getY() + 1];
            case WEST:
                return this.board[(int)p.getX() - 1][(int)p.getY()];
            case NORTH:
                return this.board[(int)p.getX()][(int)p.getY() - 1];
        }
        return null;
    }

    /**
     * vrati dalsi point
     * @param p
     * @param direction
     * @return
     */
    public Point getNextPoint(Point p, Direction direction) {
        switch (direction) {
            case EAST:
                return new Point((int)p.getX() + 1, (int)p.getY());
            case SOUTH:
                return new Point((int)p.getX(), (int)p.getY() + 1);
            case WEST:
                return new Point((int)p.getX() - 1, (int)p.getY());
            case NORTH:
                return new Point((int)p.getX(), (int)p.getY() - 1);
        }
        return null;
    }
    

/**
     * Vymeni dva objekty v mape.
     * @param object1 bod prveho objektu.
     * @param object2 bod druheho objektu.
     */
    public void swapObjects(Point object1, Point object2) {
        MyObject temp = this.board[(int)object1.getX()][(int)object1.getY()];
        this.board[(int)object1.getX()][(int)object1.getY()] = this.board[(int)object2.getX()][(int)object2.getY()];
        this.board[(int)object2.getX()][(int)object2.getY()] = temp;
    }
    
    private void fillWithGrass() {
        for (int y = 0; y < this.ySize; y++) {
            for (int x = 0; x < this.xSize; x++) {
                this.board[y][x] = new Grass();
            }
        }
    }
    
    /**
     *
     * @return x rozmer mapy
     */
    public int getSizeX() {
        return this.xSize;
    }
    
    /**
     *
     * @return rozmer mapy
     */
    public int getSizeY() {
        return this.ySize;
    }
    
    /**
     * otoci kazdym turniketom na mape
     */
    public void rotateTurnikets() {
        for (int y = 0; y < this.ySize; y++) {
            for (int x = 0; x < this.xSize; x++) {
                if (this.board[y][x] instanceof Turniket) {
                    ((Turniket)this.board[y][x]).changeDirection();
                }
                
                if (this.board[y][x] instanceof TurniketRotator) {
                    ((TurniketRotator)this.board[y][x]).changeDirection();
                }
            }
        }
    }

    /**
     * zmaze z mapy
     * @param point suradnice objektu
     */
    public void deleteFromMap(Point point) {
        this.board[(int)point.getX()][(int)point.getY()] = new Grass();
    }

    /**
     * prida do mapy
     * @param object 
     * @param y suradnica objektu
     * @param x suradnica objektu
     */
    public void addToMap(MyObject object, int y, int x) {
        this.board[y][x] = object;
    }
}
