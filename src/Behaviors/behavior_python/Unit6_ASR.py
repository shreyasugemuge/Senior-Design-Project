import pandas as pd
import time,datetime
import sys

count = 1
Unit_Release_Date = '3/8/2013'
print('ID, Unit Materials Available Date, Student Submit ASR Date, Dates Difference')
for args in sys.argv[1:]:
    df = pd.read_csv(args)
    Submit_ASR_Date = df[df["Object_Title"] == "Submit ASR Unit #6"]["Date"].values.any()
    Unit_Release_Date_ = datetime.datetime.strptime(Unit_Release_Date, '%m/%d/%Y')
    if type(Submit_ASR_Date) is str:
        Submit_ASR_Date_ = datetime.datetime.strptime(Submit_ASR_Date, '%m/%d/%Y')
        Date_Differ = Submit_ASR_Date_ - Unit_Release_Date_
        D = str(Date_Differ.days)
    else:
        Submit_ASR_Date = 'Unfinished'
        D = "None"

    print(str(count) + ',' + Unit_Release_Date + ',' + Submit_ASR_Date + ',' + D)
    count = count + 1