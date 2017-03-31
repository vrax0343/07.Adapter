package observer;

import java.util.ArrayList;

import unit.SingletonUnit;

public interface Observer {
	public void update(ArrayList<SingletonUnit> unit, int locationX, int locationY, int range);
}
