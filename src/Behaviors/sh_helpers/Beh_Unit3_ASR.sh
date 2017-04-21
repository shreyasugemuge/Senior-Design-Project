#!/bin/bash
echo -e "Caculate how many days of each student submits the ASR after the Unit3 study guide materials avaliable.\n..............\n..............\n"
python ../behavior_python/Unit3_ASR.py ../private/clean/log_*.csv > ../docs/unit_ASR/unit3.csv
echo -e "Sucess"