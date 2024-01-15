package neu.edu.controller.response;

public class GenericResponse {

	
	public GenericResponse() {
		// TODO Auto-generated constructor stub
	}
	private boolean status;
	public GenericResponse(boolean status)
	{
		super();
		this.status=status;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
