
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class MyCombiner extends Reducer<Text, Text, Text, Text> {
	public void reduce(Text inpK,Iterable<Text> inpV, Context c) throws IOException, InterruptedException{
		double amount = 0.0;
		for(Text x: inpV){
			amount += Double.parseDouble(x.toString());
		}
		c.write(new Text("Hello"), new Text(inpK+":"+Double.toString(amount)));
	}

}
