import pandas as pd
import sys
# Suppress warning
pd.options.mode.chained_assignment = None
clean = 0
# Read raw log file
for args in sys.argv[1:]:
    clean = clean + 1
    df =  pd.read_csv(args)
    # Rename columns
    df.columns = ['Date','Activity_Count','Date_Active', 'Time', 'Activity', 'Object_Title', 'Quiz_Title']
    # clean up duplicate colums
    df.Quiz_Title[df.Object_Title == df.Quiz_Title] = ''
    # create prepared log file
    df.to_csv( 'private/clean/log_'+ str(clean) +'.csv',sep=',')

