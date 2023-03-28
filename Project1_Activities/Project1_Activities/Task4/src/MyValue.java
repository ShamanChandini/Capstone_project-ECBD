import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Writable;

public class MyValue implements Writable{
	DoubleWritable amt;
	
	public MyValue(){
		this.amt = new DoubleWritable();
	}
	public MyValue(DoubleWritable amt){
		this.amt = amt;
	};
	
	@Override
	public void readFields(DataInput arg0) throws IOException {
		amt.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		amt.write(arg0);
	}
	
	public void setAmt(DoubleWritable amt){
		this.amt=amt;
	}
	public double getAmt(){
		return Double.parseDouble(amt.toString());
	}

}
