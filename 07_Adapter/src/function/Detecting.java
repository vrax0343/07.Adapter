package function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import check.MapLimitCheck;
import unit.SingletonUnit;

public class Detecting {
	final static int POSITIVEX=0;
	final static int NEGATIVEX=1;
	final static int POSITIVEY=2;
	final static int NEGATIVEY=3;
	
	SingletonUnit u = null;
	int x,y,range=0;
	
	public Detecting() { }
	public Detecting(SingletonUnit u, int x, int y){
		this.range=20;
		this.u=u;
		this.x=x;
		this.y=y;
	}
	public Detecting(SingletonUnit u, int x, int y, int range){
		this.range=range;
		this.u=u;
		this.x=x;
		this.y=y;
		MapLimitCheck mlc = new MapLimitCheck();
		int[] intArray = {x+range,x-range,y+range,y-range};
		intArray = mlc.checkArray(intArray);
		int tempX=u.getLocationX(), tempY=u.getLocationY();
		
		tempX += x;
		tempY += y;
		
		u.setLocation(mlc.check(tempX), mlc.check(tempY));
	}
	public void detectUnit(ArrayList<SingletonUnit> detectList,int x, int y, int range){
		System.out.println("---Ž���� �����մϴ�.---");
		MapLimitCheck mlc = new MapLimitCheck();
		
		int[] intArray = new int[] {x+range,x-range,y+range,y-range};
		
		intArray = mlc.checkArray(intArray);
		System.out.print("Ž�� ����  X:"+"("+intArray[NEGATIVEX]+","+intArray[POSITIVEX]+")");
		System.out.println("\tY:"+"("+intArray[NEGATIVEY]+","+intArray[POSITIVEY]+")");
		Iterator<SingletonUnit> iterator = detectList.iterator();
		while(iterator.hasNext()){
			SingletonUnit tempUnit = iterator.next();
			int tempX=tempUnit.getLocationX();
			int tempY=tempUnit.getLocationY();
			if((intArray[NEGATIVEX] <= tempX) && (intArray[POSITIVEX] >= tempX)){
				if((intArray[NEGATIVEY] <= tempY) && (intArray[POSITIVEY] >= tempY)){
					System.out.println(tempUnit.getType() + "�� Ž�� ���� �ȿ� ������ ���� ��ġ�� ("+ tempX+", "+tempY+")�Դϴ�.");
				}else
					System.out.println(tempUnit.getType() + "�� Ž�� ���� ���Դϴ�.("+ tempX+", "+tempY+")");
			}else
				System.out.println("Ž�� ������ ������ �����ϴ�.");
			
		}
		
	}
}
