package customkeyvalue;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class AmountValue implements Writable {
	Text amount;
	public AmountValue(Text amount) {
		super();
		this.amount = amount;
	}

	public AmountValue() {
		super();
		this.amount = new Text();
	}
	public Text getAmount() {
		return amount;
	}

	public void setAmount(Text amount) {
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
