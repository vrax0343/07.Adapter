package adapter;

import java.util.ArrayList;
import java.util.Iterator;

import unit.SingletonUnit;

public class MakingUnitClass {
	ArrayList<UnitClass> unitClassList=new ArrayList<UnitClass>();
	





	public ArrayList<UnitClass> makingUnitClass(SingletonUnit u){
		SingletonUnit tempUnit;
		ArrayList<SingletonUnit> unitList = u.getUnitList();
		Iterator<SingletonUnit> iterator = unitList.iterator();
		
		
		
		while(iterator.hasNext()){
			UnitClass tempNewUnit = new UnitClass();
			tempUnit = iterator.next();
			tempNewUnit.type = tempUnit.getType();
			tempNewUnit.locationX = tempUnit.getLocationX();
			tempNewUnit.locationY = tempUnit.getLocationY();
			tempNewUnit.health = tempUnit.getHealth();
			tempNewUnit.attack = tempUnit.getAttackBehavior();
			tempNewUnit.movement = tempUnit.getMovementBehavior();
			tempNewUnit.weapon = tempUnit.getWeaponBehavior();
			
			tempNewUnit.maxHealth = tempUnit.getHealth() * 2;
			tempNewUnit.maxMana = tempNewUnit.maxHealth;
			tempNewUnit.mana = tempNewUnit.maxHealth;
			
			unitClassList.add(tempNewUnit);
		}
		return unitClassList;
		
		
	}
}
