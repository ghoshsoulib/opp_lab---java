import java.util.*;
public class Assignment_1_1
{
	public static void main(String args[])
	{
		String departments[] = {"B.CSE", "B.ETCE", "B.EE", "B.IT", "M.CSE", "M.ETCE", "M.EE", "M.IT"};
		int i, dept_id;
		StudentListModified StudentListModified_1[] = new StudentListModified[8];
		for(i=0; i<8; i++)
			StudentListModified_1[i] = new StudentListModified(departments[i]);
		int choice, index;
		String roll, dept;
		Scanner sc = new Scanner(System.in);

		System.out.println("Available Departments :-");
		for(i=0; i<8; i++)
			System.out.println("("+i+") "+departments[i]);

		System.out.println("\nAvailable Options :-");

		
		while(true)
		{
		
		
				
		System.out.println("(1) Register Student");
		System.out.println("(2) Enter Marks of Student");
		System.out.println("(3) Display Marksheet of Student");
		System.out.println("(4) Sort Students and Generate Rank List");
		System.out.println("(5) Keep Students who have Passed (Delete Student Entry)");
		System.out.println("(6) Show Number of Students Admitted");
		System.out.println("(7) Exit");
		System.out.print("\t\tEnter your Choice:  ");
		
			
			choice = sc.nextInt();

			switch(choice)
			{
				
				case 1:
						System.out.print("Enter Department Number : ");
						while(true)
						{
							dept_id = sc.nextInt();
							if(dept_id>=0 && dept_id<8)
								break;
							else
								System.out.println("Invalid Department Number");
						}
						StudentListModified_1[dept_id].registerStudent();
						break;
				case 2:
						System.out.print("Enter Department Number : ");
						while(true)
						{
							dept_id = sc.nextInt();
							if(dept_id>=0 && dept_id<8)
								break;
							else
								System.out.println("Invalid Department Number");
						}
						System.out.print("Enter Roll Number : ");
						roll = sc.next();
						index = StudentListModified_1[dept_id].indexOf(roll);
						if(index == -1)
							System.out.println("Roll Number Does Not Exist");
						else
							StudentListModified_1[dept_id].marksEntry(index);
						break;
				case 3:
						System.out.print("Enter Department Number : ");
						while(true)
						{
							dept_id = sc.nextInt();
							if(dept_id>=0 && dept_id<8)
								break;
							else
								System.out.println("Invalid Department Number");
						}
						System.out.print("Enter Roll Number : ");
						roll = sc.next();
						index = StudentListModified_1[dept_id].indexOf(roll);
						if(index == -1)
							System.out.println("Roll Number Does Not Exist");
						else if(StudentListModified_1[dept_id].marksEntered(index) == false)
							System.out.println("Marks Have Not Been Entered");
						else
							StudentListModified_1[dept_id].showMarks(index);
						break;
				case 4:
						System.out.print("Enter Department Number : ");
						while(true)
						{
							dept_id = sc.nextInt();
							if(dept_id>=0 && dept_id<8)
								break;
							else
								System.out.println("Invalid Department Number");
						}
						StudentListModified_1[dept_id].sortStudent(departments[dept_id]);
						break;
				case 5:
						System.out.print("Enter Department Number : ");
						while(true)
						{
							dept_id = sc.nextInt();
							if(dept_id>=0 && dept_id<8)
								break;
							else
								System.out.println("Invalid Department Number");
						}
						StudentListModified_1[dept_id].removeStudents();
						break;
				case 6:
						System.out.print("Enter Department Number : ");
						while(true)
						{
							dept_id = sc.nextInt();
							if(dept_id>=0 && dept_id<8)
								break;
							else
								System.out.println("Invalid Department Number");
						}
						System.out.println("Number of Students Admitted = " + StudentListModified_1[dept_id].count);
						break;
						
						
				case 7:
						return;
						
						
				default:
						System.out.println("Invalid Choice");
			}
		}
	}
}
