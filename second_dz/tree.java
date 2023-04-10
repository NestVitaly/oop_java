package second_dz;

import java.util.ArrayList;
import java.util.List;

// Интерфейс человека
interface Person {
    String getName();
    int getBirthYear();
    List<Person> getChildren();
    void addChild(Person child);
}

// Реализация интерфейса "Человек"
class PersonImpl implements Person {
    private String name;
    private int birthYear;
    private List<Person> children;

    public PersonImpl(String name, int berthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBirthYear() {
        return birthYear;
    }

    @Override 
    public List<Person> getChildren() {
        return children;
    }

    @Override
    public void addChild(Person child) {
        children.add(child);
    }
}

public class tree {
    public static void main(String[] args) {
        //Сщздание объектов-людей
        Person Alexey = new PersonImpl("Alexey", 1965);
        Person Sasha = new PersonImpl("Sasha", 1980);
        Person Masha = new PersonImpl("Masha", 2000);
        Person Alina = new PersonImpl("Alina", 1998);

        //Установка родительских связей
        Alexey.addChild(Alina);
        Alexey.addChild(Masha);
        Sasha.addChild(Alina);

        //Вывод инфо о детях Алексея
        System.out.println("Дети Алексея: ");
        List<Person> AlexeyChildren = Alexey.getChildren();
        for (Person child : AlexeyChildren) {
            System.out.println(child.getName() + " (рожден(а) " + child.getBirthYear() + ")");
        }
    }
}