import java.util.Scanner;

public class Sub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть речення: ");
        String text = scanner.nextLine();

        String NoNum = text.replaceAll("\\d+", "");
        String[] words = NoNum.split("\\s+");

        int countV = 0;
        System.out.println("Слова з непарною к-тю приголосних:");

        for (String word : words) {
            if (word.isEmpty()) continue;

            String low = word.toLowerCase();

            if (startsV(low)) {
                countV++;
            }

            int conso = countC(low);

            if (conso % 2 == 1) {
                System.out.println(word);
            }
        }
        System.out.println("К-ть слів що починаються з голосної: " + countV);
        System.out.println("Текст без чисел: " + NoNum);

    }
    public static boolean startsV(String word){
        String vow = "аіеєиїюояю";
        return vow.indexOf(word.charAt(0)) != -1;
    }
    public static int countC(String word){
        String vow = "аіеєиїюояю";
        int count = 0;

        for (char c : word.toCharArray()){
            if (Character.isLetter(c) && vow.indexOf(c) == -1){
                count++;
            }
        }
        return count;
    }
}
