package com.tushar.java_specific.functional_interface;

import org.junit.Test;

public class FunctionalInterfaceSampleTest {

    @Test
    public void doSomething() {

        FunctionalInterfaceSample fi1 = new FunctionalInterfaceSample() {
            @Override
            public void doSomething() {
                System.out.println("it works with anonymous class");
            }

            @Override
            public void doSomethingElseAltogether() {
                System.out.println("This is overridden 'doSomethingElseAltogether'." +
                        " we can overwrite default method of functional interface via anonymous class," +
                        " but not by lambda method");
            }
        };

        FunctionalInterfaceSample fi2 = () -> System.out.println("it works with lambda expression");

        fi1.doSomething();
        fi2.doSomething();

        fi1.doSomethingElseAltogether();
        fi2.doSomethingElseAltogether();

    }
}
