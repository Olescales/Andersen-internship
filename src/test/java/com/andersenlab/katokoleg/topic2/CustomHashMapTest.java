package com.andersenlab.katokoleg.topic2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CustomHashMapTest {

    private CustomHashMap<Integer, String> customHashMap;

    @Before
    public void createSample() {
        customHashMap = new CustomHashMap<>();
        customHashMap.put(1, "123");
        customHashMap.put(1, "I");
        customHashMap.put(1, "345");
        customHashMap.put(28, "checkArrayIndex");
        customHashMap.put(15, "Position fifteen");
    }

    @Test
    public void putTest() {
        customHashMap.put(14, "Fourteen");
        String actual = customHashMap.get(14);
        Assert.assertEquals("Fourteen", actual);
        Assert.assertEquals(6, customHashMap.size());
    }

    @Test
    public void getReturnLastValueForKeyTest() {
        String actualResult = customHashMap.get(1);
        Assert.assertEquals("345", actualResult);
    }

    @Test
    public void containsKeyTest() {
        boolean actual1 = customHashMap.containsKey(17);
        boolean actual2 = customHashMap.containsKey(1);
        Assert.assertFalse(actual1);
        Assert.assertTrue(actual2);
    }

    @Test
    public void containsValueTest() {
        boolean actual1 = customHashMap.containsValue("123");
        boolean actual2 = customHashMap.containsValue("45");
        Assert.assertTrue(actual1);
        Assert.assertFalse(actual2);
    }

    @Test
    public void removeTest() {
        String actualResult = customHashMap.remove(15);
        Assert.assertEquals("Position fifteen", actualResult);
        String object = customHashMap.get(28);
        Assert.assertNotNull(object);
    }

    @Test
    public void clearTest() {
        customHashMap.clear();
        Assert.assertEquals(0, customHashMap.size());
    }

    @After
    public void destroy() {
        customHashMap.clear();
    }
}