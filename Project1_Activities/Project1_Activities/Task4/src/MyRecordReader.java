import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;


public class MyRecordReader extends RecordReader {
	MyKey key;
	MyValue val;
	LineRecordReader reader = new LineRecordReader();

	@Override
	public void close() throws IOException {
		reader.close();		
	}

	@Override
	public Object getCurrentKey() throws IOException, InterruptedException {
		return key;
	}

	@Override
	public Object getCurrentValue() throws IOException, InterruptedException {
		return val;
	}

	@Override
	public float getProgress() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return reader.getProgress();
	}

	@Override
	public void initialize(InputSplit arg0, TaskAttemptContext arg1) throws IOException, InterruptedException {
		reader.initialize(arg0, arg1);
		
	}

	@Override
	public boolean nextKeyValue() throws IOException, InterruptedException {
		boolean getnextVal = reader.nextKeyValue();
		if(getnextVal){
			if(key == null)
				key = new MyKey();
			if(val == null)
				val = new MyValue();
			org.apache.hadoop.io.Text line = reader.getCurrentValue();
			String[] each = line.toString().split(",");
			key.setid(new Text(each[1]));
			val.setAmt(new DoubleWritable(Double.parseDouble(each[3])));
		}
		else{
			key = null;
			val = null;	
		}
		return getnextVal;
	}

}
