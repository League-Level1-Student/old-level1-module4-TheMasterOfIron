PImage backgroundImage;
import ddf.minim.*;
Minim minim;
AudioSample sound;
int ballX = 375;
int ballY = 375;
int ballXspeed = 9;
int ballYspeed = 13;
void draw() {
  background(0, 0, 25);
  image(backgroundImage, 0, 0);
  image(backgroundImage, 0, 0, width, height);
  fill(255, 255, 255);
  stroke(0, 50, 255);
  ellipse(ballX, ballY, 15, 15);
  ballX += ballXspeed;
  ballY += ballYspeed;
  if (ballX >= width) {
    ballXspeed = -ballXspeed;
    sound.trigger();
  }
  if (ballX <= 0) {
    ballXspeed = -ballXspeed;
    sound.trigger();
  }
  if (ballY >= height) {
    ballYspeed = -ballYspeed;
    sound.trigger();
  }
  if (ballY <= 0) {
    ballYspeed = -ballYspeed;
    sound.trigger();
  }
}
void setup() {
  backgroundImage = loadImage("Screen.png");
  backgroundImage.resize(1280, 720);
  minim = new Minim (this);
  sound = minim.loadSample("268156__thirteenthfail__beat.wav", 128);
  size(1280, 720);
}
