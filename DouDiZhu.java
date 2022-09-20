import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class DouDiZhu{
    public static void main(String[] args) {
		HashMap<Integer,String> poker =new HashMap<>();
		ArrayList<Integer> IndexOfList=new ArrayList<>();
		List<String> colours=List.of("♠","♥","♣", "♦" );
		List<String> numbers=List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3" );
		int index=0;
		poker.put(index, "Red Joke");
		IndexOfList.add(index);
		++index;
		poker.put(index, "Black Joke");
		IndexOfList.add(index);
		++index;
		for(String number:numbers) {
			for(String colour:colours) {
				poker.put(index, colour+number);
				IndexOfList.add(index);
				++index;
			}
		}
//		System.out.println(poker);
		Collections.shuffle(IndexOfList);
		ArrayList<Integer> player1 = new ArrayList<>();
		ArrayList<Integer> player2 = new ArrayList<>();
		ArrayList<Integer> player3 = new ArrayList<>();
		ArrayList<Integer> base = new ArrayList<>();
		for (int i = 0; i < 54; i++) {
			Integer p = IndexOfList.get(i);
			if (i >= 51) {
				base.add(p);
			} else if (i % 3 == 0) {
				player1.add(p);
			} else if (i % 3 == 1) {
				player2.add(p);
			} else if (i % 3 == 2) {
				player3.add(p);
			}
		}
		Collections.sort(player1);
		Collections.sort(player2);
		Collections.sort(player3);
		Collections.sort(base);
		showPoker("apple",poker,player1);
		showPoker("bob",poker,player2);
		showPoker("cat",poker,player3);
		showPoker("BASE",poker,base);
		System.out.println(player1.size()+" "+player2.size()+" "+player3.size());
	}

	private static void showPoker(String name,HashMap<Integer,String> poker,ArrayList<Integer> list) {
		System.out.println(name+": ");
		for(Integer key:list) {
			String value=poker.get(key);
			System.out.print(value+" ");
		}
		System.out.println();
		
	}
	
}