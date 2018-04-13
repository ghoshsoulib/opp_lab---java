import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import directory_size.*;

class fileComparatorDate implements Comparator<File> { 
	@Override
	public int compare(File a, File b) { 
		return -Long.valueOf(a.lastModified()).compareTo(Long.valueOf(b.lastModified()));	
	}
}

class fileComparatorSize implements Comparator<File> { 
	@Override
	public int compare(File a, File b) {
		return -Long.valueOf(DirectorySize.getSize(a)).compareTo(Long.valueOf(DirectorySize.getSize(b)));
	}
}

class Main_FileSort {
	ArrayList<File> files = new ArrayList<File> ();
	
	void CreateList(String source) { 
		File path = new File(source);
		File[] fileList = path.listFiles();
		for(File file : fileList) { 
			files.add(file);
		}
	}
	
	void sortByName() { 
		Collections.sort(files);
	}
	
	void sortByDate() { 
		Collections.sort(files, new fileComparatorDate());
	}
	
	void sortBySize() {
		Collections.sort(files , new fileComparatorSize());
	}
	
	String convertToSimpleDateFormat(File f) {
		long lm = f.lastModified();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String result = sdf.format(lm);
		return result;
	}
	
	void displayUtil() {
		for(int i = 0; i < 100; i++) {
			System.out.print("=");
			if(i == 99)
				System.out.println();
		}
		System.out.printf("%-30s %-25s %-10s\n", "Name", "Last Modified", "Size(KB)");
		for(int i = 0; i < 100; i++) {
			System.out.print("=");
			if(i == 99)
				System.out.println();
		}
	}
	
	void display_simple() {
		displayUtil();
		for(File f: files) {
			System.out.printf("%-30s %15s %10d  KB\n",f.getName(), convertToSimpleDateFormat(f), (DirectorySize.getSize(f) / 1024));			
		}
	}
	
	void display_nested_structure(ArrayList<File> files, int indent) {
		for(File f:files) {
			for(int i = 0; i < indent; i++)
				System.out.print("\t");
			System.out.printf("%-30s %15s %10d  KB\n",f.getName(), convertToSimpleDateFormat(f), (DirectorySize.getSize(f) / 1024));
			if(f.isDirectory()) {
				ArrayList<File> inner = new ArrayList<File>();
				File[] inner_array = f.listFiles();
				for(File inner_file : inner_array) {
					inner.add(inner_file);
				}
				display_nested_structure(inner, indent + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the directory path");
		String src;
		do{
			src = scan.nextLine();
			File path = new File(src);
			if(!path.exists() || !path.isDirectory())
				System.out.println("Directory does not exist. enter again");
			else
				break;
		} while(true);
		
		FileSort1 fs = new FileSort1();
		
		fs.CreateList(src);
		
		if(fs.files.size() == 0)
			System.out.println("Directory is empty");
		else if(args.length == 0){
			fs.sortByName();
			fs.display_simple();
			//fs.display_nested_structure(fs.files, 0);
		} else if(args.length == 1){
			if(args[0].equals("-d")) {
				fs.sortByDate();
				fs.display_simple();
				//fs.display_nested_structure(fs.files, 0);
			} else if(args[0].equals("-s")){
				fs.sortBySize();
				fs.display_simple();
				//fs.display_nested_structure(fs.files, 0);
			} else
				System.out.println("Argument Error");
		} else
			System.out.println("Argument Error");
		scan.close();
	}	
} 
