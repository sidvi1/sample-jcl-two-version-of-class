package ru.sidvi.sample;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;
import org.xeustechnologies.jcl.JclUtils;

import java.io.File;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * @author Vitaly Sidorov mail@vitaly-sidorov.com
 */
public class LoadClassesTest {

    public static ILib lib;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        File file = new File(".");
        String pathToLib = file.getAbsolutePath() + "/src/test/resources/lib-v2.jar";
        JarClassLoader jcl = new JarClassLoader();
        jcl.add(new URL("file:///" + pathToLib));

        JclObjectFactory factory = JclObjectFactory.getInstance();
        Object o = factory.create(jcl, "ru.sidvi.sample.Lib");

        lib = JclUtils.cast(o, ILib.class);
    }

    @Test(expected = UndeclaredThrowableException.class)
    public void testNotImplementedMethod() throws MalformedURLException {
        lib.func3();
    }

    @Test
    public void testFunc1() throws MalformedURLException {
        assertEquals("func1 from Lib2", lib.func1());
    }

    @Test
    public void testFunc2() throws MalformedURLException {
        assertEquals("OtherClass from Lib2", lib.func2());
    }

}
