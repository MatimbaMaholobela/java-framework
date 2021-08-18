import java.io.File;
import java.util.*; 
/**
 * This class simply takes a file name as parameter then return an array of the values read in the file
 * 
 * @author Matimba Maholobela
 * */



public class FileRead{

   /**
    * read is a method that accepts filename as 
    * @param  filename and 
    * @return arr -float []
    * */

   static float [] arr ;
   
   public static float [] read(String filename) {
      try{//import java.Exception;

         //FileRead.filename = filename;
         Scanner file = new Scanner(new File("data/"+filename));
         int size = Integer.parseInt(file.nextLine());      
         arr = new float[size]; int i = 0;

         while(file.hasNextLine()){
         
            String line []  = file.nextLine().split(" ");

            if(line[1].indexOf(",") !=-1)
               
            { arr[i] = Float.parseFloat(line[1].replace(",",".").trim()); i++; }
            
            else {arr[i] = Float.parseFloat(line[1].trim()); i++;}
               
         }return arr;
      }
      catch(Exception e){ return null;}

   }
}
