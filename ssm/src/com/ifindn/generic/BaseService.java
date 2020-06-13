package com.ifindn.generic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Guo Yan
 * @date 2020/6/12-14:46
 */
public class BaseService<T> {

    @Autowired
    private BaseRepository<T> repository;

    public void save(){
        repository.save();
        System.out.println(repository);
    }
}
