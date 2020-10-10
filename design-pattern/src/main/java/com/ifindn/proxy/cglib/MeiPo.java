package com.ifindn.proxy.cglib;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib的动态代理：原理
 * 通过是生成被代理对象的一个子类，然后重写父类的方法生成以后的对象，可以强制转换为代理对象，
 * 子类引用赋值给父类
 * @Author Mr.Guo
 * @Date 2020-08-04 22:53
 */
public class MeiPo implements MethodInterceptor {

    public  Object getInstance(Class clazz){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    //同样是做了字节码重组，但是不用写接口
    //对于使用aip的用户来说，是无感知的
    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("i am proxy ");
        //此处一定要调父类即super方法
        //这个obj的引用是cglib给我们new出来的
        //cglib new出来以后的对象，是被代理对象的子类，在new子类之前，实际上先默认调用了super（）方法
        //new子类同时，必须先new出父类，相当于间接持有了父类的引用，
        //子类重写父类的所有方法，即操作子类的某些属性，可以间接操作父类的属性
        methodProxy.invokeSuper(obj,objects);
        return null;
    }
}
