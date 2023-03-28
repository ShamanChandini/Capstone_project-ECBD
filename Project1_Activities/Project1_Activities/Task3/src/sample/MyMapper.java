package sample;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class MyMapper extends Mapper<MyKey, MyValue,IntWritable,DoubleWritable> {
	
	public void map(MyKey inpK, MyValue inpV, Context c) throws IOException, InterruptedException{
		int cid = c.getConfiguration().getInt("Cid", 0);
		double amt = inpV.getAmt();
		int id=inpK.getid();
		
		if(cid==id){
		c.write(new IntWritable(id), new DoubleWritable(amt));
		}
		
	}

}
