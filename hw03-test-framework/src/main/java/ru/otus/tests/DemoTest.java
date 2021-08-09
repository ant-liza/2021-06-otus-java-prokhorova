package ru.otus.tests;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DemoTest {
    String one;
    String two;
    String five;

    @Before
    void setUp() {
        one = "ONE";
        two = "TWO";
        five = "FIVE";
    }

    @Test(name = "Test №1")
    void testOne() {
        assertThat(one).isEqualTo(one);
    }

    @Test(name = "Test №2")
    void testTwo() {
        assertThat(two).isEqualTo(two);
    }

    @After
    void setAfter() {
        five = "";
    }
}
