package mypack;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyMain {
	
	public static void main(String ar[]) throws ClassNotFoundException, IOException, InterruptedException
	{
	Configuration conf=new Configuration();
	Job job=new Job(conf,"transaction2");
	job.setJarByClass(MyMain.class);
	job.setMapperClass(MyMapper.class);
	job.setReducerClass(MyReducer.class);
	job.setPartitionerClass(MyPartition.class);
	job.setNumReduceTasks(4);
	job.setMapOutputKeyClass(Text.class);
	job.setMapOutputValueClass(Text.class);
	FileInputFormat.addInputPath(job, new Path(ar[0]));
	FileOutputFormat.setOutputPath(job, new Path(ar[1]));
	System.exit(job.waitForCompletion(true)?0:1);
}
}