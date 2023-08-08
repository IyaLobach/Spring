package org.example.springcore.TestBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {

  private String name;

  // Bean Lifecycle. Init-method and destroy-method
  private void myInit() {
    System.out.println("init-method");
  }

  private void myDestroy() {
    System.out.println("destroy-method");
  }


  public TestBean(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    TestBean testBean = context.getBean("testBean", TestBean.class);
    System.out.println(testBean.getName());

    context.close();
  }
}
