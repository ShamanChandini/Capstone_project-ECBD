package source;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class MyReducer extends Reducer<DoubleWritable,Text,Text,Text>{
	
	Map<Double,String> hm=new HashMap<Double,String>();
	
	public void reduce(DoubleWritable inpk,Iterable<Text> inpv,Context c) throws IOException, InterruptedException{
		double amt=Double.parseDouble(inpk.toString());
		for(Text t:inpv){
	       c.write(null, new Text(t.toString()));
		}
		
	}

}
