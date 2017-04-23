#!/bin/bash
echo -e "Caculate how many days of each student submits the ASR after the Unit materials avaliable.\n..............\n..............\n"
python ../behavior_python/1.py ../private/clean/log_*.csv > ../docs/ShiruHou/1.csv
echo -e "Sucess"
