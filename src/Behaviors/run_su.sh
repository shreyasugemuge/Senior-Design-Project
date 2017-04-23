#!/bin/bash
echo "Making sure folders required exist.."
mkdir docs/shreyas
mkdir private/clean
./sh_helpers/CleanDataset.sh
echo $?
./sh_helpers/Behaviour1.sh
echo -n $?
echo " Result located in docs/shreyas"
#ii
