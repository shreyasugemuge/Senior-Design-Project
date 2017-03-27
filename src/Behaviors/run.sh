#!/bin/bash
echo "Making sure folders required exist.."
mkdir docs
mkdir private/clean
./CleanDataset.sh
echo "Success.."
./Behaviour1.sh
echo "Success. Result located in docs/"
