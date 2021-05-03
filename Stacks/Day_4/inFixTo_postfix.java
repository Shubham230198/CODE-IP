/*Convert a given inFix expresion to postFix expression.

    Given an infix expression in the form of string str. Convert this infix expression to postfix expression.

    Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
    Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
    â€‹Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. 


    Input: str = "A*(B+C)/D"
    Output: ABC+*D/
    Explanation:
    After converting the infix expression 
    into postfix expression, the resultant 
    expression will be ABC+*D/

*/

public class inFixTo_postfix {
    

    /*Using 2 stacks.
        Time: O(exp.length());
        Space: O(exp.length());
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
	public static String infixToPostfix(String exp) {
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
		            
		            StringBuilder finalVal = new StringBuilder(val1);
		            finalVal.append(val2);
		            finalVal.append(op);
		            
		            operands.push(finalVal);
		        }
		        
		        operators.pop();
		    }
		    else {
		        
		        while(!operators.isEmpty() && getPriority(operators.peek()) >= getPriority(ch)) {
		            StringBuilder val2 = operands.pop();
		            StringBuilder val1 = operands.pop();
		            char op = operators.pop();
		            
		            StringBuilder finalVal = new StringBuilder(val1);
		            finalVal.append(val2);
		            finalVal.append(op);
		            
		            operands.push(finalVal);
		        }
		        
		        operators.push(ch);
		    }
		    
		}
		
		while(!operators.isEmpty()) {
		    StringBuilder val2 = operands.pop();
		    StringBuilder val1 = operands.pop();
		    char op = operators.pop();
		    
		    StringBuilder finalVal = new StringBuilder(val1);
		    finalVal.append(val2);
		    finalVal.append(op);
		    
		    operands.push(finalVal);
		}
		
		StringBuilder postOrder = operands.pop();
		return postOrder.toString();
	} 
    /************************************************************************************ */
}
