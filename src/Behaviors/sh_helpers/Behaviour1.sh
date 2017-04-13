#!/bin/bash
echo -e "Extracting Behavior: number of days 0 activity for each student\nExtracting Behavior: Average activity per login for each student\nExtracting Behavior: Total logins through the semester for each student"
python behavior_python/Beh_1.py private/clean/log_*.csv > docs/shreyas/beh_1.csv
