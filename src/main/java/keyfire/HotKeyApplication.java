/*
 * HotKeyApplication.java
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
package keyfire;

import keyfire.ui.HotKeyInputScreen;

import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.ScreenUiEngineAttachedListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.UiEngine;

/**
 * The application that presents a user interface to the user where the user can enter a hotkey to
 * launch the associated application.
 */
public class HotKeyApplication extends UiApplication implements Runnable {

    private final BlackBerrySystem _system;
    private final HotKeyInputScreen _screen;

    /**
     * Creates a new instance of <code>HotKeyApplication</code>.
     * 
     * @param system the system to use
     * @throws NullPointerException if <code>system==null</code>
     */
    public HotKeyApplication(BlackBerrySystem system) {
        if (system == null) {
            throw new NullPointerException("system==null");
        }
        this._system = system;
        this._screen = new HotKeyInputScreen();
    }

    /**
     * Returns this application's screen.
     * 
     * @return this application's screen; never returns <code>null</code>
     */
    public HotKeyInputScreen getScreen() {
        return this._screen;
    }

    /**
     * Returns the system used by this object.
     * 
     * @return the <code>BlackBerrySystem</code> object that was specified to the constructor; never
     * returns <code>null</code>
     */
    public BlackBerrySystem getSystem() {
        return this._system;
    }

    /**
     * Runs the application. This method first waits for the event thread to start and then pushes
     * the screen returned from {@link #getScreen()} onto the display stack.
     */
    public void run() {
        // wait for event thread to start up
        while (!this.hasEventThread()) {
            Thread.yield();
        }

        // push the applicaiton's screen onto the display stack
        synchronized (this.getAppEventLock()) {
            this.pushGlobalScreen(this._screen, 0, UiEngine.GLOBAL_MODAL);
        }
    }

    private static class MyScreenUiEngineAttachedListener implements ScreenUiEngineAttachedListener {

        public void onScreenUiEngineAttached(Screen screen, boolean attached) {
            if (!attached) {

            }
        }
    }
}
