package org.example.springcore.Annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("classical")
@Scope("singleton")
public class ClassicalMusic implements IMusic {

  @Override
  public String getMusic() {
    return "Classical";
  }
}
