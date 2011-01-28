/*
 * MockBlackBerrySystem.java
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
package keyfire.testutil;

import keyfire.BlackBerrySystem;

/**
 * A mock implementation of BlackBerrySystem.
 */
public class MockBlackBerrySystem implements BlackBerrySystem {

    public void exit(int exitCode) {
    }

    public String getPersistentData() {
        return null;
    }

    public void setPersistentData(String data) {
    }

}
