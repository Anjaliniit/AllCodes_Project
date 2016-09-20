package task3;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SumCountMapper extends Mapper<TrIdKey, AmountValue, TrIdKey, AmountValue> {
//public class SumCountMapper extends Mapper<TrIdKey, AmountValue, Text, DoubleWritable> {
	public void map(TrIdKey inkey, AmountValue value, Context context) throws IOException, InterruptedException{
		//context.write(inkey.getTrId(), value.getAmount());
//	if(inkey.getTrId().toString().equals("4009999"))	context.write(inkey.getTrId(), value.getAmount());
		context.write(inkey, value);
	}

}
