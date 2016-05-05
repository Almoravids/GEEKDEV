package beans;

public enum Status {
comingSoon(1,"Coming Soon"),
onGoing(2,"On Going"),
complete(3,"Complete");
	private int statusId;
	private String status;
	
	
	
	private Status(int statusId,String status) {
		this.statusId=statusId;
		this.status=status;
	}
	
	public int getStatusId() {
		return statusId;
	}
	
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	  
	public String getStatus(int idStatus){
		String statueName = "";
		for (Status statue : Status.values())
			if (statue.getStatusId()==idStatus)
		    statueName=statue.getStatus();
		return statueName;
	}
}
