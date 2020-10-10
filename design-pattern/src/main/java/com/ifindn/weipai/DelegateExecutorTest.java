package com.ifindn.weipai;

/**
 * @Author Mr.Guo
 * @Date 2020-09-10 7:52
 */
public class DelegateExecutorTest {

    public static void main(String[] args) {
        DelegateExecutor delegateExecutor = new DelegateExecutor(new ExecutorA());
        //看上去好像是DelegateExecutor在干活，实际上是ExecutorA或ExecutorB在干活
        delegateExecutor.doing();
    }
}
