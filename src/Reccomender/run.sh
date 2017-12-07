mkdir -p bin
javac -d bin/ util/mainClass.java
java -cp bin mainClass $1 $2
python dm/corr_rf.py
javac -d bin/ util/rec/Reccomend_n.java
java -cp bin rec.Reccomend_n
echo "results in rec/"
