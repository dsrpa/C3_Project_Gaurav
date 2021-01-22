import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class RestaurantServiceTest {
	// Refactoring the code
	public static final String SWEET_CORN_SOUP = "Sweet corn soup";
	public static final String VEGETABLE_LASAGNE = "Vegetable lasagne";
	public static final int _119 = 119;
	public static final int _269 = 269;
	public static final String AMELIE_S_CAFE = "Amelie's cafe";
	public static final String CHENNAI = "Chennai";
	public static final String _12 = "12:00:00";
	private RestaurantService service;

	@BeforeEach
	public void setupData() {
		service = new RestaurantService();
		final LocalTime openingTime = LocalTime.parse("10:30:00");
		final LocalTime closingTime = LocalTime.parse("22:00:00");
		final Restaurant restaurant = service.addRestaurant(AMELIE_S_CAFE, CHENNAI, openingTime, closingTime);
		restaurant.addToMenu(SWEET_CORN_SOUP, _119);
		restaurant.addToMenu(VEGETABLE_LASAGNE, _269);
	}

	//>>>>>>>>>>>>>>>>>>>>>>SEARCHING<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	@Test
	public void searching_for_existing_restaurant_should_return_expected_restaurant_object() {
		try {
			final Restaurant restaurant = service.findRestaurantByName(AMELIE_S_CAFE);
			assertEquals(restaurant.getName(), AMELIE_S_CAFE);
		} catch (final restaurantNotFoundException ex) {
			fail();
		}
	}

	//You may watch the video by Muthukumaran on how to write exceptions in Course 3: Testing and Version control: Optional content
	@Test
	public void searching_for_non_existing_restaurant_should_throw_exception() throws restaurantNotFoundException {
		assertThrows(restaurantNotFoundException.class, () -> service.findRestaurantByName("ABC"));
	}
	//<<<<<<<<<<<<<<<<<<<<SEARCHING>>>>>>>>>>>>>>>>>>>>>>>>>>


	//>>>>>>>>>>>>>>>>>>>>>>ADMIN: ADDING & REMOVING RESTAURANTS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	@Test
	public void remove_restaurant_should_reduce_list_of_restaurants_size_by_1() throws restaurantNotFoundException {
		final int initialNumberOfRestaurants = service.getRestaurants().size();
		service.removeRestaurant(AMELIE_S_CAFE);
		assertEquals(initialNumberOfRestaurants - 1, service.getRestaurants().size());
	}

	@Test
	public void removing_restaurant_that_does_not_exist_should_throw_exception() {
		assertThrows(restaurantNotFoundException.class, () -> service.removeRestaurant("Pantry d'or"));
	}

	@Test
	public void add_restaurant_should_increase_list_of_restaurants_size_by_1() {
		final int initialNumberOfRestaurants = service.getRestaurants().size();
		service.addRestaurant("Pumpkin Tales", CHENNAI, LocalTime.parse(_12), LocalTime.parse("23:00:00"));
		assertEquals(initialNumberOfRestaurants + 1, service.getRestaurants().size());
	}
	//<<<<<<<<<<<<<<<<<<<<ADMIN: ADDING & REMOVING RESTAURANTS>>>>>>>>>>>>>>>>>>>>>>>>>>


}