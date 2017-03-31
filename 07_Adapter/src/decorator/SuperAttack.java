package decorator;

import decorator.function.Fight;
import factory.af.unit.TeamUnit;

public class SuperAttack extends AbilityDecorator {
	TeamUnit teamUnit;
	public SuperAttack(TeamUnit unit){
		this.teamUnit=unit;
		System.out.println(teamUnit.teamName +" "+teamUnit.getName() + "��(��) ���� ������ �߽��ϴ�");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "���������� �մϴ�";
	}
	
	public TeamUnit attack(){
		System.out.println("���� ������ �մϴ�.");
		System.out.println("���� ü����: "+teamUnit.getHealth());
		System.out.println("-----------------------------");
		new Fight().fightSuperAttack(teamUnit);
		System.out.println("-----------------------------");
		System.out.println("���� �� ü����: "+teamUnit.getHealth());
		return teamUnit;
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		
	}
	
	public void move(int x, int y){
		teamUnit.move(x, y);
	}

}
