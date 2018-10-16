package com.assignment;

//import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import com.assignment.readfile.*;

public class ReadFileTest {
	
		@Rule 
		public TemporaryFolder temporaryFolder=new TemporaryFolder();
	
		@Rule
		public ExpectedException thrown = ExpectedException.none();
		

		@Test
		public void throwsErrorWhenTargetFileDoesnotExist() throws Throwable{
		
			
			thrown.expect(Throwable.class);
			thrown.expectMessage("File does not exist");
			String output="C:\\Users\\Reverside\\Documents\\Assignments\\assignment_tools\\sample_4.txt";
		
			//File returnedFile=
			ReadFile readfile=new ReadFile();
			readfile.readFile(output, 500);		
		}
		
		@Test
		public void returnNewFilename() {
			String output="C:\\Users\\Reverside\\Documents\\Assignments\\assignment_tools\\sample_1.txt";
			ReadFile readfile=new ReadFile();
				
			String expected="C:\\Users\\Reverside\\Documents\\Assignments\\assignment_tools\\sample_1.sql";
			String results=readfile.readFile(output, 500).toString();
			

			assertEquals(expected, results);
		}
		
		@Test
		public void whenReadWithBufferedReader_thenCorrect() throws IOException {
		     String expected_value = "Manmay Mohanty, M, 07/03/1983, Y";
		     String file ="C:\\Users\\Reverside\\Documents\\Assignments\\assignment_tools\\sample_1.txt";
		      
		     BufferedReader reader = new BufferedReader(new FileReader(file));
		     String currentLine = reader.readLine();
		     reader.close();
		 
		    assertEquals(expected_value, currentLine);
		}
}





