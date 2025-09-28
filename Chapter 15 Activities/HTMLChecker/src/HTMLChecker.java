import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
 */
public class HTMLChecker {
    public static void main(String[] args) {
        // You can change this to test other files like TagSample2.html, etc.
        String filename = "TagSample1.html";

        System.out.println("Checking file: " + filename);

        try (Scanner in = new Scanner(new File(filename))) {
            // Your code goes here
            Stack<String> tagStack = new Stack<>();

            while (in.hasNext()) {
                String tag = in.next();

                // If it's an opening tag, push it onto the stack.
                if (!tag.startsWith("</")) {
                    tagStack.push(tag);
                }
                // If it's a closing tag...
                else {
                    // Check for an error: closing tag with no corresponding opening tag.
                    if (tagStack.size() == 0) {
                        System.out.println("Error: No opening tag for " + tag);
                        return; // Stop processing
                    }

                    // Pop the top opening tag from the stack.
                    String openTag = tagStack.pop();

                    // Extract the tag names for comparison (e.g., "p" from "<p>" and "</p>")
                    String openTagName = openTag.substring(1, openTag.length() - 1);
                    String closeTagName = tag.substring(2, tag.length() - 1);

                    // Check for a mismatch error.
                    if (!openTagName.equals(closeTagName)) {
                        System.out.println("Error: Tag mismatch. Expected </" + openTagName + ">, but found " + tag);
                        return; // Stop processing
                    }
                }
            }

            // After processing the file, check if any tags were left unclosed.
            if (tagStack.size() == 0) {
                System.out.println("HTML tags are properly nested.");
            } else {
                System.out.println("Error: Unclosed tag(s) remaining. Top of stack: " + tagStack.pop());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + filename);
        }
    }
}
