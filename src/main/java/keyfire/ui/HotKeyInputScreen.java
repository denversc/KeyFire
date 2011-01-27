/*
 * HotKeyInputScreen.java
 * By: Denver Coneybeare
 * Jan 26, 2011
 *
 * Copyright 2011 Denver Coneybeare
 * 
 * This file is part of KeyFire.
 *
 * KeyFire is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * KeyFire is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with KeyFire.  If not, see <http://www.gnu.org/licenses/>.
 */
package keyfire.ui;

import net.rim.device.api.ui.Keypad;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.PopupScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

/**
 * A screen that allows the user to enter a hotkey.
 */
public class HotKeyInputScreen extends PopupScreen {

    /**
     * Creates a new instance of <code>HotKeyInputScreen</code>.
     */
    public HotKeyInputScreen() {
        super(new VerticalFieldManager(), DEFAULT_MENU);
        this.add(new LabelField("KeyFile 0.0.1"));
    }

    protected boolean keyDown(int keycode, int time) {
        final int key = Keypad.key(keycode);

        switch (key) {
            case Keypad.KEY_ESCAPE:
                this.close();
                return true;
            default:
                return super.keyDown(keycode, time);
        }

    }
}
