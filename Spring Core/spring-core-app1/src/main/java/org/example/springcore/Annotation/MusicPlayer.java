package org.example.springcore.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("player")
public class MusicPlayer {

  @Autowired
  @Qualifier("rock")
  private IMusic music1;

  @Autowired
  @Qualifier("classical")
  private IMusic music2;

  @Value("${player.volume}")
  private int volume;

  public MusicPlayer() {

  }


  public MusicPlayer(IMusic m1, IMusic m2) {
    music1 = m1;
    music2 = m2;
  }

  public void setMusic1(IMusic music1) {
    this.music1 = music1;
  }

  public void setMusic2(IMusic music2) {
    this.music2 = music2;
  }

  public IMusic getMusic1() {
    return music1;
  }

  public IMusic getMusic2() {
    return music2;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  public void play() {
    //System.out.println(music1.getMusic());
    System.out.println(music2.getMusic());
  }

  public void playVolume() {
    System.out.println(volume);
  }

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "applicationContext.xml");

    // @Component,  @Autowired and @Qualifier annotation
    MusicPlayer musicPlayer1 = context.getBean("player", MusicPlayer.class);
    musicPlayer1.play();
    System.out.println();

    // @Scope annotation
    MusicPlayer musicPlayer2 = context.getBean("player", MusicPlayer.class);
    System.out.println(musicPlayer2.getMusic1() + " " + musicPlayer2.getMusic2());

    // singleton
    musicPlayer2.setMusic1(context.getBean("classical", ClassicalMusic.class));
    System.out.println(musicPlayer2.getMusic2());

    // prototype
    musicPlayer2.setMusic1(context.getBean("rock", RockMusic.class));
    System.out.println(musicPlayer2.getMusic1());
    System.out.println();

    // ПОЧЕМУ НЕ РАБОТАЕТ PROTOTYPE, КОГДА СОЗДАЮ ДВА РАЗНЫХ ОБЪЕКТА??
    MusicPlayer musicPlayer3 = context.getBean("player", MusicPlayer.class);
    MusicPlayer musicPlayer4 = context.getBean("player", MusicPlayer.class);

    System.out.println(musicPlayer3.getMusic1() + " " + musicPlayer3.getMusic2());
    System.out.println(musicPlayer4.getMusic1() + " " + musicPlayer4.getMusic2());
    System.out.println();

    // @Value annotation
    MusicPlayer musicPlayer5 = context.getBean("player", MusicPlayer.class);
    musicPlayer5.playVolume();
    System.out.println();



    context.close();
  }
}
