import java.util.*;
import java.text.SimpleDateFormat;

class Student
{
	String roll;
	String name;
	String date;
	int marks[];
	boolean enteredMarks;

	Student(String entered_roll)
	{
		Scanner sc = new Scanner(System.in);

		roll = entered_roll;

		System.out.print("Enter Name : ");
		name = sc.next();

		marks=new int[5];
		enteredMarks = false;

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
		date = ft.format(dNow);
	}

	void getMarks()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Marks :- ");
		for(int i=0; i<5; i++)
		{
			System.out.print("	Subject "+(i+1)+" : ");
			marks[i] = sc.nextInt();
		}
		enteredMarks = true;
	}

	void displayMarkSheet()
	{
		System.out.println("Name : "+name);
		System.out.println("Roll : "+roll);
		System.out.println("Date of Admission : "+date);

		int i, totalMarks = 0;
		char grade;
		boolean hasFailed = false;

		System.out.println("==================================================");
		System.out.println("||\tSubject\t|\tMarks\t|\tGrade\t||");
		System.out.println("||----------------------------------------------||");

		for(i=0; i<5; i++)
		{
			switch(marks[i]/10)
			{
				case 10:
				case 9:
						grade = 'S';
						break;
				case 8:
						grade = 'A';
						break;
				case 7:
						grade = 'B';
						break;
				case 6:
						grade = 'C';
						break;
				case 5:
						grade = 'D';
						break;
				case 4:
						grade = 'E';
						break;
				default:
						grade = 'X';
						hasFailed = true;
			}
			System.out.println("||\t"+i+"\t|\t"+marks[i]+"\t|\t"+grade+"\t||");
			totalMarks += marks[i];
		}

		System.out.println("==================================================");
		if(hasFailed)
			System.out.println("Remarks : Not Passed");
		else
		{
			System.out.println("Average : "+(1.0*totalMarks/5));
			System.out.println("Remarks : Passed");
		}
	}

}