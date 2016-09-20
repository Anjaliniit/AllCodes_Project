package mypack;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class MyData {

	
	public static void main(String ar[]) throws IOException, ClassNotFoundException, InterruptedException
	{
		Configuration conf=new Configuration();
		Job job=new Job(conf,"reduce map side");
		job.setJarByClass(MyData.class);
		job.setReducerClass(MyReducer.class);
		job.setNumReduceTasks(1);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		MultipleInputs.addInputPath(job,new Path(ar[0]),TextInputFormat.class,CustomerMapper.class);
		MultipleInputs.addInputPath(job,new Path(ar[1]),TextInputFormat.class,TransactionManager.class);
		FileOutputFormat.setOutputPath(job, new Path(ar[2]));
		System.exit(job.waitForCompletion(true)?0:1);
	}
}
