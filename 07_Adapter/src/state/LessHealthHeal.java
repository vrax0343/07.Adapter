package state;

public class LessHealthHeal implements State{
	NewUnit nu;
	
	public LessHealthHeal(NewUnit nu) {
		super();
		this.nu = nu;
	}

	@Override
	public void selfHeal() {
		// TODO Auto-generated method stub
		if(nu.getMana() <= 0){
			System.out.println(nu.getType() + "�� ������ �����մϴ�");
			nu.setState(nu.getCantSelfHeal());
			nu.check = 1;
		} else{
			nu.setHealth(nu.getHealth()+1,1);
			nu.setMana(nu.getMana()-1);
			System.out.println("���� ��������: '"+nu.getMana()+"'");
		}
		System.out.println();
	}

}
