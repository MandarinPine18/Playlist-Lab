public class Song {
	private String name;
	private String artist;
	private int duration; //in seconds

	public Song(String name, String artist, int min, int sec) {
		this.name = name;
		this.artist = artist;
		this.duration = min*60 + sec;
	}

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

	public int getMinutes() {
		return duration / 60;
	}

	public int getSeconds() {
		return duration % 60;
	}

	public String toString() {
		return name + " by " + artist + " (" + getMinutes() + ":" + getSeconds() + ")";
	}
}
