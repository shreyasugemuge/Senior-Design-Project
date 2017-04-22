import pandas as pd
import time,datetime
import sys

count = 1
Unit2_Release_Date = '1/25/2013'
print('ID, Unit2 Materials Available Date, Student Submit ASR Unit 2A Date, Dates Difference of 2A, Student Submit ASR Unit 2B Date, Dates Difference of 2B, Student Submit ASR Unit 2C Date, Dates Difference of 2C')
for args in sys.argv[1:]:
    df = pd.read_csv(args)
    Submit_ASR2A_Date = df[df["Object_Title"] == "Submit ASR Unit #2A"]["Date"].values.any()
    Submit_ASR2B_Date = df[df["Object_Title"] == "Submit ASR Unit #2B"]["Date"].values.any()
    Submit_ASR2C_Date = df[df["Object_Title"] == "Submit ASR Unit #2C"]["Date"].values.any()
    Unit2_Release_Date_ = datetime.datetime.strptime(Unit2_Release_Date, '%m/%d/%Y')
    if type(Submit_ASR2A_Date) is str:
        Submit_ASR2A_Date_ = datetime.datetime.strptime(Submit_ASR2A_Date, '%m/%d/%Y')
        Date_Differ2A = Submit_ASR2A_Date_ - Unit2_Release_Date_
        D2A = str(Date_Differ2A.days)
    else:
        Submit_ASR2A_Date = 'Unfinished'
        D2A = "None"

    if type(Submit_ASR2B_Date) is str:
        Submit_ASR2B_Date_ = datetime.datetime.strptime(Submit_ASR2B_Date, '%m/%d/%Y')
        Date_Differ2B = Submit_ASR2B_Date_ - Unit2_Release_Date_
        D2B = str(Date_Differ2B.days)
    else:
        Submit_ASR2B_Date = 'Unfinished'
        D2B = "None"

    if type(Submit_ASR2C_Date) is str:
        Submit_ASR2C_Date_ = datetime.datetime.strptime(Submit_ASR2C_Date, '%m/%d/%Y')
        Date_Differ2C = Submit_ASR2C_Date_ - Unit2_Release_Date_
        D2C = str(Date_Differ2C.days)
    else:
        Submit_ASR2C_Date = 'Unfinished'
        D2C = "None"

    print(str(count) + ',' + Unit2_Release_Date + ',' + Submit_ASR2A_Date + ',' + D2A + ',' + Submit_ASR2B_Date + ',' + D2B + ',' + Submit_ASR2C_Date + ',' + D2C)
    count = count + 1
