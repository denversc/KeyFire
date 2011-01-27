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

/**
 * The main entry point for the KeyFire application.
 */
public class Main {

    private final String[] _args;

    /**
     * Creates a new instance of <code>Main</code>. Note that this method stores a copy of the given
     * array and therefore any changes made to the array's contents will not be realized by this
     * class.
     * 
     * @param args the startup arguments; may be <code>null</code>
     */
    public Main(String[] args) {
        this._args = Util.copy(args);
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
     * Runs the application with the arguments that were given to the constructor.
     * 
     * @throws InvalidArgumentsException if the arguments that were given to the constructor are
     * invalid
     */
    public void run() throws InvalidArgumentsException {

    }

    /**
     * The main entry point. This method simply creates a new instance of this class with the given
     * arguments and invokes {@link #run()} method.
     * 
     * @param args the startup arguments.
     * @throws InvalidArgumentsException if the given arguments are invalid
     */
    public static void main(String[] args) throws InvalidArgumentsException {
        new Main(args).run();
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
