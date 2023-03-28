import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class MyKey implements WritableComparable {
	Text id;
	
	public MyKey(){
		this.id = new Text();
	}
	public MyKey(Text name,Text id){
		this.id = id;		
	}
	@Override
	public void readFields(DataInput arg0) throws IOException {
		id.readFields(arg0);		
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		id.write(arg0);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setid(Text id){
		this.id=id;
	}
	
	
	public String getid() {
		return id.toString();
	}
	
	

}
