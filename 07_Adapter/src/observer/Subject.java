package observer;

import java.util.ArrayList;

import unit.SingletonUnit;

public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	void notifyObservers(ArrayList<SingletonUnit> unit, int locationX, int locationY, int range);
}
