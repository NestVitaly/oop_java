package first_dz;

import java.util.ArrayList;

public class wood{
    public class Person {
        private String name;
        private Integer birthYear;
        private ArrayList<Person> children;
        private Person mother;
        private Person father;
        
        public Person(String name, Integer berthYear) {
            this.name = name;
            this.birthYear = birthYear;
            this.children = new ArrayList<Person>();
        }

        public String getName() {
            return name;
        }

        public int getBirthYear() {
            return birthYear;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void addChild(Person child) {
            this.children.add(child);
            child.setMother(this);
            child.setFather(this);
        }

        public ArrayList<Person> getChildren() {
            return children;
        }

        public Person getMother() {
            return mother;
        }

        public Person getFather() {
            return father;
        }

        public boolean isSibling(Person person) {
            if (mother != null && father != null) {
                return mother.getChildren().contains(person) && father.getChildren().contains(person);
            }
            return false;
        }

        public boolean isDescedant(Person person) {
            if (children.contains(person)) {
                return true;
            } else {
                for (Person child : children) {
                    if (child.isDescedant(person)) {
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean isAncestor(Person person) {
            if (mother == person || father == person) {
                return true;
            } else if (mother != null && mother.isAncestor(person)) {
                return true;
            } else if (father != null && father.isAncestor(person)) {
                return true;
            } else {
                return false;
            }
        }
    }
}