import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Scanner src = new Scanner(System.in);
		System.out.println("Enter the minimum value");
		int amt=0;
		try{
			amt=src.nextInt();
		}
		catch(Exception ex){
			System.out.println("Please enter only numbers");
			System.exit(1);
		}
		conf.setInt("Amount", amt);
		Job j = new Job(conf, "Output");
		FileSystem hdfs = FileSystem.get(conf);
		j.setJarByClass(MyDriver.class);
		j.setMapperClass(MyMapper.class);
		j.setNumReduceTasks(0);
		j.setMapOutputKeyClass(Text.class);
		j.setMapOutputValueClass(Text.class);
		j.setInputFormatClass(MyInputFormat.class);
		
		FileInputFormat.addInputPath(j, new Path(args[0]));
		FileOutputFormat.setOutputPath(j, new Path (args[1]));
		
		Path newpath = new Path(args[1]);
		if(hdfs.exists(newpath)){
			hdfs.delete(newpath,true);
		}
		Path localfilepath = new Path("/home/hduser/InputFormat_Trans");
		if(j.waitForCompletion(true)){
			hdfs.copyToLocalFile(newpath, localfilepath);
		}
		
		System.exit(j.waitForCompletion(true)?0:1);
	}

}
