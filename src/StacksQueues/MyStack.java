package StacksQueues;

import java.time.format.ResolverStyle;
import java.util.ListIterator;
import java.util.Stack;

public class MyStack {
	
// Reversing a string using a stack 
	public static String reversString(String s){
		Stack<Object> st = new Stack<Object>();
		String res = "";
		for(int i = 0; i < s.length() ; i++){
			st.push(s.charAt(i));
		}
		for(int i = 0; i < s.length() ; i++){
			res += st.pop();
		}
		return res;
	}
	

	
// Check for balanced parenthese in an expression using a stack
	public static boolean check(String exp){
		Stack<Object> st = new Stack<Object>();
		for(int i = 0; i < exp.length(); i++){
			if( exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) =='['){
				st.push(exp.charAt(i));
				continue;
			}
			if(st.empty())
				return false;
			switch (exp.charAt(i)){
			case ')':
				char c = (char) st.pop();
				if ( c == '{' || c =='[')
					return false;
				break;
			case '}':
				char c1 = (char) st.pop();
				if ( c1 == ')' || c1 =='[')
					return false;
				break;
			case ']':
				char c11 = (char) st.pop();
				if ( c11 == '{' || c11 ==')')
					return false;
				break;
			}
		}
		return (st.empty());
	}
// converting infix expression to postfix 
	public static int precedence(char ch){
		switch (ch){
		case '+' :
		case '-' :
			return 1;
		case '*' :
		case '/' :
			return 2;
		case '^':
			return 3;
		
		}
		return -1;
	}
	
	public static String infixToPostfix(String exp){
		String res = new String("");
		Stack<Object> st = new Stack<Object>();
		for(int i = 0; i < exp.length(); i++){
			char c = exp.charAt(i);
			if(Character.isLetterOrDigit(c))
				res += c;
			else if( c == '(')
				st.push(c);
			else if ( c == ')'){
				while (!st.empty() && (char) st.peek() != '(')
					res += st.pop();
				if( !st.empty() && (char) st.peek() != '(')
					return "Invalid Expression";
				else
					st.pop();
			}
			else {
				while ( !st.empty() && precedence(c) <= precedence((char) st.peek())){
					if((char) st.peek() == '(')
						return "Invalid Expression";
					res += st.pop();
				}
				st.push(c);
			}
		}
		while(!st.empty()){
			if((char) st.peek() == '(')
				return "Invalid Expression";
			res += st.pop();
		}
		return res;
	}
// Sort a stack using recursion
	public static void sortStack(Stack<Integer> s){
		if(!s.empty()){
			int temp = (int) s.pop();
			sortStack(s);
			sortedInsert(s, temp);
		}
	}
	
	public static void sortedInsert(Stack<Integer> s,int element){
		if(s.empty() || (int) s.peek() < element )
			s.push(element);
		else{
			int temp = (int) s.pop();
			sortedInsert(s, element);
			s.push(temp);
		}
	}
	
	public static void printStack(Stack<Integer> s){
		ListIterator lt = s.listIterator();
		while(lt.hasNext())
			lt.next();
		while(lt.hasPrevious())
			System.out.print(lt.previous() + " ");
	}
	// main function
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(5);
		stack.push(1);
		stack.push(20);
	/// end of filling the stack 
		System.out.println("the stack is empty : " + stack.empty());
		System.out.println("what is the position of  the value 1 in the stack :" +stack.search(1));
		System.out.println("is the value 6 exist in the stack :" +stack.contains(6));
		System.out.println("the top of the stack is :" + stack.peek());
		System.out.println("applying toString to a stack : "+stack.toString());
	
		System.out.println("revers (mohamed) :"+reversString("mohamed"));
		
		String exp = "{{()}}[[]]";
		System.out.println("this expression {{()}}[[]] is  :"+check(exp));
	
		String str = "a+b*(c^d-e)^(f+g*h)-i"; 
        System.out.println(infixToPostfix(str)); 
        
        printStack(stack);
        sortStack(stack);
        System.out.println();
        printStack(stack);
	}
}
