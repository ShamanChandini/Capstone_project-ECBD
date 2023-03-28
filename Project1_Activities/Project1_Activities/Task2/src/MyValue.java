
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class MyValue implements Writable{
	Text amt;
	
	public MyValue(){
		this.amt = new Text();
	}
	public MyValue(Text amt){
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
	
	public void setAmt(Text amt){
		this.amt=amt;
	}
	public Integer getAmt(){
		return Integer.parseInt(amt.toString());
	}

}