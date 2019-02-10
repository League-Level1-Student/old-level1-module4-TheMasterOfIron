
public class runningrace {
	static int nextBibNumber;
    static String raceLocation = "New York";
    static String raceStartTime = "9.00am";

    String name;
    int speed;
    int bibNumber;

void Athlete (String name, int speed){
    this.name = name;
    this.speed = speed;
}

public static void main(String[] args) {
    //create two athletes      //print their names, bibNumbers, and the location of their race. }
	Athlete a1 = new Athlete("Goku",9001);
	Athlete a2 = new Athlete("Sonic",999999999);
}
}
