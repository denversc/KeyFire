/*
 * DeviceBlackBerrySystem.java
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
package keyfire.util;

import keyfire.BlackBerrySystem;

import net.rim.device.api.system.PersistentObject;
import net.rim.device.api.system.PersistentStore;

/**
 * An implementation of <code>BlackBerrySystem</code> that does the "obvious" thing for a BlackBerry
 * device.
 */
public class DeviceBlackBerrySystem implements BlackBerrySystem {

    private final long _id;

    private PersistentObject _persistentObject;
    private final Object _persistentObjectMutex;

    /**
     * Creates a new instance of <code>DeviceBlackBerrySystem</code>.
     * 
     * @param id the ID in the <code>PersistentStore</code> and <code>RuntimeStore</code> where
     * persistent and transient data are stored, respectively
     */
    public DeviceBlackBerrySystem(long id) {
        this._id = id;
        this._persistentObjectMutex = new Object();
    }

    /**
     * Invokes <code>System.exit()</code>. Under normal circumstances this method <em>NEVER</em>
     * returns.
     * 
     * @param exitCode the value to specify to {@link System#exit(int)}
     */
    public void exit(int exitCode) {
        System.exit(exitCode);
    }

    /**
     * Returns the ID that is used to access the <code>PersistentStore</code> and
     * <code>RuntimeStore</code>
     * 
     * @return the ID that was specified to the constructor
     */
    public long getId() {
        return this._id;
    }

    /**
     * Returns data from the <code>PersistentObject</code> at the ID specified to the constructor.
     * The persistent data is retrieved by invoking {@link PersistentObject#getContents()} on the
     * object returned from {@link #getPersistentObject()}. If the contents of the
     * <code>PersistentObject</code> are <code>null</code> or not an instance of <code>String</code>
     * then <code>null</code> is returned.
     * 
     * @return the persistent data; may be <code>null</code>
     * @throws SecurityException if {@link PersistentObject#getContents()} throws is
     * @see #setPersistentData(String)
     */
    public String getPersistentData() {
        final PersistentObject persistentObject = this.getPersistentObject();
        final Object contents = persistentObject.getContents();
        if (contents instanceof String) {
            return (String) contents;
        } else {
            return null;
        }
    }

    /**
     * Gets the <code>PersistentObject</code> that is accessed by this object.
     * 
     * @return the <code>PersistentObject</code> at the ID given to the constructor; never returns
     * <code>null</code>
     * @throws SecurityException if permission to access the persistent object is denied
     * @see PersistentStore#getPersistentObject(long)
     */
    public PersistentObject getPersistentObject() {
        return PersistentStore.getPersistentObject(this._id);
    }

    /**
     * Sets data in the <code>PersistentStore</code> at the ID specified to the constructor. The
     * data is set by invoking {@link PersistentObject#setContents(Object)} with the given data on
     * the object returned from {@link #getPersistentObject()}
     * 
     * @param data the data to set; may be <code>null</code>
     * @throws SecurityException if {@link PersistentObject#setContents(Object)} throws is
     * @see #getPersistentData()
     */
    public void setPersistentData(String data) {
        final PersistentObject persistentObject = this.getPersistentObject();
        persistentObject.setContents(data);
    }

}
