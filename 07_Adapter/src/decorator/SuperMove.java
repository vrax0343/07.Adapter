package decorator;

import decorator.function.Move;
import factory.af.unit.TeamUnit;

public class SuperMove extends AbilityDecorator {
	TeamUnit teamUnit;
	public SuperMove(TeamUnit unit){
		this.teamUnit=unit;
		System.out.println(teamUnit.teamName +" "+teamUnit.getName() + "��(��) ���� �̵��� �߽��ϴ�");
	}
	
	
	
	public void move(int locX, int locY){
		System.out.println("("+locX+","+locY+")"+"���� ���� �̵��� �մϴ�.");
		System.out.println("���� ü����: "+teamUnit.getHealth());
		System.out.println("���� ��ġ��: ("+teamUnit.locationX+","+teamUnit.locationY+")");
		
		System.out.println("-----------------------------");
		teamUnit=new Move().moveSuperMove(teamUnit, locX, locY);
		System.out.println("-----------------------------");
		System.out.println("�̵� �� ü����: "+teamUnit.getHealth());
		System.out.println("�̵� �� ��ġ��: ("+teamUnit.locationX+","+teamUnit.locationY+")");
		
//		unit.attack(unit);
	}



	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public TeamUnit attack() {
		// TODO Auto-generated method stub
		teamUnit.attack();
		return teamUnit;
	}



	
}
