import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Välkommen till menyn! Här kan du göra massor.");
        System.out.println("Vad vill du göra?");
        System.out.println("1. Addera två tal");
        System.out.println("2. Räkna bokstäver i en sträng");
        System.out.println("3. Spegelvänd en sträng");
        System.out.println("4. Summera alla tal i en sträng");
        System.out.println("5. Ta reda på om ordet är en palindrom");
        System.out.println("6. Fibonaccital till n-plats");
        System.out.println("e. Avsluta");

        Scanner sc = new Scanner(in);

        //Loop-container: allt inuti loopen körs om och om tills man matar in "e"
        while (true) {
            String choice = String.valueOf(sc.nextLine());
            if (choice.equals("1")) {
                System.out.println("Här adderar vi två tal");
                System.out.println("Ange första talet:");
                int first = parseInt(sc.nextLine());
                System.out.println("Ange andra talet:");
                int second = parseInt(sc.nextLine());
                System.out.println("Summan är " + sum(first, second));
            } else if (choice.equals("2")) {
                System.out.println("Ange ord du vill leta i: ");
                String word = String.valueOf(sc.nextLine());
                System.out.println("Ange bokstaven du vill leta efter: ");
                char c = sc.nextLine().charAt(0);
                int number = numberOfCharacters(word, c);
                System.out.println("Det finns " + number + " " + "'" + c +  "'" + " i " + word);
            } else if (choice.equals("3")) {
                System.out.println("Skriv in en sträng: ");
                String inputString = String.valueOf(sc.nextLine());
                mirror(inputString);
            } else if (choice.equals("4")) {
                System.out.println("Skriv in en sträng");
                String inputString = String.valueOf(sc.nextLine());
                System.out.println(sumOfElements(inputString));
            } else if (choice.equals("5")) {
                out.println("Skriv in ett ord");
                String inputString = String.valueOf(sc.nextLine());
                System.out.println("Är ordet en palindrom?");
                System.out.println(palindrom(inputString));
            } else if (choice.equals("6")) {
                out.println("Skriv in ett tal");
                int number = Integer.parseInt((sc.nextLine()));
                out.println(fibonacci(number));
            } else if (choice.equals("e")) {
                System.out.println("Hej då!");
                break;
            }
            System.out.println("Vad vill du göra nu?");
        }

    }

    static int sum (int first, int second) {
        return first + second;
    }

    //Counter genom ordets längd i for-loopen; lagrar bokstaven i temp. If-satsen ökar bokstavens counter om temp == c (inmatad).
    static int numberOfCharacters (String word, char c) {
        int totalChars = 0;
        char temp;
        for (int i = 0; i < word.length(); i++) {
            temp = word.charAt(i);
            if (temp == c) {
                totalChars++;
            }
        }
        return totalChars;

    }

    //for-loopen räknar ordets längd baklänges. I rev lagras bokstäverna.
    static void mirror (String word) {
        String rev = "";
        for (int i = word.length()-1; i >= 0; i--) {
            rev = rev + word.charAt(i);
        }
        System.out.println(rev);
    }

    //Splittrar inmatad sträng och lagrar den i en String-lista (numberList).
    static int sumOfElements (String input) {
        String[] numberList = input.split("");

        //Definierar en integer-array som ska lagra varenda tal
        ArrayList<Integer> intList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            //Parsear strängen och lagrar tal i integer-array:n
            intList.add(parseInt(numberList[i]));
            //Summerar array:ns index
            sum = sum + intList.get(i);
        }
        return sum;
    }

    static boolean palindrom (String word) {
        for (int i = 0; i < word.length() * 0.5; i++) {
            if (word.charAt(i) != word.charAt(word.length()-i-1)) {
                //System.out.println("Ordet är inte en palindrom");
                return false;
            }
        }
        return true;
    }

    static int fibonacci (int number) {
        int first = 0, second = 1;
        for (int i = 1; i <= number; i++) {
            out.print(first + ", ");
            int next = first + second;
            first = second;
            second = next;
        }
        return first;
    }

}
