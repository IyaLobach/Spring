package com.example.springMVC.config.dao;

import com.example.springMVC.config.models.Person;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {

  private ArrayList<Person> people = new ArrayList<>();
  private int ID;

  {
    people.add(new Person(++ID, "Iya"));
    people.add(new Person(++ID, "Vika"));
    people.add(new Person(++ID, "Gera"));
    people.add(new Person(++ID, "Sonya"));
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
    System.out.println(cur.getName() + " " + cur.getId());
  }

  public void delete(int id) {
    people.remove(show(id));
  }

}
