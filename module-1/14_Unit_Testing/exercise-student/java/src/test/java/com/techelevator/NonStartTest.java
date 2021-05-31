package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {
    @Test
    public void NonStart_PartialString(){
        NonStart nonStart=new NonStart();
        String expected= "ellohere";
        String result=nonStart.getPartialString("Hello", "There");
        Assert.assertEquals(expected,result);
    }

}
