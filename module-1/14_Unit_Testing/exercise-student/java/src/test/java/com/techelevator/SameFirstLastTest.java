package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {
    @Test
    public void SameFirstLast_DifferentFirstLast_ShouldReturnFalse(){
        SameFirstLast sameFirstLast=new SameFirstLast();
        int[] arr=new int[]{1,2,3};
        boolean expected = false;
        boolean result=sameFirstLast.isItTheSame(arr);
        Assert.assertEquals(expected,result); }
    @Test
    public void SameFirstLast_SameFirstLast_ShouldReturnTrue(){
        SameFirstLast sameFirstLast=new SameFirstLast();
        int[] arr=new int[]{1,2,3,1};
        boolean expected = true;
        boolean result=sameFirstLast.isItTheSame(arr);
        Assert.assertEquals(expected,result); }
}
