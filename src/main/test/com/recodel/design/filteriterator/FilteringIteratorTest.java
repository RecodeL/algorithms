package com.recodel.design.filteriterator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilteringIteratorTest {
	private ArrayList<Integer> myListInts;
	private ArrayList<String> myListString;

	@BeforeEach
	public void setUp(){
		myListInts = new ArrayList<>() {{
			add(5);
			add(-2);
			add(-100);
			add(0);
			add(1);
		}};
		
		myListString = new ArrayList<>() {{
		    add("A");
		    add("B");
		    add("C");
		    add("Hello");
		}};
		
	}

	@Test
	public void testStringLengthFiltering(){
		FilteringIterator<String> filterIter = 
				new FilteringIterator<>(myListString.iterator(), new StringLengthTest());
		// simple assertions
		assertTrue(filterIter.hasNext());
		assertEquals("Hello", filterIter.next());
		assertFalse(filterIter.hasNext());
		// filterIter.next(); // should trigger exception at this point
	}

	@Test
	public void testPositiveNumberFiltering(){
		FilteringIterator<Integer> filterIter = 
				new FilteringIterator<>(myListInts.iterator(), new PositiveNumberTest());
		// simple assertions
		assertTrue(filterIter.hasNext());
		assertTrue(5 == filterIter.next());
		assertTrue(0 == filterIter.next());
		assertTrue(1 == filterIter.next());
		assertFalse(filterIter.hasNext());
		// filterIter.next(); // should trigger exception
	}
}
