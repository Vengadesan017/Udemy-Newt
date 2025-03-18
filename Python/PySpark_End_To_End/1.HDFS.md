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
   - CLient --> DFS --> Name node --> DFS -- Client -->FSDIS --> DataNode
   1. open() to connect for dis. file system from client
   2. RPC(Block A,B) is remote personal call to name node
   3. In name nade authenticate the user
   4. provide the block location to dfs then to client
   5. Read() to FSDatainputStream
   6. read() to data node from fsdis
   7. close() to fsdis
   - Terminal
   ```
   jpa
   hadoop fs // all commands
   hdfs dfs // all commands
   hadoop fs -usage ls
   hadoop fs -help ls
   
    git clone https://github.com/sibaramKumar/dataFiles
    cd dataFiles
    
    ### Unzip the Files
    sudo apt install unzip
    unzip SalesData.zip
    ls –lrt
    rm SalesData.zip
    
    ### Create a Folder at HDFS
    hadoop fs -mkdir -p practice/retail_db/
    
    ### Copy the Files from Local to HDFS
    hadoop fs -put dataFiles/* practice/retail_db/
   ----
    ### rmdir : Remove a directory if it is empty.
    hadoop fs -rmdir practice/temp
    hadoop fs -rmdir --ignore-fail-on-non-empty practice/temp #Supress the Error
    
    ### rm: Delete Files and Directories
    hadoop fs -rm -r practice/retail_db  #Remove all the files in a directory recursively.
    hadoop fs -rm sample.txt #Remove a file.
    
    hadoop fs -rm -f sample.txt #Remove a file. #No Error even if File does not exist
    echo $?
    
    hadoop fs -rm -f sample.txt
    echo $?        // return 0 if previous command is success else 1
    
    ### mkdir : Create a Folder
    hadoop fs -mkdir practice/retail_db
    hadoop fs mkdir -p practice/retail_db/1/2/3

   ---
    ### Command - copyToLocal or get
    hadoop fs -get practice/retail_db/orders .
    
    ### Error if the destination path already exists. To overwrite use –f flag.
    hadoop fs -get practice/retail_db/orders .
    hadoop fs -get –f practice/retail_db/orders .
    
    ### -p flag to preserves access and  modification times, ownership and the mode.
    hadoop fs -get -p practice/retail_db/orders .
    
    ### To Only copy the files with out folder use a pattern.
    hadoop fs -get practice/retail_db/orders/* .
    
    ### 
    When copying multiple files, the destination must be a directory.
    mkdir copyHere
    hadoop fs -get practice/retail_db/orders/* practice/sample.txt copyHere

    -- meta data
    ###fsck Command Help
    hadoop fsck -help
    
    ### Print a High Level Report.
    hadoop fsck practice/retail_db
    
    ### -files -->Print a detailed file level report.
    hadoop fsck practice/retail_db -files
    
    ### -files -blocks --> Print a detailed file and block report.
    hadoop fsck practice/retail_db -files -blocks
    
    ### -files -blocks -locations --> Print out locations for every block
    hadoop fsck practice/retail_db -files -blocks –locations
    
    ### -files -blocks -racks --> Print out Rack level Informatin

   --- pwemission
    ### Chmod
    #Octal Format
    hadoop fs -chmod 755 practice/retail_db/orders/part-00000    user,grp,other --> 775 --> rwx r-x r-x
    
    #Symbolic Format
    hadoop fs -chmod g+w practice/retail_db/orders/part-00000

   -- change property
    1. 
    Change Properties in hdfs-site.xml or core-site.xml.
    
    2. 
    Using -D option or --conf option.
    
    ##### Using -D Option.
    
    ### Copy the file sample1.txt.
    hadoop fs -put sample1.txt practice/retail_db
    
    ### Check the statistics.
    # Check the Replication.
    hadoop fs -stat %r practice/retail_db/sample1.txt
    # Check the Block Size
    hadoop fs -stat %o practice/retail_db/sample1.txt
    
    # Copy the file sample1.txt using different replication and block size.
    hdfs dfs -Ddfs.blocksize=64M -Ddfs.replication=3 -put -f sample1.txt practice/retail_db
    
    # Check the Statistics - Replication
    hadoop fs -stat %r practice/retail_db/sample1.txt
    # Check the Statistics - Block Size
    hadoop fs -stat %o practice/retail_db/sample1.txt
    
    ##### Using --conf
    ### Copy a file sample2.txt.
    hadoop fs -put sample2.txt practice/retail_db
    
    ### Check the statistics
    # Check the Replication
    hadoop fs -stat %r practice/retail_db/sample2.txt
    
    # Copy the File using --conf
    hdfs dfs --conf hdfs-override.xml -put -f sample2.txt practice/retail_db
    
    # Check the Replication
    hadoop fs -stat %r practice/retail_db/sample2.txt
    
    3. 
    Change after copying the Files in HDFS (setRep)
    ### Copy a file:
    hadoop fs -put sample3.txt practice/retail_db
    
    ### Check Replication.
    hadoop fs -stat %r practice/retail_db/sample3.txt
    
    ### Change Replication using setrep
    hdfs dfs -setrep 2 practice/retail_db/sample3.txt
    
    ### Check Replication
    hadoop fs -stat %r practice/retail_db/sample3.txt

   ```
      
