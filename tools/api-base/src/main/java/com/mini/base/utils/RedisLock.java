package com.mini.base.utils;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class RedisLock implements Lock {

    private static ConcurrentHashMap<String, RLock> lockMap = new ConcurrentHashMap<>();

    private static RedissonClient redissonClient;

    private RLock redisLock;

    private String key;

    public RedisLock (String key){
        this.key = key;
    }

    {
        if(redissonClient != null){
            redissonClient = AppContext.getBean("redissonClient");
        }
        getRedisLock(key);
    }

    @Override
    public void lock() {
        redisLock.lock();
    }

    @Override
    @Deprecated
    public void lockInterruptibly() throws InterruptedException {
    }

    @Override
    public boolean tryLock() {
        return redisLock.tryLock();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return redisLock.tryLock(time, unit);
    }

    @Override
    public void unlock() {
        redisLock.unlock();
    }

    @Override
    @Deprecated
    public Condition newCondition() {
        return null;
    }

    private RLock getRedisLock(String key){
        redisLock = lockMap.get(key);
        if(redisLock == null){
            redisLock = redissonClient.getLock(key);
            lockMap.put(key, redisLock);
        }
        return redisLock;
    }
}
