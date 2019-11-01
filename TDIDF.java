import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.*;
import java.text.DecimalFormat;
/* INSTRUCTIONS TO RUN:
	COMMAND to compile ;P : javac TDIDF.java
	COMMAND TO RUN: java TDIDF <inputTF.txt file> (accepts commandline input i.e java TDIDF tf.txt).

	OUTPUT- It is written in TFIDF.txt and also can be seen on console.

	*** MAKE SURE THAT EACH TERM SHOULD HAVE EXACLTY ONE "\t" AFTER IT OTHER WISE IT MIGHT CAUSE  
		NUMBERFORMAT EXPCETION BEACUSE OF EMPTY STRING *****
		*/

class TDIDF{
  public static void main(String args[])throws Exception
  {
  		String termfrequncyfile=args[0];

  	   //For rouding to 3 precision.
        DecimalFormat df = new DecimalFormat("##.###");
        BufferedWriter writer = new BufferedWriter(new FileWriter("TDIDF.txt"));
   		String line="";
   		ArrayList<String> docstitles= countnumberofdocs(termfrequncyfile);
   		int numdocsint=docstitles.size();
   		for(String indexes: docstitles)
					{
					//TO PRINT DOC NAMES AS COLUMNS
					System.out.print("\t"+indexes);
					writer.write("\t"+indexes);

					}

					System.out.println();
					writer.write("\n");
        ArrayList<String> wordList= new ArrayList();
  		ArrayList<String> MaxFreq=getmaxfreq(termfrequncyfile,numdocsint);
  		ArrayList<String> numberofdocscontaingterm=Numberofdocumentscontainingtheterm(termfrequncyfile,numdocsint);
        Scanner scanner = new Scanner(new File(termfrequncyfile));  
      	scanner.nextLine();
      	int bekhad=0;
    while (scanner.hasNextLine()) {

          line = scanner.nextLine();
          String word= line.split("\t")[0];
          //READS FREQ OF EACH TERM (AFTER FIRST TAB).
          String linnx= line.substring(line.indexOf("\t")+1);
      	  linnx.trim();
          wordList.addAll(Arrays.asList(linnx.split("[\\t, ]")));
          wordList.removeAll(Collections.singleton(null));
                  System.out.print(" "+word+""); 
                  writer.write(word);
                  int kalakandi=0;



                 		
                 		//TFIDF Working
                 		for (int i=0;i<wordList.size();i++ ) {
	            			Float numberofdocscontaingterminteger=Float.parseFloat(numberofdocscontaingterm.get(bekhad));
	            			//CACUATES TF= TERM-FREQ/MAXFREQ IN THAT DOC.
        			 		Float tf=Float.parseFloat(wordList.get(i))/Float.parseFloat(MaxFreq.get(kalakandi));
        			 		//CACUATES IDF= LOG10(TOTAL NUMBER OF DOCS / NUMBER OF DOC containing the term).

                 			Float idfdivision=((float) numdocsint/(float)numberofdocscontaingterminteger);
                 			Float idf=(float)Math.abs(Math.log10(idfdivision));
                 			//CACUATES TDIDF= TF*IDF.

                 			Float tfidf=tf*idf;

					if(idf<=-1)
                   	{
                  
                   	}
                   	else{
                    	 System.out.print("\t"+df.format(tfidf) ) ;
                    	 writer.write("\t"+df.format(tfidf));

                   	
                 		}kalakandi++;
                 		 }
                 		 bekhad++;
                 		                   	 System.out.println(); 
                 		                   	 writer.write("\n");

                 		          			wordList.clear();


        

}
writer.close();
}

public static ArrayList<String> countnumberofdocs(String termfrequncyfile)throws Exception
{   
	//Method to get the total number of docs & the documents titles.
	   		// BufferedWriter writer = new BufferedWriter(new FileWriter("ABC.txt"));
 	 		 Scanner linecounter = new Scanner(new File(termfrequncyfile));  
				int count=0;
				ArrayList<String> indexList= new ArrayList();
				String line="";
				LineNumberReader r = new LineNumberReader(new FileReader(termfrequncyfile));

				int docs=0;

					if(r.getLineNumber()==0)
					{
					line=r.readLine();
        			 indexList.addAll(Arrays.asList(line.split("[\\t, ]")));
          			 indexList.remove(0);
          			 indexList.removeAll(Collections.singleton(null));
          			 indexList.removeAll(Arrays.asList(null,""));
					}
							
					
			
				return indexList;
		

}
public static ArrayList<String> getmaxfreq(String termfrequncyfile,int numdocsint)throws Exception
{   
	//Method to get the total number of docs & the documents titles.
 	 		int digit=0;
 	 		ArrayList<String> wordList=new ArrayList<>();
 	 		ArrayList<String> tempwordList=new ArrayList<>();

 	 		        Scanner scanner = new Scanner(new File(termfrequncyfile));  
 	 		        scanner.nextLine();
				for(int a=0;a<numdocsint;a++)
    			{
    				tempwordList.add("0");

    			}
    		while (scanner.hasNextLine()) {

      		String line = scanner.nextLine().trim();
      		    String linnx= line.substring(line.indexOf("\t")+1);

    			wordList.addAll(Arrays.asList(linnx.split("[\\t, ]")));
    			wordList.removeAll(Collections.singleton(null));
    			wordList.removeAll(Arrays.asList(null,""));
    			
    			for(int i=0;i<numdocsint;i++)
    			{
    				
    				int max=Integer.parseInt(tempwordList.get(i));
                   	int currentcount=Integer.parseInt(wordList.get(i));
                   	if(max<currentcount)
                      		{

                      			tempwordList.set(i, Integer.toString(currentcount));
                      		}    
					   			
                      			

    			}

    	
    	
    			wordList.clear();
				

    				

} 	

			return tempwordList;
		

}
public static ArrayList<String> Numberofdocumentscontainingtheterm(String termfrequncyfile,int numdocsint)throws Exception
{   
	//Method to get the total number of docs which contains particular  term.
 	 		int digit=0;
 	 		ArrayList<String> wordList=new ArrayList<>();
 	 		ArrayList<String> numberofdocumentscontainingtheterm=new ArrayList<>();

 	 		        Scanner scanner = new Scanner(new File(termfrequncyfile));  
 	 		        scanner.nextLine();
				//HashSet<String> MaxFreqHS = new HashSet<String>();
    while (scanner.hasNextLine()) {

      		String line = scanner.nextLine().trim();
      		    String linnx= line.substring(line.indexOf("\t")+1);

    			wordList.addAll(Arrays.asList(linnx.split("[\\t, ]")));
    			wordList.removeAll(Collections.singleton(null));
    			wordList.removeAll(Arrays.asList(null,""));
    			wordList.removeAll(Arrays.asList("0",""));
    		//	System.out.print(""+wordList.size());
    			numberofdocumentscontainingtheterm.add(""+wordList.size());

    			
    	
    			wordList.clear();
				

    				

} 	
			return numberofdocumentscontainingtheterm;
		

}

public static int numberofterms(String termfrequncyfile)throws Exception
{   
	//Method to get the total number of temrms in doucments.
 	 		

 	 		        Scanner scanner = new Scanner(new File(termfrequncyfile));  
 	 		        scanner.nextLine();
 	 		        int linecounter=0;
   			 while (scanner.hasNextLine()) {

      		 scanner.nextLine().trim();
      		 linecounter++;
      		    
				

    				

} 	
return linecounter;		

}


}