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
    -  types
    -  classification ( logistic ,decision tree)
    - regression ( linear regression ,
    - prediction
    -  gradient boosting 
  - Unsupervised learning
    -  only the IP no historical data
    -   customer segmentation
    - algo
      - self organizing maps
      - nearest-neighbor mapping
      - k mean cluster
     
# Linear regression
- graph point make line to minimize the vertical distance between all the points ( determine the best line
- find relationship between the independent and dependent variables
- output is continuous value, such as price and age.
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
## logistic regression -
- aims to classify outputs
- output is 0 or 1, True or False
- flow
  - Load Data
  - prepare data featurss, vector
  - split rain and test data
  - fit
  - prediction
  - evaluate
## Tree method
- multiple levels of decision as yes or no if yes then next decision
- decision tree
- random forest
- types
  - single decision tree
  - random forest
  - gradient boosted tree classifier
## Decision tree
- supervised machine learning algorithm that is used for both classification and regression tasks
- root node > internal node > leraf node
- flow
  - create session and load data
  - assble features into vector
  - split the data into training and test data
  - fit 
  - transform ( prediction)
  - evaluate
## Random forest
-  multiple decision trees and combines their predictions to improve accuracy and reduce overfitting
- flow
  - create session and load data
  - assble features into vector
  - split the data into training and test data
  - fit
  - transform ( prediction)
  - evaluate
## K Means
- unsupervised learning
- used to partition a set of data points into distinct clusters based on similarity
- k - numbers of cluster > initialize centroid > assign poin to cluster > update centroid > repeat > result
- flow
  - create session and load data
  - assble features into vector
  - initialize the k means model
  - fit
  - transform ( prediction)
  - evaluate ( computeCost)
## Alternating Least Squares - Recommandation system
- collaborative filtering
- decomposing the user-item interaction matrix (e.g., a matrix of ratings given by users to items) into two lower-dimensional matrices representing users and items
## NLP for sms smap detection

# Streaming
- datas are from hdfs,s3, tcp socket, kinesis, flume, kafka
  - so use spark streaming to connect the data source to databases, hdfs, dashboard for for processing like mapreduce, join
- flow
  - input data --spark streaming--> batchs of input data --spark engine--> batchs of processed data
