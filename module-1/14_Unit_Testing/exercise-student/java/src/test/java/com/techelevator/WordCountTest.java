package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WordCountTest {
    @Test
    public void getCount_arrayWordsContainsMultiples_shouldCountRepeats() {
        //Arrange
        WordCount wordCount = new WordCount();
        Map<String, Integer> expected = new HashMap<>();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);
        //Act
        Map<String, Integer> result = wordCount.getCount(new String[] {"ba", "ba", "black", "sheep"});
        //Assert
        Assert.assertEquals(expected, result);}
    @Test
    public void getCount_arrayWordsWithNoRepeats_shouldCountWords() {
        //Arrange
        WordCount wordCount = new WordCount();
        Map<String, Integer> expected = new HashMap<>();
        expected.put("c", 1);
        expected.put("b", 1);
        expected.put("a", 1);
        //Act
        Map<String, Integer> result = wordCount.getCount(new String[] {"c", "b", "a"});
        //Assert
        Assert.assertEquals(expected, result);}
    @Test
    public void getCount_WithAnEmptyArray_shouldReturnEmptyArray() {
        //Arrange
        WordCount wordCount = new WordCount();
        Map<String, Integer> expected = new HashMap<>();
        //Act
        Map<String, Integer> result = wordCount.getCount(new String[] {});
        //Assert
        Assert.assertEquals(expected, result);}
}
