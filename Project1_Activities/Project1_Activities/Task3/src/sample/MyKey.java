package sample;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;


public class MyKey implements Writable{
	Text id;
	
	public MyKey(){
		this.id = new Text();
	}
	public MyKey(Text i){
		this.id = i;
	};
	
	@Override
	public void readFields(DataInput arg0) throws IOException {
		id.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		id.write(arg0);
	}
	
	public void setid(Text i){
		this.id=i;
	}
	public Integer getid(){
		return Integer.parseInt(id.toString());
	}

}