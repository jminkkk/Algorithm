import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Please write your code here.
        Person[] persons = new Person[5];
        persons[0] = new Person(sc.next(), sc.nextInt());
        persons[1] = new Person(sc.next(), sc.nextInt());
        persons[2] = new Person(sc.next(), sc.nextInt());
        persons[3] = new Person(sc.next(), sc.nextInt());
        persons[4] = new Person(sc.next(), sc.nextInt());

        Person person = Arrays.stream(persons)
            .sorted(Comparator.comparing(Person::getScore))
            .findFirst()
            .get();
        System.out.println(person.toString());
    }
}

class Person {
    String name;
    int score;

    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return name + " " + score;
    }
}