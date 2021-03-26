class Main {
	public static void main(String[] args) {
		Song[] songs = {
				new Song("When Am I Going to Lose You", "Local Natives", 4, 24),
				new Song("Longshot", "Catfish & the Bottlemen", 3, 52),
				new Song("Tongue Tied", "Grouplove", 3, 38),
				new Song("Out of My League", "Fitz & The Tantrums", 3, 29)
		};

		PlayList playList = new PlayList(songs.length);
		playList.playList = songs;

		playList.sortAlpha();
	}
}