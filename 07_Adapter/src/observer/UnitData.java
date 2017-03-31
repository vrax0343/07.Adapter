package observer;

import java.util.*;

import unit.SingletonUnit;

public class UnitData implements Subject {
	private ArrayList<Observer> observers;
//	private Unit unit;
	private ArrayList<SingletonUnit> unit;
	
	public UnitData() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(observer.Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeObserver(observer.Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers(ArrayList<SingletonUnit> unit, int locationX, int locationY, int range) {
		// TODO Auto-generated method stub
		for (Observer observer : observers) {
			observer.update(unit,locationX,locationY,range);
		}
	}
	public void changed(ArrayList<SingletonUnit> unit, int locationX, int locationY, int range) {
		notifyObservers(unit,locationX,locationY,range);
	}
	
	public void setUnit(ArrayList<SingletonUnit> unit) {
		this.unit = unit;
	}
	
	public ArrayList<SingletonUnit> getUnit() {
		return this.unit;
	}



	
}
