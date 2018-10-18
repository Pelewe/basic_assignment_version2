package com.assignment.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.assignment.extraction.ExtractToList;
import com.assignment.writefile.WriteTofile;



public class ReadFile {
	
	public File readFile(String filename,int startid) {
		
		String line=null;
		String newFilename="";
		List<String> contents=new ArrayList<String>();
		int counter=startid;
	    ExtractToList extract= new ExtractToList();
	    WriteTofile writer=new WriteTofile();
	    
	    
	     try {
	    	 BufferedReader bufferReader=new BufferedReader(new FileReader(filename));
	    	 newFilename=filename.substring(0,filename.length()-4);
	    	 newFilename=newFilename+".sql";
	    	 FileWriter out = new FileWriter(newFilename);
	    	 
	    	 
	    	 while((line=bufferReader.readLine())!=null) {
	    		 contents.clear();
	    		 
	    		 if(filename.endsWith("pretoria.txt")) {
	    			 if(line.equals("#")){
	    				 line=bufferReader.readLine();
	    			 }
	    			 contents.add(String.valueOf(counter));
	    			 
	    			 while(!line.equals("#")) {
	    				 contents.add(extract.extractSample3(line, counter));
	    				 line=bufferReader.readLine();
	    			 }
	    		 }
	    		 else {
	    			 contents=extract.ExtractFromLine(filename,line, counter);
	    		 }
	    		 
	    		 
	    		 try {	
	    			 writer.writeToFile(contents, out);
	    			 }
	    		 catch ( Exception e) {
	    			 System.out.println("Unable to parse and format dates");
	    			 }
	    		 
	    		 counter++;
	    		 
	    	 }
	    	 
	    	 bufferReader.close();
    		 out.close();
		     }
		     catch( IOException ex) {
		 		System.out.println("File does not exist");
		 	} 
	     
	     File returnedFile=new File(newFilename);
			
		return returnedFile;
		     
	}

}
