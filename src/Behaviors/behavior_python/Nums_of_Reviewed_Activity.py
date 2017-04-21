import pandas as pd
import numpy as np
import sys

count = 1
print('ID, Number of Reviewed Activity')
for args in sys.argv[1:]:
    df = pd.read_csv(args)
    num = (df["Activity"].str.contains("Reviewed")).sum()
    print(str(count) + ',' + str(num))
    count = count + 1
