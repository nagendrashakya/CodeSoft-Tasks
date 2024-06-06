import java.util.Scanner;

public class Student_grade_Calculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your total subjects ");
        int size = sc.nextInt();
        int Sub[] = new int[size];
        int sum = 0;
        String grade;

        System.out.println("Enter your Marks");
        for(int i=0;i<size;i++){
            System.out.print("Enter " + (i+1) + " Subject Marks : ");
            Sub[i] = sc.nextInt();
            sum += Sub[i];
        }
        int avg = sum/size;
        if (avg >= 95) {
            grade = "A+";
        } else if ((avg >= 90) && (avg < 95)) {
            grade = "A";
        } else if ((avg >= 85) && (avg <= 90)) {
            grade = "B+";
        } else if ((avg >= 80) && (avg < 85)) {
            grade = "B";
        } else if ((avg >= 75) && (avg < 80)) {
            grade = "C+";
        } else if ((avg >= 70) && (avg < 75)) {
            grade = "C";
        } else if ((avg >= 60) && (avg < 70)) {
            grade = "D";
        } else if ((avg >= 50) && (avg < 60)) {
            grade = "E";
        } else{
            grade = "F";
        }
        System.out.println("Total Marks = "+ sum);
        System.out.println("Average Percentage = "+ avg);
        System.out.println("Your Grade = " + grade);
    }
}