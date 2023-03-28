import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;


public class MyMapper extends Mapper<MyKey, MyValue, Text, Text> {
	
	public void map(MyKey inpK, MyValue inpV, Context c) throws IOException, InterruptedException{
		int minAmt = c.getConfiguration().getInt("Amount", 30);
		double amt = inpV.getAmt();
		if(amt>minAmt){
			c.write(new Text(inpK.getid()), new Text(Double.toString(inpV.getAmt())));
		}
	}

}