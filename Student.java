import java.util.Scanner;                                                                                                 ;
public class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int numSubjects;
    public void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter USN: ");
        usn = scanner.nextLine();
        System.out.print("Enter Name: ");
        name = scanner.nextLine();
        System.out.print("Enter number of subjects: ");
        numSubjects = scanner.nextInt();
        credits = new int[numSubjects];
        marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = scanner.nextInt();
        }
        scanner.close();
    }
    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("USN: " + usn);
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Subject " + (i + 1) + ": Marks = " + marks[i] + ", Credits = " + credits[i]);
        }
    }
    public void calcSGPA() {
        int totalGradePoints = 0, totalCredits = 0;
        for (int i = 0; i < numSubjects; i++) {
            int gradePoint;
            if (marks[i] >= 90) {
                gradePoint = 10;
            } else if (marks[i] >= 80) {
                gradePoint = 9;
            } else if (marks[i] >= 70) {
                gradePoint = 8;
            } else if (marks[i] >= 60) {
                gradePoint = 7;
            } else if (marks[i] >= 50) {
                gradePoint = 6;
            } else if (marks[i] >= 40) {
                gradePoint = 5;
            } else {
                gradePoint = 0; // Failed
            }
            totalGradePoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }
        double sgpa = (double) totalGradePoints / totalCredits;
        System.out.printf("SGPA: %.2f\n", sgpa);
    }
}