package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {
    @Test
    public void StringBits_ShouldReturn_EveryOtherChar(){
        StringBits stringBits = new StringBits();
        String expected= "Hlo";
        String result = stringBits.getBits("Hello");
        Assert.assertEquals(expected,result);
    }
    @Test
    public void StringBits_ShouldReturn_FirstChar(){
        StringBits stringBits = new StringBits();
        String expected= "H";
        String result = stringBits.getBits("Hi");
        Assert.assertEquals(expected,result);
    } @Test
    public void StringBits_ShouldReturn_AlternateChar(){
        StringBits stringBits = new StringBits();
        String expected= "Hello";
        String result = stringBits.getBits("Heeololeo");
        Assert.assertEquals(expected,result);
    }

}
