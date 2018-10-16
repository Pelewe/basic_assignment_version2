package com.assignment;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import com.assignment.readfile.ReadFile;

public class WriteToFileTest {
	@Rule 
	public TemporaryFolder temporaryFolder=new TemporaryFolder();

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
    public void writesContentToFile() throws IOException {
        // arrange
      /*  File output = temporaryFolder.newFolder("reports")
                .toPath()
                .resolve("output.txt")
                .toFile();

        // act
        fileWriter.writeTo(output.getPath(), "test");

        // assert
        assertThat(output)
                .hasContent("test")
                .hasExtension("sql")
                .hasParent(resolvePath("reports"));
                */
		
    }
	
	@Test
	public void throwsErrorWritingConvertingDates() throws ParseException{
	
		
		thrown.expect(ParseException.class);
		thrown.expectMessage("File does not exist");
		String output="";
		FileWriter out;
		//File returnedFile=
		//ReadFile readfile=new ReadFile();
		//readfile.readFile(output, 500);		
	}
}
