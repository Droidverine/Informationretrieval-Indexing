import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class InvertedIndexing{
	public static void main(String args[])throws Exception
	{
     
 	  String line="";
      String prcessedtxt="";
      String temp="";
      ArrayList<String> wordList= new ArrayList();

      Scanner scanner = new Scanner(new File("fullyprocessed.txt"));  
      BufferedWriter writer = new BufferedWriter(new FileWriter("InvertedIndex.txt"));

    while (scanner.hasNextLine()) {

      		line = scanner.nextLine().trim();
      		String linnx= line.substring(line.indexOf("\t")+1);
      			linnx.trim();
    			wordList.addAll(Arrays.asList(linnx.split("[\\t, ]")));
    			wordList.removeAll(Collections.singleton(null));
				

    				

} 

        LinkedHashSet<String> hashSet = new LinkedHashSet<>(wordList);
         
        ArrayList<String> listWithoutDuplicates = new ArrayList<>(hashSet);      				
	//	System.out.print(" " +listWithoutDuplicates.toString());

listWithoutDuplicates.removeAll(Arrays.asList(null,""));

    		for(int i=0;i<listWithoutDuplicates.size();i++)
    		{
    			String wordcheck=listWithoutDuplicates.get(i);
    			      Scanner scannerforrepeats = new Scanner(new File("fullyprocessed.txt"));  

    				System.out.print("\n"+wordcheck+" ");
    				writer.write("\n"+wordcheck+"\t");
    		
    			      while(scannerforrepeats.hasNextLine()){
      		line = scannerforrepeats.nextLine().trim();
      		if(line.contains(wordcheck))
      		{
      			if(line.contains(" ")){
      		 temp= line.substring(0,2);
				//System.out.print(temp); 
				      		System.out.print(" "+temp); 
				      		 writer.write(" "+temp);

      		}
      		


      		}
      		else{
      			System.out.print(" "); 	
    			 writer.write(" ");


      		}
      		}
      		/*

      		if(line.contains("\t")){
      		 temp= line.substring(0, line.indexOf("\t"));
				System.out.print(temp); 	
      		}
      		*/
      		   			


    			
    		}
    		writer.close();

		
	

}}