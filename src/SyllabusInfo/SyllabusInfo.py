print("Welcome to SyllabusInfo System")
print("Please choose the function you want operate, enter the number. i.e. 1,2,3..")
print("0------Quit the system")
print("1------Set the exams date")
print("2------Set the final exam date")
print("3------Set the assignments due date")

func_select = -1
while func_select != 0:
    func_select = input()
    func_select = int(func_select)

    if func_select == 0:
        print("Quit Success")

    elif func_select == 1:
        examsdate = dict()
        print("Please enter the total number of exam in the course: ")
        x = input()
        x = int(x)

        for i in range(x):
            examsdate[i+1] = 'no time';
        y = -1
        while y != 0:
            print("please choose the number of exam and the exam date 'mm-dd-yy', enter 0 quit setting time")
            y = input()
            y = int(y)
            if y > x or y < 0:
                print("error, please reinput")
            if y == 0:
                print("The exams date are:")
                for i in examsdate:
                    print('Exam', i + 1, ':  ', examsdate[i])
                print("Quit Sucess, please choose another operation i.e. 1,2,3")
            if y <= x and y > 0:
                dd = input()
                examsdate[y] = dd


    elif func_select == 2:
        fexamdate = dict()
        print("please enter the final exam data 'mm-dd-yy'")
        f = input()
        fexamdate['Final Exam Date'] = f
        print("The final exam date is:",fexamdate['Final Exam Date'])
        print("Quit Sucess, please choose another operation i.e. 1,2,3")


    elif func_select == 3:
        assdate = dict()
        print("Please enter the total number of assignment in the course: ")
        x = input()
        x = int(x)
        for i in range(x):
            assdate[i+1] = 'no time';
        y = -1
        while y != 0:
            print("please choose the number of assignment and the assignment date 'mm-dd-yy', enter 0 quit setting time")
            y = input()
            y = int(y)
            if y > x or y < 0:
                print("error, please reinput")
            if y == 0:
                print("The assignments due date are")
                for i in assdate:
                    print('Assignments', i + 1, ':  ', examsdate[i])
                print("Quit Sucess, please choose another operation i.e. 1,2,3")
            if y <= x and y > 0:
                dd = input()
                assdate[y] = dd

    else:
        print("error,please reinput")

