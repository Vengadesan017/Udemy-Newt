from pyspark.sql import SparkSession

spark = SparkSession \
    .builder \
    .master("local[1]") \
    .appName("example") \
    .config("spark.ui.port", "4050") \
    .getOrCreate()

print("Spark session is created....!")
print(spark)
# spark.stop()
