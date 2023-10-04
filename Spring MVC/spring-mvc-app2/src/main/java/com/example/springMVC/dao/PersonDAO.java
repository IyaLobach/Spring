package com.example.springMVC.dao;

import com.example.springMVC.models.Person;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {

  private ArrayList<Person> people = new ArrayList<>();
  private int ID;

  {
    people.add(new Person(++ID, "Iya", "iya@mail.ru", 22));
    people.add(new Person(++ID, "Vika", "vika@mail.ru", 22));
    people.add(new Person(++ID, "Gera", "gera@mail.ru", 22));
    people.add(new Person(++ID, "Sonya", "sonya@mail.ru", 22));
  }

  public ArrayList<Person> index() {
    return people;
  }

  public Person show(int id) {
    for (Person person : people){
      if (person.getId() == id)
        return person;
    }
    return null;
  }

  public void save(Person person) {
    person.setId(++ID);
    people.add(person);
  }

  public void update(int id, Person newPerson) {
    Person cur = show(id);
    cur.setName(newPerson.getName());
    cur.setEmail(newPerson.getEmail());
    cur.setAge(newPerson.getAge());
  }

  public void delete(int id) {
    people.remove(show(id));
  }

}
