package mypack;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;

public class MyReducer extends Reducer<Text,Text,Text,DoubleWritable> 
{
 public void reduce(Text inkey,Iterable<Text> invals,Context context) throws IOException, InterruptedException
 {
	 double sum=0;
	 for(Text data:invals)
	 {
	 String dataparts[]=data.toString().split(":");
	 if(dataparts[0].equals("AMT"))
	 {
		 sum+=Double.parseDouble(dataparts[0]);
		 
	 }
	 }
	 context.write(inkey,new DoubleWritable(sum));
	 
	 
}
}