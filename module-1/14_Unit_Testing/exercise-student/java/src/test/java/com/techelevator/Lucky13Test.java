package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {
    @Test
    public void Lucky13_ForNoOneNoThree_ReturnTrue(){
        Lucky13 lucky13=new Lucky13();
        int [] arr=new int[]{0,2,4};
        boolean expected = true;
        boolean result = lucky13.getLucky(arr);
        Assert.assertEquals(true,result);
    }
    @Test
    public void Lucky13_ForOneAndThree_ReturnFalse(){
        Lucky13 lucky13=new Lucky13();
        int [] arr=new int[]{1,2,3};
        boolean expected = false;
        boolean result = lucky13.getLucky(arr);
        Assert.assertEquals(expected,result);
    }
    @Test
    public void Lucky13_ForOne_ReturnFalse(){
        Lucky13 lucky13=new Lucky13();
        int [] arr=new int[]{1,2,4};
        boolean expected = false;
        boolean result = lucky13.getLucky(arr);
        Assert.assertEquals(expected,result);
    }
    @Test
    public void Lucky13_ForThree_ReturnFalse(){
        Lucky13 lucky13=new Lucky13();
        int [] arr=new int[]{0,2,3};
        boolean expected = false;
        boolean result = lucky13.getLucky(arr);
        Assert.assertEquals(expected,result);
    }

}
