package org.zerock.sample;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTests {
	
	@Test
	public void testSum() {
		Calculator cal = new Calculator();
		assertEquals(30, cal.sum(20, 10));
		System.out.println("test1");
	}
	
	@Test
	public void testSum1() {
		Calculator cal = new Calculator();
		assertEquals(60, cal.sum(50, 10));
		System.out.println("test2 : "+cal.sum(50, 10));
	}
	
	@BeforeClass
	public static void beforeTest(){
		System.out.println("beforeClass");
	}
	
	@AfterClass
	public static void afterTest(){
		System.out.println("afterClass");
	}
	
	@Before
	public void setUp() {
		System.out.println("Before setUp");
	}
	
	@After
	public void tearDown() {
		System.out.println("after tearDown");
	}
}
