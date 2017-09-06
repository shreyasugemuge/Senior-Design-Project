First load some fake data on past hires I made up. Note how we use pandas to convert a csv file into a DataFrame:

scikit-learn needs everything to be numerical for decision trees to work. So, we'll map Y,N to 1,0 and levels of education to some scale of 0-2.

Next i separate the features from the target column that we're trying to bulid a decision tree for.

 construct the decision tree and put it in a png file, thats the only good way to view it so scikit gives some support

To read this decision tree, each condition branches left for "true" and right for "false". When you end up at a value, the value array represents how many samples exist in each target value. So value = [0. 5.] mean there are 0 "no hires" and 5 "hires" by the tim we get to that point. value = [3. 0.] means 3 no-hires and 0 hires

rest is still a blur...