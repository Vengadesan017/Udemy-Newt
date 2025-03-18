# Spark session
- sparkcontext is updated as spark session in 2.0 above
- is entry point to work with RDD, Dataframe
- it is class which create the connect the instance of obj
```
pyspark
-- you see: Spark context available as 'sc' (master = local[*], app id = local-1742277967318).
----- SparkSession available as 'spark'
>>> sc
<SparkContext master=local[*] appName=PySparkShell>
>>> spark
<pyspark.sql.session.SparkSession object at 0x000001D0FF2AD7F0>
>>>

Courses\Python\PySp
    ark_End_To_End\ven\example\src\main\python


Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
d-----        18-03-2025     11:52                bin
d-----        18-03-2025     11:53                lib
d-----        18-03-2025     11:53                secured
d-----        18-03-2025     11:52                sql

-- Initializing spark
from pyspark.sql import SparkSession
spark = SparkSession \
.builder \
.master('local[*]') \
.appName("example") \
.getOrCreate()
spark.sparkContext

-- spark session creation in bin basic.py ro run spark-submit basic.py
-- 2 args one is master like yarn local kumernetes lacal[k] , 2 is deploy-mode like cluster or client
from pyspark.sql import SparkSession
spark = SparkSession \
.builder \
.master('local[*]') \                    # * or k is number of core or workers
.appName("example") \
.getOrCreate()


Spark-submit is a utility to run a pyspark application job by specifying options and configurations.
spark-submit \
--master <master-url> \
--deploy-mode <deploy-mode> \
--conf <key<=<value> \
--driver-memory <value>g \
--executor-memory <value>g \
--executor-cores <number of cores> \
--jars <comma separated dependencies> \
--packages <package name> \
--py-files \
<application> <application args>


----conf: We can provide runtime configurations, shuffle parameters, application configurations using –conf.
Ex: --conf spark.sql.shuffle.partitions = 300

```
