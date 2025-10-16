import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while(true) {
            System.out.println("\n==== CONTACT MANAGER ====");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. View Contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine().trim();

            switch(choice) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    manager.addContact(name, phone);
                    break;

                case "2":
                    manager.listContacts();
                    if(manager.getSize() > 0) {
                        System.out.print("Enter contact number to remove: ");
                        int index = Integer.parseInt(sc.nextLine()) - 1;
                        if(manager.removeContact(index)) {
                            System.out.println("Contact removed!");
                        } else {
                            System.out.println("Invalid number.");
                        }
                    }
                    break;

                case "3":
                    System.out.println("\nYour Contacts:");
                    manager.listContacts();
                    break;

                case "4":
                    System.out.println("Exiting Contact Manager. Bye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Enter 1-4.");
            }
        }
    }
}
