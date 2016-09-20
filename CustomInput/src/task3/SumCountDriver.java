package task3;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SumCountDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = new Job(conf,"Sum Count Map Reduce Job");
		
		job.setMapperClass(SumCountMapper.class);
		job.setReducerClass(SumCountReducer.class);
		job.setJarByClass(SumCountDriver.class);
		
//		job.setMapOutputKeyClass(Text.class);
//		job.setMapOutputValueClass(DoubleWritable.class);
		job.setMapOutputKeyClass(TrIdKey.class);
		job.setMapOutputValueClass(AmountValue.class);
		job.setNumReduceTasks(1);
		
		job.setInputFormatClass(SumCountInputFormat.class);
		
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		System.exit(job.waitForCompletion(true)?0:1);
		
	}

}
