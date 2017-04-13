#!/bin/bash
echo "Making sure folders required exist.."
mkdir docs
mkdir private/clean
./sh_helpers/CleanDataset.sh
echo "Success.."
./sh_helpers/Behaviour1.sh
echo "Success. Result located in docs/"
