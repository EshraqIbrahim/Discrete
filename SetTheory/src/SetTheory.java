import java.util.ArrayList;

public class SetTheory implements SetTheoryFunctions {

	@Override
	public ArrayList<String> Union(ArrayList<ArrayList<String>> targetSet, int index1, int index2) {
		// TODO Auto-generated method stub
		ArrayList<String> firstSet = new ArrayList<String>();
		ArrayList<String> secondSet = new ArrayList<String>();
		ArrayList<String> answer = new ArrayList<String>();
		firstSet = targetSet.get(index1-1);
		secondSet = targetSet.get(index2-1);
		for(int i=0;i<firstSet.size();i++){
			answer.add(firstSet.get(i));
		}
		for(int i=0;i<secondSet.size();i++){
			if(!answer.contains(secondSet.get(i))){
			answer.add(secondSet.get(i));
			}
		}
		return answer;
	}

	@Override
	public ArrayList<String> intersection(ArrayList<ArrayList<String>> targetSet, int index1, int index2) {
		// TODO Auto-generated method stub
		ArrayList<String> firstSet = new ArrayList<String>();
		ArrayList<String> secondSet = new ArrayList<String>();
		ArrayList<String> answer = new ArrayList<String>();
		firstSet = targetSet.get(index1-1);
		secondSet = targetSet.get(index2-1);
		for(int i=0;i<firstSet.size();i++){
			
			for(int j=0;j<secondSet.size();j++){
				
				if(firstSet.get(i).equals(secondSet.get(j))){
					
					answer.add(firstSet.get(i));
				}
			}
		}
		return answer;
	}

	@Override
	public ArrayList<String> Complement(ArrayList<ArrayList<String>> targetSet,ArrayList<String> universe, int index) {
		// TODO Auto-generated method stub
		ArrayList<String> set = new ArrayList<String>();
		ArrayList<String> answer = new ArrayList<String>();
		set = targetSet.get(index-1);
		for(int i=0;i<targetSet.size();i++){
			if(i!=(index-1)){
				ArrayList<String> temp = new ArrayList<String>();
				temp = targetSet.get(i);
				for(int j=0;j<temp.size();j++){
				if((!set.contains(temp.get(j)))&&(!answer.contains(temp.get(j)))){
					answer.add(temp.get(j));
				}
				}
			}
		}
		for(int i=0;i<universe.size();i++){
			boolean check = false;
			for(int j=0;j<answer.size();j++){
				if(universe.get(i).equals(answer.get(j))){
					
					check = true;
					
				}
			}
			if(check==false){
				if(!set.contains(universe.get(i))){
				answer.add(universe.get(i));
				}
			}
		}
		return answer;
	}

}
