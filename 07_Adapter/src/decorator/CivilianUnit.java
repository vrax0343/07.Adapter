package decorator;

import behavior.attack.Punch;
import behavior.movement.Walk;
import behavior.weapon.Fist;
import factory.af.unit.TeamUnit;

public class CivilianUnit extends TeamUnit {
	public CivilianUnit(){
		health=10;
		type="Civilian";
		
		attack = new Punch();
		movement = new Walk();
		weapon = new Fist();
	}
	public TeamUnit attack(){ 
		System.out.println("�븻 ����");
		return this;
	}
	public void move(){
		System.out.println("�븻 �̵�");
	}
	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		
	}
}
