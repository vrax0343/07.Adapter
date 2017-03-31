package factory.af;

import factory.af.unit.CivilianTeamUnit;
import factory.af.unit.KnightTeamUnit;
import factory.af.unit.MageTeamUnit;
import factory.af.unit.TeamUnit;

public class RedTeamFactory extends TeamFactoryStore {

	@Override
	public TeamUnit createTeamUnit(String item) {
		TeamUnit teamUnit = null;
		AbstractTeamInfoFactory atf = new RedTeamInfoFactory();
		
		if (item.equals("Mage")) {
			teamUnit = new MageTeamUnit(atf);
			teamUnit.setName("���� ����");

		}else if (item.equals("Civilian")) {
			teamUnit = new CivilianTeamUnit(atf);
			teamUnit.setName("���� �ù�");
		}else if (item.equals("Knight")) {
			teamUnit = new KnightTeamUnit(atf);
			teamUnit.setName("���� ���");
		}

		return teamUnit;
	}

}
