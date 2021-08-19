import java.util.concurrent.RecursiveAction;
import java.io.PrintWriter;
import java.util.Arrays;



public class ForkJoin extends RecursiveAction

{
		static float [] arr; static int width; 

		static final int SEQUENTIAL_CUTOFF = 10000; //sequentu

		 int lo; int hi;
		 static float[] medianArray;

		ForkJoin(float [] a, int w, int l, int h)
		{ arr = a; width = w; lo=l; hi=h;}


		protected void compute(){

		    if((hi-lo) < SEQUENTIAL_CUTOFF) {

		        filter();
			}

		    else {	 

					invokeAll(new ForkJoin(arr,width,lo,(hi+lo)/2), new ForkJoin(arr,width,(hi+lo)/2,hi));
					//filter();
			}
		     
		}

		public void filter(){

		        float[] medianArray = new float[arr.length];
			try{

					PrintWriter writer = new PrintWriter("OutputFiles/sampleOutput"+arr.length+".txt", "UTF-8");
			      
			        for(int i =0; i < arr.length; i++) {

				        if(i < width/2 || (arr.length - i) <= width/2){

				        	medianArray[i] = arr[i];//writer.println(arr[i]);

				        }
				   
				        else {

				            float[] field = new float[width]; int ii = 0;
				            
				            for(int j = i - width/2; j < i + (width/2)+1; j++) {
				               field[ii] = arr[j]; ii++;	
				            }

				            Arrays.sort(field);
				            medianArray[i] = (field[width/2]);
				        }
				        
				    }writer.close();
				}
			catch(Exception e) { System.out.println("An Error occured while writting.");}
		}
		static float [] filteredArray(){ return medianArray;}


}
