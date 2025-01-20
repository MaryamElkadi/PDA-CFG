import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

public class PDA {

    // PDA for accepting a^n b^n, n >= 0
    public static boolean acceptLanguage1(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == 'a') {
                stack.push(c); 
            } else if (c == 'b') {
                if (!stack.isEmpty() && stack.peek() == 'a') {
                    stack.pop(); 
                } else {
                    return false; 
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty(); 
    }
    
    

    public static boolean acceptLanguage2(String input) {
        int countA = 0, countB = 0;
        for (char c : input.toCharArray()) {
            if (c == 'a') {
                countA++;
            } else if (c == 'b') {
                countB++;
            } else {
                return false;
            }
        }
        return countA % 2 == 0 && countB % 3 == 0 && countA != 0;
    }
    
    // PDA for balanced brackets
    public static boolean acceptLanguage3(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '{') {
                stack.push(c); // Push '{' onto the stack
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop(); // Pop '{' from the stack
                } else {
                    return false; // Unbalanced or extra '}'
                }
            }
        }
        return stack.isEmpty(); // Stack should be empty at the end
    }
    // PDA for a^n b^m c^n, n, m >= 1
    public static boolean acceptLanguage4(String input) {
        Stack<Character> stack = new Stack<>();
    
        for (char c : input.toCharArray()) {
            if (c == 'a') {
                stack.push('a');
            } else if (c == 'b') {
                if (stack.isEmpty() || stack.peek() != 'a') {
                    return false; // 'a' missing before 'b'
                }
                stack.pop(); // Match 'a' with 'b'
                stack.push('b');
            } else if (c == 'c') {
                if (stack.isEmpty() || stack.peek() != 'b') {
                    return false; // 'b' missing before 'c'
                }
                stack.pop(); // Match 'b' with 'c'
            } else {
                return false; // Other characters are not allowed
            }
        }
    
        // Ensure all 'a' and 'b' are matched
        return stack.isEmpty();
    }
    
    
    
    
   public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("F:\\MaryamWork\\University\\forth_term2\\Theory_of_compution\\Assignmenta\\Assigment3\\20206049_20206150_20206160_S1\\PDA\\CODE\\input.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

            String line;
            int problemNumber = 0;
            while ((line = br.readLine()) != null) {
                if (line.equals("end")) {
                    pw.println("end");
                    continue;
                }

                if (line.matches("\\d+")) {
                    problemNumber = Integer.parseInt(line);
                    pw.println(problemNumber); // Print problem number
                    continue;
                }

                switch (problemNumber) {
                    case 1:
                        if (acceptLanguage1(line))
                            pw.println("accepted");
                        else
                            pw.println("not accepted");
                        break;
                    case 2:
                        if (acceptLanguage2(line))
                            pw.println("accepted");
                        else
                            pw.println("not accepted");
                        break;
                    case 3:
                        if (acceptLanguage3(line))
                            pw.println("accepted");
                        else
                            pw.println("not accepted");
                        break;
                    case 4:
                        if (acceptLanguage4(line))
                            pw.println("accepted");
                        else
                            pw.println("not accepted");
                        break;
                    default:
                        break;
                }
            }

            br.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
