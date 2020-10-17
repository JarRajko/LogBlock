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

/**
 * Vynimka pre nenajdenie suboru s mapou
 * @author Rajko
 */
public class MapNotFoundException extends Exception {

    /**
     * Vynimka sa vracia ked sa nenajde subor s obrazkom obsahujuci mapu
     * @param path cesta k mape
     */
    public MapNotFoundException(String path) {
        super("Map was not found in " + path + " !");
    }
}
