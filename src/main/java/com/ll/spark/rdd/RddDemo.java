package com.ll.spark.rdd;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Before;
import org.junit.Test;

public class RddDemo {
	
	JavaSparkContext sc;
	
	@Before
	public void init() {
		SparkConf conf = new SparkConf().setAppName("rdd app").setMaster("local");
		sc = new JavaSparkContext(conf);
	}
	
	
	@Test
	public void createRDD() {
		List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
		JavaRDD<Integer> distData = sc.parallelize(data);
		System.out.println(distData);
	}

}
