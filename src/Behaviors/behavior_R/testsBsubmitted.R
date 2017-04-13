grades <- read.csv(file="grades.csv", header=TRUE, sep=",")
testsB <- grades[,c(1,24,27,30,33,36,39,42,45)]
colnames(tests)
testsB$na_count <- apply(is.na(testsB),1,sum)
testsB$num_submissions <- 9-testsB$na_count
testsB$num_submissions
testsBnumsubmitted <- testsB[,c(1,11)]
write.csv(testsBnumsubmitted, file = "testsBsubmitted.csv")
