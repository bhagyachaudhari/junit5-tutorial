package com.passion4java.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

/**
 * Test Case : A class to test our code
 * @author bhagyac
 *
 */

// Method execution Order default is Random
//@TestMethodOrder(Alphanumeric.class) // order decided based on numeric order and then alphabetical order
@TestMethodOrder(OrderAnnotation.class) // Sort based on Order Annotation value
@DisplayName("Testing Employee Class") // display the name at JUnit console
public class TestEmployee {

	@BeforeAll
	public static void openAll() {
		System.out.println("one time setup\n");
	}
	
	@BeforeEach
	public void setup() {
		System.out.println("set up, init data");
	}
	
	//test methods
	
	@Test
	@Order(1)
	@DisplayName("Testing SAVE Method")
	public void testSave()
	{
		System.out.println("HELLO-SAVE");
	}
	
	@Test
	@Order(2)
	@DisplayName("Testing UPDATE Method")
	public void testUpdate()
	{
		System.out.println("HELLO-UPDATE");
	}
	
	@Test
	@Order(3)
	@DisplayName("Testing DELETE Method")
	@Disabled // Temporarily do not execute this method
	public void testDelete()
	{
		System.out.println("HELLO-DELETE");
	}
	
	@AfterEach
	public void clear() {
		System.out.println("clear data\n");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("close one time");
	}
	
	//@RepeatedTest(value = 3) // batch processing
	@RepeatedTest(value = 3, name="{displayName} - {currentRepetition} / {totalRepetitions}")
	@DisplayName("BATCH TEST")
	public void batchTest(TestInfo info) {
		System.out.println(info.getDisplayName());
		System.out.println(info.getTestClass().get().getName());
		System.out.println(info.getTestMethod().get().getName());
	}
	
	// Environment wise testing
	
	@Test
	@Tag("prod")
	public void testAtProd(){
		System.out.println("Run at Production");
	}
	
	@Test
	@Tag("dev")
	public void testAtDev(){
		System.out.println("Run at Dev");
	}
	
}
