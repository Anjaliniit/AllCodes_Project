package task3;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Writable;


public class AmountValue implements Writable {

	private DoubleWritable amount;
	public AmountValue() {
		this.amount=new DoubleWritable();
	}

	public AmountValue(DoubleWritable amount) {
		this.amount = amount;
	}

	public DoubleWritable getAmount() {
		return amount;
	}

	public void setAmount(DoubleWritable amount) {
		this.amount = amount;
	}

	@Override
	public void readFields(DataInput arg0) throws IOException {
		amount.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		amount.write(arg0);
		
	}


}
