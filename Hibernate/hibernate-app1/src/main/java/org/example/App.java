package org.example;

import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {

  public static void main(String[] args) {
    Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.getCurrentSession();

    session.beginTransaction();

//        Person person1 = new Person("Iya", 22);
//        Person person2 = new Person("Vika", 21);
//        Person person3 = new Person("Sonya", 21);
//
//        session.save(person1);
//        session.save(person2);
//        session.save(person3);
//
//        Person person4 = session.get(Person.class, 1);
//        System.out.println(person4);
//        person4.setName("Ira");
//        System.out.println(person4);

    Person person5 = new Person("Vova", 22);
    session.save(person5);
    System.out.println(person5.getId());

    session.getTransaction().commit();
    sessionFactory.close();
  }
}
