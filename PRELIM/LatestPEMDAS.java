import java.util.*;
public class LatestPEMDAS {
    static boolean pChecker = false;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Equation: ");
        String equation = scan.nextLine().trim();

        equation = parenthesesChecker(equation);

        if(equation.contains("+") || equation.contains("-")) equation = Eval(equation);
        else if(equation.contains("*") || equation.contains("/")) equation = Double.toString(evaluateTermWithPrecedence(equation));
        equation = Eval(equation);
        if((int) Double.parseDouble(equation) == Double.parseDouble(equation))
            System.out.printf("Result: %d", (int) Double.parseDouble(equation));
        else{
            System.out.printf("Result: %.2f", Double.parseDouble(equation));
        }
    }
    static String parenthesesChecker(String equation){
        for(int i = equation.length()-1; i >= 0; i--){
            if(equation.charAt(i)=='('){
                for(int j = i; j < equation.length(); j++){
                    if(equation.charAt(j) == ')'){
                        String result = Eval(equation.substring(i+1, j));
                        equation = equation.replace(equation.substring(i, j+1), result);
                        pChecker = true;
                        break;
                    }
                }
            }
        }
        return equation;
    }
    static String Eval(String e){
        String[] terms = e.split("[+-]");
        double result = 0;
        boolean addTerm = true;
        for(int i= 0; i< terms.length;i++){
            // Example: 45*6*(7-18)/23 -> 6/9*(45*6*-11/23)
            // IF statement para kung may "*" or "/" sa pinaka ulihan sa usa ka element like 45*6* or 3*5/
            // kay gi split man tungod sa minus sang -11... ang array mahimo nga [45*6*, 11/23]
            if(terms[i].length()-1>0 && (terms[i].charAt(terms[i].length()-1)=='*'
                ||  terms[i].charAt(terms[i].length()-1)=='/' ||  terms[i].charAt(terms[i].length()-1)=='^')){
                terms[i] += "-"+terms[i+1]; // ini nga line iya gi merge ang duwa ka element na nasayop pag split...
                                            // from [45*6*, 11/23] to [45*6*-11/23, 11/23]

                for(int j=i+1;j<terms.length-1;j++){    // ini nga for loop tig move lang sang mga elements to the left..
                    terms[j] = terms[j+1];              // like [ ,1,2,3,4] to [1,2,3,4,4]
                }                                       // for safety measures lng ni nga for loop in case may extra element

                String[] tempTerms = new String[terms.length-1]; // temporary array para tig contain sa bag o na array
                                                                 // pero ang size sini na array kay 1 lower compared
                                                                 // sa original na array

                for (int j = 0; j < terms.length - 1; j++) {    // ini nga for loop para na ni tig erase sa pinaka last na element
                    tempTerms[j] = terms[j];                    // gamit na ang temporary na array na wa pa sang unod..
                }                                               // example ang original na array ara sang [1,2,3,4,4],
                                                                // gicopy ang unod sang original array didto sa temporary array
                                                                // pero wa na gi apil ang last element

                terms = tempTerms; // ini nga line kay gicopy ang unod sa tempTerms didto na sa original na array

                //GIBUHAT NI KAY DI NA KAILANGAN ADTONG GIMERGED NA ELEMENT LIKE SA EXAMPLE SA TAAS..
                // "from [45*6*, 11/23] to [45*6*-11/23, 11/23]" ANG 11/23
                // so ang final na nga array kay [45*6*-11/23] instead nga [45*6*, 11/23]
            }
        }
        if(terms[0].isEmpty() && terms.length==2) return e;
        for(int i = 0; i< terms.length; i++) {
            if(terms[i].isEmpty()) {
                terms[i]="0";
                terms[i+1]= "-"+terms[i+1];
            }
        }
        int index = 0;
        for (String term : terms) {
            double termValue = evaluateTermWithPrecedence(term);
            if (addTerm) result += termValue;
            else result -= termValue;

            if (e.indexOf(term) + term.length() < e.length()) {
                index+=e.indexOf(term) + term.length();
                if(index>=e.length())index--;
                char nextOperator = e.charAt(index);
                if(index+1<e.length())index++;
                if (nextOperator == '+') addTerm = true;
                else if (nextOperator == '-') addTerm = false;
            }
        }
        return Double.toString(result);
    }

    static double evaluateTermWithPrecedence(String term) {
        String[] factors = term.split("[*/]");
        for(int i = 0; i<factors.length; i++) {
            if((int)exponentEvaluator(factors[i])==exponentEvaluator(factors[i]))
                factors[i] = Integer.toString((int)exponentEvaluator(factors[i]));
            else factors[i] = Double.toString(exponentEvaluator(factors[i]));
        }
        double result;
        result= Double.parseDouble(factors[0]);

        for (int i = 1; i < factors.length; i++) {
            int sameValueChecker = 0;
            for(int j = i-1; j>=0;j--){
                if(factors[i].equals(factors[j])) sameValueChecker++;
            }
            char operator;
            if(sameValueChecker!=0) operator = term.charAt(term.indexOf(factors[i],
                    term.indexOf(factors[i])+sameValueChecker*(factors[i].length())) - 1);
            else operator = term.charAt(term.indexOf(factors[i]) -1);
            double operand = Double.parseDouble(factors[i]);

            if (operator == '*') result *= operand;
            else if (operator == '/') {
                if (operand == 0) {
                    System.out.println("Error: Division by zero");
                    System.exit(1);
                }
                result /= operand;
            }
        }
        return result;
    }
    static double exponentEvaluator(String factor){
       double result = 1;
       String[] values = factor.split("\\^");
       for(int i = values.length-1; i>=0; i--){
         result = Math.pow(Double.parseDouble(values[i]),result); 
       }
       return result;
    }
}
