import processing.core.PApplet;

import worlds.Level1;
import objets.Player;
import ddf.minim.*;

public class TheGame extends PApplet {

  Player p1;
  Level1 l1;
  Minim minim;
  AudioPlayer fireBullet;
  boolean[] keyboard = new boolean[128];

  public static void main(String[] args) {
    PApplet.main(TheGame.class);
  }

  public void settings() {
    size(1000, 800);
  }

  public void setup() {
    p1 = new Player(width / 2 - 100, height - 200, 4, this);
    l1 = new Level1(0, -3500, 3, this);
    minim = new Minim(this);
    fireBullet = minim.loadFile("files/sounds/fireBullet.mp3");
  }

  public void draw() {
    background(255); // redraw and clear trace
    if (l1.levelStatus() == true) {
      l1.displayWorld();
      l1.displayLevel();
      p1.displayPlayer();
      moveKeyboard();
      collision();
      l1.dasdboard();


    } else {
      background(255);
      l1.levelFinished();
    }

    System.out.println("Position: " + l1.enemy[2
                                               ].getY());
    System.out.println("Life:" + l1.enemy[2].getLifePoints());

  }

  // ----------------------Move Keyboard--------------------
  public void moveKeyboard() {

    if (keyboard['a'] == true) {
      if (p1.getX() > 0) {
        p1.moveLeft(p1.getSpeed());
      }
      p1.setPosition(2);
    }
    if (keyboard['d'] == true) {
      if (p1.getX() + 152 < width) {
        p1.moveRight(p1.getSpeed());
      }
      p1.setPosition(1);
    }

    if (keyboard['w'] == true) {
      p1.setBulletCounter(p1.getBulletCounter() + 1);

    } else if (keyboard['w'] == false) {
      p1.setBulletCounter(0);
    }
  }

  public void keyPressed() {
    keyboard[key] = true;
  }

  public void keyReleased() {
    keyboard[key] = false;
    p1.setPosition(0);

  }
  // ----------------------End Move Keyboard--------------------

  // ----------------------Collision----------------------------
  public void collision() {
    for (int i = 0; i < p1.bullets.length; i++) {
      if (p1.bullets[i].getY() >= 0) {
        for (int j = 0; j < l1.enemy.length; j++) {
          if (l1.enemy[j].getY() <= p1.getY() - 300) {
            if (p1.bullets[i].getY() <= l1.enemy[j].getY() + 350
                && p1.bullets[i].getX() >= l1.enemy[j].getX() - 20
                && p1.bullets[i].getX() <= l1.enemy[j].getX() + 130) {
              p1.bullets[i].setY(-1000);

              if (l1.enemy[j].getLifePoints() == 1) {
                l1.enemy[j].setLifePoints(0);
              } else if (l1.enemy[j].getLifePoints() == 2) {
                l1.enemy[j].setLifePoints(1);
              } else if (l1.enemy[j].getLifePoints() == 3) {
                l1.enemy[j].setLifePoints(2);
              } else if (l1.enemy[j].getLifePoints() == 4) {
                l1.enemy[j].setLifePoints(3);
              } else if (l1.enemy[j].getLifePoints() == 5) {
                l1.enemy[j].setLifePoints(4);
              }
            }
          }
        }
      }
    }
  }
  // -----------------------------------------------------------

}
