int colorState = 0;
int red = 255;
int blue = 0;
int green = 0;
int difficulty = 0;
int menuBackgroundX = 250;
int menuBackgroundY = 450;
int dropYSpeed = 3;
int bucketX = 0;
int score = 0;
int dropX = 0;
int dropY = 450;
void backgroundColor(){
  if(colorState == 0){
    green ++;
    if(green >= 255){
      colorState ++;
    }
  }
   if(colorState == 1){
    red --;
    if(red <= 0){
      colorState ++;
    }
  }
  if(colorState == 2){
    blue ++;
    green --;
    if(blue >= 255 && green <= 0){
      colorState ++;
    }
  }
  if(colorState == 3){
    blue --;
    if(red < 75){
    red ++;
    }
    if(blue <= 130 && red >= 75){
      colorState ++;
    }
  }
}
void mousePressed(){
  if(mouseX > 25 && mouseY > 59 && mouseX < 225 && mouseY < 179){
    println("Easy Mode Selected");
    difficulty = 1;
  }
  else if(mouseX > 25 && mouseY > 189 && mouseX < 225 && mouseY < 309){
    println("Normal Mode Selected");
    difficulty = 2;
  }
  else if(mouseX > 25 && mouseY > 319 && mouseX < 225 && mouseY < 440){
    println("Hard Mode Selected");
    difficulty = 3;
  }
  else if(mouseX > 0 && mouseY > 0 && mouseX < 250 && mouseY < 450){
    println("Insane Mode Selected");
    difficulty = 4;
  }
println(mouseX);
println(mouseY);
}
void draw(){
  backgroundColor();
  if(dropYSpeed > 10){
    dropYSpeed = 10;
  }
  if(mouseX < 220){
      bucketX = mouseX;
    }
  else if(mouseX >= 220){
      bucketX = 220;
    }
  background(red,green,blue);
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
      fill(0,255,0);
  rect(25,59,200,120);
  fill(255,255,0);
  rect(25,189,200,120);
  fill(255,0,0);
  rect(25,319,200,120);
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
