import pandas as pd
import numpy as np
import time,datetime
import sys

count = 1
x = 13
print('ID, ReviewedActivities, StudyingSupplementalMaterialActivities, TotalStudyGuideMaterials, '
      'Guide1, Guide2, Guide3, Guide4, Guide5, Guide6, Guide7, SubmitASR1, SubmitASR2A, SubmitASR2B, '
      'SubmitASR2C, SubmitASR3, SubmitASR4, SubmitASR5, SubmitASR6, SubmitASR7A, SubmitASR7B')
for args in sys.argv[1:]:
    df1 = pd.read_csv(args)
    df1['Date'] = pd.to_datetime(df1['Date'], format='%m/%d/%Y')
    df2 = df1.set_index('Date')
    #Set weeks
    if x == 1:
        df = df2['2013-01-15':'2013-01-20']
    elif x == 2:
        df = df2['2013-01-15':'2013-01-27']
    elif x == 3:
        df = df2['2013-01-15':'2013-02-03']
    elif x == 4:
        df = df2['2013-01-15':'2013-02-10']
    elif x == 5:
        df = df2['2013-01-15':'2013-02-17']
    elif x == 6:
        df = df2['2013-01-15':'2013-02-24']
    elif x == 7:
        df = df2['2013-01-15':'2013-03-03']
    elif x == 8:
        df = df2['2013-01-15':'2013-03-10']
    elif x == 9:
        df = df2['2013-01-15':'2013-03-17']
    elif x == 10:
        df = df2['2013-01-15':'2013-03-24']
    elif x == 11:
        df = df2['2013-01-15':'2013-03-31']
    elif x == 12:
        df = df2['2013-01-15':'2013-04-07']
    elif x == 13:
        df = df2['2013-01-15':'2013-04-13']

    #This part caculate the total number of reviewed activities
    num_RA = (df["Activity"].str.contains("Reviewed")).sum()

    #This part caculate the total number of studying supplemental material activities
    num_SM = (df["Object_Title"].str.contains("Supplemental Material")).sum()

    #This part caculates the total number of studing guide materials activities
    g=g1=g2=g3=g4=g5=g6=g7=0
    g1 = (df['Object_Title'] == 'Study Guide 1 Videos and Podcasts').sum() + (
    df['Object_Title'] == '1a. Study Guide 1 Materials').sum()
    g2 = (df['Object_Title'] == 'Study Guide 2 Videos and Podcasts').sum() + (
    df['Object_Title'] == 'Study Guide 2 Materials').sum()
    g3 = (df['Object_Title'] == 'Study Guide 3 Videos and Podcasts').sum() + (
    df['Object_Title'] == 'Study Guide 3 Materials').sum()
    g4 = (df['Object_Title'] == 'Study Guide 4 Videos and Podcasts').sum() + (
    df['Object_Title'] == 'Study Guide 4 Materials').sum()
    g5 = (df['Object_Title'] == 'Study Guide 5 Videos and Podcasts').sum() + (
    df['Object_Title'] == 'Study Guide 5 Materials').sum()
    g6 = (df['Object_Title'] == 'Study Guide 6 Videos and Podcasts').sum() + (
    df['Object_Title'] == 'Study Guide 6 Materials').sum()
    g7 = (df['Object_Title'] == 'Study Guide 7 Videos and Podcasts').sum() + (
    df['Object_Title'] == 'Study Guide 7 Materials').sum()
    g = g1+g2+g3+g4+g5+g6+g7

    #This part caculate how many days of students submiting ASR after each unit materials avaiable
    Unit1_Release_Date = '1/15/2013'
    Submit_ASR1_Date = df[df["Object_Title"] == "2. Submit ASR Unit #1"]["Date_Active"].values.any()
    Unit1_Release_Date_ = datetime.datetime.strptime(Unit1_Release_Date, '%m/%d/%Y')
    Submit_ASR1_Date_ = datetime.datetime.strptime(Submit_ASR1_Date, '%m/%d/%Y')
    if type(Submit_ASR1_Date) is str:
        Submit_ASR1_Date_ = datetime.datetime.strptime(Submit_ASR1_Date, '%m/%d/%Y')
        D1_ = Submit_ASR1_Date_ - Unit1_Release_Date_
        D1 = str(D1_.days)
    else:
        D1 = "-1"

    Unit2_Release_Date = '1/25/2013'
    Submit_ASR2A_Date = df[df["Object_Title"] == "Submit ASR Unit #2A"]["Date_Active"].values.any()
    Submit_ASR2B_Date = df[df["Object_Title"] == "Submit ASR Unit #2B"]["Date_Active"].values.any()
    Submit_ASR2C_Date = df[df["Object_Title"] == "Submit ASR Unit #2C"]["Date_Active"].values.any()
    Unit2_Release_Date_ = datetime.datetime.strptime(Unit2_Release_Date, '%m/%d/%Y')
    if type(Submit_ASR2A_Date) is str:
        Submit_ASR2A_Date_ = datetime.datetime.strptime(Submit_ASR2A_Date, '%m/%d/%Y')
        Date_Differ2A = Submit_ASR2A_Date_ - Unit2_Release_Date_
        D2A = str(Date_Differ2A.days)
    else:
        D2A = "-1"
    if type(Submit_ASR2B_Date) is str:
        Submit_ASR2B_Date_ = datetime.datetime.strptime(Submit_ASR2B_Date, '%m/%d/%Y')
        Date_Differ2B = Submit_ASR2B_Date_ - Unit2_Release_Date_
        D2B = str(Date_Differ2B.days)
    else:
        D2B = "-1"
    if type(Submit_ASR2C_Date) is str:
        Submit_ASR2C_Date_ = datetime.datetime.strptime(Submit_ASR2C_Date, '%m/%d/%Y')
        Date_Differ2C = Submit_ASR2C_Date_ - Unit2_Release_Date_
        D2C = str(Date_Differ2C.days)
    else:
        D2C = "-1"

    Unit3_Release_Date = '2/8/2013'
    Submit_ASR3_Date = df[df["Object_Title"] == "Submit ASR Unit #3"]["Date_Active"].values.any()
    Unit3_Release_Date_ = datetime.datetime.strptime(Unit3_Release_Date, '%m/%d/%Y')
    if type(Submit_ASR3_Date) is str:
        Submit_ASR3_Date_ = datetime.datetime.strptime(Submit_ASR3_Date, '%m/%d/%Y')
        Date_Differ3 = Submit_ASR3_Date_ - Unit3_Release_Date_
        D3 = str(Date_Differ3.days)
    else:
        D3 = "-1"

    Unit4_Release_Date = '2/15/2013'
    Submit_ASR4_Date = df[df["Object_Title"] == "Submit ASR Unit #4"]["Date_Active"].values.any()
    Unit4_Release_Date_ = datetime.datetime.strptime(Unit4_Release_Date, '%m/%d/%Y')
    if type(Submit_ASR4_Date) is str:
        Submit_ASR4_Date_ = datetime.datetime.strptime(Submit_ASR4_Date, '%m/%d/%Y')
        Date_Differ4 = Submit_ASR4_Date_ - Unit4_Release_Date_
        D4 = str(Date_Differ4.days)
    else:
        D4 = "-1"

    Unit5_Release_Date = '3/1/2013'
    Submit_ASR5_Date = df[df["Object_Title"] == "Submit ASR Unit #5"]["Date_Active"].values.any()
    Unit5_Release_Date_ = datetime.datetime.strptime(Unit5_Release_Date, '%m/%d/%Y')
    if type(Submit_ASR5_Date) is str:
        Submit_ASR5_Date_ = datetime.datetime.strptime(Submit_ASR5_Date, '%m/%d/%Y')
        Date_Differ = Submit_ASR5_Date_ - Unit5_Release_Date_
        D5 = str(Date_Differ.days)
    else:
        D5 = "-1"

    Unit6_Release_Date = '3/8/2013'
    Submit_ASR6_Date = df[df["Object_Title"] == "Submit ASR Unit #6"]["Date_Active"].values.any()
    Unit6_Release_Date_ = datetime.datetime.strptime(Unit6_Release_Date, '%m/%d/%Y')
    if type(Submit_ASR6_Date) is str:
        Submit_ASR6_Date_ = datetime.datetime.strptime(Submit_ASR6_Date, '%m/%d/%Y')
        Date_Differ6 = Submit_ASR6_Date_ - Unit6_Release_Date_
        D6 = str(Date_Differ6.days)
    else:
        D6 = "-1"

    Unit7_Release_Date = '3/15/2013'
    Submit_ASR7a_Date = df[df["Object_Title"] == "Submit ASR Unit #7A"]["Date_Active"].values.any()
    Submit_ASR7b_Date = df[df["Object_Title"] == "Submit ASR Unit #7B"]["Date_Active"].values.any()
    Unit7_Release_Date_ = datetime.datetime.strptime(Unit7_Release_Date, '%m/%d/%Y')

    if type(Submit_ASR7a_Date) is str:
        Submit_ASR7a_Date_ = datetime.datetime.strptime(Submit_ASR7a_Date, '%m/%d/%Y')
        Date_Differ7a = Submit_ASR7a_Date_ - Unit7_Release_Date_
        D7a = str(Date_Differ7a.days)
    else:
        Submit_ASR7a_Date = ""
        D7a = "-1"

    if type(Submit_ASR7b_Date) is str:
        Submit_ASR7b_Date1_ = datetime.datetime.strptime(Submit_ASR7b_Date, '%m/%d/%Y')
        Date_Differ7b = Submit_ASR7b_Date1_ - Unit7_Release_Date_
        D7b = str(Date_Differ7b.days)
    else:
        D7b = "-1"

    print(str(count) + ',' + str(num_RA) + ',' + str(num_SM) + ',' + str(g) + ',' + str(g1)
          + ',' + str(g2) + ',' + str(g3) + ',' + str(g4) + ',' + str(g5) + ',' + str(g6)
          + ',' + str(g7) + ',' + D1 + ',' + D2A + ',' + D2B + ',' + D2C + ',' + D3 + ',' + D4
          + ',' + D5 + ',' + D6 + ',' + D7a + ',' + D7b)
    count = count + 1

    if count == 10 :
        print(str(count) + ',' + "-1" + ',' + "-1" + ',' + "-1" + ',' + "-1"
              + ',' + "-1" + ',' + "-1" + ',' + "-1" + ',' + "-1" + ',' + "-1"
              + ',' + "-1" + ',' + "-1" + ',' + "-1" + ',' + "-1" + ',' + "-1" + ',' + "-1" + ',' + "-1"
              + ',' + "-1" + ',' + "-1" + ',' + "-1" + ',' + "-1")
        count = count + 1