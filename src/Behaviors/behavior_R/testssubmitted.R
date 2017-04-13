grades <- read.csv(file="grades.csv", header=TRUE, sep=",")
tests <- grades[,c(1,23,26,29,32,35,38,41,44)]
colnames(tests)
tests$na_count <- apply(is.na(tests),1,sum)
tests$num_submissions <- 9-tests$na_count
tests$num_submissions
testsnumsubmitted <- tests[,c(1,11)]
write.csv(testsnumsubmitted, file = "testssubmitted.csv")
