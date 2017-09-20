# Shreyas Ugemuge
# Example

import numpy as np
import pandas as pd
from sklearn import tree
from sklearn.externals.six import StringIO
from sklearn.ensemble import RandomForestClassifier
import pydotplus


# load some made up data, using pandas into dataframe
df = pd.read_csv("merge.csv", header = 0)
# df.head() # display incase needed


# special note here, sci-kit learn only accepts numerical data.
# all these string values are being mapped to numerical values
d = {'Y': 1, 'N': 0}
df['Above Average?'] = df['Above Average?'].map(d)
#df['Ave'] = df['Average Activities Per Session']
#df['log'] = df['Total Number of Logins']
#df['Interned'] = df['Interned'].map(d)
#d = {'BS': 0, 'MS': 1, 'PhD': 2}
#df['Level of Education'] = df['Level of Education'].map(d)
print df['Above Average?']
print df['Time Test #1 A']

features = list(df.columns[1:5])

y = df["Above Average?"]
X = df[features]
classifier = tree.DecisionTreeClassifier()
classifier = classifier.fit(X,y)

dot_data = StringIO()
tree.export_graphviz(classifier, out_file=dot_data,
                     feature_names=features)
pydotplus.graph_from_dot_data(dot_data.getvalue()).write_png("dtree2.png")

clf = RandomForestClassifier(n_estimators=10)
clf = clf.fit(X, y)
#

#
#if clf.predict([[10,124]])==0 :
#    print "N"
#else :
#    print "Y"
###...and an unemployed 10-year veteran

