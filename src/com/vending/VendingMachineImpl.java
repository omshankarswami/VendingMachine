package com.vending;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.exception.NotFullPaidException;
import com.exception.NotSufficientChangeException;
import com.exception.SoldOutExcepiton;

public class VendingMachineImpl implements VendingMachine {

	private Inventory<Coin> cashInventory = new Inventory<Coin>();
	private Inventory<Item> itemInventory = new Inventory<Item>();

	private long totalSales;
	private Item currentItem;
	private long currentBalance;

	public VendingMachineImpl() {
		initialize();
	}

	private void initialize() {
		for (Coin c : Coin.values()) {
			cashInventory.put(c, 5);
		}

		for (Item i : Item.values()) {
			itemInventory.put(i, 5);
		}
	}

	@Override
	public long selectItemAndGetPrice(Item item) {

		if (itemInventory.hasItem(item)) {
			currentItem = item;

			return currentItem.getPrice();
		}
		throw new SoldOutExcepiton("Sold Out, Please buy another item");
	}

	@Override
	public void insertCoin(Coin coin) {
		currentBalance = currentBalance + coin.getPrice();
		cashInventory.add(coin);

	}

	@Override
	public List<Coin> refund() {
		List<Coin> refund = getChange(currentBalance);
		updateCashInventory(refund);
		currentBalance = 0;
		currentItem = null;
		return refund;
	}

	private void updateCashInventory(List<Coin> change) {

		for (Coin c : change) {
			cashInventory.deduct(c);
		}
	}

	@Override
	public Bucket<Item, List<Coin>> collectItemAndChange() {
		Item item = collectItem();
		totalSales = totalSales + currentItem.getPrice();
		List<Coin> change = collectChange();
		return new Bucket<Item, List<Coin>>();

	}

	private List<Coin> collectChange()  {
		long changeAmount = currentBalance - currentItem.getPrice();
		List<Coin> change = getChange(changeAmount);
		updateCashInventory(change);
		currentBalance = 0;
		currentItem = null;
		return change;

	}			

	private boolean hasSufficientChange() {
		return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
	}

	private boolean hasSufficientChangeForAmount(long l) {

		return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
	}

	
	
	private Item collectItem() throws NotSufficientChangeException, NotFullPaidException {
		if (isFullPaid()) {
			if (hasSufficientChange()) {
				itemInventory.deduct(currentItem);
				return currentItem;
			}
		}
		throw new NotSufficientChangeException("Not Sufficient change in Inventory");

	}

	@Override
	public void reset() {
		cashInventory.clear();
		itemInventory.clear();

		totalSales = 0;
		currentItem = null;
		currentBalance = 0;

	}

	public List<Coin> getChange(long amount) {

		List<Coin> changes = Collections.EMPTY_LIST;

		if (amount > 0) {
			changes = new ArrayList<Coin>();
			long balance = amount;

			while (balance > 0) {
				if (balance >= Coin.QURTER.getPrice() && cashInventory.hasItem(Coin.QURTER)) {
					changes.add(Coin.QURTER);

					balance = balance - Coin.QURTER.getPrice();
					continue;
				} else if (balance >= Coin.DIME.getPrice() && cashInventory.hasItem(Coin.DIME)) {

					changes.add(Coin.DIME);
					balance = balance - Coin.DIME.getPrice();
					continue;

				} else if (balance >= Coin.NICKEL.getPrice() && cashInventory.hasItem(Coin.NICKEL)) {

					changes.add(Coin.NICKEL);
					balance = balance - Coin.NICKEL.getPrice();
					continue;
				} else if (balance >= Coin.PENNY.getPrice() && cashInventory.hasItem(Coin.PENNY)) {

					changes.add(Coin.PENNY);
					balance = balance - Coin.PENNY.getPrice();
					continue;
				} else {
					throw new NotSufficientChangeException("NotSufficientChange, Please try another Product");
				}
			}
		}
		return changes;
	}

	public boolean isFullPaid() {
		if (currentBalance >= currentItem.getPrice()) {
			return true;
		}
		return false;
	}

}
