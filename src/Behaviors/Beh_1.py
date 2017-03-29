import pandas as pd
import numpy as np
import sys

count = 1
print 'ID, Number of days with 0 activity, Average Activity Per Session, Total number of logins \n'
dfOut = pd.DataFrame(index=range(1,len(sys.argv)), columns=['ID', 'Zero Activity', 'Average Activity Per Session', 'Number of logins for the entire semester'])
for args in sys.argv[1:]:
    df = pd.read_csv(args)
    print str(count) + ',' + str((df['Activity_Count'] == 0).sum()) + ',' + str(np.mean(df.Activity_Count.unique())) + ',' + str(len(df.Activity_Count.unique()))  + '\n'
    count = count + 1
