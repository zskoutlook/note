package org.proxy5;

public interface Aop {
    default void before(){}
    default void after(){}
    default void exception(){}
}
