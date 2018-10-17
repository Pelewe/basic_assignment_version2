package com.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.assignment.extraction.ExtractToList;



public class ExtractToListTest {

	private ExtractToList extract=new ExtractToList();
	
	@Test
	public void whenExtractFromLine_thenCorrect() throws IOException {
				 List<String> expected_value =Arrays.asList("200","Manmay","Mohanty", "07/03/1983", "Y","M");
			     String file ="sample_1.txt";
			     
			     BufferedReader reader = new BufferedReader(new FileReader(file));
			     String currentLine = reader.readLine();
			     reader.close();
			     
			     List<String> contents=extract.ExtractFromLine(file, currentLine, 200);
			     
			     
			     assertEquals(expected_value.get(0), contents.get(0));
			     assertEquals(expected_value.get(1), contents.get(1));
			     assertEquals(expected_value.get(2), contents.get(2));
			     assertEquals(expected_value.get(3), contents.get(3));
			     assertEquals(expected_value.get(4), contents.get(4));
			     assertEquals(expected_value.get(5), contents.get(5));
			}
	
	@Test
	public void whenSample2ExtractFromLine_thenCorrect() throws IOException {
		        List<String> expected_value =Arrays.asList("200","MANMAY","MOHANTY", "1983-03-07","Married", "Male");
		        String file ="sample_2.txt";
	     
	     
		        BufferedReader reader = new BufferedReader(new FileReader(file));
		        String currentLine = reader.readLine();
		        reader.close();
	     
		        List<String> contents=extract.ExtractFromLine(file, currentLine, 200);
	     
		        assertEquals(expected_value.get(0), contents.get(0));
		        assertEquals(expected_value.get(1), contents.get(1));
		        assertEquals(expected_value.get(2), contents.get(2));
		        assertEquals(expected_value.get(3), contents.get(3));
		        assertEquals(expected_value.get(4), contents.get(4));
		        assertEquals(expected_value.get(5), contents.get(5));
	}

	@Test
	public void testDifferentSampleFilePassed() throws Exception{
	    	String file ="sample_2.txt";
	     
	    	BufferedReader reader;
	    	String currentLine;
	    
	    //when sample 2 is passed as a file format
	    	file ="sample_1.txt";
	    	reader= new BufferedReader(new FileReader(file));
	    	currentLine= reader.readLine();
	    
	    
	    	extract.ExtractFromLine(file, currentLine, 200);
	    
	    	assertTrue(extract.callOneCalled);
	    	assertFalse(extract.callTwoCalled);
	    	assertFalse(extract.callThreeCalled);
	    	reader.close();
	    
	    //when sample 2 is passed as a file format
	    	ExtractToList extract1=new ExtractToList();
	    	file ="sample_2.txt";
	    	reader= new BufferedReader(new FileReader(file));
	    	currentLine= reader.readLine();
	    
	    	extract1.ExtractFromLine(file, currentLine, 200);
	    
	    	assertFalse(extract1.callOneCalled);
	    	assertTrue(extract1.callTwoCalled);
	    	assertFalse(extract1.callThreeCalled);
	    	reader.close();
	    
	    //when sample 3 is passed as a file format
	    	ExtractToList extract2=new ExtractToList();
	    	file ="sample_3.txt";
	    	reader= new BufferedReader(new FileReader(file));
	    	currentLine=reader.readLine();
	    	currentLine= reader.readLine();
	    
	    	try {
	    			extract2.ExtractFromLine(file, currentLine, 200);
	    	}catch(Exception e) {}
	 
	    	assertFalse(extract2.callOneCalled);
	    	assertFalse(extract2.callTwoCalled);
	    	assertTrue(extract2.callThreeCalled);
	    	reader.close();
	    
	    //when unknown sample is passed as a file format
	    	ExtractToList extract3=new ExtractToList();
	    	file ="sample_4.txt";
	    	reader= new BufferedReader(new FileReader(file));
	    	currentLine= reader.readLine();
	    
	    	extract3.ExtractFromLine(file, currentLine, 200);
	    
	    	assertFalse(extract3.callOneCalled);
	    	assertFalse(extract3.callTwoCalled);
	    	assertFalse(extract3.callThreeCalled);
	   
	    	reader.close();
	}
	
	@Test(expected=NullPointerException.class)
	public void Sample3extractShouldThrowsNullpointerException() throws Exception{
		
			String file ="sample_3.txt";
			
			BufferedReader  reader= new BufferedReader(new FileReader(file));
			String currentLine= reader.readLine();
			
			extract.ExtractFromLine(file, currentLine, 200);
			reader.close();
	}
	
	
}
