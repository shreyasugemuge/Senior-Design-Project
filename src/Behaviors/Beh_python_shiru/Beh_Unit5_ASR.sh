#!/bin/bash
echo -e "Caculate how many days of each student submits the ASR after the Unit5 study guide materials avaliable.\n..............\n..............\n"
python Unit5_ASR.py private/clean/log_*.csv > docs/unit_ASR/unit5.csv
echo -e "Sucess"