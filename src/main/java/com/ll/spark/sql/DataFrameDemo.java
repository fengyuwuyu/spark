package com.ll.spark.sql;

import static org.apache.spark.sql.functions.col;

import java.util.Arrays;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.junit.Before;
import org.junit.Test;

import com.ll.spark.entity.Department;
import com.ll.spark.entity.People;

public class DataFrameDemo {
	
	SparkSession spark;

	@Before
	public void init() {
		spark = SparkSession.builder().master("local").appName("Simple Application").getOrCreate();
	}
	
	@Test
	public void json() {
		Encoder<People> peopleEncoder = Encoders.bean(People.class);
		Dataset<People> peopleDataFrame = spark.read().json("file/people.json").as(peopleEncoder);
		
		Encoder<Department> departmentEncoder = Encoders.bean(Department.class);
		Dataset<Department> depDataFrame = spark.read().json("file/department.json").as(departmentEncoder);
		
		depDataFrame.printSchema();
		
		peopleDataFrame.select(col("name")).show();
		peopleDataFrame.filter(col("age").gt(20)).show();
		
		peopleDataFrame.createOrReplaceTempView("people");
		Dataset<Row> sqlDF = spark.sql("select * from people");
		sqlDF.show();
		
		sqlDF.groupBy(col("depId")).count().show();
		
	}
	
	@Test
	public void parquetHdfs() {
		Dataset<Row> ds = spark.read().parquet("hdfs://192.168.1.170:8020/user/spark/event/user/login/2018/02/24");
//		spark.createDataFrame
		ds.show();
		System.out.println(ds.collectAsList());
		
	}
	
	@Test
	public void javaToDataSet() {
		Encoder<People> encoder = Encoders.bean(People.class);
		Dataset<People> ds = spark.createDataset(Arrays.asList(new People(12, "asd", 1, 34, "123456"), new People(13, "sdfg", 1, 34, "123456")), encoder);
		ds.show();
	}
	
	@Test
	public void map() {
		Encoder<People> peopleEncoder = Encoders.bean(People.class);
		Dataset<People> peopleDataFrame = spark.read().json("file/department.json").as(peopleEncoder);
		peopleDataFrame.javaRDD().groupBy(p -> p.getAge()).map((people) -> {
			return people;
		});
		
	}
	
}
