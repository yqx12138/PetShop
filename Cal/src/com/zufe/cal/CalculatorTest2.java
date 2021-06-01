package com.zufe.cal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class CalculatorTest2 {
	Calculator calculator = new Calculator();
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAdd() {
		calculator.add(2);
	    calculator.add(3);
        assertEquals(5, calculator.getResult());
	}

	@Test
	void testSubstract() {
		  System.out.println(calculator.getResult());
		  calculator.add(10);
		  calculator.substract(8);
		 
		  assertEquals(7, calculator.getResult());
	}

	@Test
	void testDivide() {
		 calculator.add(11);
		  calculator.divide(2);
		  assertEquals(9, calculator.getResult());
	}

}
