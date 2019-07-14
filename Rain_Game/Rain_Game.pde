int menuBackgroundX = 250;
int menuBackgroundY = 450;
int dropYSpeed = 3;
int bucketX = 0;
int score = 0;
int dropX = 0;
int dropY = 450;
void draw(){
  if(dropYSpeed > 10){
    dropYSpeed = 10;
  }
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
  dropY +=dropYSpeed;
  if((dropY < 430)&&(dropY+dropYSpeed>= 430)){
checkCatch(dropX);
  }
  if(dropY >= 450){
    int randomNumber = (int) random(width-10);
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
         if ((x > mouseX && x < mouseX+100)){
            score++;
            dropYSpeed ++;
         }
          else if (score > 0){
              score--;
       dropYSpeed --;
        }
    }
void setup(){
  size(250,450);
}
