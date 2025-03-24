package mcr.account;

public class Client {
    private String firstName;
    private String lastName;
    private int id;
    private static int idCounter = 0;
    private Account account;
    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = ++idCounter;
    }

    public Account getAccount() {
        return account;
    }

    public String toString() {
        return firstName + " " + lastName;
    }
}
