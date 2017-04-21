#!/bin/bash
echo -e "Caculate how many days of each student submits the ASR after the Unit2 study guide materials avaliable.\n..............\n..............\n"
python ../behavior_python/Unit2_ASR.py ../private/clean/log_*.csv > ../docs/unit_ASR/unit2.csv
echo -e "Sucess"