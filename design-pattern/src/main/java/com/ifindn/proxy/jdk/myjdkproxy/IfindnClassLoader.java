package com.ifindn.proxy.jdk.myjdkproxy;

import java.io.*;

/**
 * @Author Mr.Guo
 * @Date 2020-07-25 18:35
 * 定义私有方法loadClass将其转化为二进制数据，从而加载到class类
 */
public class IfindnClassLoader extends ClassLoader {

//    private String path = "D:\\";
//    private final String fileType = ".class";
//
//    //类加载器名字
//    private String name = null;
//
//    public IfindnClassLoader(String name) {
//        super();
//        this.name = name;
//    }
//
//    public IfindnClassLoader(ClassLoader parent, String name) {
//        super(parent);
//        this.name = name;
//    }
//
//    //调用getclassloader（）时返回此方法，如果不重载，则显示IfindnClassLoader的引用地址
//    public String toString(){
//        return this.name;
//    }
//
//    //设置文件加载路径
//    public void setPath(String path){
//        this.path = path;
//    }
//
//
//    @Override
//    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        byte[] data = loadClassData(name);
//        return defineClass(name,data,0,data.length);
//
//    }
//    //将.class文件读入内存中，并且以字节形式返回
//    private byte[] loadClassData(String name){
//        FileInputStream fis = null;
//        ByteArrayOutputStream baos = null;
//        byte[] data = null;
//        name = name.replaceAll("\\.","\\\\");
//        System.out.println("加载文件名： " + name);
//        //将文件读取到数据流中
//        try {
//            fis = new FileInputStream(path + name + fileType );
//            baos = new ByteArrayOutputStream();
//            int ch = 0;
//            while ((ch = fis.read())!= -1){
//                baos.write(ch);
//            }
//            data = baos.toByteArray();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//
//            try {
//                fis.close();
//                baos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return data;
//    }


    private File baseDir;

    public IfindnClassLoader() {
        String basePath = IfindnClassLoader.class.getResource("").getPath();
        this.baseDir = new File(basePath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = IfindnClassLoader.class.getPackage().getName() + "." + name;
        if (baseDir != null) {
            File classFile = new File(baseDir, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                try {
                    System.out.println(classFile.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FileInputStream fis = null;
                ByteArrayOutputStream bos = null;
                try {
                    fis = new FileInputStream(classFile);
                    bos = new ByteArrayOutputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = fis.read(bytes)) != -1) {
                        bos.write(bytes, 0, len);
                    }
                    return defineClass(className,bos.toByteArray(),0,bos.size());
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fis.close();
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    classFile.delete();
                }
            }
        }
        return null;

    }
}
