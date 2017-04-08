import pandas as pd
import time,datetime
import sys

count = 1
Unit_Release_Date = '3/15/2013'
print('ID, Unit Materials Available Date, Student Submit ASR 7a Date, Dates Difference of 7a, Student Submit ASR 7b Date, Dates Difference of 7b\n')
for args in sys.argv[1:]:
    df = pd.read_csv(args)
    Submit_ASR_Date = df[df["Object_Title"] == "Submit ASR Unit #7A"]["Date"].values.any()
    Submit_ASR_Date1 = df[df["Object_Title"] == "Submit ASR Unit #7B"]["Date"].values.any()
    Unit_Release_Date_ = datetime.datetime.strptime(Unit_Release_Date, '%m/%d/%Y')

    if type(Submit_ASR_Date) is str:
        Submit_ASR_Date_ = datetime.datetime.strptime(Submit_ASR_Date, '%m/%d/%Y')
        Date_Differ = Submit_ASR_Date_ - Unit_Release_Date_
        D = str(Date_Differ.days)
    else:
        Submit_ASR_Date = 'Unfinished'
        D = "None"

    if type(Submit_ASR_Date1) is str:
        Submit_ASR_Date1_ = datetime.datetime.strptime(Submit_ASR_Date1, '%m/%d/%Y')
        Date_Differ1 = Submit_ASR_Date1_ - Unit_Release_Date_
        D1 = str(Date_Differ1.days)
    else:
        Submit_ASR_Date1 = 'Unfinished'
        D1 = "None"

    print(str(count) + ',' + Unit_Release_Date + ',' + Submit_ASR_Date + ',' + D + ',' + Submit_ASR_Date1 + ',' + D1 + '\n')
    count = count + 1