package com.niit.mks;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, Text, Text,Text>{

	@Override
	protected void reduce(Text education, Iterable<Text> values,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		int male=0;
		int female=0;
		for(Text it:values)
		{
			String value=it.toString().trim();
			if(value.equalsIgnoreCase("Male"))
			{
				male++;
				
			}
			else
			{
				female++;
			}
			
		}
		String output="Total Number of Males::"+male+"\n \t\tTotal Number of Females::"+female+ "\n \t\tTotal is:"+(male+female);
		context.write(education,new Text(output));
	}

}
