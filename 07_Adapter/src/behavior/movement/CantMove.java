package behavior.movement;

public class CantMove implements MovementBehavior {


	@Override
	public int[] move(int x1, int x2, int y1, int y2) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public String getMovementType() {
		// TODO Auto-generated method stub
		return "CantAttack";
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("이동할 수 없습니다.");
	}

}
