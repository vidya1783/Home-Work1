package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupTest {
    @Test
    public void animalGroup_withValidAnimalNameCorrectCase_shouldReturnCorrectValue(){
        //Arrange
        AnimalGroupName animalGroupName=new AnimalGroupName();
        String expected = "Pride";
        //Act
        String result=animalGroupName.getHerd("lion");
        //Assert
        Assert.assertEquals(expected,result);
    }
    @Test
    //animalName is all caps
    //animalName is all lowerCase
    //animalName is first letter capital
    //animalName is mixed case
    public void animalGroup_withValidAnimalNameAllCaps_shouldReturnCorrectValue(){
        //Arrange
        AnimalGroupName animalGroupName=new AnimalGroupName();
        String expected="Pride";
        //Act
        String result=animalGroupName.getHerd("LION");
        //Assert
        Assert.assertEquals(expected,result);
    }
    @Test
    public void animalGroup_withNullAnimalName_shouldReturnUnknown(){
        //Arrange
        AnimalGroupName animalGroupName=new AnimalGroupName();
        String expected = "unknown";
        //Act
        String result=animalGroupName.getHerd("null");
        //Assert
        Assert.assertEquals(expected,result);

    }
    @Test
    public void animalGroup_withEmptyAnimalName_shouldReturnUnknown(){
        //Arrange
        AnimalGroupName animalGroupName=new AnimalGroupName();
        String expected = "unknown";
        //Act
        String result=animalGroupName.getHerd(" ");
        //Assert
        Assert.assertEquals(expected,result);

    }
    @Test
    public void animalGroup_withValidAnimalNameNotFound_shouldReturnUnknown(){
        //Arrange
        AnimalGroupName animalGroupName=new AnimalGroupName();
        String expected = "unknown";
        //Act
        String result=animalGroupName.getHerd("Peacock");
        //Assert
        Assert.assertEquals(expected,result);

    }


}
