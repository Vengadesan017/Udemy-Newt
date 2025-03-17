# Spark
- future of Big Data
- 100X Faster than Hadoop mapreaduce in memory
- s/w : java, py, spark, winutile, pycharm
- test
  ```
  pyspark
  rdd = sc.parallelize([1,2,3])
  rdd.first()

  ```
- short cuts
- alt shft c - recent changes
- alt shft e - recent location
- ctrl space - suggestion
- ctrl d
- ctrl alt t - func of variable
```
-- run time argv
import sys
print(sys.argv)  -- ['file location.py', argv1, argv2]
// use edit config or run with para and enter the data with space

```
### python and spark in pycharm
1. go setting select python interpreter
2. content one
  - go setting in project structure select content dir - select the python in spark folder
3. content two
  - go setting in project structure select content dir - select the py4j model in lib in python in spark folder ( connect the python and spark
4. create spark obj
```

```
5. debug
   - in degub tab near console see the value of variables and frames
   - instead of run use debug after mark the check point
     - step over -- line by line
     - step in   -- line by line call the function and return the value
     - step out  -- block of loop run at moment
    

## Spark vs MapReduce
- Spark
  - HDFS -Read-> MR -write-> HDFS -read-> MR -write-> HDFS

- Map reduce
  - HDFS -RAM-> Opeartion1 -Ram-> HDFS -Operationn->..  HDFS
