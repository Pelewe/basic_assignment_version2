package com.assignment.extraction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Extract {
	

	public List<String> ExtractFromLine(String filename,String line,int counter) {
		
		if(filename.contains("1")) {
			return extractSample1(line, counter);
		}
		else if(filename.contains("2")){
			return extractSample2(line, counter);
		}
		else if (filename.contains("3")){
			return extractSample3(filename,line, counter);
		}
		else {
			return null;
		}
	}
	
	public List<String> extractSample1(String line,int counter) {
		List<String> contents=new ArrayList<>();
		String find="",temp;
		int index=0;
		
		contents.add(String.valueOf(counter));
		
		find=" ";
		index=line.indexOf(find);
		contents.add(line.substring(0,index));
		
		line=line.substring(index,line.length());
		
		
		for(int i=1;i<4 ;i++) {
			 index=line.indexOf(",");
			 temp=line.substring(1,index);
			 contents.add(temp);
			 line=line.substring(index+1,line.length());
		 }
		
		contents.add(line.substring(1,line.length()));
		
		
		 temp=contents.get(3);
		 
		 contents.remove(3);
		 
		 contents.add(temp);
		 
		 
		return contents;
		}
	
	
	
	public List<String> extractSample2(String line,int counter) {
		List<String> contents=new ArrayList<>();
		String  temp="";
		int index=0;
		 
		 contents.add(String.valueOf(counter));
		 for(int i=1;i<5 ;i++) {
			 index=line.indexOf("|");
			 temp=line.substring(1,index-1);
			 contents.add(temp);
			 line=line.substring(index+1,line.length());
			System.out.println(temp);
		 }
		 contents.add(line.substring(1,line.length()-1));
		 
		 return contents;
	}
	
	public String extractSample3(String line,int counter) {
		String contents="";
		int index=0;
	
		index=line.indexOf(":");
		contents=line.substring(index+2,line.length());
		
		 
		 return contents;
	}
	

}
