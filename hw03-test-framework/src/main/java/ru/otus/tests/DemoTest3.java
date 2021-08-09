package ru.otus.tests;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DemoTest3 {
    int one;
    int two;
    int five;

    @Before
    void setUp() {
        one = 1;
        two = 2;
        five = 5;
    }

    @Test(name = "Test * 1")
    void testOne() {
        assertThat(one).isEqualTo(one);
    }

    @Test(name = "Test * 2")
    void testTwo() {
        assertThat(two).isEqualTo(two);
    }

    @Test(name = "Test * 3")
    void testThree() {
        assertThat(two).isEqualTo(five);
    }

    @After
    void setAfter() {
        five = 0;
        one = 0;
        two = 0;
    }
}
