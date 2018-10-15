package objets;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemy extends GeneralObjets {

  PApplet p;
  int counter = 6;
  public int counter2 = 0;
  public PImage enemy;
  public PImage damage1;
  public PImage damage2;
  public PImage damage3;
  public PImage damage4;
  public PImage damage5;
  public PImage damage6;
  public PImage damage7;
  public PImage damage8;
  public PImage damage9;
  public PImage damage10;
  public PImage damage11;
  public PImage hit;

  public PImage death1;
  public PImage death2;
  public PImage death3;
  public PImage death4;
  public PImage death5;
  public PImage death6;
  public PImage death7;
  public PImage death8;
  public PImage death9;
  public PImage death10;
  public PImage death11;
  public PImage death12;
  public PImage death13;
  public PImage death14;
  public PImage death15;
  public PImage death16;
  public PImage death17;
  public PImage death18;

  private int lifePoints;
  public int lifePointStorage;


  public Enemy(int x, int y, int speed, int lifePoints, PApplet p) {
    super(x, y, speed);
    this.lifePoints = lifePoints;
    this.p = p;
    this.lifePointStorage = lifePoints;
    setImagesEnemy();
  }

  public int getLifePoints() {
    return lifePoints;
  }

  public void setLifePoints(int lifePoints) {
    this.lifePoints = lifePoints;
  }

  public void setImagesEnemy() {
    enemy = p.loadImage("files/enemy.png");
    hit = p.loadImage("files/hit.png");
    damage1 = p.loadImage("files/damage1.png");
    damage2 = p.loadImage("files/damage2.png");
    damage3 = p.loadImage("files/damage3.png");
    damage4 = p.loadImage("files/damage4.png");
    damage5 = p.loadImage("files/damage5.png");
    damage6 = p.loadImage("files/damage6.png");
    damage7 = p.loadImage("files/damage7.png");

    death1 = p.loadImage("files/death1.png");
    death2 = p.loadImage("files/death2.png");
    death3 = p.loadImage("files/death3.png");
    death4 = p.loadImage("files/death4.png");
    death5 = p.loadImage("files/death5.png");
    death6 = p.loadImage("files/death6.png");
    death7 = p.loadImage("files/death7.png");
    death8 = p.loadImage("files/death8.png");
    death9 = p.loadImage("files/death9.png");
    death10 = p.loadImage("files/death10.png");
    death11 = p.loadImage("files/death11.png");
    death12 = p.loadImage("files/death12.png");
    death13 = p.loadImage("files/death13.png");
    death14 = p.loadImage("files/death14.png");
    death15 = p.loadImage("files/death15.png");
    death16 = p.loadImage("files/death16.png");
    death17 = p.loadImage("files/death17.png");
    death18 = p.loadImage("files/death18.png");

  }

  public void displayEnemy() {
    if (lifePoints >= 3) {
      p.image(enemy, getX(), getY());
    } else if (lifePoints > 0 && lifePoints < 3) {
      enemyDamage();
    } else if (lifePoints == 0) {
      enemyDeath();
    }
  }

  // extra methods for enemy

  public void enemyDamage() {
    p.image(damage1, getX(), getY());
    counter += 1;
    if (counter == 80) {
      counter = 11;
    }
    if (counter > 6 && counter <= 10) {
      p.image(hit, getX(), getY());
    }
    if (counter > 10 && counter <= 20) {
      p.image(damage2, getX(), getY());
    }
    if (counter > 20 && counter <= 30) {
      p.image(damage3, getX(), getY());
    }
    if (counter > 30 && counter <= 40) {
      p.image(damage4, getX(), getY());
    }
    if (counter > 40 && counter <= 50) {
      p.image(damage5, getX(), getY());
    }
    if (counter > 50 && counter <= 60) {
      p.image(damage6, getX(), getY());
    }
    if (counter > 60 && counter <= 70) {
      p.image(damage7, getX(), getY());
    }
  }

  public void enemyDeath() {
    counter2 += 1;
    if (counter2 > 10 && counter2 <= 15) {
      p.image(death1, getX(), getY());
    }
    if (counter2 > 15 && counter2 <= 20) {
      p.image(death2, getX(), getY());
    }
    if (counter2 > 20 && counter2 <= 25) {
      p.image(death3, getX(), getY());
    }
    if (counter2 > 25 && counter2 <= 30) {
      p.image(death5, getX(), getY());
    }
    if (counter2 > 30 && counter2 <= 35) {
      p.image(death6, getX(), getY());
    }
    if (counter2 > 35 && counter2 <= 40) {
      p.image(death7, getX(), getY());
    }
    if (counter2 > 40 && counter2 <= 45) {
      p.image(death8, getX(), getY());
    }
    if (counter2 > 45 && counter2 <= 50) {
      p.image(death9, getX(), getY());
    }
    if (counter2 > 50 && counter2 <= 55) {
      p.image(death10, getX(), getY());
    }
    if (counter2 > 55 && counter2 <= 60) {
      p.image(death11, getX(), getY());
    }
    if (counter2 > 60 && counter2 <= 65) {
      p.image(death12, getX(), getY());
    }
    if (counter2 > 65 && counter2 <= 70) {
      p.image(death13, getX(), getY());
    }
    if (counter2 > 70 && counter2 <= 75) {
      p.image(death14, getX(), getY());
    }
    if (counter2 > 75 && counter2 <= 80) {
      p.image(death15, getX(), getY());
    }
    if (counter2 > 80 && counter2 <= 85) {
      p.image(death16, getX(), getY());
    }
    if (counter2 > 85 && counter2 <= 90) {
      p.image(death17, getX(), getY());
    }
    if (counter2 > 90 && counter2 <= 95) {
      p.image(death18, getX(), getY());
    }

    if (counter2 > 50) {
      setSpeed(0);
    }
    if (counter2 > 100) {
      setY(10000);
    }


  }

  public void moveForward() {
    setY(getY() + getSpeed());
  }

} // End of public class Enemy
