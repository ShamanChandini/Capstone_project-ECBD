
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class MyMapper extends Mapper<LongWritable, Text, Text,Text> {
	HashMap<String, String> hm= new HashMap<>();
	public void setup(Context c) throws IOException{
		Path[] allFiles = DistributedCache.getLocalCacheFiles(c.getConfiguration());		
		for(Path eachFile : allFiles){
			if(eachFile.getName().equals("Customer.dat")){
				FileReader fr = new FileReader(eachFile.toString());
				BufferedReader br = new BufferedReader(fr);
				String line =br.readLine();
				while(line != null){
					String[] eachVal = line.split(",");
					String id = eachVal[0];
					String name = eachVal[1];
					hm.put(id,name);
					line=br.readLine();
				}
				br.close();
			}
			if (hm.isEmpty()) 
			{
				throw new IOException("Unable To Load The file..");
			}
		}
	}
	
	public void map(LongWritable mInpKey, Text mInpVal, Context c) throws IOException, InterruptedException{
		String line = mInpVal.toString();
		String eachVal[] = line.split(",");
		String id=eachVal[2];
		String amt= eachVal[3];
		String Name = hm.get(id);
		
		
		//DoubleWritable mOutVal = new DoubleWritable(Double.parseDouble(amt));
		if(Name!=null)
			c.write(new Text(Name), new Text(amt));
		
	} 
	

}
