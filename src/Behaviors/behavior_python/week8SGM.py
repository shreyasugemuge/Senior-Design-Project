import pandas as pd
import numpy as np
import sys

count = 1
print('ID, Num_of_activities of Study Guide Materials, G1, G2, G3, G4, G5, G6, G7')
for args in sys.argv[1:]:
    df1 = pd.read_csv(args)
    df1['Date'] = pd.to_datetime(df1['Date'],format='%m/%d/%Y')
    df2 = df1.set_index('Date')
    df = df2['2013-01-15':'2013-03-09']
    
    g=0
    g1=0
    g2=0
    g3=0
    g4=0
    g5=0
    g6=0
    g7=0
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


    print(str(count) + ',' + str(g) + ',' + str(g1) + ',' + str(g2) + ',' + str(g3) + ',' + str(g4) + ',' + str(g5) + ',' + str(g6)  + ',' + str(g7))
    count = count + 1
