package com.testcy.admin;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.springframework.test.annotation.Repeat;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Junit5单元测试类")
public class Juint5Test {


    @DisplayName("测试Display注解1")
    @Test
    public void testDisplayName1() {

        System.out.println("DisplayName1测试。。。");
    }

    @Disabled
    @DisplayName("测试Display注解2")
    @Test
    public void testDisplayName2() {

        System.out.println("DisplayName测试2。。。");
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("BeforeEach测试。。");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("AfterEach测试。。");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("BeforeAll测试。。。");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("AfterAll测试。。。");
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeOut() throws InterruptedException {
        Thread.sleep(50);
        System.out.println("Timeout测试...");
    }

    @RepeatedTest(value = 5)
    @Test
    void testRepeated() {
        System.out.println("RepeatedTest测试。。5");
    }

    @Test
    void testCal() {
        int result = cal(1, 2);
        assertEquals(3, result, "业务逻辑计算失败！");
        Object o1 = new Object();
        Object o2 = new Object();
        assertNotSame(o1, o2);
    }

    int cal(int i, int j) {
        return i + j;
    }

    @Test
    void testArray() {
        assertArrayEquals(new int[]{1, 3}, new int[]{1, 3});
    }

    @DisplayName("组合断言。。。")
    @Test
    void testAll() {
        assertAll(
                () -> assertTrue(true && true),
                () -> assertEquals(2, 2)
        );
    }

    @DisplayName("异常断言")
    @Test
    void testException() {
        assertThrows(ArithmeticException.class, () -> {
            int i = 10 / 0;
        });
    }

    @DisplayName("快速失败。。")
    @Test
    public void test() {
        if (1 == 2) {

            fail("快速失败。。。");
        }
    }

    @DisplayName("前置条件")
    @Test
    void testassumeTrue(){

        Assumptions.assumeTrue(true,"结果不是true");
        System.out.println("前置条件满足，继续执行。。");
    }
}
