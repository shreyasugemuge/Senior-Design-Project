#!/bin/bash
echo -e "Caculate how many days of each student submits the ASR after the Unit6 study guide materials avaliable.\n..............\n..............\n"
python ../behavior_python/Unit6_ASR.py ../private/clean/log_*.csv > ../docs/ShiruHou/unit_ASR/unit6.csv
echo -e "Sucess"
