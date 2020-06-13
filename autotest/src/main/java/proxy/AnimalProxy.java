package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Guo Yan
 * @date 2020/6/12-16:13
 */
public class AnimalProxy {

    private Animal animal;

    public AnimalProxy(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimalProxy(){
        Animal proxy = null;
        ClassLoader loader = animal.getClass().getClassLoader();
        Class[] interfaces = {Animal.class};
        proxy = (Animal)Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理。。。。");
                method.invoke(animal,args);
                System.out.println("结束了。。。。");
                return 0;
            }
        });

        return proxy;
    }
}
