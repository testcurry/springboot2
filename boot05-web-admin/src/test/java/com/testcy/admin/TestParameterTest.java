package com.testcy.admin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class TestParameterTest {

    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4,5})
    void test(int i){

        System.out.println(i);

    }

    @ParameterizedTest
    @DisplayName("参数化测试")
    @MethodSource("stringProvider")
    void test1(String i){

        System.out.println(i);

    }

    static Stream<String> stringProvider(){
        return Stream.of("apple","banner","testcy");
    }

}
