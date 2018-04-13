import java.util.*;

class Stack{

	char arr[];
	int top;
	int len;

	Stack(int n){
		len=n;
		arr=new char[n];
		top=-1;
	}

	boolean isFull(){
		return ((top+1)==len);
	}

	boolean isEmpty(){
		return (top==-1);
	}

	void push(char e){
		if(isFull())
			System.out.println("Stack overflow");
		else
			arr[++top]=e;
	}

	char pop(){
		if(isEmpty()){
			System.out.println("Stack underflow");
			return '?';
		}
		else
			return arr[top--];
	}

	void peek(){
		if(isEmpty())
			System.out.println("Stack underflow");
		else
			System.out.println("Top element is : "+arr[top]);
	}

	void display(){
		if(isEmpty())
			System.out.println("Stack empty");
		else{
			
			for(int i=top;i>=0;i--)
				System.out.print(arr[i]);
			System.out.println();
		}
	}
}
class Parenthesis{
	static Stack st;
	static String s;
	Parenthesis(int n){
		st=new Stack(n);
	}

	void read(){
		System.out.println("please Enter string: ");
		System.out.print("String: ");
		Scanner sc=new Scanner(System.in);
		s=sc.nextLine();
		st=new Stack(s.length()); 
	}

	int getPrecedence(char c){
		if(c=='[')
			return 1;
		if(c=='{')
			return 2;
		if(c=='(')
			return 3;
		return -1;
	}

	boolean match(char c1, char c2){
		return ((c1=='(' && c2==')') || (c1=='{' && c2=='}') || (c1=='[' && c2==']'));
	}

	boolean check(){
		char ch,ch2;
		for(int i=0;i<s.length();i++){
			ch=s.charAt(i);
			if(ch=='(' || ch=='{' || ch=='['){
				st.push(ch);
			}
			else if(ch==')' || ch=='}' || ch==']'){
				if(st.isEmpty())
					return false;
				else{
					ch2=st.pop();
					
					if(!match(ch2,ch))
						return false; //if brackets are mismached, then failure.
				}
			}
			
		}
		return (st.isEmpty()); //correct parenthesis match means stack should be empty outside loop
	}

	public static void main(String args[]){
		Parenthesis p=new Parenthesis(1);
		Scanner sc=new Scanner(System.in);
		int ch;
		boolean res;
		do{
			p.read();
			System.out.println(s);
			res=p.check();
			System.out.println((res)?"Parentheses match":"Parentheses don't match");
			System.out.print("Press N to stop and any other key to continue: ");
			ch=(sc.next()).charAt(0);
			if(ch=='n' || ch=='N'){
				System.out.println("***********Thank You*********");
				break;
			}
		}while(true);
	}
}
