
public class Dictionary {
public String index;
public String value;

public Dictionary() {
	
}//Constructor ends here

public Dictionary(int i, String v) {
	switch(i){
	case 0: this.index = "00"; break;
	case 1: this.index = "01"; break;
	case 2: this.index = "10"; break;
	case 3: this.index = "11"; break;
	default: System.out.println("Invalid value. Cannot be entered into dictionary"); break;
	}
	this.value = v;
}// Constructor ends here

public void setIndex(String i){
	this.index = i;
}

public void setIndexInt(int i){
	switch(i){
		case 0: this.index = "00"; break;
		case 1: this.index = "01"; break;
		case 2: this.index = "10"; break;
		case 3: this.index = "11"; break;
		default: System.out.println("Invalid value. Cannot be entered into dictionary"); break;
	}
}

public void setValue(String v){
	this.value = v;
}

public String getIndex(){
	return this.index;
}

public String getValue(){
	return this.value;
}

}//Dictionary class ends here
