package function;

import java.util.ArrayList;

import check.MapLimitCheck;
import unit.SingletonUnit;

public class RememberUnit {
	public RememberUnit() { }
	
	public ArrayList<SingletonUnit> rememberOne(ArrayList<SingletonUnit> unitList, ArrayList<SingletonUnit> detectList, String type){
		if (detectList ==null)
			detectList = new ArrayList<SingletonUnit>();
		detectList.add(new FindUnit().findOneByType(unitList, type));
		return detectList;
	}
}
