package com.assignment;
import com.assignment.readfile.ReadFile;
import junit.framework.TestCase;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;


public class ReadFileTest  extends TestCase {
	
		@Rule 
		public TemporaryFolder temporaryFolder=new TemporaryFolder();
	
		@Rule
		public ExpectedException thrown = ExpectedException.none();
	
		@Test
		public void throwsErrorWhenTargetFileDoesnotExist() throws IOException{
		
			
			thrown.expect(IOException.class);
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
				
			String expected="sample_1.sql";
			String results=readfile.readFile(output, 500).toString();
			

			assertEquals(expected, results);
			
			
		}
		
}





