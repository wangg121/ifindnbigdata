package com.ifindn.proxy.jdk.myjdkproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Mr.Guo
 * @Date 2020-07-25 18:34
 * 生成代理对象的代码
 */
public class IfindnProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(IfindnClassLoader loader,
                                          Class<?>[] interfaces,
                                          IfindnInvocationHandler h)
            throws IllegalArgumentException {

        //1.生成源代码
        String str = generateSrc(interfaces[0]);
        //2.将生成的源代码输出到磁盘，保存为.java文件
        String path = IfindnProxy.class.getResource("").getPath();
        File f = new File(path + "$Proxy0.java");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(str);
            fw.close();

            //3.编译源代码，并生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            //4.将.class文件加载到jvm

            //5.返回被代理后的对象
            Class clazz = loader.findClass("$Proxy0");
            Constructor constructor = clazz.getConstructor(IfindnInvocationHandler.class);
            return constructor.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            f.delete();
        }
        return null;
    }

    private static String generateSrc(Class<?> clazz) {
        StringBuffer src = new StringBuffer();
        src.append("package com.ifindn.proxy.jdk.myjdkproxy;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        src.append("public  class $Proxy0 implements " + clazz.getName() + "{" + ln);
        src.append("IfindnInvocationHandler h;" + ln);

        src.append("public $Proxy0(IfindnInvocationHandler h) {" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" + ln);

        for (Method method : clazz.getMethods()) {
            src.append("public " + method.getReturnType().getName() + " " + method.getName() + "(){" + ln);
            src.append("try{" + ln);
            src.append("Method m = " + clazz.getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});" + ln);
            if (!method.getReturnType().getName().equals("void")) {
                src.append("return ");
            }
            src.append("this.h.invoke(this,m,null);" + ln);
            src.append("}catch(Throwable e){ } " + ln);
            src.append("}" + ln);
        }

        src.append("}");
        return src.toString();
    }


}
