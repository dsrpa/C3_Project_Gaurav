public class Item {
	private final String name;
	private final int price;

	public Item(final String name, final int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + ":"
				+ price
				+ "\n"
				;
	}
}
