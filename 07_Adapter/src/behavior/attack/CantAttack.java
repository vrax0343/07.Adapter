package behavior.attack;

public class CantAttack implements AttackBehavior {

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("������ �� �����ϴ�.");
	}

	@Override
	public String getAttackType() {
		// TODO Auto-generated method stub
		return "CantAttack";
	}

}
