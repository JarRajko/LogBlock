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

package rajko.logBlock.objects.items;

/**
 *
 * @author Rajko
 */
public enum KeyTier {
    KEY_TIER_1(1),
    KEY_TIER_2(2),
    KEY_TIER_3(3),
    KEY_TIER_4(4),
    KEY_TIER_5(5),
    KEY_TIER_6(6);
    
    private int tierNumber;
    
    KeyTier(int tierNumber) {
        this.tierNumber = tierNumber;
    }

    /**
     * Vrati cislo tieru klucu
     * @return
     */
    public int getTierNumber() {
        return this.tierNumber;
    }
    
}
