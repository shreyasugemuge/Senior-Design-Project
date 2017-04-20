#!/bin/bash
echo -e "Caculate how many activities of each student reviewed tests and assignments\n..............\n..............\n"
python Nums_of_Reviewed_Activity.py private/clean/log_*.csv > docs/nums_of_reviewed.csv
echo -e "Sucess"