public class PlayList {
	public Song[] playList;

	public PlayList(int num) {
		playList = new Song[num];
	}

	public Song[] sortAlpha() {
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
		return playList;
	}
}
