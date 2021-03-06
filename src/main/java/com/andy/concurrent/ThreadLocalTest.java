package com.andy.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * <p>ClassName: ThreadLocal 简单使用 </p>
 * <p>@author wuqiong  2018/1/16 11:47 </p>
 */
public class ThreadLocalTest {

    /**
     * 原理: ThreadLocal 是采用键、值对象为值的存储结构，这个结构被附带在线程上，也就是说一个线程可以根据一个ThreadLocal查询绑定到这个线程上的一个值。
     *      ThreadLocal键是一个弱引用，当线程被JVM的 gc 回收时，引用消失，随之值也会回收释放。几乎不会出现内存问题.
     *
     * 1、ThreadLocal 可以用来保存和传递 变量、 经典用法:com.github.pagehelper.PageHelper.startPage()
     * 2、可以用来变量副本，如: SimpleDateUtils 保存指定格式的SimpleDateFormat 变量。此时可支持多线程访问。
     *
     */

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest.begin();//开始时间
        //休眠 1000 毫秒
        TimeUnit.MILLISECONDS.sleep(1000L);
        Long longValue=ThreadLocalTest.end();//结束时间
        //用当前时间，减去 放入ThreadLocal内的时间
        System.out.println("耗时为:"+(System.currentTimeMillis()-longValue));

    }

    //初始化
    public static final ThreadLocal<Long> INTEGER_THREAD_LOCAL = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };


    public static final void begin(){
        INTEGER_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    public static final Long end(){
        return INTEGER_THREAD_LOCAL.get();
    }

}
