# Spark
- futute of Big Data
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
    
# HDFS -hadoop file system
- Big data challenges
  - high storage
  - processing
  - solution
    - hadoop hdfs is used to storage problem
    - hadoop mapreduce is used to  processing problem
    - spark is 100x faster then mapreduce
  - The HDFC create distributed file system likw 10 tb 10tb files
  - cost effective use commodity h/w
  - fault-tolerant
  - Components
    - name node
      - master - store meta data - enterprise h/w
      - editlog file
      - fsimage
    - data note
      - slave - create block delete replicate - commodity h/w
  - HDFS data block
    - massive file into small split files called data block 128mb or 64mb
    - in each node it done replication
      - each rack it contain the n of data node
      - in same rack it do not replicate the data
1. Read
   - CLient --> DFS --> Name node
   1. open() to connect for dis. file system from client
   2. RPC(Block A,B) is remote personal call to name node
   3. In name nade authenticate the user
   4. provide the block location to dfs then to client
   5. Read() to FSDatainputStream
   6. read() to data node from fsdis
   7. close() to fsdis
      
   
