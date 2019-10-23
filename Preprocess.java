import java.util.*; 
import java.io.*;
import java.util.stream.Stream;
import java.nio.file.*;

/**
 * Created by Shivraj on 29-09-2019.
 */

class Preprocess
{

	public static void main(String[] args) throws Exception {
		//GETTING LIST OF STOPWORDS FROM STOPWORDS.TXT FILE ";
		String[] stopwords=getstopwords("Stopwords.txt");
    //CALLING METHOD TO REMOVE STOPWORDS
		removeStopwords();
		 
}
public static void Stemmingmethod()throws Exception
{
      //STEMMING CAN BE PERFORMED ONLY BY ANALYZING CHARACTER BY CHARACTER.
   char[] w = new char[501];
      Stemmer s = new Stemmer();
      String prcessedtxt="";
      ArrayList<String> finalsen= new ArrayList();
      BufferedWriter writer = new BufferedWriter(new FileWriter("fullyprocessed.txt"));

      String u=null;
     
      {
         FileInputStream in = new FileInputStream("stopwordsremoved.txt");

         while(true)

           {  int ch = in.read();
              if (Character.isLetter((char) ch))
              {
                 int j = 0;
                 while(true)
                 {  ch = Character.toLowerCase((char) ch);
                    w[j] = (char) ch;
                    if (j < 500) j++;
                    ch = in.read();
                    if (!Character.isLetter((char) ch))
                    {
                      
                        s.add(w, j); 

                       s.stem();
                       {  

                          u = s.toString();
                          finalsen.add(u);
                          /* to test getResultBuffer(), getResultLength() : */
                          /* u = new String(s.getResultBuffer(), 0, s.getResultLength()); */

                          System.out.print(u);
                       }
                       break;
                    }
                 }
              }
              if (ch < 0) break;
              System.out.print((char)ch);
              finalsen.add(""+(char)ch);


           }
         }
         
      
      
                for(String word:finalsen){
      prcessedtxt=prcessedtxt+""+ word;
    }
    writer.write(prcessedtxt+"\n"); 
    prcessedtxt="";
    finalsen.clear();
          writer.close();


  
}
//<<<<Start
  public static String[] getstopwords(String file)
  {   
    int counter=0;

    try{

    Scanner sccounter=new Scanner(new File(file));
    while(sccounter.hasNextLine())
    {
      counter=counter+1;
      sccounter.nextLine();
    }

    String[] wordss= new String[counter];
    Scanner scwords=new Scanner(new File(file));
    for (int i=0;i< counter ; i=i+1) {
      wordss[i]=scwords.next();
      
    }
       return wordss;
    }
    catch(Exception NoSuchFieldException)
    {
      System.out.print("NO such File");
    }
    return null;

  }
// End>>>>

  /* Method to remove  stopwords from sentence. */

// <<<<Start
public static void removeStopwords() throws Exception
  {
    //converting sentence to lowercase 
    String[] stopwords=getstopwords("Stopwords.txt");
    //FileWriter f=new FileWriter("output.txt");
      String line="";
      String prcessedtxt="";
      Scanner scanner = new Scanner(new File("Sentence.txt"));
       Scanner newscanner = new Scanner(new File("Sentence.txt"));

      BufferedWriter writer = new BufferedWriter(new FileWriter("stopwordsremoved.txt"));
       FileInputStream fstream = new FileInputStream("Sentence.txt");
         BufferedReader   br = new BufferedReader(new InputStreamReader(fstream));
         LineNumberReader lineNumberReader =
    new LineNumberReader(br);
            //BufferedReader br = new BufferedReader(new FileReader("Sentence.txt"));

      int counter=0;
      int subc=0;
      ArrayList<String> wordList= new ArrayList();
      br.mark(3);
            

         HashMap<String, String> capitalCities = new HashMap<String, String>();
      

    while (scanner.hasNextLine()) {

      line = scanner.nextLine().trim();
             line=line.replaceAll("\\p{Punct}", "");

            line=""+line;


      
    wordList.addAll(Arrays.asList(line.split("[\\t, ]")));
    String title=wordList.get(0);
    wordList.remove(0);
    wordList.add(0,"\t");
    
    List<String> StopwordList= new ArrayList();
    //adding stop words in another array.
    StopwordList.addAll(Arrays.asList(stopwords));
    //removing stopwords from sentence.
    wordList.removeAll(StopwordList);
    
    for(String word:wordList){
      prcessedtxt=prcessedtxt+" "+ word;
    }
    writer.write(title+prcessedtxt+"\n"); 
  //  System.out.print(wordList.toString());
    prcessedtxt="";
    wordList.clear();


    counter++;
  
      

}   
  
    writer.close();
    
Stemmingmethod();
}
//End>>>>
 public static String readFileAsString(String fileName)throws Exception 
  { 
     //data = "Sentence.txt"; 
    //String data = new String(Files.readAllBytes(Paths.get(fileName))); 
   /* FileWriter f=new FileWriter("output.txt");
     String line="";
    Scanner scanner = new Scanner(new File(fileName));
  while (scanner.hasNextLine()) {
    line = scanner.nextLine();
    line=line+"\n";
    f.write(line);
   // process the line
}*/
//BufferedReader br = new BufferedReader(new FileReader(fileName));
  FileWriter f=new FileWriter("output.txt");
    String line="";
    Scanner scanner = new Scanner(new File(fileName));
   while (scanner.hasNextLine()) {
    line = scanner.nextLine();
//System.out.print(line+"\n");

   // process the line
}

    return line; 

  } 
  public static Scanner iteratline(Scanner scanner,int number)throws Exception{
    return scanner.skip("(?:.*\\r?\\n|\\r){"+number+"}");


  }

 
}