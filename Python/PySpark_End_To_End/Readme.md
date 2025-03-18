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
  - use python java scala r sql
  - run in on premises
  - parallel storage and processing
  - Generality
    - spark SQL , spark Streaming, Mlib , GraphX on the top of apache spark

- Map reduce
  - HDFS -RAM-> Opeartion1 -Ram-> HDFS -Operationn->..  HDFS
  - sequence storage and processing
## Spark companent
- Apache Spark core on top of Hdoop yarn , kubernates..
- Spark sql , spark streaming, Mlib, GraphX
- graphx for graphs and graph parallel computation
- Mlib for machine leraning
- spark streaming is interface for streaming data processing on top of dataframes
- spark sql provide different api and sql interface for processing on top of dataframes
