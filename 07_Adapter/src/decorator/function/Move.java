package decorator.function;

import check.MapLimitCheck;
import factory.af.unit.TeamUnit;

public class Move {
	public void moveOnce(TeamUnit tempUnit,int locX, int locY){
		int x, y=0;
		System.out.print("�Ϲ� �̵��� �մϴ�.");
		System.out.print("�̵���: ("+tempUnit.getLocationX()+","+tempUnit.getLocationY()+")");
		
		MapLimitCheck mlc = new MapLimitCheck();
		x=mlc.check(locX);
		y=mlc.check(locY);
		if((x!=locX) || (y!=locY)){
			System.out.println("�� �ִ� ũ��� ���� ������ ��ǥ��: ("+x+","+y+")"+"�Դϴ�.");
		}
		
		tempUnit.setLocationX(x);
		tempUnit.setLocationY(y);
		
		System.out.println("\t�̵���: ("+tempUnit.getLocationX()+","+tempUnit.getLocationY()+")");
//		System.out.println("hi");
	}
	
	public TeamUnit moveSuperMove(TeamUnit unit,int locX, int locY){
		MapLimitCheck mlc = new MapLimitCheck();
		int x=mlc.check(locX);
		int y=mlc.check(locY);
		if(x!=locX || y!=locY)
			System.out.println("�� �ִ� ũ��� ���� ������ ��ǥ��: ("+locX+","+locY+")"+"�Դϴ�.");
		else
			System.out.println("��ǥ������: ("+locX+","+locY+")"+"�Դϴ�.");
		while(true){
			if((unit.health <1) || ((locX==unit.locationX)&&(locY==unit.locationY))){
				System.out.println("ü���� �����Ͽ� �̵��� �� �����ϴ�.");
				break;
			} 
			
			if(locX < unit.locationX) unit.locationX-=2;
			else if(locX > unit.locationX) unit.locationX+=2;
			else if(locY > unit.locationY) unit.locationY+=2;
			else if(locY < unit.locationY) unit.locationY-=2;
			unit.health -=1;
		}
		
		return unit;
	}
	
//	public NormalUnit moveOnce(NormalUnit tempUnit){
//		if (tempUnit.health < 1){ }
//		else{
//			Move move = new Move();
//			move.movee(tempUnit);
//		}
//		
//		return tempUnit;
//	}
}
