import java.util.Scanner;

public class VotingClient {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Voting System =====");
            System.out.println("1. Voter Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Register Voter");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    voterLogin();
                    break;
                case 2:
                    adminLogin();
                    break;
                case 3:
                    registerVoter();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void voterLogin() {
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (DatabaseHelper.validateVoter(email, password)) {
            System.out.println("Login successful! You can now vote.");
            vote();
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private static void adminLogin() {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (DatabaseHelper.validateAdmin(username, password)) {
            System.out.println("Admin Login successful!");
            adminDashboard();
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private static void registerVoter() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        DatabaseHelper.addVoter(name, email, password);
        System.out.println("Voter registered successfully!");
    }

    private static void adminDashboard() {
        while (true) {
            System.out.println("\n===== Admin Dashboard =====");
            System.out.println("1. Add Candidate");
            System.out.println("2. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter Candidate Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Party: ");
                String party = scanner.nextLine();
                DatabaseHelper.addCandidate(name, party);
                System.out.println("Candidate added successfully!");
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void vote() {
        System.out.print("Enter Voter ID: ");
        int voterId = scanner.nextInt();
        System.out.print("Enter Candidate ID: ");
        int candidateId = scanner.nextInt();
        DatabaseHelper.vote(voterId, candidateId);
        System.out.println("Vote cast successfully!");
    }
}
