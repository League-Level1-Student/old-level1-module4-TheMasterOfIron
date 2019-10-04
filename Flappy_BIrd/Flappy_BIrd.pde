double topPipeX = 500;
int topPipeY = 0;
//-550 - 0
double topPipeXVelocity = -1;
int bottomPipeX = 0;
int bottomPipeY = 0;
int bottomPipeXVelocity = -1;
int gravity = 1;
int birdYVelocity = 0;
int birdX = 50;
int birdY = 325;
void mousePressed(){
  birdYVelocity = -15;
}
void draw(){
  background(0,225,255);
fill(255, 255, 0);
stroke(255, 255, 9);
ellipse(birdX, birdY, 22, 20);
fill(50, 255, 0);
rect((int)topPipeX, topPipeY, 50, 500);
if(birdYVelocity < 25){
  birdYVelocity += gravity;
}
 birdY += birdYVelocity;
 bottomPipeX += bottomPipeXVelocity;
 topPipeX += topPipeXVelocity;
}
void setup(){
  size(400, 650);
}
