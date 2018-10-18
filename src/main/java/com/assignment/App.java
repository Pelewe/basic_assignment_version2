package com.assignment;

import java.io.File;
import com.assignment.readfile.*;


public class App 
{
	public static void main(String[] arg)  {
		//READ INPUTS
		
		String Filename=arg[0].toLowerCase();
		int firstId=Integer.parseInt(arg[1]);
		
		
		ReadFile read=new ReadFile();
		File file=read.readFile(Filename,firstId);
		
		System.out.print(file);
		
		
	}
}
