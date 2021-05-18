package com.techelevator;


import java.sql.SQLOutput;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		int value, num1 = 0, num2 = 1;
		System.out.println("Enter value: ");
		Scanner userInput = new Scanner(System.in);
		value = userInput.nextInt();
		userInput.close();
		System.out.print("Fibonacci Series of "+ value +" numbers:");
		int i=1;
		while(i <= value)
		{
			System.out.print(num1+" ");
			int sumOfPrevTwo = num1 + num2;
			num1 = num2;
			num2 = sumOfPrevTwo;
			i++;
		}
	}
}



