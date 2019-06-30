PImage backgroundImage;
import ddf.minim.*;
Minim minim;
AudioSample sound;
AudioSample lose;
int ballX = 375;
int ballY = 375;
int ballXspeed = 5;
int ballYspeed = 5;
int paddleX = 230;
int paddleY = mouseY;
int paddleLength = 75;
int rightpaddleX = 1050;
int rightpaddleY = 375;
int rightpaddleLength = 75;
int rightpaddleSpeed = 4;
boolean intersects(int ballX, int ballY, int paddleLength) {
  if (((ballY > paddleY) && (ballY < paddleY + paddleLength) && ((ballX > paddleX) && (ballX < paddleX + 10 )) || (ballX > rightpaddleX) && (ballX < rightpaddleX + 10))) {
    sound.trigger();
    return true;
  } else
    return false;
}

void draw() {
  paddleY = mouseY;
  if (paddleY > 595) {
    paddleY = 595;
  }
  if (paddleY < 50) {
    paddleY = 50;
  }
  if (rightpaddleY < ballY) {
    rightpaddleY += rightpaddleSpeed;
  }
  if (rightpaddleY > ballY) {
    rightpaddleY += -rightpaddleSpeed;
  }
  background(0, 0, 25);
  image(backgroundImage, 0, 0);
  fill(255, 255, 255);
  stroke(0, 50, 255);
  rect(paddleX, paddleY, 10, paddleLength);
  ellipse(ballX, ballY, 15, 15);
  rect(rightpaddleX, rightpaddleY, 10, rightpaddleLength);
  ballX += ballXspeed;
  ballY += ballYspeed;
  if (ballX >= 1070) {
    ballXspeed = -ballXspeed;
    sound.trigger();
  }
  if (ballX <= 210) {
    ballXspeed = -ballXspeed;
    lose.trigger();
  }
  if (ballY >= 670) {
    ballYspeed = -ballYspeed;
    sound.trigger();
  }
  if (ballY <= 50) {
    ballYspeed = -ballYspeed;
    sound.trigger();
  }
  if (intersects(ballX, ballY, paddleLength)) {
    ballXspeed = -ballXspeed;
  }
  //if ((ballXspeed >0)  && intersects(ballX, ballY, rightpaddleX, rightpaddleY, rightpaddleLength)){
   // ballXspeed = -ballXspeed;
  //}
}
void setup() {
  backgroundImage = loadImage("Screen.png");
  backgroundImage.resize(width, height);
  minim = new Minim (this);
  sound = minim.loadSample("268156__thirteenthfail__beat.wav", 128);
  lose = minim.loadSample("350985__cabled-mess__lose-c-02.wav", 128);
  size(1280, 720);
}
