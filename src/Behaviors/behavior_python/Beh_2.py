import pandas as pd
import numpy as np
import sys

count = 1
print 'ID, Number of days with 0 activity, Average Activity Per Session, Total number of logins \n'
dfOut = pd.DataFrame(index=range(1,len(sys.argv)), columns=['ID', 'Zero Activity', 'Average Activity Per Session', 'Number of logins for the entire semester'])
for args in sys.argv[1:]:
    df = pd.read_csv(args)
    print df.loc[df['Activity'].astype(str).str.contains('Delivered') , '']
    count = count + 1
