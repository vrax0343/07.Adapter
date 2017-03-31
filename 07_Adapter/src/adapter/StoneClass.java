package adapter;

import behavior.attack.AttackBehavior;
import behavior.attack.CantAttack;
import behavior.movement.CantMove;
import behavior.movement.MovementBehavior;
import behavior.weapon.WeaponBehavior;
import function.GenerateRandomPosition;

public class StoneClass implements StoneInterface {
	int locationX,locationY,stoneSize=GenerateRandomPosition.generate();
	int health=100;
	AttackBehavior attack = new CantAttack();
	MovementBehavior movement = new CantMove();
	WeaponBehavior weapon=null;
	

	@Override
	public void attack() throws UnsupportedOperationException{
		// TODO Auto-generated method stub
		this.attack.attack();
//		throw new UnsupportedOperationException("hhhhhhhhhh");
	}

	@Override
	public void move() throws UnsupportedOperationException{
		// TODO Auto-generated method stub
//		throw new UnsupportedOperationException("gggggggggggg");
		this.movement.move();
	}
	
//	public void specialAttack() throws

	public int getStoneSize() {
		return stoneSize;
	}

	public void setStoneSize(int stoneSize) {
		this.stoneSize = stoneSize;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return stoneSize;
	}
	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}
	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}

	public int getLocationX() {
		// TODO Auto-generated method stub
		return this.locationX;
	}
	public int getLocationY() {
		// TODO Auto-generated method stub
		return this.locationY;
	}
	
	
}
