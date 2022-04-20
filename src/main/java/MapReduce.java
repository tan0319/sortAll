
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;
import java.util.StringTokenizer;

public class MapReduce {



    // map阶段
    public static class TokenizerMapper
            extends Mapper<Object, Text, Text, IntWritable>{
        // 定义计数器1
        private final static IntWritable one = new IntWritable(1);
        // 定义key
        private Text word = new Text();

        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {
            // 行数据拆分 tokenizer 使用默认的分隔符集 " \t\n\r\f"，即：空白字符、制表符、换行符、回车符和换页符。分隔符字符本身不作为标记。
            StringTokenizer itr = new StringTokenizer(value.toString());
            while (itr.hasMoreTokens()) {
                // 设置key
                word.set(itr.nextToken());
                // 将key与计数器组成新key-value
                context.write(word, one);
            }
        }
    }

    // reduce 阶段
    public static class IntSumReducer
            extends Reducer<Text,IntWritable,Text,IntWritable> {
        // 定义输出的数量值
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values,
                           Context context
        ) throws IOException, InterruptedException {
            // 为每一个key叠加值
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            // 将结果最后输出
            context.write(key, result);
        }
    }

    public static void main(String[] args) throws Exception {
        // 设置配置参数
        Configuration conf = new Configuration();
        // 判断一下执行的时候是否有足够的参数 执行的时候需要设置输入与输出目录 所以数量要>2
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: wordcount <in> [<in>...] <out>");
            System.exit(2);
        }
        // 设置开启一个新的job
        Job job = Job.getInstance(conf, "word count");
        // 打包成jar的类
        job.setJarByClass(MapReduce.class);
        // 设置map reduce combine 类
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        // 设置输出数据的key-val类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        // 设置不同的输入路径(支持多输入路径)
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        // 设置输出路径,需要注意,不管有多少个输入路径,最后一个一定要是输出路径
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        // 等待这个job完成根据返回结果进行操作
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
