package mypack;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

	public void map(LongWritable inputkey,Text invalue,Context context) throws IOException, InterruptedException
	{
		String txn=invalue.toString();
		String txnparts[]=txn.split(",");
		Double amt=Double.parseDouble(txnparts[3]);
		if(amt>150)
		{
			context.write(new Text("no of transaction"),new IntWritable(1));	
		}
		
		
	}
	
	
}
