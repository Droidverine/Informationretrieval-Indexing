import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/* INSTRUCTIONS TO RUN:
	COMMAND to compile ;P : javac InvertedIndexing.java
	COMMAND TO RUN: java InvertedIndexing <processed.txt file> (accepts commandline input i.e java  InvertedIndexing fullyprocessed.txt).

	OUTPUT- It is written in InvertedIndex.txt and also can be seen on console.

	*** MAKE SURE THAT EACH TITLE SHOULD HAVE EXACLTY ONE "\t" AFTER IT OTHER WISE IT MIGHT CAUSE  
		NUMBERFORMAT EXPCETION BEACUSE OF EMPTY STRING *****
		*/
class InvertedIndexing{
	public static void main(String args[])throws Exception
	{
      String inputfile=args[0];
 	  String line="";
      ArrayList<String> wordList=new ArrayList<String>();
      Scanner scanner = new Scanner(new File(inputfile));  


    while (scanner.hasNextLine()) {
     	//TO GET ALL TERMS
      		line = scanner.nextLine().trim();
      		String linnx= line.substring(line.indexOf("\t")+1);
      			linnx.trim();
    			wordList.addAll(Arrays.asList(linnx.split("[\\t, ]")));
    			wordList.removeAll(Collections.singleton(null));
			} 

        LinkedHashSet<String> hashSet = new LinkedHashSet<>(wordList);
        ArrayList<String> listWithoutDuplicatewords = new ArrayList<>(hashSet);  
      
    		for(int i=0;i<listWithoutDuplicatewords.size();i++)
    		{
    			//TO COMPARE EACH TERM WITH EACH DOCUMENT
    				 String wordcheck=listWithoutDuplicatewords.get(i);
    			     Scanner scannerforrepeats = new Scanner(new File(inputfile));  
    				 System.out.print("\n"+wordcheck+" ");
    		
    			      while(scannerforrepeats.hasNextLine()){
    					ArrayList<String> tmplist=new ArrayList<String>();
				      	line = scannerforrepeats.nextLine().trim();
      					tmplist.addAll(Arrays.asList(line.split("[\\t, ]")));
      					tmplist.removeAll(Collections.singleton(null));
   						if(tmplist.contains(wordcheck))
   						{
						System.out.print("\t"+tmplist.get(0)); 
   						}
   						else{
   						System.out.print(""); 
						}

   				tmplist.clear();

      		
      		}
      				    			
    		}


   

		
	

}


}