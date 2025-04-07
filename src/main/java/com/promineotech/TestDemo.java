package com.promineotech;

import java.util.Random;
import java.util.function.IntPredicate;

//make class with methods to test with JUnit

public class TestDemo {

//method adds two positive integers
	public int addPositive(int a, int b) {
		
//check if both params are positive
//if so, return sum
		if (a > 0 && b > 0) {
			return a + b;
//else, throw illegal arg exception and message
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}

//method gets a random number btw 1 and 10, then squares it
//returns the result
	public int randomNumberSquared() {
		int result = getRandomInt();
		
		return result * result;
	}
//generates random int btw 1 and 10
//enables package visibility for testing 
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
//custom method to check if the number is prime	
// @param num to check
// @return true if num is prime, else false
// @throws illegal arg excepction if num < 2
	public boolean isPrime(int num) {
//prime num has to be > 1			
		if (num < 2) {
			throw new IllegalArgumentException("NUmber must be greater than 1!");
		}
//check if num divisible by any int from 2 to sqrt(num)
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
//if above statement not returned as false, then number is prime 		
		return true;
	}
}
	

