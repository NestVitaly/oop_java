package three_dz;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Интерфейс человека
interface Person<T extends Person> {
    String getName();
    int getBirthYear();
    List<T> getChildren();
    void addChild(T child);
    boolean test(Predicate<T> predicate); //добавлен интерфейс для проверки условий
}

// Реализация интерфейса "Человек"
class PersonImpl implements Person {
    private String name;
    private int birthYear;
    private List<Person> children;

    public PersonImpl(String name, int birthYear) {
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

    @Override
    public boolean test(Predicate predicate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'test'");
    }
}

public class code_rewew {
    public static void main(String[] args) {
        //Сщздание объектов-людей
        GenealogyManager manager = new GenealogyManager();
        manager.addPerson(new PersonImpl("Alexey", 1965));
        manager.addPerson(new PersonImpl("Sasha", 1980));
        manager.addPerson(new PersonImpl("Masha", 2000));
        manager.addPerson(new PersonImpl("Alina", 1998));

        //Установка родительских связей
        manager.setChild("Alexey", "Alina");
        manager.setChild("Alexey", "Masha");
        manager.setChild("Sasha", "Alina");

        //Вывод инфо о детях Алексея
        System.out.println("Дети Алексея: ");
        List<Person> AlexeyChildren = manager.getChildren("Alexey");
        for (Person child : AlexeyChildren) {
            System.out.println(child.getName() + " (рожден(а) " + child.getBirthYear() + ")");
        }
    }
}

class GenealogyManager<T extends Person> {
    private List<T> people;
    public GenealogyManager() {
        this.people = new ArrayList<>();
    }

    public void addPerson(T person) {
        people.add(person);
    }
    public void setChild(String parentName, String childName) {
        T parent = findPersonByName(parentName);
        T child = findPersonByName(childName);
        if (parent != null && child != null) {
            parent.addChild(child);
        }
    }

    public List<T> getChildren(String parentName) {
        T parent = findPersonByName(parentName);
        if (parent != null) {
            return (List<T>) parent.getChildren();
        } else {
            return new ArrayList<>();
        }
    }

    private T findPersonByName(String name) {
        for (T person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
}

