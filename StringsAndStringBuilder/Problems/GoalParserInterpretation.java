public class GoalParserInterpretation {

    // This method converts the command into its interpreted string.
    public static String interpret(String command) {

        StringBuilder result = new StringBuilder();

        // Traverse the command string.
        for (int i = 0; i < command.length(); i++) {

            // If the current character is 'G', append 'G'.
            if (command.charAt(i) == 'G') {
                result.append("G");
            }

            // If we find "()", append 'o'.
            else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                result.append("o");
                i++; // Skip the next character ')'
            }

            // Otherwise, it must be "(al)", so append "al".
            else if (command.charAt(i) == '(' &&
                    command.charAt(i + 1) == 'a') {

                result.append("al");
                i += 3; // Skip 'a', 'l', ')'
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        // Example 1
        String command = "G()(al)";
        System.out.println("Command : " + command);
        System.out.println("Output  : " + interpret(command));

        // Example 2
        command = "G()()()()(al)";
        System.out.println("\nCommand : " + command);
        System.out.println("Output  : " + interpret(command));

        // Example 3
        command = "(al)G(al)()()G";
        System.out.println("\nCommand : " + command);
        System.out.println("Output  : " + interpret(command));
    }
}