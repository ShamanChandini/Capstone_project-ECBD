import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class MyReducer extends Reducer<IntWritable,IntWritable,IntWritable,IntWritable>{
	
	public void reduce(IntWritable inpk,Iterable<IntWritable> inpv,Context c) throws IOException, InterruptedException{
		int count=0;
		for(@SuppressWarnings("unused") IntWritable x:inpv){
			count=count+1;
			}
		c.write(new IntWritable(count),null);
		
		
	}

}
