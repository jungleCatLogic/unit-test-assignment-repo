# Java Unit Testing Assignment

<div align="center">
  <h3>TestDemo JUnit Test Implementation</h3>
  
  <p>
    A demonstration of Java unit testing techniques using JUnit 5 and Mockito
  </p>

  <p>
    <img src="https://img.shields.io/badge/Java-17-orange" alt="Java 17" />
    <img src="https://img.shields.io/badge/JUnit-5.7.2-brightgreen" alt="JUnit 5.7.2" />
    <img src="https://img.shields.io/badge/Mockito-5.14.2-blue" alt="Mockito 5.14.2" />
    <img src="https://img.shields.io/badge/Maven-Project-yellow" alt="Maven Project" />
  </p>
</div>

## About The Project

This project demonstrates fundamental unit testing techniques using JUnit 5 and Mockito in a Java Maven project. It includes examples of:
- Standard JUnit tests with `@Test` annotation
- Parameterized tests with `@ParameterizedTest` annotation
- Test mocking with Mockito
- Custom method implementation and testing

The project consists of a `TestDemo` class containing several methods and a corresponding test class, `TestDemoJUnitTest`, which verifies the functionality of those methods using different testing approaches.

## Test Components

### TestDemo Class
The main class contains these methods:
- `addPositive(int a, int b)`: Adds two positive integers, throws exception if either parameter is not positive
- `randomNumberSquared()`: Gets a random number between 1 and 10 and returns its square
- `getRandomInt()`: Generates a random integer between 1 and 10
- `isPrime(int num)`: Custom method to check if a number is prime

### TestDemoJUnitTest Class
The test class includes:
- Parameterized test for `addPositive()`: Tests multiple scenarios using a data provider method
- Standard test for `addPositive()`: Tests specific positive number combinations
- Mock test for `randomNumberSquared()`: Uses Mockito to create a predictable test environment
- Custom test for `isPrime()`: Tests both prime and non-prime numbers

## Tech Stack

- Java 17
- JUnit Jupiter 5.7.2
- AssertJ 3.20.2
- Mockito 5.14.2
- Maven

## Getting Started

### Prerequisites

- Java JDK 17 or higher
- Maven
- Eclipse or other Java IDE

### Installation

1. Clone the repository
   ```sh
   git clone https://github.com/junglecatlogic/unit-test-assignment.git
   ```

2. Open the project in Eclipse
   - File > Import > Existing Maven Project
   - Navigate to the cloned repository
   - Select the project and click Finish

3. Let Maven download the dependencies
   - Right-click on the project > Maven > Update Project

### Running the Tests

Run the tests using Eclipse's JUnit runner:
1. Right-click on `TestDemoJUnitTest.java`
2. Select "Run As" > "JUnit Test"

## Code Features

### Parameterized Test
```java
@ParameterizedTest
@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
    // Test implementation
}
```

### Standard JUnit Test
```java
@Test
void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
    assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
    assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
}
```

### Mockito Test
```java
@Test
void assertThatNumberSquaredIsCorrect() {
    TestDemo mockDemo = spy(testDemo);
    doReturn(5).when(mockDemo).getRandomInt();
    int fiveSquared = mockDemo.randomNumberSquared();
    assertThat(fiveSquared).isEqualTo(25);
}
```

## Project Structure

```
unit-test-assignment/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── promineotech/
│   │               └── TestDemo.java
│   └── test/
│       └── java/
│           └── com/
│               └── promineotech/
│                   └── TestDemoJUnitTest.java
├── .gitignore
├── pom.xml
└── README.md
```

## Key Testing Concepts Demonstrated

1. **Test Setup and Teardown**
   - Using `@BeforeEach` to prepare test objects

2. **Parameterized Testing**
   - Efficient testing of multiple scenarios with a single test method

3. **Standard Unit Testing**
   - Direct testing of specific inputs and expected outputs

4. **Test Mocking**
   - Creating controlled test environments for unpredictable components

5. **Exception Testing**
   - Verifying that methods throw exceptions when expected

## Contributing

This project is for educational purposes. If you'd like to contribute:

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request
