import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Topology {

	public int num_nodes, num_neighbors; 
	public String topology;
	public ArrayList<Node> all_nodes = new ArrayList<Node>();
	public ArrayList<Node> nodes = new ArrayList<Node>();
	private static final Random rnd = new Random();
	//constructor
	public Topology(int N, int k, String t){
		this.num_nodes = N;
		this.num_neighbors = k;
		this.topology = t;
	}//constructor ends here
	
	public void identifyNodes() {
		for(int i=1; i<=this.num_nodes; i++){
			Node temp = new Node (i, this.num_nodes, this.num_neighbors);
			if(this.topology == "O") {
				temp.createAddrO();
			}
			else if(this.topology == "B") {
				temp.createAddrB();
			}
			all_nodes.add(temp);
			nodes.add(temp);
		}//for loop ends here
	}//Method identifyNodes ends here
	
	public void initialize(){
		Collections.shuffle(nodes, rnd);
		for(int j=0; j<this.num_nodes; j++){ //for all nodes from 0 to N-1
			Collections.shuffle(nodes, rnd);
		    for(int k=0; k<this.num_neighbors; k++){ //add neighbors from 0 - k-1
		    	if(nodes.get(k).getIdentifier() != all_nodes.get(j).getIdentifier()){
		    		all_nodes.get(j).View.add(nodes.get(k).getIdentifier());//is this necessary???
		    		all_nodes.get(j).setPartialView(k, nodes.get(k).getIdentifier());
		    	}
			}
		}//for loop ends here
	}//method initialize ends here
	
	public void rankO(){
		int rank, absolute, a, b;
		for(int i=0; i<this.num_nodes; i++){ //for all nodes in system,
			for(int j=0; j<all_nodes.get(i).View.size(); j++) { //rank the nodes
				a=all_nodes.get(i).getIdentifier();
				b=all_nodes.get(i).getView(j);
				if((a-b)<0){
					absolute=b-a;
				}
				else absolute = a-b;
				rank = Math.min(num_nodes - absolute, absolute);
				all_nodes.get(i).setRanking(j, rank);
			}
		}
	}//method rankO ends here
	
	public void sort(){
		int max = -1;
		int maxIndex = -1;
		for(int i=0; i<this.num_nodes; i++){ //for all nodes in system,
			for(int j=this.num_neighbors; j>0; j--) {
				for(int k = 0; k<all_nodes.get(i).View.size(); k++) {
					if(max < all_nodes.get(i).getRanking(j)){
						max=all_nodes.get(i).getRanking(j);
						maxIndex = k;
					}
				}
				all_nodes.get(i).setPartialView(j, max);
				all_nodes.get(i).View.remove(maxIndex);
				all_nodes.get(i).Ranking.remove(maxIndex);
			}
			all_nodes.get(i).View.clear();
			all_nodes.get(i).Ranking.clear();
		}
	}//Method sort ends here
	
	public void exchange(){
		
	}
}//Class Topology ends here
