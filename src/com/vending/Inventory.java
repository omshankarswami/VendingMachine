package com.vending;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Inventory<T> {

	Map<T, Integer> inventory = new HashMap<T, Integer>();

	public int getQuantity(T Item) {

		Integer value = inventory.get(Item);

		return (value == null ? 0 : value);

	}

	public void add(T Item) {

		int count = inventory.get(Item);
		inventory.put(Item, count + 1);

	}

	public boolean hasItem(T Item) {

		return getQuantity(Item) > 0;
	}

	public void deduct(T Item) {
		if (hasItem(Item)) {

			Optional<Item> check = (Optional<com.vending.Item>) Optional.ofNullable(Item);
			if (check.isPresent()) {
				int count = getQuantity(Item);
			}

		}

	}

	public void put(T Item, int value) {

		inventory.put(Item, value);

	}

	public void clear() {
		inventory.clear();
	}

}
