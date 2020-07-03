package com.spark.laboratory.utils;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MD5UtilsTest {

    @Test
    public void testMD5() throws Exception {
        System.out.println(MD5Utils.getMD5Str("123456"));
    }
}
