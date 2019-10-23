import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.*;


class TDIDF{
  public static void main(String args[])throws Exception
  {
     
    String line="";
      String prcessedtxt="";
      String temp="";
       int counter=0;
       String word="";
      BufferedWriter writer = new BufferedWriter(new FileWriter("outputs\\TDIDF.txt"));

       ArrayList<String> headerslist = new ArrayList<>();
       headerslist=countnumberofdocs();
       int numofdocs=headerslist.size();
      //  System.out.print("");
       writer.write("\t");
       for (String title:headerslist ) {
       	System.out.print("\t"+title);
        writer.write("\t"+title);
       	
       }
                System.out.println("");
                writer.write("\n");


      ArrayList<String> wordList= new ArrayList();
     //  int numofdocs=countnumberofdocs();

      Scanner scanner = new Scanner(new File("InvertedIndex.txt"));  


    while (scanner.hasNextLine()) {

          line = scanner.nextLine();
        
          
          wordList.addAll(Arrays.asList(line.split("[\\t, ]")));
          wordList.removeAll(Collections.singleton(null));
         System.out.print(" "+wordList.get(0)+""); 
          writer.write(" "+wordList.get(0)+" \t");


          wordList.remove(0);
          
          wordList.removeAll(Arrays.asList(null,""));
          for (int i=0;i<headerslist.size() ;i++ ) {
        if(wordList.contains(headerslist.get(i)))
        {
                                        //  System.out.print(" ala"+wordList.size()); 
                                           Double logvala=((double)numofdocs)/(double)wordList.size();

                                System.out.print("\t"+Math.log10(logvala)); 
                                writer.write("\t"+Math.log10(logvala));


        }
        else{
                                                   System.out.print("\t 0"); 
                                                  writer.write("\t 0");


        }

      }
              System.out.println();
                        writer.write("\n");





wordList.clear();

}               
        writer.close();



  /*System.out.print(" " +wordList.toString());
        for(int i=0;i<wordList.size();i++)
        {
          String wordcheck=wordList.get(i);
          Scanner scannerforrepeats = new Scanner(new File("fullyprocessed.txt"));  

            System.out.print("\n"+wordcheck+" ");
            writer.write("\n"+wordcheck+" ");
                                     counter=0;
                numofdocs=0;

                while(scannerforrepeats.hasNextLine()){
          line = scannerforrepeats.nextLine().trim();
           
          if(line.contains(wordcheck))
          {
            if(line.contains("\t")){
              counter++;

          }
          


          }
          else{
            System.out.print(" ");  
           writer.write(" ");


          }
                          numofdocs++;


          }
        



          
                  


          
        }
      System.out.print(" "+counter); 


        writer.close();
        */

    
  

}
public static ArrayList<String> countnumberofdocs()throws Exception
{      Scanner linecounter = new Scanner(new File("InvertedIndex.txt"));  
				int count=0;
				ArrayList<String> indexList= new ArrayList();
				String line="";

				while(linecounter.hasNextLine())
				{
				//	linecounter.nextLine();
					 line = linecounter.nextLine().trim();
					 String linnx= line.substring(line.indexOf("\t")+1);
      				linnx.trim();
        			 indexList.addAll(Arrays.asList(linnx.split("[\\t, ]")));
          			// indexList.remove(0);
          			indexList.removeAll(Collections.singleton(null));
          			indexList.removeAll(Arrays.asList(null,""));
          							          	//		System.out.println(" "+linnx+"\t"); 


						//count++;

				}

        LinkedHashSet<String> hashSet = new LinkedHashSet<>(indexList);
         
           ArrayList<String> listWithoutDuplicates = new ArrayList<>(hashSet);

				// System.out.print(" "+listWithoutDuplicates.toString()+"\t"); 


				return listWithoutDuplicates;
		

}


}