package lab07;

import java.util.*;

//Extension of Chapter 14.4 Case Study: Expression Evaluator

public class Postfixer {


	/**
	*  Determines if the first operator has same or greater
    *  precedence than the second
	*
	* @param op1 the first operator
	* @param op2 the second operator
	* @return the boolean result
	*/
	private static boolean hasPrecedence(String op1, String op2) {
		if (opToPrcd(op1) >= opToPrcd(op2)) {
			return true;
		}
	    return false;
	}

	/**
	* Converts an operator to its precedence priority
	*
	* We expect you to be able to handle +, -, *, /, ^, and (
	* (why don't you need ")" as well? see algorithm in part 4)
	*
	* The order of these is as follows:
	*    ^, * and /, + and -, (
	*
	* @param op a string representing an operator, e.g. "+" or "-"
	* @return an integer value reflecting its precedence
	*/
	private static int opToPrcd(String op) {
		int priority = -1; // Is this an appropriate value to initialize to?
		if(op.equals("^")) {
			priority = 3;
		}
		else if(op.equals("*") || op.equals("/")){
			priority = 2;
		}
		else if(op.equals("+") || op.equals("-")){
			priority = 1;
		}
		else if (op.equals("(")){
			priority = 0;
		}
	    return priority;
	}

	/**
	* determines if the input token is an operator
	*
	* @param token the string token to check
	* @return a boolean reflecting the result
	*/
	private static boolean isOperator(String token) {
		if(token.equals("^") || token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-") || token.equals("(")) {
			return true;
		}
		return false;
	}

	/**
    * Evaluates an expression
    *
    * NOTE Beware the order of pop and evaluation when receiving operand1
    * and operand2 as input.
    *
    * @param operand1 the first operand
    * @param operator the operator to apply
    * @param operand2 the second operand
    * @return a double expressing the result
    * @throws IllegalArgumentException if operator passed is not one of
    *  "+", "-", "*", "/", or "^"
    *
	*/
	private static double evaluate(double operand1, String operator, double operand2){
		double evaluation = 0.0;
		if(operator.equals("+")) {
			evaluation = operand1 + operand2;
		}
		else if(operator.equals("-")) {
			evaluation = operand2 - operand1;
		}
		else if(operator.equals("*")) {
			evaluation = operand1 * operand2;
		}
		else if(operator.equals("/")) {
			evaluation = operand2 / operand1;
		}
		else if(operator.equals("^")) {
			evaluation = Math.pow(operand2, operand1);
		}
		else{
			throw new IllegalArgumentException(); //Is this the correct for to go about this?
		}
		return evaluation;
	}


	/**
	* give a description of the purpose of this method
	* @param line fill in
	* @return fill in
	*/
	public static double infixEvaluator(String line){
		StringSplitter data = new StringSplitter(line); 
		Stack<String> operators = new Stack<String>();  
		Stack<Double> operands = new Stack<Double>();
		while(data.hasNext()) {
			String token = data.next();
			if(token.equals(")")){ 
				while(!operators.peek().equals("(")) {
					double first_operand = operands.pop();
					double second_operand = operands.pop();
					double newEvaluation = evaluate(first_operand,operators.pop(),second_operand);
					operands.push(newEvaluation);
				}
				operators.pop();
			}
			else if(token.equals("(")) {
				operators.push(token);
			}
			else if(isOperator(token)) {
				while(!operators.empty() && hasPrecedence(operators.peek(), token)){ //how do I get around the instance for problem four where it tries to pop two operands when its on the value "(" and only has one operand two pop
					double first_operand = operands.pop();
					double second_operand = operands.pop();
					double newEvaluation = evaluate(first_operand,operators.pop(),second_operand);
					operands.push(newEvaluation);
				}
				operators.push(token);
			}
			else {
				operands.push(Double.parseDouble(token));
			}
		}
		while(!operators.empty()) {
			double first_operand = operands.pop();
			double second_operand = operands.pop();
			double newEvaluation = evaluate(first_operand,operators.pop(),second_operand);
			operands.push(newEvaluation);
		}

		System.out.println(operands.peek());
		return operands.pop();

	}

	/**
	* give a description of the purpose of this method
	* @param line fill in
	* @return fill in
	*/
	public static String toPostfix(String line){
		StringSplitter data = new StringSplitter(line); 
		Stack<String> operators = new Stack<String>();
		String postFix = "";
		while(data.hasNext()) {
			String token = data.next();
			if(!isOperator(token) && !token.equals(")")) { // I dont think data.peek() is referring to the same thing which is giving me problems
				postFix += token;
			}
			else if(isOperator(token)) {
				String current_operator = token;
				while(!token.equals("(") && hasPrecedence(operators.peek(), current_operator)) {
					postFix += operators.pop();
				}
				operators.push(current_operator);
			}
			else if(token.equals("(")) {
				operators.push(token);
			}
			else if(token.equals(")")) {
				while(!operators.peek().equals("(")) {
					postFix += operators.pop();
				}
				operators.pop();
			}
		}
		System.out.println(postFix);
		return postFix; 
	}


	public static void main(String[] args){

        if (infixEvaluator("10 + 2") != 12)
            System.err.println("test0 failed --> your answer should have been 12");

        if (infixEvaluator("10 - 2 * 2 + 1") != 7)
            System.err.println("test1 failed --> your answer should have been 7");

        if (infixEvaluator("100 * 2 + 12") != 212)
            System.err.println("test2 failed --> your answer should have been 212");

        if (infixEvaluator("100 * ( 2 + 12 )") != 1400)
            System.err.println("test3 failed --> your answer should have been 1400");

        if (infixEvaluator("100 * ( 2 + 12 ) / 14") != 100)
            System.err.println("test4 failed --> your answer should have been 100");


        System.out.println("Lab Testing Done!!!");

        /* uncomment the below lines for assignmemt */
		 if (!toPostfix(new String("(4+5)")).equals("45+"))
		     System.err.println("test1 failed --> should have been 45+");

		 if (!toPostfix(new String("((4+5)*6)")).equals("45+6*"))
		     System.err.println("test2 failed --> should have been 45+6*");

		 if (!toPostfix(new String("((4+((5*6)/7))-8)")).equals("456*7/+8-"))
		     System.err.println("test3 failed --> should have been 456*7/+8-");

		 if (!toPostfix(new String("((4+5*(6-7))/8)")).equals("4567-*+8/"))
		     System.err.println("test4 failed --> should have been 4567-*+8/");

		 if (!toPostfix(new String("(9+(8*7-(6/5^4)*3)*2)")).equals("987*654^/3*-2*+"))
		     System.err.println("test5 failed --> should have been 987*654^/3*-2*+");

         System.out.println("Assignment Testing Done!!!");


	}

}
