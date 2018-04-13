import java.util.*;

class StudentListModified
{
	int count;
	String department;
	ArrayList<StudentModified> students;

	StudentListModified(String dept)
	{
		count = 0;
		department = dept;
		students = new ArrayList<StudentModified>();
	}

	void registerStudent()
	{
		StudentModified tempStudent = new StudentModified(department, count);
		students.add(tempStudent);
		count++;
	}

	void marksEntry(int index)
	{
		students.get(index).getMarks();
	}

	void showMarks(int index)
	{
		students.get(index).displayMarkSheet();
	}

	int indexOf(String roll)
	{
		for(int i=0; i<count; i++)
			if(students.get(i).roll.equals(roll))
				return i;
		return -1;
	}

	boolean marksEntered(int index)
	{
		return students.get(index).enteredMarks;
	}

	void sort(ArrayList<StudentModified> students)
	{
		StudentModified temp;
		int i,j,max_index;
		for(i=0; i<students.size(); i++)
		{
			max_index=0;
			for(j=0; j<students.size()-i; j++)
			{
				if(students.get(max_index).totalMarks() < students.get(j).totalMarks())
					max_index = j;
			}
			temp = students.get(max_index);
			students.remove(max_index);
			students.add(temp);
		}
	}

	void sortStudent(String dept)
	{
		int i;
		sort(students);
		System.out.println("Rank List for Department : "+dept);
		System.out.println("==================================================");
		System.out.println("||\tRank\t|\tName\t|\tTotal\t||");
		System.out.println("||----------------------------------------------||");
		for(i=0; i<students.size(); i++)
			System.out.println("||\t"+(i+1)+"\t|\t"+students.get(i).name+"\t|\t"+students.get(i).totalMarks()+"\t||");
		System.out.println("==================================================");
	}

	void removeStudents()
	{
		int i;
		for(i=0; i<students.size(); i++)
			if(students.get(i).hasPassed() == false)
			{	count--;
				students.remove(i);
				i--;
			}
		System.out.println("Screening of Students Done Successfully");
	}

}