package com.andersenlab.katokoleg.topic4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
public class StreamAPITasksTest {

    @Test
    public void addUp() {

    }

    @Test
    public void getNameAndPlaceOfOrigin() {
        Singer singer1 = new Singer("Oleg", "Minsk");
        Singer singer2 = new Singer("Olga", "Minsk");
        Stream<Singer> singer11 = Stream.of(singer1, singer2);
        StreamAPITasks streamAPITasks = new StreamAPITasks();
        List<String> nameAndPlaceOfOrigin = streamAPITasks.getNameAndPlaceOfOrigin(singer11);
        Assert.assertEquals(List.of("Olga=Minsk", "Oleg=Minsk"), nameAndPlaceOfOrigin);
    }

    @Test
    public void stringLowerCaseCounterTest() {
        StreamAPITasks streamAPITasks = new StreamAPITasks();
        long actual = streamAPITasks.countLowerCaseChars("SaSafgerwabZzsrnASFVE");
        Assert.assertEquals(13, actual);
    }
}