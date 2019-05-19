PImage backgroundImage;
import ddf.minim.*;
Minim minim;
AudioSample sound;
int ballX = 375;
int ballY = 375;
int ballXspeed = 5;
int ballYspeed = 5;
int paddleX = 230;
int paddleY = mouseY;
int paddleLength = 75;
boolean intersects(int ballX, int ballY, int paddleX, int paddleY, int paddleLength) {
     if ((ballY > paddleY) && (ballY < paddleY + paddleLength)&& (ballX <= paddleX + 10 ))
          return true;
     else
          return false;
    }
void draw() {
paddleY = mouseY;
  background(0, 0, 25);
  image(backgroundImage, 0, 0);
  fill(255, 255, 255);
  stroke(0, 50, 255);
  rect(paddleX,paddleY,10,paddleLength);
  ellipse(ballX, ballY, 15, 15);
  ballX += ballXspeed;
  ballY += ballYspeed;
  if (ballX >= 1070) {
    ballXspeed = -ballXspeed;
    sound.trigger();
  }
  if (ballX <= 210) {
    ballXspeed = -ballXspeed;
    sound.trigger();
  }
  if (ballY >= 670) {
    ballYspeed = -ballYspeed;
    sound.trigger();
  }
  if (ballY <= 50) {
    ballYspeed = -ballYspeed;
    sound.trigger();
  }
  if((ballXspeed <0 ) && intersects(ballX,ballY,paddleX,paddleY,paddleLength)){
    ballXspeed = -ballXspeed;
  }
}
void setup() {
  backgroundImage = loadImage("Screen.png");
  backgroundImage.resize(width,height);
  minim = new Minim (this);
  sound = minim.loadSample("268156__thirteenthfail__beat.wav", 128);
  size(1280, 720);
}
