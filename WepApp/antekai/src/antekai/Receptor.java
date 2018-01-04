package antekai;

public class Receptor 
{
	private String unigene;
	private String name;
	private int receptorID;
	
	

	
	
	public Receptor() {
		super();
	}
	public String getUnigene() {
		return unigene;
	}
	public void setUnigene(String unigene) {
		this.unigene = unigene;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReceptorID() {
		return receptorID;
	}
	public void setReceptorID(int receptorID) {
		this.receptorID = receptorID;
	}
	
	@Override
	   public String toString() {
	        return ("receptor ID= " + this.receptorID + "\n name = " + this.name + "\n unigene = " + this.unigene);
	        
	}
	
}
