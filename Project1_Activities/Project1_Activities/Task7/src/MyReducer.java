
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, Text, Text, Text> {
	public void reduce(Text inpK, Iterable<Text> inpV, Context c) throws IOException, InterruptedException{
		double amount=0.0,max=0.0;
		String name=null;
		Map<String,Double> hm=new HashMap<String,Double>();
		for(Text each: inpV){
			String[] data=each.toString().split(":");
			name=data[0];
			amount=Double.parseDouble(data[1]);
			hm.put(name,amount);
			
		}
		Set<java.util.Map.Entry<String, Double>> set = hm.entrySet();
		List<java.util.Map.Entry<String, Double>> list = new ArrayList<java.util.Map.Entry<String,Double>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Double>>()
        {
            public int compare( Map.Entry<String, Double> o1, Map.Entry<String, Double> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        int flag=0;
        for(Map.Entry<String, Double> entry:list){
        	c.write(new Text(entry.getKey().toString()),new Text(""+entry.getValue()+""));
        	flag++;
        	if(flag==3){break;}
        }
	}
}