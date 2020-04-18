import java.util.ArrayList;

public class for문_리스트_중간삭제 {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		
		int size = list.size();

		for (int i=0; i < size; i++) {
			if(i == 3) {
				list.remove(i);
				i--;
				size--;
			}else {				
			}
			System.out.println(list.get(i));
			System.out.println(size+" size");
		}

//		System.out.println();
//		
//		for (int i=0,size = list.size(); i < list.size(); i++) {
//			if(i == 3) {
//				list.remove(i);
//				i--;
//			}else {				
//				System.out.println(list.get(i));
//			}
//			System.out.println(size+" size");
//		}
	}
	
	
}
