#!/bin/bash
echo -e "Caculate how many activities of each student to study each guide materials.\n..............\n..............\n"
python ../behavior_python/week8SGM.py ../private/clean/log_*.csv > ../docs/ShiruHou/2_8weeks.csv
echo -e "Sucess"
