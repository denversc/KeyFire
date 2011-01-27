/*
 * Main.java
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

import keyfire.util.DeviceBlackBerrySystem;

import net.rim.device.api.system.Application;

/**
 * The main entry point for the KeyFire application.
 */
public class Main {

    public static final long GUID = 0;

    private final String[] _args;
    private final BlackBerrySystem _system;

    /**
     * Creates a new instance of <code>Main</code>. Note that this method stores a copy of the given
     * array and therefore any changes made to the array's contents will not be realized by this
     * class.
     * 
     * @param args the startup arguments; may be <code>null</code>
     * @param system the <code>BlackBerrySystem</code> to use
     * @throws NullPointerException if <code>system==null</code>
     */
    public Main(String[] args, BlackBerrySystem system) {
        if (system == null) {
            throw new NullPointerException("system==null");
        }
        this._args = Util.copy(args);
        this._system = system;
    }

    /**
     * Returns a copy of the args that were specified to the constructor.
     * 
     * @return a copy of the args that were specified to the constructor; returns <code>null</code>
     * if and only if the array given to the constructor was <code>null</code>
     */
    public String[] getArgs() {
        return Util.copy(this._args);
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
     * Runs the application with the arguments that were given to the constructor.
     * <p>
     * This method invokes {@link #getApplication(String[])} with the arguments returned from
     * {@link #getArgs()}. If the returned object is <code>null</code> then
     * <code>InvalidArgumentsException</code> is thrown. Otherwise, if the object is an instance of
     * {@link Runnable} then its <code>run()</code> method is invoked. Finally, the object's
     * <code>enterEventDispatcher()</code> method is invoked.
     * 
     * @throws InvalidArgumentsException if the arguments that were given to the constructor are
     * invalid
     */
    public void run() throws InvalidArgumentsException {
        final String[] args = this.getArgs();
        final BlackBerrySystem system = this.getSystem();

        final Application application = getApplication(args, system);

        if (application instanceof Runnable) {
            ((Runnable) application).run();
        }

        application.enterEventDispatcher();
    }

    /**
     * Returns a new instance of an Application that corresponds to the given arguments.
     * 
     * @param args the arguments whose Application instance to return; may be null
     * @param system the <code>BlackBerrySystem</code> object to specify to the constructor of the
     * application object created
     * @return a newly-created instance of <code>Application</code> created based on the given
     * arguments; returns null if there is no corresponding <code>Application</code> instance.
     * @throws NullPointerException if <code>system==null</code>
     */
    public static Application getApplication(String[] args, BlackBerrySystem system) {
        if (system == null) {
            throw new NullPointerException("system==null");
        }

        if (args == null || args.length == 0) {
            return new HotKeyApplication();
        }

        return null;
    }

    /**
     * The main entry point. This method simply creates a new instance of this class with the given
     * arguments and invokes {@link #run()} method.
     * 
     * @param args the startup arguments.
     * @throws InvalidArgumentsException if the given arguments are invalid
     */
    public static void main(String[] args) throws InvalidArgumentsException {
        final BlackBerrySystem system = new DeviceBlackBerrySystem(GUID);
        new Main(args, system).run();
    }

    /**
     * Exception thrown when invalid arguments are specified to the Main class.
     * 
     * @see Main#run()
     */
    public static class InvalidArgumentsException extends Exception {

        /**
         * Creates a new instance of <code>InvalidArgumentsException</code>.
         * 
         * @param message the message for this exception; may be null
         */
        public InvalidArgumentsException(String message) {
            super(message);
        }

    }
}
