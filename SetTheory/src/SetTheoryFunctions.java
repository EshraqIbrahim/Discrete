import java.util.ArrayList;

public interface SetTheoryFunctions {
	 //Integer.parseInt
	public ArrayList<String> Union(ArrayList<ArrayList<String>> targetSet,int index1,int index2);
	public ArrayList<String> intersection(ArrayList<ArrayList<String>> targetSet,int index1,int index2);
	public ArrayList<String> Complement(ArrayList<ArrayList<String>> targetSet,ArrayList<String> universe,int index);
}
