package com.assignment.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.assignment.extraction.Extract;
import com.assignment.writefile.Writefile;



public class ReadFile {
	
	public File readFile(String filename,int startid) {
		
		String line=null;
		List<String> contents=new ArrayList<>();
		int counter=startid;
	    Extract extract= new Extract();
	    Writefile writer=new Writefile();
	    
	    
	     try {
	    	 BufferedReader bufferReader=new BufferedReader(new FileReader(filename));
	    	 filename=filename.substring(0,filename.length()-4);
	    	 filename=filename+".sql";
	    	 FileWriter out = new FileWriter(filename);
	    	 
	    	 
	    	 while((line=bufferReader.readLine())!=null) {
	    		 contents.clear();
	    		 
	    		 if(filename.contains("3")) {
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
	     
	     File returnedFile=new File(filename);
			
		return returnedFile;
		     
	}

}
