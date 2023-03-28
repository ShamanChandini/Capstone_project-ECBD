import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner extends Partitioner<Text, Text> {

	@Override
	public int getPartition(Text arg0, Text arg1, int arg2) {
		// TODO Auto-generated method stub
		int month=Integer.parseInt(arg0.toString());
		if(month==1)
			return 0;
		else if(month==2)
			return 1;
		else if(month==3)
			return 2;
		else if(month==4)
			return 3;
		else if(month==5)
			return 4;
		else if(month==6)
			return 5;
		else if(month==7)
			return 6;
		else if(month==8)
			return 7;
		else if(month==9)
			return 8;
		else if(month==10)
			return 9;
		else if(month==11)
			return 10;
		else
			return 11;
	}

	
	
}
