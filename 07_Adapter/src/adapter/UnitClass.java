package adapter;

import behavior.attack.AttackBehavior;
import behavior.movement.MovementBehavior;
import behavior.weapon.WeaponBehavior;
import state.State;
import unit.SingletonUnit;

public class UnitClass implements UnitInterface{
	String type = "";
	int locationX=0, locationY=0;
	int health=0;
	int mana, maxMana, maxHealth=0;
	int size=0;
	AttackBehavior attack = null;
	MovementBehavior movement = null;
	WeaponBehavior weapon=null;
	
	
	
	public UnitClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnitClass(SingletonUnit unit) {
		super();
	}

//	StoneClass sc = new StoneClass();
//	UnitInterface ui = new Stone

	@Override
	public void attack() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		System.out.println("Im unitClass");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	public int getSize(){
		return this.size;
	}
	
	
	
	
	
	
	
	//getter
	
	public String getType() {
		return type;
	}
	public int getLocationX() {
		return locationX;
	}
	public int getLocationY() {
		return locationY;
	}
	public int getHealth() {
		return health;
	}
	public int getMana() {
		return mana;
	}
	public int getmaxMana() {
		return maxMana;
	}
	public int getmaxHealth() {
		return maxHealth;
	}
	public AttackBehavior getAttack() {
		return attack;
	}
	public MovementBehavior getMovement() {
		return movement;
	}
	public WeaponBehavior getWeapon() {
		return weapon;
	}
	
	//setter
	public void setType(String type) {
		this.type = type;
	}
	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}
	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}
	public void setHealth(int health,int value) {
		System.out.println("+"+this.getType() + " 에 체력을  '"+value+"' 더합니다");
		System.out.print("[Before]: " + this.health);
		if (health > this.maxHealth) 
			this.health = this.maxHealth;
		else 
			this.health = health;
		System.out.println("\t[After]: " + this.health);
	}
	public void setHealth(int health) {
		System.out.println("---"+this.getType() + " 의 체력을 수정합니다---");
		System.out.print("[Before]: " + this.health);
		if (health > this.maxHealth) 
			this.health = this.maxHealth;
		else 
			this.health = health;
		System.out.println("\t[After]: " + this.health);
	}
	public void setMana(int mana) {
		if (mana > this.maxMana) 
			this.mana = this.maxMana;
		else 
			this.mana = mana;
	}
	public void setmaxMana(int maxMana) {
		this.maxMana = maxMana;
	}
	public void setmaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public void setAttack(AttackBehavior attack) {
		this.attack = attack;
	}
	public void setMovement(MovementBehavior movement) {
		this.movement = movement;
	}
	public void setWeapon(WeaponBehavior weapon) {
		this.weapon = weapon;
	}

		
}
