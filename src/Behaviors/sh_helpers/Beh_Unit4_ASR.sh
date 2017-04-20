#!/bin/bash
echo -e "Caculate how many days of each student submits the ASR after the Unit4 study guide materials avaliable.\n..............\n..............\n"
python Unit4_ASR.py private/clean/log_*.csv > docs/unit_ASR/unit4.csv
echo -e "Sucess"