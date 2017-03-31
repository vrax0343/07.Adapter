package function;

import java.util.ArrayList;
import java.util.Iterator;

import unit.SingletonUnit;

public class Died {
	ArrayList<SingletonUnit> unitList=null;
	Iterator<SingletonUnit> iterator = null;
//	public Died() { }
	public Died(ArrayList<SingletonUnit> unitList){ 
		this.unitList = unitList;
		this.iterator = unitList.iterator();
	}
	
	public void diedOne(String type){
		boolean result = false;
		while(iterator.hasNext()){
			SingletonUnit tempUnit = iterator.next();
			String tempType = tempUnit.getType();
			
			if(tempType.contains(type)){
				System.out.println(tempType + "�� �׾����ϴ�.");
				iterator.remove();
				result=true;
				return;
			}
			
		}
		if (result==false)
			System.out.println("���� ����");
	}
	public void diedAll() {
		// TODO Auto-generated method stub
		while(iterator.hasNext()){
			SingletonUnit tempUnit = iterator.next();
			String tempType = tempUnit.getType();
			System.out.println(tempType + "�� �׾����ϴ�.");
			iterator.remove();
		}
	}
	
}
