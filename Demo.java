import java.util.Scanner;

class student_class {
    private String studentName, studentID, Grade;
    private double assignmentOneMarks, assignmentTwoMarks, projectMarks, individualTotalMarks;

    student_class() {
        final double P = 50.00;
        final double HD = 85.00;
    }

    student_class(int i) {

    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setAssignmentOneMarks(double assignmentOneMarks) {
        this.assignmentOneMarks = assignmentOneMarks;
    }

    public double getAssignmentOneMarks() {
        return assignmentOneMarks;
    }

    public void setAssignmentTwoMarks(double assignmentTwoMarks) {
        this.assignmentTwoMarks = assignmentTwoMarks;
    }

    public double getAssignmentTwoMarks() {
        return assignmentTwoMarks;
    }

    public void setProjectMarks(double projectMarks) {
        this.projectMarks = projectMarks;
    }

    public double getProjectMarks() {
        return projectMarks;
    }

    double calculateTotalMarks(double assignmentOneMarks, double assignmentTwoMarks, double projectMarks) {
        individualTotalMarks = assignmentOneMarks + assignmentTwoMarks + projectMarks;
        return individualTotalMarks;
    }

    String calculateGrade(double individualTotalMarks) {
        if (individualTotalMarks >= 85) {
            return "HD Grade";
        } else if (individualTotalMarks < 85 && individualTotalMarks >= 75) {
            return "D Grade";
        } else if (individualTotalMarks < 75 && individualTotalMarks >= 65) {
            return "C Grade";
        } else if (individualTotalMarks < 65 && individualTotalMarks >= 50) {
            return "P Grade";
        } else {
            return "F Grade";
        }
    }
}

public class Demo {

