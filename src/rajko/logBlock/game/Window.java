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

import java.awt.Component;
import java.awt.Container;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 * 
 * @author Rajko
 */
public class Window 
{
    private JFrame frame;
    
    /**
     * Vytvori nove okno
     * @param WIDTH sirka v pixeloch
     * @param HEIGHT vyska v pixeloch
     * @param table JComponent
     */
    public Window(int WIDTH,int HEIGHT,JTable table)
    {
        this.frame = new JFrame();
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(true);
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.frame.getContentPane().add(table);
        this.frame.setSize(WIDTH, HEIGHT);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setAlwaysOnTop( false ); 
        this.removeMinMaxClose(this.frame);
    } 
    
    private void removeMinMaxClose(Component comp)//method borrowed from  https://coderanch.com/t/344419/java/deactivate-close-minimise-resizable-window
    {
        if (comp instanceof AbstractButton)
        {
            comp.getParent().remove(comp);
        }
        if (comp instanceof Container)
        {
            Component[] comps = ((Container) comp).getComponents();
            for (int x = 0, y = comps.length; x < y; x++)
            {
                removeMinMaxClose(comps[x]);
            }
        }
    }
}

