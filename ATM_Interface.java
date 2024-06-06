import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private int pin;
    private double balance;

    public User(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public void checkBalance(int enteredPin) {
        if (enteredPin == pin) {
            System.out.println("Your balance is: " + balance);
        } else {
            System.out.println("Invalid PIN");
        }
    }

    public void withdraw(int enteredPin, double amount) {
        if (enteredPin == pin) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal successful. Your new balance is: " + balance);
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Invalid PIN");
        }
    }

    public void deposit(int enteredPin, double amount) {
        if (enteredPin == pin) {
            balance += amount;
            System.out.println("Deposit successful. Your new balance is: " + balance);
        } else {
            System.out.println("Invalid PIN");
        }
    }
}

public class ATM_Interface {
    private Map<String, User> users;

    ATM_Interface() {
        this.users = new HashMap<>();
    }

    public void createUser(String username, int pin, double balance) {
        users.put(username, new User(pin, balance));
    }

    public void checkBalance(String username, int pin) {
        if (users.containsKey(username)) {
            users.get(username).checkBalance(pin);
        } else {
            System.out.println("User not found");
        }
    }

    public void withdraw(String username, int pin, double amount) {
        if (users.containsKey(username)) {
            users.get(username).withdraw(pin, amount);
        } else {
            System.out.println("User not found");
        }
    }

    public void deposit(String username, int pin, double amount) {
        if (users.containsKey(username)) {
            users.get(username).deposit(pin, amount);
        } else {
            System.out.println("User not found");
        }
    }

    public static void main(String[] args) {
        ATM_Interface atm = new ATM_Interface();
        int usize;

//        atm.createUser("user1", 1234, 1000.0);
//        atm.createUser("user2", 5678, 500.0);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many userdata data you want to add : ");
        usize = scanner.nextInt();
        for(int i =0;i< usize; i++){
            System.out.println("Enter username, pin, balance");
            atm.createUser(scanner.next(), scanner.nextInt(), scanner.nextDouble());
            System.out.println("Data Inserted");
        }
        int option;

        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter PIN: ");
                    int pin = scanner.nextInt();
                    atm.checkBalance(username, pin);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.next();
                    System.out.print("Enter PIN: ");
                    pin = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    atm.withdraw(username, pin, amount);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter username: ");
                    username = scanner.next();
                    System.out.print("Enter PIN: ");
                    pin = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextDouble();
                    atm.deposit(username, pin, amount);
                    System.out.println();
                    break;
                default:
                    System.out.println("Code Exited");
                    break;
            }
        } while( option != 4);
    }
}