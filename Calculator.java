import java.util.Scanner;

public class Calculator {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter a mathematical expression: ");
String expression = scanner.nextLine();

try {
int result = evaluateExpression(expression);
System.out.println("Result: " + result);
} catch (IllegalArgumentException e) {
System.out.println(e.getMessage());
}
}

private static int evaluateExpression(String expression) {
String[] tokens = expression.split(" ");

if (tokens.length % 2 != 1) {
throw new IllegalArgumentException("Invalid expression format!");
}

int result = Integer.parseInt(tokens[0]);

for (int i = 1; i < tokens.length; i += 2) {
String operator = tokens[i];
int operand = Integer.parseInt(tokens[i + 1]);

switch (operator) {
case "+":
result += operand;
break;
case "-":
result -= operand;
break;
case "*":
result *= operand;
break;
case "/":
if (operand == 0) {
throw new IllegalArgumentException("Division by zero is not allowed!");
}
result /= operand;
break;
default:
throw new IllegalArgumentException("Invalid operator: " + operator);
}
}

return result;
}
}