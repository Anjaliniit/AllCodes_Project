package customkeyvalue;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CustomKeyValueMapper extends Mapper<LongWritable,Text,UidDateKey,AmountValue> {
	public void map(LongWritable inkey, Text invalue,Context context  ) throws IOException, InterruptedException{
		String line = invalue.toString();
		String parts[] = line.split(",");
		UidDateKey uiddt = new UidDateKey(new Text(parts[2]),new Text(parts[1]));
		AmountValue amt = new AmountValue(new Text(parts[3]));
		context.write(uiddt, amt);
		
	}
}
