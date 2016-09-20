package customkeyvalue;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CustomKeyValueDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = new Job(conf,"Custom Key Value Map Reduce Job");
		
		job.setJarByClass(CustomKeyValueDriver.class);
		job.setMapperClass(CustomKeyValueMapper.class);
		job.setReducerClass(CustomKeyValueReducer.class);
		job.setNumReduceTasks(1);
	//	job.setInputFormatClass(CustomInputFormat.class);
		
		job.setMapOutputKeyClass(UidDateKey.class);
		job.setMapOutputValueClass(AmountValue.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		System.exit(job.waitForCompletion(true)?0:1);
		

	}

}
