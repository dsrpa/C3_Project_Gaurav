import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
	private static final List<Restaurant> restaurants = new ArrayList<>();

	public Restaurant findRestaurantByName(final String restaurantName) throws restaurantNotFoundException {
		for (final Restaurant restaurant : restaurants) {
			if (restaurant.getName().equals(restaurantName)) {
				return restaurant;
			}
		}

		throw new restaurantNotFoundException(restaurantName);
	}


	public Restaurant addRestaurant(final String name, final String location,
									final LocalTime openingTime, final LocalTime closingTime) {
		final Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
		restaurants.add(newRestaurant);
		return newRestaurant;
	}

	public Restaurant removeRestaurant(final String restaurantName) throws restaurantNotFoundException {
		final Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
		restaurants.remove(restaurantToBeRemoved);
		return restaurantToBeRemoved;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	// TDD SOLUTION
	/**
	 * Gets the total cost of the menu items, loop over all restaurants,
	 * and then loop over all the items and find their prices for a match and sum
	 *
	 * @param itemNames items to find
	 * @return total sum of the items
	 */
	public int getTotalPrice(final List<String> itemNames) {
		int sum = 0;

		return sum;
	}

	/**
	 * Clears the restaurants list
	 */
	public void clearRestaurants() {
	}

}
