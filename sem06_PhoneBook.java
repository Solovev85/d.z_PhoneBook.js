import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод для добавления записи в телефонную книгу
    public void addEntry(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    // Метод для получения всех записей в отсортированном виде
    public List<Map.Entry<String, Set<String>>> getSortedEntries() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        return entries;
    }

    // Метод для вывода всех записей
    public void printPhoneBook() {
        List<Map.Entry<String, Set<String>>> sortedEntries = getSortedEntries();
        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println("Name: " + entry.getKey() + ", Phones: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("Alice", "123-456-7890");
        phoneBook.addEntry("Bob", "234-567-8901");
        phoneBook.addEntry("Alice", "345-678-9012");
        phoneBook.addEntry("Charlie", "456-789-0123");
        phoneBook.addEntry("Bob", "567-890-1234");

        phoneBook.printPhoneBook();
    }
}