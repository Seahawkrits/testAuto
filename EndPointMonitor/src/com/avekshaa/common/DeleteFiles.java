package com.avekshaa.common;
 
import java.io.File;
import java.io.IOException;
 
public class DeleteFiles
{
    public void deleteOriginalFiles(String filesLocation)
    {	
 
    	File directory = new File(filesLocation);
 
    	//make sure directory exists
    	if(!directory.exists()){
 
           System.out.println("Directory does not exist.");
           System.exit(0);
 
        }else{
 
           try{
 
               delete(directory);
 
           }catch(IOException e){
               e.printStackTrace();
               System.exit(0);
           }
        }
 
    	System.out.println("Done - Files deleted successfully...");
    }
 
    public void delete(File file)
    	throws IOException{
 
    	if(file.isDirectory()){
 
    		//directory is empty, then delete it
    		if(file.list().length==0){
 
    		   file.delete();
    		   System.out.println("Directory is deleted : " 
                                                 + file.getAbsolutePath());
 
    		}else{
 
    		   //list all the directory contents
        	   String files[] = file.list();
 
        	   for (String temp : files) {
        	      //construct the file structure
        	      File fileDelete = new File(file, temp);
 
        	      //recursive delete
        	     delete(fileDelete);
        	   }
 
        	   //check the directory again, if empty then delete it
        	   if(file.list().length==0){
        		String fileName = file.getName();
   //        		System.out.println("File Name is: "+fileName);
           		file.delete();
        	     System.out.println("Directory is deleted : " 
                                                  + file.getAbsolutePath());
        	   }
    		}
 
    	}else{
    		//if file, then delete it
    		String fileName = file.getName();
 //   		System.out.println("File Name is: "+fileName);
    		if(!fileName.equalsIgnoreCase("CompressedImages.zip"))
    		file.delete();
    		System.out.println("File is deleted : " + file.getAbsolutePath());
    	}
    }
}