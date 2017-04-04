import pandas as pd
import time,datetime
import sys

count = 1
Unit1_Release_Date = '1/15/2013'
print('ID, Unit1 Materials Available Date, Student Submit ASR Date, Dates Different \n')
#dfOut = pd.DataFrame(index=range(1,len(sys.argv)), columns=['ID', 'Unit1', 'ASR', 'Dates'])
for args in sys.argv[1:]:
    df = pd.read_csv(args)
    df1 = df[df["Object_Title"] == "2. Submit ASR Unit #1"]
    df2 = df1["Date"]
    Submit_ASR_Date = df2.values.any()
    Unit1_Release_Date_ = datetime.datetime.strptime(Unit1_Release_Date,'%m/%d/%Y')
    Submit_ASR_Date_ = datetime.datetime.strptime(Submit_ASR_Date,'%m/%d/%Y')
    Date_Differ = Submit_ASR_Date_ - Unit1_Release_Date_
    print(str(count) + ',' + Unit1_Release_Date + ',' + Submit_ASR_Date + ',' + str(Date_Differ.days) + '\n')
    count = count + 1
