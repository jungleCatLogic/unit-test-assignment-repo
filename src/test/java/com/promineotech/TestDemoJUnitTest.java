package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

//create private instance variable
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

//implement parameterized test
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
//if exception not expected, test the result		
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
//if exception expected, verify it is thrown
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

//	
//make method that returns a stream of arguments with test cases
//
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
//format: arguments(a, b, expected result, expect exception)			
//positive test cases (valid inputs)
				arguments(2, 4, 6, false), arguments(20, 40, 60, false), arguments(1, 99, 100, false),

//negative test cases (invalid inputs)
				arguments(0, 5, 0, true), arguments(5, 0, 0, true), arguments(-5, 10, 0, true),
				arguments(10, -5, 0, true), arguments(-3, -7, 0, true));
	}
//write non-parameterized test for addPositive method
//test mult input combos in separate assertions

	@Test
	void assertThatPairsOfPOsitiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);

		assertThat(testDemo.addPositive(1, 1)).isEqualTo(2);
		assertThat(testDemo.addPositive(100, 200)).isEqualTo(300);
	}

//custom tests for isPrime method
//test for both prime and non-prime numbers
//also check for the expected exception for invalid inputs (less than 2)

	@Test
	void assertThatNUmbersAreCorrectlyIdentifiedAsPrime() {
		assertThat(testDemo.isPrime(2)).isTrue();
		assertThat(testDemo.isPrime(13)).isTrue();
		assertThat(testDemo.isPrime(47)).isTrue();
		assertThat(testDemo.isPrime(89)).isTrue();

		assertThat(testDemo.isPrime(4)).isFalse();
		assertThat(testDemo.isPrime(25)).isFalse();
		assertThat(testDemo.isPrime(100)).isFalse();

		assertThatThrownBy(() -> testDemo.isPrime(1)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.isPrime(0)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.isPrime(-5)).isInstanceOf(IllegalArgumentException.class);

	}

//
//write method randomNumberSquared to obtain random into btw 1 and 10
//return square of that number
//method calls other method in same class called getRandomInt
//
	@Test
	void assertThatNumberSquaredIsCorrect() {
//create spy of TestDemo
		TestDemo mockDemo = spy(testDemo);
//config the spy to return 5 when getRandomInt is called
		doReturn(5).when(mockDemo).getRandomInt();
//call method under test
		int fiveSquared = mockDemo.randomNumberSquared();
//
		assertThat(fiveSquared).isEqualTo(25);

	}

}
