package extra;

import java.util.Random;

public class Typing_Tutor {
public void main(String[] args) {
	
	

}
static char generateRandomLetter() {
    Random r = new Random();
    return (char) (r.nextInt(26) + 'a');
}
}
