import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text,DoubleWritable,Text> {

	public void map(LongWritable inputkey,Text invalue,Context context) throws IOException, InterruptedException
	{
		String txn=invalue.toString();
		String txnparts[]=txn.split(",");
		Double amt=Double.parseDouble(txnparts[3]);
		context.write(new DoubleWritable(amt), new Text(txn));		
	}
}
