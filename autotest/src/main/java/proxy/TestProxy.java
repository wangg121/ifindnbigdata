package proxy;

/**
 * @author Guo Yan
 * @date 2020/6/12-16:25
 */
public class TestProxy {

    public static void main(String[] args){
        Cat c = new Cat();
        Animal proxy = new AnimalProxy(c).getAnimalProxy();
        proxy.eat();


    }

}
