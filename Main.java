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

		System.out.println("Create your own playlist!");

		PlayList playList = makePlaylist();

		System.out.println("~~BEGIN DEMO~~");
		System.out.println("\nSorted alphabetically and printed:");
		playList.sortAlpha();
		System.out.println(playList);
		System.out.println("\nSorted by duration and printed:");
		playList.sortDuration();
		System.out.println(playList);

		System.out.println("~~ END DEMO~~");

		help();
		while(true) {
			String cmd = input("> ") + "                 "; // the extra spaces are a quick fix to avoid index issues in some of the if-statements
			if(cmd.startsWith("init")) {
				playList = makePlaylist();
			} else if (cmd.startsWith("remove")) {
				try {
				playList.remove(Integer.parseInt(cmd.trim().substring(7))-1);
				} catch (IllegalArgumentException e) {
					System.out.println("Please follow the remove command with a space and a non-negative integer that is a valid position to remove.");
				}
			} else if (cmd.startsWith("sort")) {
				if (cmd.substring(5).startsWith("-d")) {
					playList.sortDuration();
				} else if (cmd.substring(5).startsWith("-a")) {
					playList.sortAlpha();
				} else {
					System.out.println("-d\tSort by duration\n-a\tSort alphabetically");
				}
			} else if (cmd.startsWith("get")) {
				try {
					System.out.println(playList.getSong(Integer.parseInt(cmd.trim().substring(4))-1));
				} catch (IllegalArgumentException e) {
					System.out.println("Please follow the get command with a space and a non-negative integer that is a valid position to retrieve.");
				}
			} else if (cmd.startsWith("print")) {
				System.out.println(playList);
			} else if (cmd.startsWith("help")) {
				help();
			} else if (cmd.startsWith("exit")) {
				System.exit(0);
			}
		}
	}

	public static void help() {
		System.out.println("In order to do things, type one of the following commands:\n" +
				"init\t-will allow you to make a new playlist from scratch\n" +
				"exit\t-will exit the program\n" +
				"sort\t-will sort the playlist (follow with space and either \"-a\" (for alphabetical) or \"-d\" (for duration-based)\n" +
				"get\t\t-will get an element from the playlist, follow with space and the index to retrieve (starts counting at 1)\n" +
				"remove\t-will remove an element from the playlist, follow with space and the index to remove (starts counting at 1)\n" +
				"print\t-will print all elements of the playlist (will print positions, which start at 1 and are one higher than indices)\n" +
				"help\t-will print all of these commands as they are here");
	}

	public static PlayList makePlaylist() {
		int num = 0;    // number of songs
		while (true) {
			try {
				num = Integer.parseInt(input("How many songs would you like in your playlist?\n"));
				if(num < 0) {
					throw new NumberFormatException();
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a non-negative integer. Try again.");
			}
		}

		PlayList tempList = new PlayList(num);

		for(int i = 0; i < num; i++) {
			String name = input("Enter the name of song " + (i+1) + ": ");
			String artist = input("Enter the artist of song " + (i+1) + ": ");
			int min;
			int sec;

			while (true) {
				try {
					min = Integer.parseInt(input("Enter the minutes of song " + (i + 1) + ": "));
					sec = Integer.parseInt(input("Enter the seconds of song " + (i + 1) + ": "));
					if (sec >= 60 || sec < 0 || min < 0) {
						throw new IllegalArgumentException();
					}
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("Please enter non-negative integers and make sure seconds is less than 60. Try again.");
				}
			}

			tempList.setSong(i, new Song(name, artist, min, sec));

			System.out.println();
		}

		System.out.println("Playlist creation complete.");
		return tempList;
	}

	public static String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}
}