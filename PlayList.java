public class PlayList {
	public Song[] playList;

	public PlayList(int num) {
		playList = new Song[num];
	}

	public Song getSong(int index) {
		try {
			return playList[index];
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
	}

	public void setSong(int index, Song song) {
		playList[index] = song;
	}

	public void sortAlpha() {
		for(int i = 0; i < playList.length-1; i++) {
			int first = i;
			for(int j = i+1; j < playList.length; j++) {
				if(playList[j].getSongName().compareTo(playList[first].getSongName()) < 0) {
					first = j;
				}
			}
			Song temp = playList[i];
			playList[i] = playList[first];
			playList[first] = temp;
		}
	}

	public void sortDuration() {
		for(int i = 0; i < playList.length-1; i++) {
			int min = i;
			for(int j = i+1; j < playList.length; j++) {
				if(playList[j].getDuration() < playList[min].getDuration()) {
					min = j;
				}
			}
			Song temp = playList[i];
			playList[i] = playList[min];
			playList[min] = temp;
		}
	}

	public Song remove(int index) {
		if(index >= playList.length || index < 0) {
			return null;
		}

		Song out = playList[index];
		Song[] temp = new Song[playList.length-1];

		int newI = 0;
		for(int orig = 0; orig < playList.length; orig++) {
			if(orig == index) {
				orig++;
			}
			temp[newI] = playList[orig];
			newI++;
		}

		playList = temp;

		return out;
	}

	public String toString() {
		String built = "";
		for (int i = 0; i < playList.length; i++) {
			built += (i+1) + ". " + playList[i] + "\n";
		}
		if(built.length() > 0) {
			built = built.substring(0, built.length()-1); // chopping off that extra \n
		}
		return built;
	}
}
