import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class MyReducer extends Reducer<Text,DoubleWritable,Text,DoubleWritable>{
	double sum=0;
	
	public void reduce(Text inpk,Iterable<DoubleWritable> inpv,Context c) throws IOException, InterruptedException{
	    //int count=0; not used anywhere
		for(DoubleWritable x:inpv){
			sum=sum+x.get();
		
		}
		c.write(inpk, new DoubleWritable(sum));
		
		
	}

}