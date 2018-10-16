/*package com.assignment;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import com.assignment.readfile.ReadFile;

public class ReadFileTest {
	private ReadFile readfile=new ReadFile();
	
	@Rule 
	public TemporaryFolder temporaryFolder=new TemporaryFolder();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void throwsErrorWhenTargetFileDoesnotExist() throws IOException{
		
		File output=new File("C:\\Users\\Reverside\\Documents\\Assignments\\assignment_tools\\sample_4.txt");
		thrown.expect(IOException.class);
		thrown.expectMessage("File does not exist");
		
		readfile.readFile(output, 500);
	}
	

}
*/