package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Tests {

	public static void test1() {

		Person p1 = new Person(45, "Bob", "Bobson");
		Person p2 = new Person(45, "Alex", "Jackson");
		Person p3 = new Person(35, "Frank", "Stone");

		ArrayList<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);

		LinkedList<Person> list2 = new LinkedList<Person>();
		list2.add(p1);
		list2.add(p2);
		list2.add(p3);

		list.sort(new PersonComparrator());
		System.out.println(list);
		Collections.sort(list2);
		System.out.println(list2);
	}

	public static void test2() {

		Person p1 = new Person(45, "Bob", "Bobson");
		Person p2 = new Person(45, "Alex", "Jackson");
		Person p3 = new Person(45, "Frank", "Stone");
		Person p4 = new Person(45, "Frank", "Stone");

		Set<Person> set = new TreeSet<Person>();
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);

		System.out.println(set);
	}

	public static void test3() {

		Person p1 = new Person(45, "Bob", "Bobson");
		
		String str = "Lorem USER_NAME USER_LASTNAME is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
				+ "when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, "
				+ "but also the leap into electronic typesetting, remaining essentially unchanged. "
				+ "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, "
				+ "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

		String[] words = str.split(" ");

		StringBuilder sb = new StringBuilder();
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String word : words) {

			//System.out.println("[" + word + "]");
			
		
			if(word.equals("USER_NAME")){
				sb.append(p1.getName());
			}else if(word.equals("USER_LASTNAME")){
				sb.append(p1.getLastName());
			}else{
				sb.append(word);
			}
			
			
		}
		System.out.println(sb);
		System.out.println("-------------------");
		
//		Iterator <Entry<String, Integer>> iter = map.entrySet().iterator();
//		while(iter.hasNext()){
//			Entry<String, Integer> entry = iter.next();
//			System.out.println(entry);
//		}

	}
}
