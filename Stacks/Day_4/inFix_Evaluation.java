/*InfixEvaluation 

    Note: We are assumming all the expression strings are perfectly balanced. (numtiple digit numbers can be present);


    Test Cases:
     "10 + 2 * 6"            ---> 22
     "100 * 2 + 12"          ---> 212
     "100 * ( 2 + 12 )"      ---> 1400
     "100 * ( 2 + 12 ) / 14" ---> 100   
*/

public class inFix_Evaluation {


    /* Using 2-Stacks
        Time: O(n);
        Space: O(2n);
    */

    public static int operation(int val1, int val2, char op) {
        if(op == '*') {
            return val1 * val2;
        }
        else if(op == '/') {
            return val1 / val2;
        }
        else if(op == '+') {
            return val1 + val2;
        }
        else {
            return val1 - val2;
        }
    }
    
    
    public static int getPriority(char op) {
        
        if(op == '+' || op == '-') {
            return 1;
        }
        else if(op == '*' || op == '/') {
            return 2;
        }
        else {         //if op == '('
            return 0;
        }
    }
    
    
    
    public static int calculate(String s) {
        
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == ' ') {
                continue;
            }
            else if(Character.isDigit(ch)) {
                
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num*10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                
                operands.push(num);
            }
            else if(ch == '(') {
                operators.push(ch);
            }
            else if(ch == ')') {
                
                while(operators.peek() != '(') {
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    char op = operators.pop();
                    
                    int finalVal = operation(val1, val2, op);
                    operands.push(finalVal);
                }
                
                operators.pop();
            }
            else {
                
                while(!operators.isEmpty() && getPriority(operators.peek()) >= getPriority(ch)) {
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    char op = operators.pop();

                    int finalVal = operation(val1, val2, op);
                    operands.push(finalVal);
                }

                operators.push(ch);    

            }

        }
        
        while(!operators.isEmpty()) {
            int val2 = operands.pop();
            int val1 = operands.pop();
            char op = operators.pop();
            
            int finalVal = operation(val1, val2, op);
            operands.push(finalVal);

        }
        
        return operands.pop();
    }

}
