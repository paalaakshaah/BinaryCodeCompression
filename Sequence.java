
public class Sequence extends Dictionary{

	public String instruction;
	public String encoding;
	public String rest;
		
	public Sequence() {
		this.encoding = "none";
	}
	
	public Sequence(String i) {
		this.instruction = i;
	}
	
	public Sequence(String i, String e) {
		this.instruction = i;
		this.encoding = e;
	}//Constructors end here
		
	public void setInsrtuction(String i){
		this.instruction = i;
	}

	public void setEncoding(String e){
		this.encoding = e;
	}
	
	public void setRest(String r){
		this.rest = r;
	}
	
	public String getInstruction(){
		return this.instruction;
	}

	public String getEncoding(){
		return this.encoding;
	}
	
	public String getRest(){
		return this.rest;
	}
}//Sequence class ends here
