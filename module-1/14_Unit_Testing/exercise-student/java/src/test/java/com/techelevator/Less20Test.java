package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {
    @Test
    public void Less20_TwoLessThanMultipleOfTwenty_ShouldReturnTrue(){
        Less20 less20= new Less20();
        boolean expected= true;
        boolean result=less20.isLessThanMultipleOf20(18);
        Assert.assertEquals(true,result);
    }
    @Test
    public void Less20_OneLessThanMultipleOfTwenty_ShouldReturnTrue(){
        Less20 less20=new Less20();
        boolean expected=true;
        boolean result=less20.isLessThanMultipleOf20(19);
        Assert.assertEquals(true,result);
    }
    @Test
    public void Less20_IsEqualToMultipleOfTwenty_ShouldReturnFalse(){
        Less20 less20=new Less20();
        boolean expected=false;
        boolean result=less20.isLessThanMultipleOf20(20);
        Assert.assertEquals(false,result);
    }
}
