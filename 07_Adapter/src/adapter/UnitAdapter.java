package adapter;


public class UnitAdapter implements StoneInterface{
	UnitInterface iu;
	
	
	public UnitAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UnitAdapter(UnitInterface iu) {
		super();
		this.iu = iu;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void attack() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
