package beans;

public enum TypeEpisode {

	OVA(2), MOVIE(3), EPISODE(1);
	
	private int type;

	TypeEpisode(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
