int bucketX = 0;
int score = 0;
int dropX = 0;
int dropY = 450;
void draw(){
  if(mouseX < 220){
      bucketX = mouseX;
    }
  else if(mouseX >= 220){
      bucketX = 220;
    }
  background(150,150,150);
  fill(0,50,200);
  stroke(0,50,200);
  ellipse(dropX+5,dropY+20,10,14);
  fill(0,50,200);
  stroke(0,50,200);
  triangle(dropX,dropY+20,dropX+10,dropY+20,dropX+5,dropY);
  dropY +=3;
  if(dropY >= 450){
    int randomNumber = (int) random(width);
    dropY = -20;
    dropX = randomNumber;
  }
  fill(200,200,200);
  stroke(200,200,200);
  rect(bucketX,415,30,35);
  fill(0, 0, 0);
    textSize(16);
    text(score, bucketX+ 11, 440);
    
}
void checkCatch(int x){
         if (x > mouseX && x < mouseX+100)
            score++;
         else if (score > 0) 
            score--;
        println("Your score is now: " + score);
    }
void setup(){
  size(250,450);
}
