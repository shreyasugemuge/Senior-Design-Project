# Shreyas Ugemuge

import numpy as np
import pandas as pd
from sklearn import tree
from sklearn.externals.six import StringIO
from sklearn.ensemble import RandomForestClassifier
from sklearn.naive_bayes import GaussianNB
import matplotlib.pyplot as plt
import pydotplus
import pickle



df = pd.read_csv("data/train.csv", header = 0)
# df.head() # display incase needed


# special note here, sci-kit learn only accepts numerical data.
# all these string values are being mapped to numerical values
d = {'Y': 1, 'N': 0}
df['Above Average'] = df['Above Average'].map(d)

features = list(df.columns[1:17])

y = df["Above Average"]
X = df[features]

classifier = RandomForestClassifier(n_estimators=5)
classifier = classifier.fit(X, y)

importances = classifier.feature_importances_
indices = np.argsort(importances)
features = df.columns[1:17]
#
# plt.figure(1)
# plt.title('Feature Importances')
# plt.barh(range(len(indices)), importances[indices], color='b', align='center')
# plt.yticks(range(len(indices)), features[indices])
# plt.xlabel('Relative Importance')
# plt.show()

dda = pd.DataFrame({'features': df.columns[1:17], 'imp': importances})
dda = dda.sort_values(by='imp',ascending=False)
dda.to_csv("data/priority.csv")
results = []
IDs = []
df = pd.read_csv("data/test.csv", header = 0)
count = 0.0
total = 0.0

for index,row in df.iterrows():

    result = classifier.predict(row[1:17].values.reshape(1,-1))
    IDs.append(row[0])
    results.append(result)
    s = 0
    if row["Above Average"] == "Y" :
        s = 1
    if s == result :
        count = count + 1
    total = total + 1
    accuracy = count/total
print "Model Accuracy: ", (count/total)*100
f = {1: 'Y', 0: 'N'}
lll = pd.DataFrame({'ID': IDs,'prediction':list(map(int,results))})
lll['prediction'] = lll['prediction'].map(f)
lll.to_csv("pred.csv")

filename = 'finalized_model.sav'
pickle.dump(classifier, open(filename, 'wb'))
