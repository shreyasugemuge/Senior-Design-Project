#!/bin/bash
echo -e "Caculate how many activities of each student reviewed tests and assignments\n..............\n..............\n"
python ../behavior_python/reviewed4weeks.py ../private/clean/log_*.csv > ../docs/ShiruHou/4_4weeks.csv
echo -e "Sucess"
