package behavior.weapon;

import behavior.attack.AttackBehavior;

public class NoWeapon implements WeaponBehavior {

	@Override
	public void useWeapon(AttackBehavior ab){
		// TODO Auto-generated method stub
		System.out.println("���Ⱑ �����ϴ�.");
		ab.attack();
	}

	@Override
	public String getWeaponType() {
		// TODO Auto-generated method stub
		return "NoWeapon";
	}

}
