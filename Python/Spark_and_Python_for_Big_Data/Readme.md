# Spark
- run 100x faster then Hadoop mapreduce in memory
# Haboop
- distrubute very large files accross m mechine
- use HDFS ( name node data node)
- HDFS allow us to work with large data set
- HDFS duplicates the data block
- used mapreduce
- RM allows computation on data
# spark RDDs ( master - slave )
- resilient distributed dataset
- fault tolerant
- parallel operation
- ability to use many data source

# Data bricks
- free online community version support 6gb cluster
- had DFFS format to store
- https://www.databricks.com/try-databricks or https://community.cloud.databricks.com/login.html
  - create cluster
  - create note book
  - create table : Upload data file
    - check file type , delimiter

# data frame
- create spark session
- spark.read.csv()
- show()
- printSchema()
- column
- describe()
- select()
- head(3)
- withColumn(,)
- withColumnRenamed(,)
- createOrReplaceTempView()

# Machine learning process - **MLlib**
- data acquisition
- data cleaning   --test data to model testing
- madel trainning and building
- model testing   -- loop to model training
- model deployment

- Types
  - supervised learning
    -  both ip and op
    -  classification , regreesion, prediction, gradient boosting 
  - Unsupervised learning
    -  only the IP no historical data
    -   customer segmentation
    - algo
      - self organizing maps
      - nearest-neighbor mapping
      - k mean cluster
     
# Linear regression
- graph point make line to minimize the vertical distance between all the points ( determine the best line
- flow
  - load data
  - prepare feaatures by make single feasures vector
  - split train and test data
  - initialize LR model
  - train model with train data using fit data
  - make prediction  on model with test data using transform method
  - evaluate the model using root mean squareor r squre 
- eveluation methods
  - mean absolute error
  - mean squared error
  - root mean square error
  - r square error value
