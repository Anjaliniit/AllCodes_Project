package customkeyvalue;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CustomKeyValueReducer extends Reducer<UidDateKey, AmountValue, Text, Text> {
	public void reduce(UidDateKey inkey, Iterable<AmountValue> invalues,Context context) throws IOException, InterruptedException{
		for(AmountValue invalue : invalues){
			context.write(inkey.getUid(), invalue.getAmount());
		}
	}

}
