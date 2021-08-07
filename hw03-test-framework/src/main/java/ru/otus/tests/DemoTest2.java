package ru.otus.tests;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DemoTest2 {
    private String first;
    private String second;
    private String third;
    private String four;

    @Before
    void setUp() {
        System.out.println("setUp() start");
        first = "Apple";
        second = "Orange";
        third = "Apple";
    }

    @Before
    void setUp2() {
        System.out.println("setUp2() start");
        four = "Fdtdth";
    }

    @Test(name = "Test # 1")
    void testFruits1() {
        assertThat(first).isEqualTo(second);
    }

    @Test(name = "Test # 2")
    void testFruits2() {
        assertThat(first).isEqualTo(third);
    }

    @Test(name = "Test # 3")
    void testFruits3() {
        assertThat(second).isEqualTo(four);
    }

    @Test(name = "Test # 4")
    void testFruits4() {
        assertThat(second).isEqualTo(second);
    }

    @After
    void setAfter() {
        System.out.println("setAfter() start");
        first = "";
        second = "";
    }
}
