package mypack;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text,Text,DoubleWritable> {

	public void map(LongWritable inputkey,Text invalue,Context context) throws IOException, InterruptedException
	{
		String txn=invalue.toString();
		String txnparts[]=txn.split(",");
		String date=txnparts[1];
		Double d=Double.parseDouble(txnparts[3]);
		String month=date.substring(0,2);
		context.write(new Text(month), new DoubleWritable(d));		
	}
}