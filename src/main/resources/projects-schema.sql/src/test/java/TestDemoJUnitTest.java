import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
	//private instance variable
	private TestDemo testDemo;

	//setUp method
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	//1. parameterized test for TestDemo
	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else (assertThatThrownBy(() ->
				testDemo.addPositive(a,b))).isInstanceOf(IllegalArgumentException.class);
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		
		Stream<Arguments> stream = Stream.of(
		arguments(2,4,6,false),
		arguments(7,8,15,false),
		arguments(0,99,99,true),
		arguments(-8,-8,-16,true));
		
		return stream; 
	}
	
	//2. create a test for addPositive
	@Test 
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(16,24)).isEqualTo(40);
		assertThat(testDemo.addPositive(8,9)).isEqualTo(17);
		assertThat(testDemo.addPositive(99,99)).isEqualTo(198);
		assertThat(testDemo.addPositive(6,7)).isEqualTo(13);
	}
	
	
	//3. I decided to recreate both tests for a dividing method
	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForDivideTwoDoubles")
	void assertThatTwoDoublesAreDividedCorrectly(double a, double b, double expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.divideTwoDoubles(a,b)).isEqualTo(expected);
		} else (assertThatThrownBy(() ->
			testDemo.divideTwoDoubles(a, b))).isInstanceOf(IllegalArgumentException.class);
	}
	
	static Stream<Arguments> argumentsForDivideTwoDoubles() {
		Stream<Arguments> stream = Stream.of(
		arguments(10,2,5,false),
		arguments(10,4,2.5,false),
		arguments(50,0,0,true),
		arguments(9,3,3,false),
		arguments(25,5,5,false));
	
	return stream;
	}

	@Test
	void assertThatPairsOfNumbersAreDividedCorrectly() {
		assertThat(testDemo.divideTwoDoubles(10,2)).isEqualTo(5);
		assertThat(testDemo.divideTwoDoubles(10,4)).isEqualTo(2.5);
		assertThat(testDemo.divideTwoDoubles(50,2)).isEqualTo(25);
		assertThat(testDemo.divideTwoDoubles(9,3)).isEqualTo(3);
		assertThat(testDemo.divideTwoDoubles(25,5)).isEqualTo(5);
	}
	
	//4. testing randomNumberSquared using Mockito
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
}