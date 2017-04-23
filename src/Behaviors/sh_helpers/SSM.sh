#!/bin/bash
echo -e "Caculate how many activities of each student study supplemental materials\n..............\n..............\n"
python ../behavior_python/Study_Supplemental_Material.py ../private/clean/log_*.csv > ../docs/ShiruHou/3.csv
echo -e "Sucess"
