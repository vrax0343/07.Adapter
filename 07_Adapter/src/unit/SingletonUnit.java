package unit;

import function.*;
import observer.UnitData;
import observer.UnitDisplay;
import behavior.movement.*;
import behavior.weapon.*;
import behavior.attack.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;




public class SingletonUnit extends Observable{
	static final int CITIZEN = 0;
	static final int KNIGHT = 1;
	static final int MAGE = 2;
	
	private UnitData unitData = new UnitData();
	private UnitDisplay unitDisplay = new UnitDisplay(unitData);
	
	private static SingletonUnit uniqueInstance;
	private ArrayList<SingletonUnit> unitList = new ArrayList<SingletonUnit>();
	private ArrayList<SingletonUnit> detectList = new ArrayList<SingletonUnit>();
	
	AttackBehavior attack = null;
	MovementBehavior movement = null;
	WeaponBehavior weapon=null;
	
	String type = "";
	int locationX=0, locationY=0;
	int health=0;
	int movementSpeed=0;
	int[] unitCount = {1,1,1};
	
	
	private SingletonUnit() {}

	//for Citizen,Knight,Mage
	private SingletonUnit(AttackBehavior attack, MovementBehavior movement, WeaponBehavior weapon,
			String type, int locationX, int locationY, int health) {
		super();
		this.attack = attack;
		this.movement = movement;
		this.weapon = weapon;
		this.type = type;
		this.locationX = locationX;
		this.locationY = locationY;
		this.health = health;
	}
	
	//for Owl
	private SingletonUnit(AttackBehavior attack, MovementBehavior movement, WeaponBehavior weapon,
			String type, int locationX, int locationY, ArrayList<SingletonUnit> unit) {
		super();
		this.attack = attack;
		this.movement = movement;
		this.weapon = weapon;
		this.type = type;
		this.locationX = locationX;
		this.locationY = locationY;
		this.detectList = unit;
	}


