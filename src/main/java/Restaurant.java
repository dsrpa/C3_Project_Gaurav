import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private final String name;
	private final String location;
	public LocalTime openingTime;
	public LocalTime closingTime;
	private final List<Item> menu = new ArrayList<Item>();

	public Restaurant(final String name, final String location,
					  final LocalTime openingTime, final LocalTime closingTime) {
		this.name = name;
		this.location = location;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
	}

	public boolean isRestaurantOpen() {
		return this.getCurrentTime().isAfter(this.openingTime)
				&& this.getCurrentTime().isBefore(this.closingTime);
	}

	public LocalTime getCurrentTime() {
		return LocalTime.now();
	}

	public List<Item> getMenu() {
		return menu;
	}

	public Item findItemByName(final String itemName) {
		for (final Item item : menu) {
			if (item.getName().equals(itemName)) {
				return item;
			}
		}
		return null;
	}

	public void addToMenu(final String name, final int price) {
		final Item newItem = new Item(name, price);
		menu.add(newItem);
	}

	public void removeFromMenu(final String itemName) throws itemNotFoundException {

		final Item itemToBeRemoved = findItemByName(itemName);
		if (itemToBeRemoved == null) {
			throw new itemNotFoundException(itemName);
		}

		menu.remove(itemToBeRemoved);
	}

	public void displayDetails() {
		System.out.println("Restaurant:" + name + "\n"
				+ "Location:" + location + "\n"
				+ "Opening time:" + openingTime + "\n"
				+ "Closing time:" + closingTime + "\n"
				+ "Menu:" + "\n" + getMenu());

	}

	public String getName() {
		return name;
	}

}
