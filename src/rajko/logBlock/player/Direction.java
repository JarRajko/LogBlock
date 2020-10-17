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

package rajko.logBlock.player;

/**
 *
 * @author Rajko
 */
public enum Direction {
    //heading je kvoli tomu ze som premenoval enum
    //ale v suboroch to je ulozene ako up, down left right
    SOUTH("down"),
    NORTH("up"),
    WEST("left"),
    EAST("right");
    
    private String heading;
    
    Direction(String heading) {
        this.heading = heading;
    }
    
    public String getHeading() {
        return this.heading;
    }
}
