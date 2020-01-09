package comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ProductComparator implements Comparator<Product> {

	enum SortType {
		NAME, WEIGHT, TYPE
	}

	private SortType type;

	@Override
	public int compare(Product o1, Product o2) {

		if (type == null) {
			throw new IllegalArgumentException("EMPTY SORTING TYPE");
		}

		switch (type) {
		case NAME:
			return o1.getName().compareTo(o1.getName());
		case WEIGHT:
			return new Double(o1.getWeight()).compareTo(o2.getWeight());
		case TYPE:
			return o1.getType().compareTo(o2.getType());
		}
		return 0;
	}

}

class Product {
	private String name;
	private double weight;
	private String type;

	public Product(String name, double weight, String type) {
		super();
		this.name = name;
		this.weight = weight;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product " + name + ", weight=" + weight + ", type=" + type + "]";
	}

}

class Creator {
	private String name;
	private int age;
	private Product product[];

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Product[] getProduct() {
		return product;
	}

	public void setProduct(Product[] product) {
		this.product = product;
	}

	public Creator(String name, int age, Product[] product) {
		super();
		this.name = name;
		this.age = age;
		this.product = product;
	}

	@Override
	public String toString() {
		return "Creator " + name + ", age=" + age + ", product=" + Arrays.toString(product) + "]\n";
	}

}

class Car implements Comparable<Car>, Comparator<Car> {
	private String model;
	private double price;

	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}

	public Car(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Car c) {

		return this.model.compareTo(c.getModel());
	}

	@Override
	public int compare(Car c1, Car c2) {
		if (c1.price == c2.price) {
			return 0;
		} else if (c1.price > c2.price) {
			return 1;
		} else {
			return -1;
		}
	}

}

class NumsComparator implements Comparator<Integer> {

	public boolean isAsc = false;

	public boolean isAsc() {
		return isAsc;
	}

	public void setAsc(boolean isAsc) {
		this.isAsc = isAsc;
	}

	public NumsComparator(boolean isAsc) {
		super();
		this.isAsc = isAsc;
	}

	public int compare(Integer a, Integer b) {
		if (isAsc) {

			return b.compareTo(a);
		} else

			return a.compareTo(b);
	}

}

class Phone {
	@Override
	public String toString() {
		return String.format("MODEL: %s. PRICE: %f. OS: %s\n%s\n", model, price, os, nums);

	}

	private String model;
	private String os;
	private List<String> nums;
	private Double price;

	public Phone(String model, String os, List<String> nums, Double price) {
		super();
		this.model = model;
		this.os = os;
		this.nums = nums;
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public List<String> getNums() {
		return nums;
	}

	public void setNums(List<String> nums) {
		this.nums = nums;

	}

}

public class Test {

	public static void main(String[] args) {

		// List<Integer> nums = Arrays.asList(1, -22, Integer.MAX_VALUE,
		// ((int) (Math.random() * 2)) == 0 ? Integer.MIN_VALUE :
		// Integer.MAX_VALUE);
		//
		// System.out.println("BEFORE SORTING:");
		// System.out.println(nums);
		//
		// NumsComparator comp = new NumsComparator(false);
		//
		// Collections.sort(nums, comp);
		//
		// System.out.println("AFTER SORTING:");
		// System.out.println(nums);
		//
		// comp.setAsc(true);
		// Collections.sort(nums, comp);
		// System.out.println(nums);
		//
		// System.out.println("------------------------------");
		//
		// List<String> str = Arrays.asList("Dima", "Artem", "Mike", "Nike");
		// System.out.println(str);
		/////////////////////////////////////////////////////////////////////////////////////////////////
		// List<Car> cars = new ArrayList<Car>();
		//
		// cars.add(new Car("BMW", 230000));
		// cars.add(new Car("ACURA", 120000));
		// cars.add(new Car("MERSEDES", 430000));
		// cars.add(new Car("AUDI", 340000));
		//
		// System.out.println(cars);
		// Collections.sort(cars);
		// System.out.println(cars);
		//
		// Collections.sort(cars, new Car("DYMMU", 0));
		// System.out.println(cars);

		List<Phone> phones = new ArrayList<Phone>();
		phones.add(new Phone("Apple X10", "iOS 9", Arrays.asList("+375294564584", "+375295564584", "+375292564584"),
				252.3));
		phones.add(new Phone("Apple X5", "iOS 8", Arrays.asList("+375296564584", "+375297564584", "+375293564584"),
				300.8));
		phones.add(new Phone("LG MX32", "Android 9", Arrays.asList("+375295564584", "+375293564584", "+375299564584"),
				100.8));

		for (Phone phone : phones) {
			Collections.sort(phone.getNums());
		}
		Collections.sort(phones, new Comparator<Phone>() {

			@Override // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			public int compare(Phone p1, Phone p2) {

				return p1.getOs().compareToIgnoreCase(p2.getOs());
			}

		});
		System.out.println("SORT");
		System.out.println(phones);

		boolean flag = true;
		Collections.sort(phones, (Phone a, Phone b) -> {
			if (flag) {
				return a.getPrice().compareTo(b.getPrice());
			} else {
				return b.getPrice().compareTo(a.getPrice());
			}

		});
		System.out.println("-----------------------------------------------");
		System.out.println("NEW STYLE:");
		System.out.println(phones);

		System.out.println("-----------------------------------------------");

		Collections.sort(phones, (a, b) -> {
			return a.getModel().compareTo(b.getModel());
		});

		System.out.println("NEW SHORT STYLE:");
		System.out.println(phones);

		////////////////////////////////////////////////////////////////////////////////////////////

		List<Creator> creat = new ArrayList<Creator>();
		
		Product prod1[] = new Product[2];
		prod1[0] = new Product("Audi", 1200, "Car");
		prod1[1] = new Product("BMW", 2200, "Car");
		creat.add(new Creator("Artem", 23, prod1));
		
		Product prod2[] = new Product[3];
		prod2[0] = new Product("Mercedes", 2300, "Car");
		prod2[1] = new Product("Acura", 1300, "Car");
		prod2[2] = new Product("Lamborgine", 4000, "Car");
		creat.add(new Creator("Dimon", 30, prod2));
		
		Product prod3[] = new Product[3];
		prod3[0] = new Product("Volvo", 2300, "Car");
		creat.add(new Creator("Pavel", 18, prod3));
		
		System.out.println(creat);
		
		new Product("", 1, "");
	}
}
