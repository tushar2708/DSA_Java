package com.tushar.java_specific.functional_interface;

@FunctionalInterface
public interface FunctionalInterfaceSample {

    void doSomething();

    /*
        Below method will generate compiler error, if not commented
        because only one abstract method is allowed in a functional interface.
    */
//    void doSomethingElse();
    /*
        Below method will not generate compiler error,
        because functional interface may have default methods.
    */
    default void doSomethingElseAltogether() {
        System.out.println("this is a default method inside 'FunctionalInterface', which hasn't been overridden");
    }
}
