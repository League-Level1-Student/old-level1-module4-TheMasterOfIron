//All Int Variables

int colorState = 0;
int red = 255;
int blue = 0;
int green = 0;
int difficulty = 0;
int menuBackgroundX = 250;
int menuBackgroundY = 450;
int dropYSpeed = 0;
int dropYSpeedDecrease = 1;
int alreadyHitBottom = 0;
int bucketX = 0;
int bucketWidth = 0;
int score = 0;
int scoreOffset = 1;
int scoreOffsetIncreased = 0;
int dropX = 0;
int dropY = 450;

//All Boolean Variables

boolean hasSelectedDifficulty = false;
boolean lost = false;

//All String Variables

String title = "Rain Game";
String easyButtonText = "Easy";
String normalButtonText = "Normal";
String hardButtonText = "Hard";
String loseScreenText = "You Lose!";
String loseScreenScoreText = "Your Score Was" + score +".";

//App PImage Variables

PImage waterBucket;
PImage easyWaterBucket;
//Background Color Switching

void backgroundColor() {
  if (colorState == 0) {
    green += 4;
    if (green >= 255) {
      colorState ++;
    }
  }
  if (colorState == 1) {
    red -= 4;
    if (red <= 0) {
      colorState ++;
    }
  }
  if (colorState == 2) {
    blue += 4;
    green -= 4;
    if (blue >= 255 && green <= 0) {
      colorState ++;
    }
  }
  if (colorState == 3) {
    blue -= 4;
    if (red < 75) {
      red += 4;
    }
    if (blue <= 130 && red >= 75) {
      colorState ++;
    }
  }
  if (colorState == 4) {
    if (blue < 211) {
      blue += 4;
    }
    if (red < 148) {
      red += 4;
    }
    if (blue >= 211 && red >= 148) {
      colorState ++;
    }
  }
  if (colorState == 5) {
    if (blue > 0) {
      blue -= 4;
    }
    if (red < 255) {
      red += 4;
    }
    if (red >= 255 && blue <= 0) {
      colorState = 0;
    }
  }
  if (colorState == 6) {
    if (blue > 0) {
      blue --;
    }
    if (red > 0) {
      red --;
    }
    if (green < 255) {
      green ++;
    }
  }
  if (colorState == 7) {
    if (blue > 0) {
      blue --;
    }
    if (red < 255) {
      red ++;
    }
    if (green < 255) {
      green ++;
    }
  }
  if (colorState == 8) {
    if (blue > 0) {
      blue --;
    }
    if (red < 255) {
      red ++;
    }
    if (green > 0) {
      green --;
    }
  }
  if (colorState == 9) {
    if (blue > 0) {
      blue --;
    }
    if (red > 0) {
      red--;
    }
    if (green > 0) {
      green --;
    }
  }
}

//All The Main Menu Stuff

void mousePressed() {
  if(hasSelectedDifficulty == false){
  if (mouseX > 25 && mouseY > 59 && mouseX < 225 && mouseY < 179) {
    println("Easy Mode Selected");
    difficulty = 1;
    colorState = 6;
    dropYSpeed = 2;
    dropYSpeedDecrease = 1;
    hasSelectedDifficulty = true;
  } else if (mouseX > 25 && mouseY > 189 && mouseX < 225 && mouseY < 309) {
    println("Normal Mode Selected");
    difficulty = 2;
    colorState = 7;
    dropYSpeed = 3;
    dropYSpeedDecrease = 1;
        hasSelectedDifficulty = true;
  } else if (mouseX > 25 && mouseY > 319 && mouseX < 225 && mouseY < 440) {
    println("Hard Mode Selected");
    difficulty = 3;
    colorState = 8;
    dropYSpeed = 4;
    dropYSpeedDecrease = 2;
        hasSelectedDifficulty = true;
  } else if (mouseX > 0 && mouseY > 0 && mouseX < 250 && mouseY < 450) {
    println("Insane Mode Selected");
    difficulty = 4;
    colorState = 9;
    dropYSpeed = 5;
    dropYSpeedDecrease = 1000000;
        hasSelectedDifficulty = true;
  }
  }
  
//Show Coordinates When Clicked
  
  println(mouseX);
  println(mouseY);
}

//Draw Methood

