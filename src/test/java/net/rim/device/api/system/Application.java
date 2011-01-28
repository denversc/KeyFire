/*
 * Application.java
 * By: Denver Coneybeare
 * Jan 27, 2011
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
package net.rim.device.api.system;

/**
 * A mock implementation of net.rim.device.api.system.Application.
 */
public class Application {

    private boolean _hasEventThread;
    private final Object _appEventLock;

    public Application() {
        this._appEventLock = new Object();
    }

    public void enterEventDispatcher() {
    }

    public Object getAppEventLock() {
        return this._appEventLock;
    }

    public boolean hasEventThread() {
        return this._hasEventThread;
    }

    public void setHasEventThread(boolean value) {
        this._hasEventThread = value;
    }
}
