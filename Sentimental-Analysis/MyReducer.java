package tweet;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text,IntWritable, Text, DoubleWritable> {

	public void reduce(Text key,Iterable<IntWritable> values,Context context)
	{
		try
		{
			int count = 0,sum=0;
			for(IntWritable i:values)
			{
				count++;
				sum=sum+i.get();
			}
			double r = (sum*100)/count;
			context.write(new Text("Rating is: "), new DoubleWritable(r));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
