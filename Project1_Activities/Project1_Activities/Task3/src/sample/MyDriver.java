package sample;

import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		
		Configuration conf = new Configuration();
		Scanner src = new Scanner(System.in);
		System.out.println("Enter Your Customer ID");
		int cid=0;
		
		try{
			cid=src.nextInt();
		}
		catch(Exception ex){
			System.out.println("Please enter only numbers");
			System.exit(1);
		}
		conf.setInt("Cid",cid);
		Job j = new Job(conf, "Output");
		j.setJarByClass(MyDriver.class);
		j.setMapperClass(MyMapper.class);
		j.setReducerClass(MyReducer.class);
		j.setNumReduceTasks(1);
		j.setMapOutputKeyClass(IntWritable.class);
		j.setMapOutputValueClass(DoubleWritable.class);
		
		j.setInputFormatClass(MyInputFormat.class);
		
		FileInputFormat.addInputPath(j, new Path(args[0]));
		FileOutputFormat.setOutputPath(j, new Path (args[1]));
		
		System.exit(j.waitForCompletion(true)?0:1);

	}

}
