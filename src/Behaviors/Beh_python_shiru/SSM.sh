#!/bin/bash
echo -e "Caculate how many activities of each student study supplemental materials\n..............\n..............\n"
python Study_Supplemental_Material.py private/clean/log_*.csv > docs/study_supplemental_materials.csv
echo -e "Sucess"