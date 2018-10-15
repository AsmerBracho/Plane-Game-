package objets;

import processing.core.PApplet;
import processing.core.PImage;

public class Player extends GeneralObjets {

  PApplet p;
  PImage plane;
  PImage planeR;
  PImage planeL;
  private int position;
  boolean[] keyboard = new boolean[128];
  public Weapons[] bullets = new Weapons[30];
  private int bullet;
  private int bulletCounter;


  // ------------------------------------------------------------------
  public Player(int x, int y, int speed, PApplet p) {
    super(x, y, speed);
    this.p = p;
    bullet = -1;
    setBulletCounter(0);
    setPosition(0);

    for (int i = 0; i < bullets.length; i++) {
      bullets[i] = new Weapons(0, y + 40, 5, p);
      bullets[i].setImageBullet();
    }
    setImagesPlayer();
  }

  // ------------------------------------------------------------------
  public void setImagesPlayer() {
    plane = p.loadImage("files/planeIddle.png");
    planeR = p.loadImage("files/planeRight.png");
    planeL = p.loadImage("files/planeLeft.png");

  }

  public void displayPlayer() {
    drawBullet(); // draw bullet
    fireBullet(); // what happens if the bullet is fired
    if (getPosition() == 0) {
      p.image(plane, getX(), (float) getY());
    } else if (getPosition() == 1) {
      p.image(planeR, getX(), (float) getY());;
    } else if (getPosition() == 2) {
      p.image(planeL, getX(), (float) getY());
    }

  }

  public void drawBullet() {
    for (int j = 0; j < bullets.length; j++) {
      if (bullets[j].getY() <= -1000) {
        bullets[j].isMoving = 0;
      }
    }

    for (int i = 0; i <= bullet; i++) {
      bullets[i].createBullet();
      if (bullets[i].isMoving == 1) {
        bullets[i].moveBullet(8);
      }

    }
  }

  public void fireBullet() {
    if (getBulletCounter() == 1) {
      bullet += 1;
      if (bullet == bullets.length) {
        bullet = 0;
        for (int i = 0; i < bullets.length; i++) {
          bullets[i].setY((int) (getY() + 50));
          bullets[i].isMoving = 1;
        }
      }
      bullets[bullet].setX(getX() + 55);
    } // End if
  }


  public int getBulletCounter() {
    return bulletCounter;
  }

  public void setBulletCounter(int bulletCounter) {
    this.bulletCounter = bulletCounter;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }


}
