package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {
    @Test
    public void DateFashion_WithValidValues_ShouldReturnTwo(){
        DateFashion dateFashion=new DateFashion();
        int expected = 2;
        int result=dateFashion.getATable(5,10);
        Assert.assertEquals(expected,result); }
    @Test
    public void DateFashion_WithValidValues_ShouldReturnOne(){
        DateFashion dateFashion=new DateFashion();
        int expected = 1;
        int result=dateFashion.getATable(5,5);
        Assert.assertEquals(expected,result); }
    @Test
    public void DateFashion_WithValidValues_ShouldReturnZero(){
        DateFashion dateFashion=new DateFashion();
        int expected = 0;
        int result=dateFashion.getATable(5,2);
        Assert.assertEquals(expected,result); }


}

