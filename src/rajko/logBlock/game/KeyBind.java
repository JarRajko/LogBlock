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

import com.sun.glass.events.KeyEvent;

/**
 * Bindovanie klavesov
 * @author Rajko
 */
public enum KeyBind {
    KEY_UP(KeyEvent.VK_W),
    KEY_DOWN(KeyEvent.VK_S),
    KEY_LEFT(KeyEvent.VK_A),
    KEY_RIGHT(KeyEvent.VK_D),
    PAUSE(KeyEvent.VK_ESCAPE),
    ENTER(KeyEvent.VK_ENTER);
    
    private int keyCode;
    
    KeyBind(int keyCode) {
        this.keyCode = keyCode;
    }
    
    public int getKeyCode() {
        return this.keyCode;
    }
}
