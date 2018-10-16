package com.assignment;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.assignment.extraction.ExtractToList;

import junit.framework.TestCase;

public class ExtractToListTest {

	@Test
	public void whenExtractFromLine_thenCorrect() throws IOException {
				List<String> expected_value =Arrays.asList("200","Manmay","Mohanty","M", "07/03/1983", "Y");
			     String file ="C:\\Users\\Reverside\\Documents\\Assignments\\assignment_tools\\sample_1.txt";
			     
			     ExtractToList extract=new ExtractToList();
			     BufferedReader reader = new BufferedReader(new FileReader(file));
			     String currentLine = reader.readLine();
			     reader.close();
			     
			     List<String> contents=extract.ExtractFromLine(file, currentLine, 200);
			     
			     
			    assertEquals(expected_value.get(4), contents.get(3));
			}
	
	@Test
	public void whenSample2ExtractFromLine_thenCorrect() throws IOException {
		List<String> expected_value =Arrays.asList("200","Manmay","Mohanty", "07/03/1983","Married", "Male");
	     String file ="C:\\Users\\Reverside\\Documents\\Assignments\\assignment_tools\\sample_2.txt";
	     
	     ExtractToList extract=new ExtractToList();
	     BufferedReader reader = new BufferedReader(new FileReader(file));
	     String currentLine = reader.readLine();
	     reader.close();
	     
	     List<String> contents=extract.ExtractFromLine(file, currentLine, 200);
	     
	    assertEquals(expected_value.get(4), contents.get(4));
	}
			
}
