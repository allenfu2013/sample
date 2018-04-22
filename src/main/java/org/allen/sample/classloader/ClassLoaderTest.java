package org.allen.sample.classloader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 动态加载在Java中有2种实现
 * 1: ClassLoader.loadClass()去加载，ClassLoader最高级别的类加载器，所有的类都归他管理，用loadClass加载的类，是未经过初始化的，所以很多静态变量和方法无法被使用，
 * 2: Class.forName().用这个方法加载的类已经经过初始化。
 */
public class ClassLoaderTest {

    public void hello() {
        System.out.println("hello");
    }

    public static void testClassForName() throws Exception {
        Class<?> clazz = Class.forName("org.allen.sample.classloader.ClassLoaderTest");
        Method method = clazz.getMethod("hello");
        Object inst = clazz.newInstance();
        method.invoke(inst);
    }

    public static void testLoadClass() throws Exception {
        String jarOrClassPath = "";
        File file = new File(jarOrClassPath);
        URL url = file.toURI().toURL();
        ClassLoader loader = new URLClassLoader(new URL[]{url});

        String classNameWithPackage = "";
        Class<?> clazz = loader.loadClass(classNameWithPackage);
    }

    public static void main(String[] args) throws Exception {
        testClassForName();
    }
}
