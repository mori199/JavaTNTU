import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть речення: ");
        String text = scanner.nextLine();

        System.out.print("Яке слово знайти: ");
        String target = scanner.nextLine();

        System.out.print("На яке слово замінити: ");
        String replacement = scanner.nextLine();

        String result = text.replace(target, replacement);

        System.out.println("Результат: " + result);
    }
}
