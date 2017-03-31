package behavior.movement;

public interface MovementBehavior {
	public void move();
	public int[] move(int x1,int x2,int y1,int y2);
	public String getMovementType();
}
