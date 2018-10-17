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
	
		private ReadFile readfile=new ReadFile();
		
		@Rule 
		public TemporaryFolder temporaryFolder=new TemporaryFolder();
	
		@Rule
		public ExpectedException thrown = ExpectedException.none();
		

		@Test
		public void throwsErrorWhenTargetFileDoesnotExist() throws IOException{
			
			thrown.expect(IOException.class);
			String output="sample_5.txt";
			
		    FileReader reader = new FileReader(output);
		    reader.read();
		    reader.close();
			
			//readfile.readFile(output, 500);		
		}
		
		
		@Test
		public void returnNewFilenameWithSQLextension() {
			String output="sample_1.txt";
				
			String expected="sample_1.sql";
			String results=readfile.readFile(output, 500).toString();
			

			assertEquals(expected, results);
		}
		
		@Test
		public void whenReadWithBufferedReader_thenCorrect() throws IOException {
		     String expected_value = "Manmay Mohanty, M, 07/03/1983, Y";
		     String file ="sample_1.txt";
		      
		     BufferedReader reader = new BufferedReader(new FileReader(file));
		     String currentLine = reader.readLine();
		     reader.close();
		 
		    assertEquals(expected_value, currentLine);
		}
		
}





