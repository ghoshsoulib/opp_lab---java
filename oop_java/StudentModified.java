import java.util.*;

class StudentModified extends Student
{

	StudentModified(String department, int index)
	{
		super("");

		Scanner sc = new Scanner(System.in);

		String tempIndex = ""+index;
		while(tempIndex.length() != 3)
			tempIndex = "0"+tempIndex;

		roll = department.charAt(0)+department.substring(2)+ date.charAt(8)+date.charAt(9) + tempIndex;
		System.out.println("Roll Number is : "+roll);
	}

	int totalMarks()
	{
		int i,total=0;

		for(i=0;i<5;i++)
			total += marks[i];

		return total;
	}

	boolean hasPassed()
	{
		int i;

		for(i=0;i<5;i++)
			if(marks[i]<40)
				return false;

		return true;
	}
}