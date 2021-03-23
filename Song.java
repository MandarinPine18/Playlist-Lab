public class Song {
	private String name;
	private String artist;
	private int duration; //in seconds

	public Song(String name, String artist, int duration) {
		this.name = name;
		this.artist = artist;
		this.duration = duration;
	}

	public String getSongName() {
		return name;
	}

	public String getArtistName() {
		return artist;
	}

	public int getDuration() {
		return duration;
	}
}
