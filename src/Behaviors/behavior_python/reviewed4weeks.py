import pandas as pd
import numpy as np
import sys

count = 1
print('ID, Number of Reviewed Activity')
for args in sys.argv[1:]:
    df1 = pd.read_csv(args)
    df1['Date'] = pd.to_datetime(df1['Date'],format='%m/%d/%Y')
    df2 = df1.set_index('Date')
    df = df2['2013-01-15':'2013-02-09']
    num = (df["Activity"].str.contains("Reviewed")).sum()
    print(str(count) + ',' + str(num))
    count = count + 1
