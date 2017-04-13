#!/bin/bash
echo "Making sure folders required exist.."
mkdir docs/unit_ASR
echo "Success.."
./Beh_Unit2_ASR.sh
./Beh_Unit2_ASR.sh
./Beh_Unit3_ASR.sh
./Beh_Unit4_ASR.sh
./Beh_Unit5_ASR.sh
./Beh_Unit6_ASR.sh
./Beh_Unit7_ASR.sh

echo "Success. Result located in docs/"
