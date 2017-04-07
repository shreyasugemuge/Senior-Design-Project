grades <- read.csv(file="grades.csv", header=TRUE, sep=",")
assignments <- grades[,c(1,13,14,15,16,17,18,19,20,21,22)]
colnames(assignments)
assignments$na_count <- apply(is.na(assignments),1,sum)
assignments$num_submissions <- 10-assignments$na_count
assignments$num_submissions
assignmentsnumsubmitted <- assignments[,c(1,13)]


