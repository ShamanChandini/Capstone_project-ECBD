import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;



public class MyMapper extends Mapper<MyKey, MyValue,Text,DoubleWritable> {
	
	public void map(MyKey inpK, MyValue inpV, Context c) throws IOException, InterruptedException{
		int usermonth = c.getConfiguration().getInt("Month", 0);
		double amt = inpV.getAmt();
		String m=inpK.getid();
		String mon=m.split("-")[0];
		int data=Integer.parseInt(mon);
		if(usermonth==data)
			c.write(new Text(mon), new DoubleWritable(amt));
		
		
		
		}
		
	}

