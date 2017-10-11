package aug6;

public class HashMapclient {

	public static void main(String[] args) {

		HashMap<String, Integer> map=new HashMap<>();
		map.put("India", 125);
		map.put("Pak",10);
		map.put("Aus", 25);
		map.put("Afganistan", 120);
		map.display();
		map.put("China", 200);
		map.put("America", 90);
		map.put("New zealand", 30);
		map.display();
		map.put("China", 20);
		map.display();
		System.out.println(map.containskey("India"));
		System.out.println(map.get("India"));
		map.remove("India");
		System.out.println(map.containskey("India"));
		System.out.println(map.keyset());
	}

}
