package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {
    @Test
    public void FrontTimes_Two_ShouldReturnResult(){
        FrontTimes frontTimes=new FrontTimes();
        String expected = "ChoCho";
        String result =frontTimes.generateString("Chocolate", 2);
        Assert.assertEquals(expected,result); }
    @Test
    public void FrontTimes_Three_ShouldReturnResult(){
        FrontTimes frontTimes=new FrontTimes();
        String expected = "ChoChoCho";
        String result =frontTimes.generateString("Chocolate", 3);
        Assert.assertEquals(expected,result); }
    @Test
    public void FrontTimes_StringLengthLessThanThree_ShouldReturnResult(){
        FrontTimes frontTimes=new FrontTimes();
        String expected = "AbcAbcAbc";
        String result =frontTimes.generateString("Abc", 3);
        Assert.assertEquals(expected,result); }
}
