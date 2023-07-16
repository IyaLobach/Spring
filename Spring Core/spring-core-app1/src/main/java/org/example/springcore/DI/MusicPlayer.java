package org.example.springcore.DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MusicPlayer {
  private IMusic music;
  private int volume;

  public MusicPlayer() {

  }

  public MusicPlayer(IMusic m) {
    music = m;
  }

  public void setMusic(IMusic music) {
    this.music = music;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  public void play() {
    System.out.println(music.getMusic());
  }

  public void playVolume() {
    System.out.println(volume);
  }

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    // принцип IoC
    // внедрение вручную, без Dependency Injection
    MusicPlayer musicPlayer = new MusicPlayer(context.getBean("rockMusicBean", RockMusic.class));
    musicPlayer.play();
    System.out.println();

    // Dependency Injection in constructor
    MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);
    musicPlayer2.play();
    System.out.println();

    // Dependency Injection in setter
    MusicPlayer musicPlayer3 = context.getBean("musicPlayerSetter", MusicPlayer.class);
    musicPlayer3.play();
    musicPlayer3.playVolume();
    System.out.println();

    // Dependency Injection from file
    MusicPlayer musicPlayer4 = context.getBean("musicPlayerFile", MusicPlayer.class);
    musicPlayer4.play();
    musicPlayer4.playVolume();
    System.out.println();

    context.close();
  }
}
