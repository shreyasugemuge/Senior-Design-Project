mkdir -p bin
javac -d bin/ util/mainClass.java
javac -d bin/ util/rec/Reccomend_n.java
java -cp bin mainClass $1 $2
python dm/corr_rf.py
java -cp bin rec.Reccomend_n
echo "results in rec/"
