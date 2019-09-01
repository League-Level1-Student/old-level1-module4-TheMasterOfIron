int topPipeX = 750;
int topPipeY = -700;
int bottomPipeX = 0;
int bottomPipeY = 0;
int gravity = 1;
int birdYVelocity = 0;
int birdX = 20;
int birdY = 325;
void draw(){
  background(0,225,255);
fill(255, 255, 0);
stroke(255, 255, 9);
ellipse(birdX, birdY, 22, 20);
fill(50, 255, 0);
rect(topPipeX, topPipeY, 50, 1000);
if(mousePressed){
  birdYVelocity = -10;
}
if(birdYVelocity < 25){
  birdYVelocity += gravity;
}
 birdY += birdYVelocity;
}
void setup(){
  size(400, 650);
}
