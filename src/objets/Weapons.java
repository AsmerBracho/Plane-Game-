package objets;

import processing.core.PApplet;
import processing.core.PImage;

public class Weapons extends GeneralObjets {

  PApplet p;
  PImage bulletImg;
  public int bulletStatus;
  public int isMoving;


  public Weapons(int x, int y, int speed, PApplet p) {
    super(x, y, speed);
    this.p = p;
    isMoving = 1;
    bulletStatus = 0;
  }

  public void setImageBullet() {
    bulletImg = p.loadImage("files/bullet.png");
  }

  public void createBullet() {
    if (bulletStatus == 0) {
      p.image(bulletImg, getX(), (float) getY());
      p.image(bulletImg, getX() + 30, (float) getY());
    } else if (bulletStatus == 1) {
      p.ellipse(getX(), (float) getY(), 0, 0);
    }
  }

  public void moveBullet(int s) {
    setY((int) (getY() - s));
  }


}
