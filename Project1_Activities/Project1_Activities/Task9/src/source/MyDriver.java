package source;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDriver {

	public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		Job j = new Job(conf,"Combiner Program");
		j.setJarByClass(MyDriver.class);
		j.setMapperClass(MyMapper.class);
		j.setCombinerClass(MyCombiner.class);
		j.setReducerClass(MyReducer.class);
		j.setNumReduceTasks(1);
		j.setMapOutputKeyClass(Text.class);
		j.setMapOutputValueClass(Text.class);
	
		FileInputFormat.addInputPath(j, new Path(args[0]));
		FileOutputFormat.setOutputPath(j, new Path(args[1]));
		
		DistributedCache.addCacheFile(new URI("/Oliver/Customer.dat"),j.getConfiguration());
		
		System.exit(j.waitForCompletion(true)?0:1);

	}

}
