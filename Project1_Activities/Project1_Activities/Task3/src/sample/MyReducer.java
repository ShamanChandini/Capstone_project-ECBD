package sample;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class MyReducer extends Reducer<IntWritable,DoubleWritable,IntWritable,Text>{
	double sum=0;
	
	public void reduce(IntWritable inpk,Iterable<DoubleWritable> inpv,Context c) throws IOException, InterruptedException{
	    int count=0;
	    double avg=0.0;
		for(DoubleWritable x:inpv){
			sum+=x.get();
			count=count+1;
			}
		avg=sum/count;
		c.write(inpk, new Text("Sum"+sum+"Count"+count+"Average"+avg));
		
		
	}

}
