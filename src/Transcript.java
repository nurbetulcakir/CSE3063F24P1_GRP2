
public class Transcript extends Student{
	
	private double gpa;
	private double cpga;
	private int creditReceived;
	private int creditEarned;
	private int totalCreditReceived;
	private int totalCreditEarned;
	
	public Transcript(ID StudentID, String firstName, String lastName, double gpa,
			double cpga, int creditReceived, int creditEarned, int totalCreditReceived,
			int totalCreditEarned) {
		
		super(StudentID, firstName, lastName);
		this.setGpa(gpa);
		this.setCpga(cpga);
		this.setCreditReceived(creditReceived);
		this.setCreditEarned(creditEarned);
		this.setTotalCreditReceived(totalCreditReceived);
		this.setTotalCreditEarned(totalCreditEarned);
		
		
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public double getCpga() {
		return cpga;
	}

	public void setCpga(double cpga) {
		this.cpga = cpga;
	}

	public int getCreditReceived() {
		return creditReceived;
	}

	public void setCreditReceived(int creditReceived) {
		this.creditReceived = creditReceived;
	}

	public int getCreditEarned() {
		return creditEarned;
	}

	public void setCreditEarned(int creditEarned) {
		this.creditEarned = creditEarned;
	}

	public int getTotalCreditReceived() {
		return totalCreditReceived;
	}

	public void setTotalCreditReceived(int totalCreditReceived) {
		this.totalCreditReceived = totalCreditReceived;
	}

	public int getTotalCreditEarned() {
		return totalCreditEarned;
	}

	public void setTotalCreditEarned(int totalCreditEarned) {
		this.totalCreditEarned = totalCreditEarned;
	}

}
