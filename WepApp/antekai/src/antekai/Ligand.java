package antekai;

public class Ligand {
	
	private int ligand_id;
	private String name;
	private String smile;
	private double ki;
	
	public Ligand()
	{
		//do nothing
	}
	
	public Ligand(int ligand_id, String name, String smile) {
		super();
		this.ligand_id = ligand_id;
		this.name = name;
		this.smile = smile;
	}
	
	public int getLigand_id() {
		return ligand_id;
	}
	public void setLigand_id(int ligand_id) {
		this.ligand_id = ligand_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSmile() {
		return smile;
	}
	public void setSmile(String smile) {
		this.smile = smile;
	}

	public String getKi() {
		String x=""+ki;
		return x;
	}

	public void setKi(double ki) {
		this.ki = ki;
	}
	
	
	
	
}
