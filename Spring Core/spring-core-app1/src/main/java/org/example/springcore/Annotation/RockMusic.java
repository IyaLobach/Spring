package org.example.springcore.Annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("rock")
@Scope("prototype")
public class RockMusic implements IMusic {

  @Override
  public String getMusic() {
    return "Rock";
  }
}
