package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest{
    @Test
    public void CigarParty_WithCorrectCount_shouldReturnSuccessful(){
        //Arrange
        CigarParty cigarParty=new CigarParty();
        boolean expected = true;
        //Act
        boolean result = cigarParty.haveParty(50,false);
        //Assert
        Assert.assertEquals(expected,result);}

            @Test
    public void CigarParty_WithIncorrect_booleanValues_ShouldReturn_False(){
        //Arrange
        CigarParty cigarParty=new CigarParty();
        boolean expected =false;
        //Act
        boolean result = cigarParty.haveParty(30,false);
        //Assert
        Assert.assertEquals(expected,result);}
    @Test
    public void CigarParty_WithCorrect_booleanValues_ShouldReturn_True(){
        //Arrange
        CigarParty cigarParty=new CigarParty();
        boolean expected =true;
        //Act
        boolean result = cigarParty.haveParty(70,true);
        //Assert
        Assert.assertEquals(expected,result);}}




