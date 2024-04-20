import java.util.Scanner;
public class Main {

    public static Key[] userArray = new Key[200];
    public static int size = 0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        while (true) {
            intro();
            int findOrMake = console.nextInt();
            if (findOrMake == 1) {
                makePass(console);
            }
            if(findOrMake == 2) {
                findUser(console);
            }
            else if (findOrMake == 3) {
                overView();
            }
            System.out.println();
        }
    }

    public static void intro() {
        System.out.println("If you need to make a username or password press 1.");
        System.out.println("If you need to find a password press 2.");
        System.out.println("If you need to see the all the keys press 3.");
        System.out.print("Choice: ");
    }

    public static void makePass(Scanner console) {
        System.out.print("Type your website: ");
        String userName = console.next();
        System.out.print("Type your password: ");
        String secret = console.next();
        Key key = new Key(userName, secret);
        userArray[size] = key;
        size++;
    }

    public static void findUser(Scanner console) {
        System.out.print("Write your username to find password: ");
        String userName = console.next();
        for (int i = 0; i < size; i++) {
            Key key = userArray[i];
            if (userName.equals(key.getName())) {
                System.out.print("Password: " + key.getPassword());
                System.out.println();
            }
        }
    }

    public static void overView() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            Key key = userArray[i];
            System.out.print("Website Name: ");
            System.out.println(key.getName());
            System.out.print("Password: ");
            System.out.println(key.getPassword());
            System.out.println();
        }
    }
}