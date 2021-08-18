import java.util.concurrent.ForkJoinPool;

//import java.io.File;
//import java.io.FileWriter;
import java.util.*;
public class ForkJoinRun{

	static long startTime  = 0;


	public static void tick(){ startTime  = System.currentTimeMillis();}

	public static float tock(){ return (System.currentTimeMillis()-startTime)/1000.0f;}

	public static void main(String[] args) {

		Scanner input  = new Scanner(System.in);

		System.out.println("enter  <data file name> <filter size (odd integer 3 <=size<=21)>");
		
		String inputfile = input.next(); int width = input.nextInt();

		tick();
		float[] arr = FileRead.read(inputfile);
		float time0 = tock();

		input.close();

		System.out.println("File read complete "+time0+" seconds.\nInitiating Median Filter...");

		final ForkJoinPool fjPool = new ForkJoinPool();

		tick();
		System.gc();
		fjPool.invoke(new ForkJoin(arr,width,0,arr.length));
		
		float time = tock();
		System.out.println("Run time "+time+ " seconds");
	}
		
}
