package com.zufe.cal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CalculatorTest {
	Calculator calculator = new Calculator();
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAdd() {
		calculator.add(3);
	    calculator.add(2);
        assertEquals(5, calculator.getResult());
	}

}
