# Python 
- __name__
- os.enviorn
## logging the error
- 5 levels
  - Debug
  - info
  - warning
  - error
  - critical
- methods
  - basicConfig(**kwargs)
  - parameters
    - level
    - filename
    - fileMode
```
import logging as logger


logger.debug("Harmless debug Message")
logger.info("Just an information")
logger.warning("Its a Warning")
logger.error("Did you try to divide by zero")
logger.critical("Internet is down")

-- into a file with custom logger
import logging 
# Create and configure logger
logging.basicConfig(filename="newfile.log",
                    format='%(asctime)s %(message)s',
                    filemode='w')

# Creating an object
logger = logging.getLogger()

# Setting the threshold of logger to DEBUG
logger.setLevel(logging.DEBUG)

f_formate = logging.formatter('%(asctime)s - %(name)s - %(levelname)s - %(meggage)s')
f_handler.setFormatter(f_format)

logger.debug("Harmless debug Message")


-- use config file
- create logging_to_file.config
- add alla the log to the file 
```
