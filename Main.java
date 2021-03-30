import java.util.*;

class Main {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Song[] songs = {
				new Song("When Am I Going to Lose You", "Local Natives", 4, 24),
				new Song("Longshot", "Catfish & the Bottlemen", 3, 52),
				new Song("Tongue Tied", "Grouplove", 3, 38),
				new Song("Out of My League", "Fitz & The Tantrums", 3, 29)
		};

		PlayList playList = new PlayList(songs.length);
		playList.playList = songs;

		System.out.println("Create your own playlist! Type \"init\" to begin ");
		while(true) {
			String cmd = input("> ");
			if(cmd.startsWith("init")) {
				;
			} else if (cmd.startsWith("remove")) {
				;
			} else if (cmd.startsWith("sort")) {
				if (cmd.substring(5).startsWith("-d")) {
					playList.sortDuration();
				} else if (cmd.substring(5).startsWith("-a")) {
					playList.sortAlpha();
				} else {
					; //TODO add a help message for sort
				}
			} else if (cmd.startsWith("get")) {
				System.out.println(playList.getSong(Integer.parseInt(cmd.substring(4))));
			} else if (cmd.startsWith("print")) {
				System.out.println(playList);
			}
		}
	}

	public static String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}
}