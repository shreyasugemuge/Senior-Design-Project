#!/bin/bash
echo -e "Caculate how many activities of each student to study each guide materials.\n..............\n..............\n"
python Study_Guide_Materials.py private/clean/log_*.csv > docs/Beh_SGM.csv
echo -e "Sucess"