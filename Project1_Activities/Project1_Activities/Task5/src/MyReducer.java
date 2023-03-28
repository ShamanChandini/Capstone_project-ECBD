import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class MyReducer extends Reducer<Text,Text,Text,Text>{
	double sum=0;
	
	public void reduce(Text inpk,Iterable<Text> inpv,Context c) throws IOException, InterruptedException{
		for(Text x:inpv){
			c.write(x,null);	
		
		}
		
		
		
	}

}