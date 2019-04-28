
public class Oof {
public static void main(String[] args) {
	Song s1 = new Song("Roblox Death Sound - OOF Sound Effect.mp3");
	System.out.println(s1);
	for (int i = 0; i < 10000; i++) {
		s1.play();
		try {
			Thread.sleep(600000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
