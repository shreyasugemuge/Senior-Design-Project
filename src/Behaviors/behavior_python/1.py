import pandas as pd
import time,datetime
import sys

count = 1
Unit1_Release_Date = '1/15/2013'
Unit2_Release_Date = '1/25/2013'
Unit3_Release_Date = '2/8/2013'
Unit4_Release_Date = '2/15/2013'
Unit5_Release_Date = '3/1/2013'
Unit6_Release_Date = '3/8/2013'
Unit7_Release_Date = '3/15/2013'
print('ID,ASR1,ASR2a,ASR2b,ASR2c,ASR3,ASR4,ASR5,ASR6,ASR7a,ASR7b')
#dfOut = pd.DataFrame(index=range(1,len(sys.argv)), columns=['ID', 'Unit1', 'ASR', 'Dates'])
for args in sys.argv[1:]:
    df = pd.read_csv(args)

    df1 = df[df["Object_Title"] == "2. Submit ASR Unit #1"]
    df2 = df1["Date"]
    Submit_ASR1_Date = df2.values.any()
    Unit1_Release_Date_ = datetime.datetime.strptime(Unit1_Release_Date,'%m/%d/%Y')
    Submit_ASR_Date_ = datetime.datetime.strptime(Submit_ASR1_Date,'%m/%d/%Y')
    Date_Differ1 = Submit_ASR_Date_ - Unit1_Release_Date_
    D1 = str(Date_Differ1.days)

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
        D2A = ""

    if type(Submit_ASR2B_Date) is str:
        Submit_ASR2B_Date_ = datetime.datetime.strptime(Submit_ASR2B_Date, '%m/%d/%Y')
        Date_Differ2B = Submit_ASR2B_Date_ - Unit2_Release_Date_
        D2B = str(Date_Differ2B.days)
    else:
        Submit_ASR2B_Date = 'Unfinished'
        D2B = ""

    if type(Submit_ASR2C_Date) is str:
        Submit_ASR2C_Date_ = datetime.datetime.strptime(Submit_ASR2C_Date, '%m/%d/%Y')
        Date_Differ2C = Submit_ASR2C_Date_ - Unit2_Release_Date_
        D2C = str(Date_Differ2C.days)
    else:
        Submit_ASR2C_Date = 'Unfinished'
        D2C = ""

    Submit_ASR3_Date = df[df["Object_Title"] == "Submit ASR Unit #3"]["Date"].values.any()
    Unit3_Release_Date_ = datetime.datetime.strptime(Unit3_Release_Date, '%m/%d/%Y')
    if type(Submit_ASR3_Date) is str:
        Submit_ASR3_Date_ = datetime.datetime.strptime(Submit_ASR3_Date, '%m/%d/%Y')
        Date_Differ3 = Submit_ASR3_Date_ - Unit3_Release_Date_
        D3 = str(Date_Differ3.days)
    else:
        Submit_ASR3_Date = 'Unfinished'
        D3 = ""

    Submit_ASR4_Date = df[df["Object_Title"] == "Submit ASR Unit #4"]["Date"].values.any()
    Unit4_Release_Date_ = datetime.datetime.strptime(Unit4_Release_Date, '%m/%d/%Y')
    if type(Submit_ASR4_Date) is str:
        Submit_ASR4_Date_ = datetime.datetime.strptime(Submit_ASR4_Date, '%m/%d/%Y')
        Date_Differ4 = Submit_ASR4_Date_ - Unit4_Release_Date_
        D4 = str(Date_Differ4.days)
    else:
        Submit_ASR4_Date = 'Unfinished'
        D4 = ""

    Submit_ASR5_Date = df[df["Object_Title"] == "Submit ASR Unit #5"]["Date"].values.any()
    Unit5_Release_Date_ = datetime.datetime.strptime(Unit5_Release_Date, '%m/%d/%Y')
    if type(Submit_ASR5_Date) is str:
        Submit_ASR5_Date_ = datetime.datetime.strptime(Submit_ASR5_Date, '%m/%d/%Y')
        Date_Differ5 = Submit_ASR5_Date_ - Unit5_Release_Date_
        D5 = str(Date_Differ5.days)
    else:
        Submit_ASR5_Date = 'Unfinished'
        D5 = ""

    Submit_ASR6_Date = df[df["Object_Title"] == "Submit ASR Unit #6"]["Date"].values.any()
    Unit6_Release_Date_ = datetime.datetime.strptime(Unit6_Release_Date, '%m/%d/%Y')
    if type(Submit_ASR6_Date) is str:
        Submit_ASR6_Date_ = datetime.datetime.strptime(Submit_ASR6_Date, '%m/%d/%Y')
        Date_Differ6 = Submit_ASR6_Date_ - Unit6_Release_Date_
        D6 = str(Date_Differ6.days)
    else:
        Submit_ASR6_Date = 'Unfinished'
        D6 = ""

    Submit_ASR7A_Date = df[df["Object_Title"] == "Submit ASR Unit #7A"]["Date"].values.any()
    Submit_ASR7B_Date = df[df["Object_Title"] == "Submit ASR Unit #7B"]["Date"].values.any()
    Unit7_Release_Date_ = datetime.datetime.strptime(Unit7_Release_Date, '%m/%d/%Y')
    if type(Submit_ASR7A_Date) is str:
        Submit_ASR7A_Date_ = datetime.datetime.strptime(Submit_ASR7A_Date, '%m/%d/%Y')
        Date_Differ7A = Submit_ASR7A_Date_ - Unit7_Release_Date_
        D7A = str(Date_Differ7A.days)
    else:
        Submit_ASR7A_Date = 'Unfinished'
        D7A = ""

    if type(Submit_ASR7B_Date) is str:
        Submit_ASR7B_Date_ = datetime.datetime.strptime(Submit_ASR7B_Date, '%m/%d/%Y')
        Date_Differ7B = Submit_ASR7B_Date_ - Unit7_Release_Date_
        D7B = str(Date_Differ7B.days)
    else:
        Submit_ASR7B_Date = 'Unfinished'
        D7B = ""

    print(str(count) + ',' + D1 + ',' + D2A + ',' + D2B + ',' + D2C + ',' + D3 + ',' + D4 +
          ',' + D5 + ',' + D6 + ',' + D7A + ',' + D7B)
    count = count + 1
