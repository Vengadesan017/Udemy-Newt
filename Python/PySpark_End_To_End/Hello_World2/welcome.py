# print("Helloo spark guys..!")
#
# import sys
# print(sys.argv)

from pyspark.sql import SparkSession

spark = SparkSession.builder.master('local').appName('Venagt').getOrCreate()

print("Spark obj created successfully...")

print(spark)

rdd = spark.sparkContext.parallelize([1,2,3,4])


print(rdd.collect())  # Check if RDD is working
print(rdd.first())