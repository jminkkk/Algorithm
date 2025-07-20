import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        String[] addresses = new String[n];
        String[] regions = new String[n];

        PriorityQueue<Person> persons = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            addresses[i] = sc.next();
            regions[i] = sc.next();
            persons.add(new Person(names[i], addresses[i], regions[i]));
        }
        Person person = persons.remove();
        System.out.println(person.toString());
    }
}

class Person implements Comparable<Person> {
    String name;
    String region;
    String addresse;

    public Person(String name, String region, String addresse) {
        this.name = name;
        this.region = region;
        this.addresse = addresse;
    }

    public int compareTo(Person person) {
        return person.name.compareTo(this.name);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name ").append(name).append("\n");
        sb.append("addr ").append(region).append("\n");
        sb.append("city ").append(addresse);

        return sb.toString();
    }
}