package pack;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class MyReducer extends Reducer<Text,IntWritable,Text,IntWritable> 
{
	 TreeMap<Integer,String>map=new TreeMap<>();
 public void reduce(Text inkey,Iterable<IntWritable> invals,Context context) 
 {
	 int count=0;
	  
	    for(IntWritable singleValue:invals)
	    {
	      count++;                            
	    }
	    map.put(count,inkey.toString());
	 
 }
 public void cleanup(Context context)throws IOException, InterruptedException
	    {
	/* String name=null;
	 	int value=0;
	 	Set<Integer> s=map.keySet();
		
	    Iterator itr=s.iterator();
	    while(itr.hasNext())
	    {  value=(Integer)itr.next();
	    	name=map.get(value);
	    	
	    } 
		context.write(new Text(name),new IntWritable(value));*/
	   context.write(new Text(map.get(map.lastKey())),new IntWritable(map.lastKey()));	 
}
}