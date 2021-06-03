package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {
		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */
		//Prompt user for file name or directory and instantiate file object?
        Scanner userInput=new Scanner(System.in);
        String path="";

		System.out.println("Enter the path of the file or directory: ");
		File target= new File(path);
		System.out.println();
		//Inspect the file system by validating the path and determine it's type
		if(target.exists()){
			System.out.println("Name: " + target.getName());
			System.out.println("AbsolutePath: "+target.getAbsolutePath());
			System.out.println("CanonicalPath: "+ target.getAbsolutePath());

			if (target.isFile() || target.isDirectory()) {

				System.out.println((target.isFile()) ?"Type: File":"Type:Directory");

			}
			System.out.println("size: "+target.length());
		}else{
			System.out.println(target.getName()+"does not exist");
		}
		//Create a directory
		System.out.println("\n Time to create sa new directory");
		System.out.println("Enter the path name of the directory: ");
		String newDirectoryName=userInput.nextLine();
		File newDirectory=new File(newDirectoryName);
		if(!newDirectory.exists()){
			//create it
			if(newDirectory.mkdir()){
				System.out.println(newDirectory.getName()+ "was created as a new directory");
			}else{
				System.out.println("Sorry, unable to create the new directory"+ newDirectory.getName());
				System.exit(1);

			}
		}else{
			System.out.println("Directory '"+newDirectory.getName()+"' already exists");

		}
		//create a file
		System.out.println("\n Time to create a file in the new directory...");
		System.out.println("Please enter the new file's name: ");
		String fileName=userInput.nextLine();
		File newFile=new File(newDirectory, fileName);
		newFile.createNewFile();

		System.out.println("Name: " + target.getName());
		System.out.println("AbsolutePath: "+target.getAbsolutePath());
		System.out.println("CanonicalPath: "+ target.getAbsolutePath());
		System.out.println("size: "+target.length());}
		public static void printFileDetails(File fileSystemObject)throws IOException{
			System.out.println("Name: " + fileSystemObject.getName());
			System.out.println("AbsolutePath: "+fileSystemObject.getAbsolutePath());
			System.out.println("CanonicalPath: "+ fileSystemObject.getAbsolutePath());
			System.out.println("size: "+fileSystemObject.length());}
		}


	}



