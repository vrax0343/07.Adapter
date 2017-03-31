package main;

import unit.*;

import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.ldap.UnsolicitedNotificationListener;

import adapter.UnitInterface;
import adapter.MakingUnitClass;
import adapter.StoneAdaptor;
import adapter.StoneClass;
import adapter.UnitAdapter;
import adapter.UnitClass;
import adapter.Village;
import behavior.weapon.*;
import decorator.SuperAttack;
import decorator.SuperMove;
import factory.af.unit.TeamUnit;
import factory.fm.*;
import function.FindUnit;
import function.GenerateRandomPosition;


public class MainTest {
	static final int KNIGHT = 0;
	static final int CITIZEN = 1; 
	static final int MAGE = 2;
	
	public static void main(String[] args){		
		
		SingletonUnit unit = SingletonUnit.getInstance();
		
		System.out.println("=======================================================");
		System.out.println("1. 중립 유닛을 종류별로 생성한다. ");
		System.out.println("=======================================================");
		
		unit.addUnit("Knight");
		unit.addUnit("Citizen");
		unit.addUnit("Mage");
		System.out.println();
		
		ArrayList<UnitClass> unitClassList = new MakingUnitClass().makingUnitClass(unit);
		
		
		
		System.out.println("=======================================================");
		System.out.println("2. 생성된 유닛을 모두 60, 60으로 이동한다.");
		System.out.println("=======================================================");
		
		Iterator<UnitClass> iter = unitClassList.iterator();
		while(iter.hasNext()){
			UnitClass tempUnit = iter.next();
			tempUnit.setLocationX(60);
			tempUnit.setLocationY(60);
		}
		System.out.println();
	
		System.out.println("=======================================================");
		System.out.println("3. (30,30)-(50, 50) 에 마을을 생성한다.");
		System.out.println("=======================================================");
		
		Village village = new Village(30,30,50,50);
		System.out.println();
	
		
		System.out.println("=======================================================");
		System.out.println("4. 시민이 마을안으로 들어갔다");
		System.out.println("=======================================================");
		
//		village.enterVillage(unit.findOne("Citizen"));
		village.enterVillage(unitClassList.get(1));
		System.out.println();
	
		System.out.println("=======================================================");
		System.out.println("5. 기사가 마을안으로 들어갔다.");
		System.out.println("=======================================================");
		
//		village.enterVillage(unit.findOne("Knight"));
		village.enterVillage(unitClassList.get(0));
		System.out.println();
	
		System.out.println("=======================================================");
		System.out.println("6. 마을 정찰 수행 ");
		System.out.println("=======================================================");
		
		village.inspection();
		System.out.println();
		
		
		System.out.println("=======================================================");
		System.out.println("7. 마을에 일반 바위 생성하여 크기를 출력한다.");
		System.out.println("=======================================================");
		
		
		StoneClass stone = new StoneClass();
		stone.setStoneSize(GenerateRandomPosition.generate(1, 100));
		village.enterVillageStone(stone);
		
		System.out.println(stone.getSize());
//		village.enterVillage(stoneAdaptor);
//		testUnit(stoneAdaptor);
		
		
//		village.
		System.out.println();
	
		System.out.println("=======================================================");
		System.out.println("8. 유닛으로 어댑팅된 바위 생성");
		System.out.println("=======================================================");
		StoneClass stone2 = new StoneClass();
		UnitInterface stoneAdaptor = new StoneAdaptor(stone);
		System.out.println();
		
		
		System.out.println("=======================================================");
		System.out.println("9. 바위가 공격한다.");
		System.out.println("=======================================================");
		try{
			stone2.attack();
		}catch(UnsupportedOperationException uoe){
			System.out.println(uoe.getMessage());
		}
		
		
		System.out.println();

		System.out.println("=======================================================");
		System.out.println("10. 바위가 이동한다. ");
		System.out.println("=======================================================");
		
		try{
			stone2.move();
		}catch(UnsupportedOperationException uoe){
			System.out.println(uoe.getMessage());
		}
		
		System.out.println("=======================================================");
		System.out.println("11. 바위가 특수능력을 수행한다.");
		System.out.println("=======================================================");
//		mage.attack();
//		System.out.println();
//		mage.doSelfHeal();
		System.out.println();
		
//		System.out.println("=======================================================");
//		System.out.println("12. 바위의 크기를 출력한뒤 죽는다.");
//		System.out.println("=======================================================");
//		mage.attack();
//		System.out.println();
//		mage.doSelfHeal();
//		System.out.println();

	
	}
	static void testUnit(UnitInterface ui){
		try{
			ui.attack();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
