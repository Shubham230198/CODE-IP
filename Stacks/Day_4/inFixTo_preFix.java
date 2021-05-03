/*Convert a given inFix expresion into preFix expression.

    For Input:
    A*(B+C)/D
    your output is: 
    /*A+BCD

*/

public class inFixTo_preFix {
    

    /*Using 2-Stacks.
        Time: O(n);
        Space O(n);
    */
    public static int getPriority(char op) {
        
        if(op == '(') {
            return Integer.MIN_VALUE;
        }
        else if(op == '+' || op == '-') {
            return 1;
        }
        else if(op == '*' || op == '/') {
            return 2;
        }
        else {         //if op == '^'
            return 3;
        }
    }
    
    
    //Function to convert an infix expression to a postfix expression.
	public static String infixToPrefix(String exp) {
		Stack<StringBuilder> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		
		for(int i = 0; i < exp.length(); i++) {
		    char ch = exp.charAt(i);
		    
		    if(Character.isLetterOrDigit(ch)) {
		        operands.push(new StringBuilder(ch + ""));
		    }
		    else if(ch == '(') {
		        operators.push(ch);
		    }
		    else if(ch == ')') {
		        while(!operators.isEmpty() && operators.peek() != '(') {
		            StringBuilder val2 = operands.pop();
		            StringBuilder val1 = operands.pop();
		            char op = operators.pop();
		            
		            StringBuilder finalVal = new StringBuilder(op + "");
		            finalVal.append(val1);
		            finalVal.append(val2);
		            
		            operands.push(finalVal);
		        }
		        
		        operators.pop();
		    }
		    else {
		        
		        while(!operators.isEmpty() && getPriority(operators.peek()) >= getPriority(ch)) {
		            StringBuilder val2 = operands.pop();
		            StringBuilder val1 = operands.pop();
		            char op = operators.pop();
		            
		            StringBuilder finalVal = new StringBuilder(op + "");
		            finalVal.append(val1);
		            finalVal.append(val2);
		            
		            operands.push(finalVal);
		        }
		        
		        operators.push(ch);
		    }
		    
		}
		
		while(!operators.isEmpty()) {
		    StringBuilder val2 = operands.pop();
		    StringBuilder val1 = operands.pop();
		    char op = operators.pop();
		    
            StringBuilder finalVal = new StringBuilder(op + "");
            finalVal.append(val1);
            finalVal.append(val2);
		    
		    operands.push(finalVal);
		}
		
		StringBuilder preOrder = operands.pop();
		return preOrder.toString();
	}
    /************************************************************************* */
}
