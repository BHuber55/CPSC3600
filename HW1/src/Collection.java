
public class Collection<T> {
	private T[] items;

	// probably not okay.. but we will see what happens.
	@SuppressWarnings("unchecked")
	public Collection() {
		items = (T[]) new Object[10];
	}

	public boolean isEmpty() {
		return (items.length == 0);
	}

	public void makeEmpty() {
		for (int i = 0; i < items.length; i++) {
			items[i] = null;
		}
	}

	public void insert(T item) {
		for(int i = 0; i < items.length; i++) {
			if(items[i] == null){
				items[i] = item;
				break;
			}
		}
	}
	
	public void remove(T item) {
		for(int i = 0; i < items.length; i++) {
			if(item.equals(items[i])) {
				items[i] = null;
			}
		}
	}

	public boolean isPresent(T item) {
		for (int i = 0; i < items.length; i++) {
			if (item.equals(items[i]) || item == items[i]) {
				return true;
			}
		}
		
		return false;
	}

	public T get(int i) {
		return items[i];
	}

	public int size() {
		int size = 0;
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				size++;
			}
		}
		
		return size;
	}
}
