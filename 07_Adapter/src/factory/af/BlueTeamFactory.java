package factory.af;

import factory.af.unit.*;

public class BlueTeamFactory extends TeamFactoryStore {

	@Override
	public TeamUnit createTeamUnit(String item) {
		// TODO Auto-generated method stub
		TeamUnit teamUnit = null;
		AbstractTeamInfoFactory atf = new BlueTeamInfoFactory();
		
		if (item.equals("Mage")) {
			teamUnit = new MageTeamUnit(atf);
			teamUnit.setName("��� ����");

		}else if (item.equals("Civilian")) {
			teamUnit = new CivilianTeamUnit(atf);
			teamUnit.setName("��� �ù�");
		}else if (item.equals("Knight")) {
			teamUnit = new KnightTeamUnit(atf);
			teamUnit.setName("��� ���");
		}

		return teamUnit;
	}

}
