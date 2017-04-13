#!/bin/bash
echo "Preparing dataset"
python behavior_python/CleanDataset.py private/alllogs/*.csv
