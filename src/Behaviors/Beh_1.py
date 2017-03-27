import pandas as pd
import numpy as np
import sys

count = 1
print 'ID, Number of days with 0 activity\n'
dfOut = pd.DataFrame(index=range(1,len(sys.argv)), columns=['ID', 'Zero Activity', 'Average Activity Per Session'])
for args in sys.argv[1:]:
    df = pd.read_csv(args)
    print str(count) + ',' + str((df['Activity_Count'] == 0).sum()) + ',' + str(np.mean(df.Activity_Count.unique())) + '\n'
    count = count + 1