void draw() {
  
if(lost == true && score < 10){
  stroke(red,green,blue);
  fill(red,green,blue);
  rect(0,0,250,450);
  stroke(-red,-green,-blue);
  fill(-red,-green,-blue);
  textSize(48);
  text(loseScreenText,17,187);
  textSize(16);
  text(loseScreenScoreText,17,187);
  
}
  
//Background Color
  
    background(red, green, blue);
  backgroundColor();
  
//Nothing Happens If Difficulty Is 0
  
  if (difficulty == 0){
  }
  
//Easy Specific Scripts
  
  else if (difficulty == 1) {
    if (dropYSpeed > 5) {
      dropYSpeed = 5;
    }
    bucketWidth = 60;
    fill(0, 50, 200);
  stroke(0, 50, 200);
  ellipse(dropX+5, dropY+20, 10, 14);
  fill(0, 50, 200);
  stroke(0, 50, 200);
  triangle(dropX, dropY+20, dropX+10, dropY+20, dropX+5, dropY);
  fill(200, 200, 200);
  stroke(200, 200, 200);
  image(easyWaterBucket,bucketX,415);
  }
  
//Medium Specific Scripts
  
  else if (difficulty == 2) {
    if (dropYSpeed > 10) {
      dropYSpeed = 10;
    }
    bucketWidth = 30;
    fill(0, 50, 200);
  stroke(0, 50, 200);
  ellipse(dropX+5, dropY+20, 10, 14);
  fill(0, 50, 200);
  stroke(0, 50, 200);
  triangle(dropX, dropY+20, dropX+10, dropY+20, dropX+5, dropY);
  fill(200, 200, 200);
  stroke(200, 200, 200);
  image(waterBucket,bucketX,415);
  }
  
//Hard Specific Scripts
  
  else if (difficulty == 3) {
    if (dropYSpeed > 15) {
      dropYSpeed = 15;
    }
    bucketWidth = 25;
    fill(0, 50, 200);
  stroke(0, 50, 200);
  ellipse(dropX+5, dropY+20, 10, 14);
  fill(0, 50, 200);
  stroke(0, 50, 200);
  triangle(dropX, dropY+20, dropX+10, dropY+20, dropX+5, dropY);
  fill(200, 200, 200);
  stroke(200, 200, 200);
  rect(bucketX, 415, bucketWidth, 35);
  }
  
//Insane Specific Scripts
  
  else if (difficulty == 4) {
    if (dropYSpeed > 25) {
      dropYSpeed = 25;
    }
    bucketWidth = 15;
    fill(25, 25, 25);
  stroke(25, 25, 25);
  ellipse(dropX+5, dropY+20, 10, 14);
  fill(25, 25, 25);
  stroke(25, 25, 25);
  triangle(dropX, dropY+20, dropX+10, dropY+20, dropX+5, dropY);
  fill(200, 200, 200);
  stroke(200, 200, 200);
  rect(bucketX, 415, bucketWidth, 35);
  }
  
//Bucket Stuff
  
    bucketX = mouseX - bucketWidth/2;
    
//Preventon Of Reversed Rain (PRR)

if(dropYSpeed < 0){
  dropYSpeed = 0;
}

//Drop Being Caught Or Not And Teleportation
  
  dropY +=dropYSpeed;
  if ((dropY < 430)&&(dropY+dropYSpeed>= 430)) {
    checkCatch(dropX);
  }
  if (dropY >= 450) {
    int randomNumber = (int) random(width-10);
    dropY = -20;
    dropX = randomNumber;
    alreadyHitBottom = 0;
  }
  
//Score Scripts
  
  if(hasSelectedDifficulty == true){
  fill(0, 0, 0);
  textSize(16);
  text(score, bucketX+bucketWidth / 2 - scoreOffset * 4, 440);
  if (score >= 10 && scoreOffsetIncreased == 0){
   scoreOffset ++;
   scoreOffsetIncreased ++;
  }
  else if (score < 10 && scoreOffsetIncreased == 1){
   scoreOffset --;
   scoreOffsetIncreased --;
  }
  if(dropYSpeed == 0){
   lost = true; 
  }
  }
  
//Main Menu Boxes
  
    if(hasSelectedDifficulty == false){
  fill(0, 255, 0);
  rect(25, 59, 200, 120);
  fill(0, 0, 0);
  textSize(40);
  text(easyButtonText, 85, 134);
  fill(255, 255, 0);
  rect(25, 189, 200, 120);
  fill(0, 0, 0);
  textSize(40);
  text(normalButtonText, 55, 264);
  fill(255, 0, 0);
  rect(25, 319, 200, 120);
  fill(0, 0, 0);
  textSize(40);
  text(hardButtonText, 80, 394);
  textSize(40);
  text(title, 22, 40);
    }
}

//Checking To See If Drop Has Been Caught Or Not

void checkCatch(int x) {
  if ((x >= bucketX && x <= bucketX + bucketWidth)) {
    score++;
    dropYSpeed ++;
  } else if (score > 0 && alreadyHitBottom == 0) {
    score--;
    dropYSpeed -= dropYSpeedDecrease;
    alreadyHitBottom = 1;
  }
  else if (score == 0 && alreadyHitBottom == 0) {
    dropYSpeed -= dropYSpeedDecrease;
    alreadyHitBottom = 1;
  }
}

//Setup Methood

void setup() {
  
//Setting Images
  
  easyWaterBucket = loadImage("Easy Water Bucket.png");
  
//Setting Size Of Screen

  size(250, 450);
}
