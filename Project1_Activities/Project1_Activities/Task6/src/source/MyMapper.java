package source;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text,DoubleWritable,Text> {

	
	public void map(LongWritable inpk,Text inpv,Context c) throws IOException, InterruptedException{
		String[] line=inpv.toString().split(",");
		double amt=Double.parseDouble(line[3]);
		
		c.write(new DoubleWritable(amt),new Text(inpv.toString()));
		
	}
	
}
