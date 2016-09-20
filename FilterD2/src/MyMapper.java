import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class MyMapper extends Mapper<LongWritable,Text,NullWritable, Text> {
	
	TreeMap<Double,String> details=new TreeMap<Double,String>();
	public void map(LongWritable inkey,Text invalue,Context context) throws IOException, InterruptedException
	{
		String str=invalue.toString();
	    String usrparts[]=str.split(",");
	    Double amt=Double.parseDouble(usrparts[3]);
	    
	    if(amt==0 && str==null)
	    	return;
	    details.put(amt,str);		
	    
	    if(details.size()>10)
	    {
	    	details.remove(details.firstKey());
	    	
	    }
	    
	}
	public void cleanup(Context context)throws IOException, InterruptedException
	{
		for( String t:details.values())
		context.write(NullWritable.get(),new Text(t));
		
	}
}
