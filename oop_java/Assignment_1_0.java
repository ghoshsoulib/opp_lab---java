import java.util.*;
public class Assignment_1_0
{
	public static void main(String args[])
	{
		StudentList studentList_1 = new StudentList();
		int choice, index;
		String roll;
		Scanner sc = new Scanner(System.in);

		System.out.println("(0) Exit");
		System.out.println("(1) Register Student");
		System.out.println("(2) Enter Marks of Student");
		System.out.println("(3) Display Marksheet of Student");
		System.out.println("(4) Show Number of Students Admitted");
		
		while(true)
		{
			System.out.print("\nEnter Choice : ");
			choice = sc.nextInt();

			switch(choice)
			{
				case 0:
						return;
				case 1:
						System.out.print("Enter Roll Number : ");
						roll = sc.next();
						index = studentList_1.indexOf(roll);
						if(index != -1)
							System.out.println("Roll Number Already Exists");
						else
							studentList_1.registerStudent(roll);
						break;
				case 2:
						System.out.print("Enter Roll Number : ");
						roll = sc.next();
						index = studentList_1.indexOf(roll);
						if(index == -1)
							System.out.println("Roll Number Does Not Exist");
						else
							studentList_1.marksEntry(index);
						break;
				case 3:
						System.out.print("Enter Roll Number : ");
						roll = sc.next();
						index = studentList_1.indexOf(roll);
						if(index == -1)
							System.out.println("Roll Number Does Not Exist");
						else if(studentList_1.marksEntered(index) == false)
							System.out.println("Marks Have Not Been Entered");
						else
							studentList_1.showMarks(index);
						break;
				case 4:
						System.out.println("Number of Students Admitted = " + studentList_1.count);
						break;
				default:
						System.out.println("Invalid Choice");
			}
		}
	}
}