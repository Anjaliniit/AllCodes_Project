package task3;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class TrIdKey implements WritableComparable<TrIdKey> {

	Text trId;
	public TrIdKey() {
		trId=new Text();
	}

	public TrIdKey(Text trId) {
		this.trId = trId;
	}

	public Text getTrId() {
		return trId;
	}

	public void setTrId(Text trId) {
		this.trId = trId;
	}

	@Override
	public void readFields(DataInput arg0) throws IOException {
		trId.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		trId.write(arg0);
	}

	@Override
	public int compareTo(TrIdKey arg0) {
		return trId.toString().compareTo(arg0.trId.toString());
	}

	 

}
