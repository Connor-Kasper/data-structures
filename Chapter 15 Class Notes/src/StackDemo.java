import java.util.Stack;

/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
*/
public class StackDemo
{
    public static void main(String[] args)
    {
        Stack<String> commands = new Stack<>();

        // Push a lot of commands on top of the stack
        commands.push("Insert: 'Hello'");
        commands.push("Insert: ','");
        commands.push("Insert: ' ");
        commands.push("Insert: 'World'");
        commands.push("Insert: '?'");
        commands.push("Delete: '?'");
        commands.push("Insert: '!'");

        // print the stack
        System.out.println("Current stack: " + commands);

        // User presses undo button 4 times
        for(int i = 0; i < 4; i++)
        {
            String command = commands.pop();
            System.out.println("Undoing command: " + command);
        }
        System.out.println("Current stack: " + commands);
    }
}
