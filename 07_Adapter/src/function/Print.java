package function;

import java.util.ArrayList;
import java.util.Iterator;

import unit.SingletonUnit;

public class Print {
	ArrayList<SingletonUnit> unitList=null;
	Iterator<SingletonUnit> iterator = null;
//	public Print() { }
	public Print(ArrayList<SingletonUnit> unitList){ 
		iterator = unitList.iterator();
	}
	
	public void printOne(String type){
		boolean result = false;
		while(iterator.hasNext()){
			SingletonUnit tempUnit = iterator.next();
			String tempType = tempUnit.getType();
			
			if(tempType.contains(type)){
				System.out.println(tempUnit.toString());
				result=true;
				return;
			}
			
		}
		if (result==false)
			System.out.println("��� ����");
	}
	public void printAll() {
		// TODO Auto-generated method stub
		int i = 1;
		while(iterator.hasNext()){
			SingletonUnit tempUnit = iterator.next();
			System.out.println("---"+i+"��° ������ " + tempUnit.getType()+"�Դϴ�.---");
			System.out.print("Type: "+tempUnit.getType() + "\t"+
					"Health: " + tempUnit.getHealth() + "\t"+
					"Location X,Y: " + tempUnit.getLocationX()+","+tempUnit.getLocationY()+"\t"+
					"WeaponType: " + tempUnit.getWeaponType() + "\t"+
					"MovementType: " + tempUnit.getMovementType() + "\t"+
					"AttackType: " + tempUnit.getAttackType() + "\n");
			
			i++;
		}
		if(i==1)
			System.out.println("���� ������ �������� �ʽ��ϴ�.");
	}
}
