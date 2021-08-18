import java.io.PrintWriter;
import java.util.Arrays;
import java.util.*;

public class NormalRun

{
	static long startTime  = 0;

	public static void tick(){ startTime  = System.currentTimeMillis();}

	public static float tock(){ return (System.currentTimeMillis()-startTime)/1000.0f;}

	public static void main(String args []){

	
	
		Scanner input  = new Scanner(System.in);

		System.out.println("enter  <data file name> <filter size (odd integer 3 <=size<=21)>");
		
		String inputfile = input.next(); int width = input.nextInt();

		tick();
		float[] arr = FileRead.read(inputfile);
		float time0 = tock();

		input.close();

		System.out.println("No Fork Join\nFile read complete "+time0+" seconds.\n Initiating Median Filter...");

		tick();
		
		filter(arr,width);
		
		float time = tock();
		System.out.println("Run time "+time+ " seconds");		

	}


	static void filter(float[] arr, int width){

		        //float[] filtered = new float[arr.length];/// this array will be replaced by the output file
		try{

			PrintWriter writer = new PrintWriter("OutputFiles/NormalRun/sampleOutput"+arr.length+".txt", "UTF-8");
			      
			for(int i =0; i < arr.length; i++) {

				if(i < width/2 || (arr.length - i) <= width/2){

				    writer.println(arr[i]);

				}
				   
				else{

				    float[] field = new float[width]; int ii = 0;
				            
				    for(int j = i - width/2; j < i + (width/2)+1; j++) {

				        field[ii] = arr[j]; ii++;
				    }

				    Arrays.sort(field);
				    writer.println(field[width/2]);
				}
				        
			}writer.close();
		}
		
		catch(Exception e) { System.out.println("An Error occured while writting.");}
		      
	}
}
