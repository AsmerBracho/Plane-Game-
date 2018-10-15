package worlds;

import objets.Enemy;
import objets.GeneralObjets;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;

public class Level1 extends GeneralObjets {
  
  PApplet p; 
  PImage level;
  public Enemy[] enemy = new Enemy[8];
  int counter = 0;
  int numberEnemies = -1;
  double speed;
  int score = 0;
  boolean up = false;
  int scoreCounter = 0;
  int frequency = 250; // frequency enemies are created 
  
  PImage life; 
  PImage stars; 
  PImage pause; 
  
  // Constructor
  public Level1(int x, int y, int speed, PApplet p) {
    super(x, y, speed); 
    this.p = p;
    for (int i=0; i < enemy.length; i++) {
      enemy[i] = new Enemy(0, -400, 2, /*LifePoints*/ 5, p);
    }
    setImagesLevel();
  }
  
  
  public void setImagesLevel() {
    // set up level Images
    level = p.loadImage("files/level1.jpg");
    stars = p.loadImage("files/star.png");
    life = p.loadImage("files/life.png");
    pause = p.loadImage("files/pause.png");
  }
  
  public void displayLevel () {
    // display enemies
    createEnemies();
    drawEnemies();
    // display Level
  }
  
  public void displayWorld() {
    p.image(level, getX(), getY());
    p.image(level, getX(), getY() -4300);
    
    moveWorld(1);
    score();
  }
  
  public void moveWorld(int speed) {
    setY(getY() + speed);
  }
  
  public void drawEnemies() {
    for (int i = 0; i <= numberEnemies; i++) {
      enemy[i].displayEnemy();
      enemy[i].moveForward();
      
      // move it here
    }
  }
  
  public void createEnemies() {
    counter += 1;
    if (counter % frequency == 0) {
      enemy[numberEnemies + 1]
          .setX(PApplet.round((p.random((p.width - p.width) + 200, p.width - 300))));
      numberEnemies += 1;
    }
    if (numberEnemies == 7) {
      numberEnemies = -1;

      for (int i = 0; i < 8; i++) {
        enemy[i].setY(-400);
          enemy[i].setLifePoints(enemy[i].lifePointStorage);
          enemy[i].setSpeed(2);
          enemy[i].counter2 = 0;
        }
        
      /*
        if (numberEnemies == 5) {
          enemy[enemy.length - 2].setY(-400);
          enemy[enemy.length - 2].setLifePoints(enemy[enemy.length - 2].lifePointStorage);
          enemy[enemy.length - 2].setSpeed(2);
          enemy[enemy.length - 2].counter2 = 0;
        }
        */
      }
    score();
  }
  
  public boolean levelStatus() {
    if (numberEnemies == enemy.length - 3) {
      return true;
    }
    return true;
  }
  
  public void levelFinished() {
    p.fill(255,0,0);
    p.textSize(30);
    p.text("Congratulation", p.width/2 - 100, p.height/2);
  }
  
  
  public void score() {
    scoreCounter += 1; 
    for(int i = 0; i< enemy.length; i ++) {
      if (enemy[i].counter2 == 105) {
        up = true; 
      }
     
      if (up == true) {
        score +=1;
      }
      
      if (enemy[i].getY() == 10000) {
        up = false; 
      }
      
      if (scoreCounter%800 == 0) {
        score += 1; 
      }
        
    }
  }
  
  //--------------------Dashboard---------------------------
  
  public void dasdboard() {
    PFont f1 = p.createFont("Action Jackson", 20, true);
    PFont f2 = p.createFont("Adventure Subtitles", 20, true);
    p.fill(255);
    p.stroke(0);
    p.textFont(f2, 25);
    p.text("SCORE: ", 40, 40);
    // rect
    p.fill(0);
    //p.rect(p.width -115, 11, 100, 40);
    
    
    //score
    p.fill(255);
    p.textFont(f2, 40);
    p.text(score, 150, 40);
    
    
    // icons 
    p.image(stars, p.width - 130, p.height - 130);
    p.textFont(f2, 35);
    p.fill(174,149,62);
    p.text("7", p.width - 50, p.height - 100);
    
    p.image(life, p.width - 130, p.height - 290);
    p.text("3", p.width - 50, p.height - 260);
    p.image(pause, 30, p.height - 130);
  }
 
  
  
}
