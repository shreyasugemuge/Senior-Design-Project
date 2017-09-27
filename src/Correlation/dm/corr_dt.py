# Shreyas Ugemuge
# Example

import numpy as np
import pandas as pd
from sklearn import tree
from sklearn.externals.six import StringIO
from sklearn.ensemble import RandomForestClassifier
from sklearn.naive_bayes import GaussianNB
import pydotplus


# load some made up data, using pandas into dataframe
df = pd.read_csv("data/train.csv", header = 0)
# df.head() # display incase needed


# special note here, sci-kit learn only accepts numerical data.
# all these string values are being mapped to numerical values
d = {'Y': 1, 'N': 0}
df['Above Average'] = df['Above Average'].map(d)
#df['Ave'] = df['Average Activities Per Session']
#df['log'] = df['Total Number of Logins']
#df['Interned'] = df['Interned'].map(d)
#d = {'BS': 0, 'MS': 1, 'PhD': 2}
#df['Level of Education'] = df['Level of Education'].map(d)
#print df['Above Average']
#print df['Time Test #1 A']

features = list(df.columns[1:6])

y = df["Above Average"]
X = df[features]

classifier = tree.DecisionTreeClassifier()
classifier = classifier.fit(X,y)
dot_data = StringIO()
tree.export_graphviz(classifier, out_file=dot_data,
                     feature_names=features)
pydotplus.graph_from_dot_data(dot_data.getvalue()).write_png("dtree2.png")


df = pd.read_csv("data/test.csv", header = 0)
count = 0.0
total = 0.0
for index,row in df.iterrows():
    result = classifier.predict([[row["Number of days with 0 activities"], row["Average Activities Per Session"], row["Total Number of Logins"], row["Time Test 1A"],row["Time Test 1B"]]])
    s = 0
    if row["Above Average"] == "Y" :
        s = 1
    if s == result :
        count = count + 1
    total = total + 1
    accuracy = count/total
    print "ID: ",row["ID"],"Result: ",result,"Actual: ",s,"Accuracy: ",count,"/",total
print "Total Accuracy: ", (count/total)*100
#    print "above"
#else :
#    print "below"
