import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("F:\\MaryamWork\\University\\forth_term2\\Theory_of_compution\\Assignmenta\\Assigment3\\20206049_20206150_20206160_S1\\CFG\\input_cfg.txt"));
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
                        if (problem1(line))
                            pw.println("accepted");
                        else
                            pw.println("not accepted");
                        break;
                    case 2:
                        if (problem2(line))
                            pw.println("accepted");
                        else
                            pw.println("not accepted");
                        break;
                    case 3:
                        if (problem3(line))
                            pw.println("accepted");
                        else
                            pw.println("not accepted");
                        break;
                    case 4:
                        if (problem4(line))
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

    public static boolean problem1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == 'a')
                stack.push(c);
            else if (c == 'b') {
                if (stack.isEmpty() || stack.pop() != 'a')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean problem2(String s) {
        int aCount = 0;
        int bCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a')
                aCount++;
            else if (c == 'b')
                bCount++;
        }
        return aCount == 2 * bCount;
    }

    public static boolean problem3(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static boolean problem4(String s) {
        int aCount = 0, bCount = 0;
        boolean foundB = false;
        
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                if (foundB) // 'a' occurs after 'b', not in the right format
                    return false;
                aCount++;
            } else if (c == 'b') {
                foundB = true;
                bCount++;
            } else {
                return false; // other characters are not allowed
            }
        }
    
        // Check if the count of 'a's is 2n+3 and 'b's is n
        return aCount == 2 * bCount + 3;
    }
}
