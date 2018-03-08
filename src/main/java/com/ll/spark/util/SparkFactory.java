package com.ll.spark.util;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

public class SparkFactory {

	public static SparkSession getOrCreate(String master, String appName, String configKey, Object configValue) {
		SparkConf conf = new SparkConf();
		getSparkConf(conf, configKey, configValue);
		return SparkSession.builder().master(master).appName(appName).config(conf).getOrCreate();
	}

	private static void getSparkConf(SparkConf conf, String configKey, Object configValue) {
		
	}
}
