package com.ifindn.superthread;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Guo Yan
 * @date 2020/4/21-15:40
 */
public class WangMin implements Delayed {

    private String name;
    private String id;
    private long end;

    private TimeUnit time = TimeUnit.SECONDS;

    public WangMin(String name,String id,long end){
        this.name = name;
        this.id = id;
        this.end = end;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return end - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        WangMin w =(WangMin)o;
        return this.getDelay(time) - w.getDelay(time) > 0 ? 1:0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
