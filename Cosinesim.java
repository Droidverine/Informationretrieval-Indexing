import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;


class Cosinesim{
  public static void main(String args[])throws Exception
  {
     
    String line="";
      String prcessedtxt="";
      String temp="";
       int counter=0;
       int numofdocs=5;
       String word="";
       int index1;
       int index2;
       Double dotpro=0.00;
       Double sqrtpro;
       Double tempbuff=0.00;
              Double tempbuff1=0.00;

       DecimalFormat df = new DecimalFormat("#.#########");
        df.setRoundingMode(RoundingMode.CEILING);

              Scanner myObj = new Scanner(System.in);  

        System.out.println("Enter File 1");

    String file1 = myObj.nextLine();
        System.out.println("Enter File 2");

    String file2 = myObj.nextLine();
       ArrayList<Integer> tempList= countnumberofdocs(file1,file2);
       index1=tempList.get(0);
       index2=tempList.get(1);
       
      
      ArrayList<String> wordList= new ArrayList();

      Scanner scanner = new Scanner(new File("outputs\\TDIDF.txt"));  
      if(scanner.hasNextLine())
      {
      	scanner.nextLine();
      }

    while (scanner.hasNextLine()) {
          
          line = scanner.nextLine().trim();
			String linnx= line.substring(line.indexOf("\t")+1);
      				linnx.trim();

        
          
          wordList.addAll(Arrays.asList(linnx.split("[\\t, ]")));


          wordList.removeAll(Collections.singleton(null));

          
          wordList.removeAll(Arrays.asList(null,""));

         
          	          dotpro=dotpro+Double.parseDouble(wordList.get(index1))*Double.parseDouble(wordList.get(index2));

                      tempbuff=tempbuff+Double.parseDouble(wordList.get(index1));
                      tempbuff1=tempbuff1+Double.parseDouble(wordList.get(index2));


          wordList.clear();





}               
                   System.out.println(" "+dotpro/Math.sqrt(tempbuff1* tempbuff)+""); 




    
  // 0.019802349086927146

}

//METHOD TO GET INDEXES NAMES OF FILES i.e. D1,D2,D3,D4
public static ArrayList<Integer> countnumberofdocs(String file1, String file2)throws Exception
{      Scanner linecounter = new Scanner(new File("outputs//TDIDF.txt"));  
				int count=0;
				String line="";
				int file1index=0;
				int file2index=0;
				ArrayList<String> indexList= new ArrayList();
				ArrayList<Integer> indexnumber= new ArrayList();



					 line = linecounter.nextLine().trim();
					// String linnx= line.substring(line.indexOf("\t")+1);
      				//linnx.trim();
        			 indexList.addAll(Arrays.asList(line.split("[\\t, ]")));
          			// indexList.remove(0);
          			indexList.removeAll(Collections.singleton(null));
          			indexList.removeAll(Arrays.asList(null,""));
         			//System.out.print(" "+indexList.indexOf(file1)+" "+ indexList.indexOf(file2)); 

         			indexnumber.add(indexList.indexOf(file1));
         			indexnumber.add(indexList.indexOf(file2));


				

        LinkedHashSet<String> hashSet = new LinkedHashSet<>(indexList);
         
           ArrayList<String> listWithoutDuplicates = new ArrayList<>(hashSet);

				return indexnumber;
		

}


}