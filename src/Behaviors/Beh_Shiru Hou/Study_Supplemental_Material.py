import pandas as pd
import numpy as np
import sys

count = 1
print('ID, Number of Studying Supplemental Material Activities\n')
for args in sys.argv[1:]:
    df = pd.read_csv(args)
    num = (df["Object_Title"].str.contains("Supplemental Material")).sum()
    print(str(count) + ',' + str(num) + '\n')
    count = count + 1