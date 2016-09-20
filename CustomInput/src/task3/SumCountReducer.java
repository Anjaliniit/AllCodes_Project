package task3;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SumCountReducer extends Reducer<TrIdKey,AmountValue, Text, Text> {
	public void reduce(TrIdKey key,Iterable<AmountValue> values,Context context) throws IOException, InterruptedException{
		double sum=0;
		int count=0;
		for(AmountValue value : values){
//			if(key.getTrId().toString().equals("4009999")){
			sum+=value.getAmount().get();
			count++;
//			context.write(key.getTrId(), new Text("Total Amount Spent " + sum + " No of Expenses : " + count));
//			}
		}
		context.write(key.getTrId(), new Text("Total Amount Spent " + sum + " No of Expenses : " + count));
	}

}
