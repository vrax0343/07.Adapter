package state;

public class CantSelfHeal implements State {
	NewUnit nu;
	
	public CantSelfHeal(NewUnit nu) {
		super();
		this.nu = nu;
	}


	@Override
	public void selfHeal() {
		// TODO Auto-generated method stub
		if(nu.check==0)
			System.out.println("���� ���� �� ������ �ڰ�ġ��� �Ұ��� �մϴ�.");
		else if(nu.check==1)
			System.out.println(nu.getType() + "�� ������ �����մϴ�");
		int tempHealth=nu.getHealth();
		if(tempHealth <50) 
			nu.setState(nu.getLessHealthHeal());
		else
			nu.setState(nu.getMuchHealthHeal());
		System.out.println();
	}

}
