package task3;

import java.io.IOException;

import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

public class SumCountReader extends RecordReader<TrIdKey, AmountValue> {
	private TrIdKey trId;
	private AmountValue amount;
	private LineRecordReader reader= new LineRecordReader();
	

	@Override
	public void close() throws IOException {
		reader.close();
	}

	@Override
	public TrIdKey getCurrentKey() throws IOException, InterruptedException {
		return trId;
	}

	@Override
	public AmountValue getCurrentValue() throws IOException, InterruptedException {
		return amount;
	}

	@Override
	public float getProgress() throws IOException, InterruptedException {
		return reader.getProgress();
	}

	@Override
	public void initialize(InputSplit arg0, TaskAttemptContext arg1) throws IOException, InterruptedException {
		reader.initialize(arg0, arg1);
		
	}

	@Override
	public boolean nextKeyValue() throws IOException, InterruptedException {
		boolean flag = reader.nextKeyValue();
		if(flag){
			if(trId==null){
				trId=new TrIdKey();
			}
			if(amount==null){
				amount = new AmountValue();
			}
			Text line = reader.getCurrentValue();
			String[] tokens = line.toString().split(",");
			trId.setTrId(new Text(tokens[2]));
			amount.setAmount(new DoubleWritable(Double.parseDouble(tokens[3].toString())));
		}
		else
		{
			trId=null;
			amount=null;
		}
		return flag;
	}

}
