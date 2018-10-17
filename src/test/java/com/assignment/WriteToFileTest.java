package com.assignment;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import com.assignment.writefile.WriteTofile;

public class WriteToFileTest {
	
	private WriteTofile writer=new WriteTofile();
	private List<String> testList=new ArrayList<String>();
	private List<String> testTemp=new ArrayList<String>();
	
	@Rule 
	public TemporaryFolder temporaryFolder=new TemporaryFolder();

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	 @Before
	 public void init() {
		 testList.add("200");
		 testList.add("manmay");
		 testList.add("mohanty");
		 testList.add("07/03/1983");
		 testList.add("Married");
		 testList.add("Male");
		 
	 }
	 
	@Before
	public void initUnstructedList() {
		 testTemp.add("200");
		 testTemp.add("07/03/1983");
		 testTemp.add("manmay");
		 testTemp.add("mohanty");
		 testTemp.add("Married");
		 testTemp.add("Male");
	}
	
	@Test
    public void writesWrongContentToFileReturnsException() throws Exception {
		
		thrown.expect(ParseException.class);
		
		FileWriter out=new FileWriter("testList1.sql");
		writer.writeToFile(testTemp, out);
		out.close();
    }
	
	@Test
    public void writesContentToFile_isCorrect() throws Exception{
		
		FileWriter out=new FileWriter("testList1.sql");
		writer.writeToFile(testList, out);
		out.close();
		
		BufferedReader reader = new BufferedReader(new FileReader("testList1.sql"));
	    assertNotNull(reader.readLine());
    }
	
	@Test
	public void ConvertingDates_isCorrect() throws Exception{
	
		assertNotSame(testList.get(3),writer.dateFormat(testList.get(3)));	
	}
	
	@Test
	public void convertDateReturnsDateInstanceWithDateNotNull() throws Exception {
		String stringDate="1993-12-01";
		Date convertedDate=writer.dateFormat(stringDate);
		
		assertNotNull(convertedDate);
		
	}
	
	@Test
	public void ConvertingStringToDateThatisNotaDate_throwsException() throws Exception{
	
		thrown.expect(ParseException.class);
		writer.dateFormat("today");	
	}
	
	@After
	public void destroy() {
		testList.clear();
		testTemp.clear();
	}
}
