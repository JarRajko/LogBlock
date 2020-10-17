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
package rajko.logBlock.exceptions;

import java.awt.Color;

/**
 * Vynimka sa vracia ked farba nie je priradena ziadnemu objektu
 * @author Rajko
 */
public class NoSuchObjectException extends Exception {

    /**
     *  Vypise chybu ked k farbe neexistuje instancia priradena v hashmape
     * @param color farba pre ktoru neexistuje instancia
     */
    public NoSuchObjectException(Color color) {
        super("Object for color R: " + color.getRed() + " G: " + color.getGreen() + " B: " + color.getBlue() + " does not exist!" );
    }
}