	public static synchronized SingletonUnit getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new SingletonUnit();
		}
		return uniqueInstance;
	}
	

	public void addUnit(String type){
		SingletonUnit tempUnit=null;
		if(type.equals("Citizen")){ 
			tempUnit=new SingletonUnit(new Punch(), new Walk(), new Fist(),
					"Citizen"+unitCount[CITIZEN], GenerateRandomPosition.generate(), GenerateRandomPosition.generate(),10);
			unitCount[CITIZEN]+=1;
		}else if(type.equals("Knight")){
			tempUnit=new SingletonUnit(new SwingSword(), new Walk(), new Sword(),
					"Knight"+unitCount[KNIGHT], GenerateRandomPosition.generate(), GenerateRandomPosition.generate(),30);
			unitCount[KNIGHT]+=1;
		}else if(type.equals("Mage")){
			tempUnit=new SingletonUnit(new CastFireball(), new Teleport(), new Staff(),
					"Mage"+unitCount[MAGE], GenerateRandomPosition.generate(), GenerateRandomPosition.generate(),20);
			unitCount[MAGE]+=1;
		}else if(type.equals("Owl")){
			tempUnit=new SingletonUnit(new CantAttack(), new Fly(), new NoWeapon(),
					"Owl", GenerateRandomPosition.generate(), GenerateRandomPosition.generate(),null);
		}else{
			System.out.println("Error");
		}
		unitList.add(tempUnit);
		System.out.println("---"+tempUnit.type+" �߰� �Ϸ�---");
//		System.out.println(tempUnit.toString());
		System.out.println();
	}
	
	public void moveDirect(String type, int x, int y){
		SingletonUnit tempUnit = new FindUnit().findOneByType(unitList, type);
		if (tempUnit==null){
			System.out.println(type + "�� �������� �ʽ��ϴ�.");
		}else
			new Move().moveLocation(tempUnit, x, y);
	}
	
	public void addDetect(String type){
		if(type.equals("Owl")){
			System.out.println("�û��̴� ����� �� �����ϴ�.");
			System.exit(1);
		}
		SingletonUnit tempUnit = new FindUnit().findOneByType(unitList, type);
		SingletonUnit tempOwl = new FindUnit().findOneByType(unitList, "Owl");
		
		if(tempOwl.detectList == null){
			tempOwl.detectList = new ArrayList<SingletonUnit>();
		}
		tempOwl.detectList.add(tempUnit);
		
	}
	
	public void specialAbility(){
		SingletonUnit tempOwl = new FindUnit().findOneByType(unitList, "Owl");
		System.out.println("���� Owl�� ��ġ��: ("+tempOwl.getLocationX()+", "+tempOwl.getLocationY()+")");
		System.out.println("���� Owl�� ��ϵ� ������ �Ʒ��� �����ϴ�.");
		for(SingletonUnit u:tempOwl.detectList){
			System.out.println(u);
		}
//		unitDisplay = new UnitDisplay(unitData);
		unitData.changed(tempOwl.detectList,tempOwl.getLocationX(),tempOwl.getLocationY(),20);
	}
	
	
	public void removeUnit(String type){
		Iterator<SingletonUnit> iterator = unitList.iterator();
		while(iterator.hasNext()){
			SingletonUnit tempUnit = iterator.next();
			System.out.println(tempUnit.type + "�� �׾����ϴ�.");
			iterator.remove();
		}
	}
	

	public void unitDied(String type) {
		// TODO Auto-generated method stub
		
		SingletonUnit tempOwl = new FindUnit().findOneByType(unitList, "Owl");
		SingletonUnit tempUnit = new FindUnit().findOneByType(unitList, type);
		tempOwl.detectList.remove(tempUnit);
		new Died(unitList).diedOne(type);
		System.out.println(tempUnit);
//		
	}
	
	public void unitDiedAll() {
		// TODO Auto-generated method stub
		new Died(unitList).diedAll();
	}
	
	public void fight(SingletonUnit tempUnit){
		System.out.print(tempUnit.type + " \t");
		tempUnit.weapon.useWeapon(tempUnit.attack);
		System.out.println();
	}
	public void fightAllUnit() {
		// TODO Auto-generated method stub
		Iterator<SingletonUnit> iterator = unitList.iterator();
		while(iterator.hasNext()){
			SingletonUnit tempUnit = iterator.next();
			tempUnit.fight(tempUnit);
		}
	}
	
	public void fightOneUnit(String type) {
		// TODO Auto-generated method stub
		SingletonUnit tempUnit = new FindUnit().findOneByType(unitList, type);
		tempUnit.fight(tempUnit);
	}
	
	public void printAllUnit(){
		new Print(unitList).printAll();
	}
	
	
	//move()�޼ҵ�� Unit�����̱� ������ Unit Ŭ�������� ����
	//Move�� ���õ� �۾��� function��Ű���� MoveŬ������ �۾��ϵ��� ����
	public void move(int x, int y){
		new Move(this, x, y);
	}
	//getter
	
	public String getType(){
		return this.type;
	}
	public int getHealth(){
		return this.health;
	}
	public void getLocation(){
		System.out.println("("+this.locationX+"," + this.locationY+")");
	}
	public int getLocationX(){
		return this.locationX;
	}
	public int getLocationY(){
		return this.locationY;
	}
	public String getWeaponType(){
		return this.weapon.getWeaponType();
	}	
	public String getMovementType() {
		// TODO Auto-generated method stub
		return this.movement.getMovementType();
	}


	public String getAttackType() {
		// TODO Auto-generated method stub
		return this.attack.getAttackType();
	}
	
	public SingletonUnit getOwl(){
		return new FindUnit().findOneByType(unitList, "Owl");
	}
	
	public SingletonUnit getKnight(){
		return new FindUnit().findOneByType(unitList, "Knight");
	}
	
	
	
	
	public ArrayList<SingletonUnit> getUnitList() {
		return unitList;
	}
	
	public AttackBehavior getAttackBehavior() {
		// TODO Auto-generated method stub
		return this.attack;
	}
	public MovementBehavior getMovementBehavior() {
		// TODO Auto-generated method stub
		return this.movement;
	}
	public WeaponBehavior getWeaponBehavior() {
		// TODO Auto-generated method stub
		return this.weapon;
	}

	public void setUnitList(ArrayList<SingletonUnit> unitList) {
		this.unitList = unitList;
	}

	//setter
	public void setWeapon(WeaponBehavior w){
		System.out.println("[Before Weapon]: " + this.getWeaponType());
		this.weapon = w;
		System.out.println("[After Weapon]: " + this.getWeaponType());
	}
	public void setMovement(MovementBehavior m){
		this.movement = m;
	}
	public void setAttack(AttackBehavior a){
		this.attack = a;
	}
	
	public void setLocation(int x, int y){
		System.out.println(this.getType() + "\t�̵� ����");
		System.out.println("[Before Location]: (" + this.getLocationX()+","+this.getLocationY()+")");
		this.locationX = x;
		this.locationY = y;
		System.out.println("[After Location]: (" + this.getLocationX()+","+this.getLocationY()+")");
		System.out.println();
	}
	
	
	//toString
	public String toString(){
		return  
				"Type: " + this.type + "\t"+
				"Health: " + this.health + "\t"+
				"Location X,Y: " + this.locationX+","+this.locationY+"\t"+
				"WeaponType: " + this.weapon.getWeaponType() + "\t"+
				"MovementType: " + this.movement.getMovementType() + "\t"+
				"AttackType: " + this.attack.getAttackType() + "\t";
	}


	
	
	
}


