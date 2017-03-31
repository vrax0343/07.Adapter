package adapter;


public class StoneAdaptor implements UnitInterface{
	StoneInterface si;
	
	public StoneAdaptor(StoneInterface si) {
		super();
		this.si = si;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void attack() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		si.attack();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return si.getSize();
	}
	
}
