import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class MyMapper extends Mapper<LongWritable,Text,Text,Text>{
	
	public void map(LongWritable inpk,Text inpv,Context c) throws IOException, InterruptedException{
		String line=inpv.toString();
		String mon=line.split(",")[1].split("-")[0];
		
		
		c.write(new Text(mon),new Text(line));
		
		
		}
	}