    public static void main(String[] args) {

        System.out.print("\n***********************************************************************\n");
        System.out.print("\n|| Welcome to the grade Management System(GMS) of MIT WPU ||");
        System.out.print("\n|| Developed by Prinsi Kakadiya, 1132220154 ||");
        System.out.print("\n\n***********************************************************************\n");

        Scanner sc = new Scanner(System.in);
        System.out.printf("\n Enter No of students:");
        int n = sc.nextInt();
        student_class s[] = new student_class[n];
        int choice, count = 0;
        String st_name[] = new String[n];
        String st_ID[] = new String[n];
        String grade[] = new String[n];
        double assignmentOneMarks[] = new double[n];
        double assignmentTwomarks[] = new double[n];
        double projectMarks[] = new double[n];
        double total[] = new double[n];

        do {
            System.out.printf("\n\n 1. Enter Students Record \n 2. Display student information \n 3. Display Statistics \n 4. Exit the Application");
            System.out.printf("\n\n Enter choice:");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:

                    if (count == n) {
                        System.out.printf("\n Maximum count reached");
                        break;
                    } else {
                        for (int i = 0; i < n; i++) {
                            System.out.printf("\n Enter Student Name:");
                            st_name[i] = sc.nextLine();
                            while (st_name[i].isEmpty()) {
                                System.out.printf("\n ERROR student name cannot be blank");
                                System.out.printf("\n Enter Student Name:");
                                st_name[i] = sc.nextLine();
                            }
                            s[i] = new student_class();
                            s[i].setStudentName(st_name[i]);

                            System.out.printf(" Enter Student ID:");
                            st_ID[i] = sc.nextLine();
                            while (st_ID[i].isEmpty()) {
                                System.out.printf("\n ERROR student ID cannot be blank");
                                System.out.printf("\n Enter Student ID:");
                                st_ID[i] = sc.nextLine();
                            }
                            s[i].setStudentID(st_ID[i]);

                            System.out.printf(" Enter Assignment 1 marks of student %s:", st_name[i]);
                            assignmentOneMarks[i] = sc.nextDouble();
                            while (assignmentOneMarks[i] == 0) {
                                System.out.printf("\n Marks must be greater than 0");
                                System.out.printf("\n Enter Assignment 1 marks of student %s:", st_name[i]);
                                assignmentOneMarks[i] = sc.nextDouble();
                            }
                            while (assignmentOneMarks[i] > 20) {
                                System.out.printf("\n Marks must be less than 20");
                                System.out.printf("\n Enter Assignment 1 marks of student %s:", st_name[i]);
                                assignmentOneMarks[i] = sc.nextDouble();
                            }
                            s[i].setAssignmentOneMarks(assignmentOneMarks[i]);

                            System.out.printf(" Enter Assignment 2 marks of student %s:", st_name[i]);
                            assignmentTwomarks[i] = sc.nextDouble();
                            while (assignmentTwomarks[i] == 0) {
                                System.out.printf("\n Marks must be greater than 0");
                                System.out.printf("\n Enter Assignment 2 marks of student %s:", st_name[i]);
                                assignmentTwomarks[i] = sc.nextDouble();
                            }
                            while (assignmentTwomarks[i] > 30) {
                                System.out.printf("\n Marks must be less than 30");
                                System.out.printf("\n Enter Assignment 2 marks of student %s:", st_name[i]);
                                assignmentTwomarks[i] = sc.nextDouble();
                            }
                            s[i].setAssignmentTwoMarks(assignmentTwomarks[i]);

                            System.out.printf(" Enter Project marks of student %s:", st_name[i]);
                            projectMarks[i] = sc.nextDouble();
                            while (projectMarks[i] == 0) {
                                System.out.printf("\n Marks must be greater than 0");
                                System.out.printf("\n Enter Project marks of student %s:", st_name[i]);
                                projectMarks[i] = sc.nextDouble();
                            }
                            while (projectMarks[i] > 50) {
                                System.out.printf("\n Marks must be less than 50");
                                System.out.printf("\n Enter Project marks of student %s:", st_name[i]);
                                projectMarks[i] = sc.nextDouble();
                            }
                            s[i].setProjectMarks(projectMarks[i]);
                            total[i] = s[i].calculateTotalMarks(assignmentOneMarks[i], assignmentTwomarks[i], projectMarks[i]);

                            grade[i] = s[i].calculateGrade(total[i]);
                            count++;
                        }
                    }


                    break;
                case 2:
                    if (count == 0) {
                        System.out.printf("\n You must enter at least one record");
                        break;
                    } else {
                        for (int i = 0; i < n; i++) {
                            System.out.printf("\n Stu_name: %s \t Stu_ID: %s \t assign1_Marks: %f \t assign2_Marks: %f \t Project_Marks: %f \t Total_Marks %f", s[i].getStudentName(), s[i].getStudentID(), s[i].getAssignmentOneMarks(), s[i].getAssignmentTwoMarks(), s[i].getProjectMarks(), total[i]);
                        }
                    }
                    break;

                case 3:

                    if (count == 0) {
                        System.out.printf("\n You must enter at least one record");
                        break;
                    } else {
                        int max = 0, min = 0;
                        for (int i = 0; i < n; i++) {
                            if (total[i] > total[max]) {
                                max = i;
                            }
                        }
                        for (int i = 0; i < n; i++) {
                            if (total[i] < total[min]) {
                                min = i;
                            }
                        }
                        System.out.printf("\n The student %s with student number %s has received maximum marks which is %f", st_name[max], st_ID[max], total[max]);
                        System.out.printf("\n The student %s with student number %s has received minimum marks which is %f", st_name[min], st_ID[min], total[min]);

                        double avg, sum = 0;
                        for (int i = 0; i < n; i++) {
                            sum = sum + total[i];
                        }
                        avg = sum / n;
                        System.out.printf("\n The average marks of class is %f", avg);
                    }

                    break;

            }
        } while (choice != 4);
        System.out.printf("\n\nThank you for using the Grading Management System ");
        System.out.printf("\nPrograme written by prinsi kakadiya with student number S1132220154 ");

    }
}