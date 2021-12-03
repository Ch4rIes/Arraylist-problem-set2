import java.util.*;
class Main {
	public static ArrayList<Integer> eraSieve(int num){
		// problem 1
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 2 ; i < num + 1 ; i++){result.add(i);}
		for(int i = 0 ; i < result.size() ; i++){
			for(int j = i + 1 ; j < result.size() ; j++){
				if(result.get(j) % result.get(i) == 0){
					result.remove(j); 
					j--;
				}
			}
		}
		return result;
	} 
	public static void goldbach(int num){
		// problem 2
		ArrayList<Integer> primes = eraSieve(num);
		HashSet<Integer> cont = new HashSet<Integer>();
		for(int i = 0 ; i < primes.size() ; i++){
			int cur = primes.get(i);
			if(cont.contains(num - cur)){
				System.out.println(cur +" "+ (num - cur));
				break;
			}else if(cur + cur == num){
				System.out.println(cur  + " " + cur);
				break;
			}else{
				cont.add(cur);
			}
		}
	}
	public static ArrayList<Integer> addingBigInts(ArrayList<Integer> list1 , ArrayList<Integer> list2){
		//problem 3
		Collections.reverse(list1);
		Collections.reverse(list2);
		ArrayList<Integer> result = new ArrayList<Integer>();
		int rest = 0;
		for(int i = 0 ; i < Math.max(list1.size() , list2.size()) ; i++){
			if(i >= list1.size())
				list1.add(0);
			if(i >= list2.size())
				list2.add(0);
		}
		for(int i = 0 ; i < list1.size() ; i++){
			int num1 = list1.get(i);
			int num2 = list2.get(i);
			result.add((num1 + num2 + rest) % 10);
			rest = (num1 + num2 + rest)/10;
		}
		if(rest > 0){
			result.add(rest);
		}
		Collections.reverse(result);
		return result;
	} 

  	public static void main(String[] args) {
		System.out.println(eraSieve(20));
    	goldbach(100);
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		l1.add(2); l1.add(5); l1.add(8); l1.add(9); l2.add(2); l2.add(5); l2.add(0);
		System.out.println(addingBigInts(l1 , l2));
  	}
}
