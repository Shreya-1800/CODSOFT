package GradeCalculator;

import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        //taking number of subjects as input
        System.out.print("Enter number of subjects : ");
        int sub=sc.nextInt();

        int sum=0;
        int[] marks;
        marks=new int[sub];

        //taking marks as input in array
        for (int i=0;i<sub;i++) {
            System.out.print("Enter marks for subject "+(i+1)+" out of 100: ");
            marks[i]=sc.nextInt();
        }
        System.out.println("!...MARKS ENTERED SUCCESSFULLY...!");

        //calculating total marks
        for (int i=0;i<sub;i++){
            sum=sum+marks[i];
        }

        System.out.println("Total marks obtained out of "+(sub*100)+" are : "+sum+"");
        //calculating percentage as float value
        System.out.println("Percentage obtained are : "+(float)sum/sub+"%");

        //deciding grade
        if((sum/sub)<=100 && (sum/sub)>=90)
            System.out.println("Grade obtained is A");
        else if((sum/sub)<90 && (sum/sub)>=80)
            System.out.println("Grade obtained is B");
        else if((sum/sub)<80 && (sum/sub)>=70)
            System.out.println("Grade obtained is C");
        else if((sum/sub)<70 && (sum/sub)>=60)
            System.out.println("Grade obtained is D");
        else if((sum/sub)<60 && (sum/sub)>=50)
            System.out.println("Grade obtained is E");
        else if((sum/sub)<50 && (sum/sub)>=0)
            System.out.println("Grade obtained is F");
        else
            System.out.println("XXX INVALID PERCENTAGE *** NO GRADE AVAILABLE XXX");

    }
}