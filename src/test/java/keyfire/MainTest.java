/*
 * MainTest.java
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
package keyfire;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import keyfire.testutil.MockBlackBerrySystem;

import org.junit.Before;
import org.junit.Test;

import net.rim.device.api.system.Application;

/**
 * Unit tests for the class Main.
 */
public class MainTest {

    private BlackBerrySystem _system;

    @Before
    public void init() {
        this._system = new MockBlackBerrySystem();
    }

    public void test_constructor(String[] args) {
        final String[] argsCopy = copy(args);
        final Main x = new Main(args, this._system);
        assertArrayEquals(argsCopy, x.getArgs());
        assertNotSame(args, x.getArgs());
    }

    @Test
    public void test_constructor_element0EmptyStringArgs() {
        this.test_constructor(new String[] { "" });
    }

    @Test
    public void test_constructor_element0NonEmptyStringArgs() {
        this.test_constructor(new String[] { "abcd" });
    }

    @Test
    public void test_constructor_element0NullArgs() {
        this.test_constructor(new String[] { null });
    }

    @Test
    public void test_constructor_nullArgs() {
        final Main x = new Main(null, this._system);
        assertNull(x.getArgs());
    }

    @Test
    public void test_constructor_nullSystem() {
        try {
            new Main(new String[0], null);
            fail("new Main(new String[0], null) should have thrown NullPointerException");
        } catch (final NullPointerException e) {
            assertEquals("system==null", e.getMessage());
        }
    }

    @Test
    public void test_constructor_zeroLengthArgs() {
        this.test_constructor(new String[0]);
    }

    @Test
    public void test_createApplication_element0NonNullArgs() {
        final Main x = new Main(new String[] { "test" }, this._system);
        try {
            final Application application = x.createApplication();
            fail("createApplication() should have thrown InvalidArgumentsException, but returned "
                + application);
        } catch (final Main.InvalidArgumentsException e) {
            assertEquals("unknown argument: test", e.getMessage());
        }
    }

    @Test
    public void test_createApplication_element0NullArgs() {
        final Main x = new Main(new String[] { null }, this._system);
        try {
            final Application application = x.createApplication();
            fail("createApplication() should have thrown InvalidArgumentsException, but returned "
                + application);
        } catch (final Main.InvalidArgumentsException e) {
            assertEquals("unknown argument: null", e.getMessage());
        }
    }

    @Test
    public void test_createApplication_nullArgs() throws Main.InvalidArgumentsException {
        final Main x = new Main(null, this._system);
        final Application application = x.createApplication();
        assertType(application, HotKeyApplication.class);
    }

    @Test
    public void test_createApplication_zeroLengthArgs() throws Main.InvalidArgumentsException {
        final Main x = new Main(new String[0], this._system);
        final Application application = x.createApplication();
        assertType(application, HotKeyApplication.class);
    }

    @Test
    public void test_getArgs_copy() {
        final String[] args = new String[] { "abc", null, "def" };
        final String[] argsCopy = copy(args);

        final Main x = new Main(args, this._system);

        final String[] actual1 = x.getArgs();
        assertArrayEquals(argsCopy, actual1);
        assertNotSame(args, actual1);

        final String[] actual2 = x.getArgs();
        assertArrayEquals(argsCopy, actual2);
        assertNotSame(args, actual2);
    }

    @Test
    public void test_getArgs_null() {
        final Main x = new Main(null, this._system);
        assertNull(x.getArgs());
        assertNull(x.getArgs());
    }

    @Test
    public void test_getSystem() {
        final Main x = new Main(null, this._system);
        assertSame(this._system, x.getSystem());
    }

    @Test
    public void test_GUID() {
        assertEquals(0x5696b214bb5434eaL, Main.GUID);
    }

    @Test
    public void test_InvalidArgumentsException_EmptyString() {
        final Main.InvalidArgumentsException x = new Main.InvalidArgumentsException("");
        assertEquals("", x.getMessage());
    }

    @Test
    public void test_InvalidArgumentsException_NonEmptyString() {
        final Main.InvalidArgumentsException x = new Main.InvalidArgumentsException("test");
        assertEquals("test", x.getMessage());
    }

    @Test
    public void test_InvalidArgumentsException_null() {
        final Main.InvalidArgumentsException x = new Main.InvalidArgumentsException(null);
        assertNull(x.getMessage());
    }

    @Test
    public void test_InvalidArgumentsException_throw() {
        try {
            throw new Main.InvalidArgumentsException("test");
        } catch (final Main.InvalidArgumentsException e) {
            // expected
        }
    }

    public static void assertType(Object object, Class expectedType) {
        if (expectedType == null) {
            throw new NullPointerException("expectedType==null");
        }

        if (object == null) {
            fail("got null, expected an instance of " + expectedType.getName());
        } else {
            final Class actualType = object.getClass();
            if (actualType != expectedType) {
                fail("got " + actualType.getName() + ", expected " + expectedType.getName());
            }
        }
    }

    private static String[] copy(String[] array) {
        if (array == null) {
            return null;
        }
        final String[] copy = new String[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }
}
