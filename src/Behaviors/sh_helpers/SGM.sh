#!/bin/bash
echo -e "Caculate how many activities of each student to study each guide materials.\n..............\n..............\n"
python ../behavior_python/Study_Guide_Materials.py ../private/clean/log_*.csv > ../docs/ShiruHou/2.csv
echo -e "Sucess"
