import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class MyMapper extends Mapper<MyKey, MyValue,IntWritable,IntWritable> {
	
	public void map(MyKey inpK, MyValue inpV, Context c) throws IOException, InterruptedException{
		int minAmt = c.getConfiguration().getInt("Lower", 0);
		int maxAmt = c.getConfiguration().getInt("Upper", 10);
		int amt = inpV.getAmt();
		int count=0;
		if(amt>minAmt || amt<maxAmt){
			c.write(new IntWritable(1),new IntWritable(1));
		}
	}

}
