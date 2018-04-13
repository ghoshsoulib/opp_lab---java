class StudentList
{
	int count;
	Student students[];

	StudentList()
	{
		count = 0;
		students = new Student[100];
	}

	void registerStudent(String roll)
	{
		students[count++] = new Student(roll);
	}

	void marksEntry(int index)
	{
		students[index].getMarks();
	}

	void showMarks(int index)
	{
		students[index].displayMarkSheet();
	}

	int indexOf(String roll)
	{
		for(int i=0; i<count; i++)
			if(students[i].roll.equals(roll))
				return i;
		return -1;
	}

	boolean marksEntered(int index)
	{
		return students[index].enteredMarks;
	}
}