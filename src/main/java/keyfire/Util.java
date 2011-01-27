/*
 * Util.java
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
 * Useful utility methods.
 */
public class Util {

    /**
     * Private constructor to prevent instantiation.
     */
    private Util() {
    }

    /**
     * Creates a copy of a String array.
     * 
     * @param array the array to copy; may be null
     * @return a newly-created array whose elements are the same as those of the given array;
     * returns <code>null</code> if and only if the given array is <code>null</code>
     */
    public static String[] copy(String[] array) {
        if (array == null) {
            return null;
        }

        final String[] copy = new String[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }
}
