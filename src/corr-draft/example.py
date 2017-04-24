# Shreyas Ugemuge
# Example

import numpy as np
import pandas as pd
from sklearn import tree
from sklearn.externals.six import StringIO
from sklearn.ensemble import RandomForestClassifier
import pydotplus


# load some made up data, using pandas into dataframe
df = pd.read_csv("data.csv", header = 0)
# df.head() # display incase needed

# some changes, makes it mode compatible.
# special note here, sci-kit learn only accepts numerical data, hence
# all these string values are being mapped to numerical values
d = {'Y': 1, 'N': 0}
df['Hired'] = df['Hired'].map(d)
df['Employed?'] = df['Employed?'].map(d)
df['Top-tier school'] = df['Top-tier school'].map(d)
df['Interned'] = df['Interned'].map(d)
d = {'BS': 0, 'MS': 1, 'PhD': 2}
df['Level of Education'] = df['Level of Education'].map(d)

# get my x values, that is basically everything up to column 6
features = list(df.columns[:6])

# Now actually construct the decision tree using featurs as x and hired column (7)
# as y
y = df["Hired"]
X = df[features]
classifier = tree.DecisionTreeClassifier()
classifier = classifier.fit(X,y)

dot_data = StringIO()
tree.export_graphviz(classifier, out_file=dot_data,
                     feature_names=features)
pydotplus.graph_from_dot_data(dot_data.getvalue()).write_png("dtree.png")

#clf = RandomForestClassifier(n_estimators=10)
#clf = clf.fit(X, y)
#
##Predict employment of an employed 10-year veteran
#print clf.predict([[10, 1, 4, 0, 0, 0]])
##...and an unemployed 10-year veteran
#print clf.predict([[10, 0, 4, 0, 0, 0]])
