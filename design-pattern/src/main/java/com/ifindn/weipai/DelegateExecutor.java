package com.ifindn.weipai;

/**
 * @Author Mr.Guo
 * @Date 2020-09-10 7:51
 */
public class DelegateExecutor implements IExcutor {

    private IExcutor iExcutor;
    public DelegateExecutor(IExcutor iExcutor){
        this.iExcutor = iExcutor;
    }

    @Override
    public void doing() {
        iExcutor.doing();
    }
}
