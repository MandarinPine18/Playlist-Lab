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
			String cmd = input("> ") + "                 "; // the extra spaces are a quick fix to avoid index issues in some of the if-statements
			if(cmd.startsWith("init")) {
				; //TODO add input system
			} else if (cmd.startsWith("remove")) {
				playList.remove(Integer.parseInt(cmd.trim().substring(7)));
			} else if (cmd.startsWith("sort")) {
				if (cmd.substring(5).startsWith("-d")) {
					playList.sortDuration();
				} else if (cmd.substring(5).startsWith("-a")) {
					playList.sortAlpha();
				} else {
					System.out.println("-d\tSort by duration\n-a\tSort alphabetically");
				}
			} else if (cmd.startsWith("get")) {
				System.out.println(playList.getSong(Integer.parseInt(cmd.substring(4))));
			} else if (cmd.startsWith("print")) {
				System.out.println(playList);
			} else if (cmd.startsWith("exit")) {
				System.exit(0);
			}
		}
	}

	public static String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}
}