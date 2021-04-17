package com.passion4java.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class TestMessage 
{
	private Message m;
	private String expected;
	private String actual;
	
	@Test
	@Tag("dev")
	public void testA() {
		String expected = "hello";
		String actual = "hello";
		
		//Assertions.assertEquals(expected, actual);
		assertEquals(expected, actual); // static import
	}
	
	@BeforeEach
	public void setUp() {
		m = new Message();
		expected = "Hello... RD";
		actual = "";
	}
	
	@Test
	public void testShowMsg() {
		actual = m.showMsg("RD");
		assertEquals(expected, actual, "Data not matched");
	}


	@AfterEach
	public void clean() {
		m = null; 
		expected = actual = "";
	}
	
}
