#!/bin/bash
echo -e "Caculate how many activities of each student reviewed tests and assignments\n..............\n..............\n"
python ../behavior_python/Nums_of_Reviewed_Activity.py ../private/clean/log_*.csv > ../docs/ShiruHou/4.csv
echo -e "Sucess"
