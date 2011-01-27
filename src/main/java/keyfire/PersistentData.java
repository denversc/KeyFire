/*
 * PersistentData.java
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

/**
 * Implementations provide a means to store data persistently.
 */
public interface PersistentData {

    /**
     * Gets the persistent data.
     * 
     * @return the persistent data; may be <code>null</code> if there is no persistent data set
     * @throws SecurityException if permission to read the persistent data is denied
     */
    public String getPersistentData();

    /**
     * Sets the persistent data.
     * 
     * @param data the data to set; if <code>null</code> then clear any previously-set data.
     * @throws SecurityException if permission to write the persistent data is denied
     */
    public void setPersistentData(String data);

}
