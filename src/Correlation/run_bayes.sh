mkdir -p bin
javac -d bin/ util/mainClass.java 
java -cp bin mainClass $1 $2
python dm/corr_nb.py
