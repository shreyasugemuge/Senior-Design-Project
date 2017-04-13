grades <- read.csv(file="grades.csv", header=TRUE, sep=",")
optionalassignments <- grades[,c(1,47,48,49,50,51,52)]
colnames(optionalassignments)
optionalassignments$na_count <- apply(is.na(optionalassignments),1,sum)
optionalassignments$na_count
optionalassignments$num_submissions <- 6-optionalassignments$na_count
optionalassignmentsnumsubmitted <- optionalassignments[,c(1,9)]
write.csv(optionalassignmentsnumsubmitted, file = "optassignmentsnumsubmitted.csv")
