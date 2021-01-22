public class itemNotFoundException extends Throwable {
	public itemNotFoundException(final String itemName) {
		super(itemName);
	}
}