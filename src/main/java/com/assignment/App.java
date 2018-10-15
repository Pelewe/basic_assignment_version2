package com.assignment;

import java.io.File;

import com.assignment.readfile.*;

public class App 
{
	public static void main(String[] arg) {
		//READ INPUTS
		
		/*String Filename=arg[0];
		int firstId=Integer.parseInt(arg[1]);
		*/
		
		String Filename="C:\\Users\\Reverside\\Documents\\Assignments\\assignment_tools\\sample_3.txt";
		int firstId=500;
		
		ReadFile read=new ReadFile();
		File file=read.readFile(Filename,firstId);
		
		System.out.print(file);
		
	}
}
