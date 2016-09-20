package customkeyvalue;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class UidDateKey implements WritableComparable<UidDateKey> {

	private Text uid, trdate;
	public UidDateKey() {
		this.uid=new Text();
		this.trdate=new Text();
		
	}

	public Text getUid() {
		return uid;
	}

	public void setUid(Text uid) {
		this.uid = uid;
	}

	public Text getTrdate() {
		return trdate;
	}

	public void setTrdate(Text trdate) {
		this.trdate = trdate;
	}

	public UidDateKey(Text uid, Text trdate) {
		super();
		this.uid = uid;
		this.trdate = trdate;
	}

	@Override
	public void readFields(DataInput arg0) throws IOException {
		 uid.readFields(arg0);
		 trdate.readFields(arg0);
		 
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		 uid.write(arg0);
		 trdate.write(arg0);	
	}

	@Override
	public int compareTo(UidDateKey arg0) {
 
		return uid.toString().compareTo(arg0.toString());
	}

}
