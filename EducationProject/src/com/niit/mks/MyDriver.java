package com.niit.mks;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDriver {
	public static void main(String [] args) throws IOException, InterruptedException, ClassNotFoundException
	{
		Configuration conf=new Configuration();
		Job job=new Job(conf, "education census");
		job.setJarByClass(MyDriver.class);
		job.setMapperClass(MyMapper.class);
		job.setReducerClass(MyReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		FileSystem hdfs=FileSystem.get(conf);
		Path newfolder=new Path(args[1]);
		if(hdfs.exists(newfolder))
		{
		  hdfs.delete(newfolder,true);
		}
		
		

        FileInputFormat.addInputPath(job,new Path (args[0]));
        FileOutputFormat.setOutputPath(job,newfolder);
        if(job.waitForCompletion(true))
		{
					hdfs.copyToLocalFile(newfolder,new Path("/home/cloudera/Desktop/output"));
		}
        
        
	}
	

}
