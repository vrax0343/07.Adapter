package adapter;

import java.util.ArrayList;

import function.GenerateRandomPosition;
import unit.SingletonUnit;

public class Village {
	
	ArrayList<UnitClass> unitList = new ArrayList<UnitClass>();
	ArrayList<StoneClass> stoneList = new ArrayList<StoneClass>();
	int leftX,leftY,rightX,rightY=0;
	
	public Village() {
		super();
		int[] tempArr = {GenerateRandomPosition.generate(),
							GenerateRandomPosition.generate(),
							GenerateRandomPosition.generate(),
							GenerateRandomPosition.generate()};
		int temp=0;
		if(tempArr[0]>tempArr[2]){
			temp=tempArr[2];
			tempArr[2]=tempArr[0];
			tempArr[0]=temp;
		}else{ }
		if(tempArr[1]<tempArr[3]){
			temp=tempArr[3];
			tempArr[3]=tempArr[1];
			tempArr[1]=temp;
		}
		this.leftX = tempArr[0];
		this.leftY = tempArr[1];
		this.rightX = tempArr[2];
		this.rightY = tempArr[3];
		
	}
	
	


	public Village(int leftX, int leftY, int rightX, int rightY) {
		super();
		this.leftX = leftX;
		this.leftY = leftY;
		this.rightX = rightX;
		this.rightY = rightY;
	}




	public void inspection(){
		UnitClass tempUnit = null;
		StoneClass tempStone = null;
		System.out.println("마을의 현재 크기: ("+this.leftX+","+this.leftY+")-("+this.rightX+","+this.rightY+")");
		for(int i=1; i<this.unitList.size()+1; i++){
			tempUnit = unitList.get(i-1);
			System.out.println(i+"번째 입주자: "+tempUnit.getType()+"\t위치: ("+tempUnit.getLocationX()+","+tempUnit.getLocationY()+")");
		}
		for(int i=1; i<this.stoneList.size()+1; i++){
			tempStone = stoneList.get(i-1);
			System.out.println(i+"번째 돌: \t위치: ("+tempStone.getLocationX()+","+tempStone.getLocationY()+")");
		}
		System.out.println();
	}
	
		
		
	public void enterVillage(UnitClass unitClass){
		unitClass.setLocationX(GenerateRandomPosition.generate(this.leftX, this.rightX));
		unitClass.setLocationY(GenerateRandomPosition.generate(this.leftY, this.rightY));
		
		unitList.add(unitClass);
		
		System.out.println(unitClass.getType()+"이 마을에 입주했습니다.");
	}
	public void enterVillageStone(StoneClass unit){
		unit.setLocationX(GenerateRandomPosition.generate(this.leftX, this.rightX));
		unit.setLocationY(GenerateRandomPosition.generate(this.leftY, this.rightY));
		
		stoneList.add(unit);
		System.out.println("돌이 마을에 입주했습니다.");
	}

	public ArrayList<UnitClass> getUnitList() {
		return unitList;
	}
	
	public StoneClass addStone(){
		return new StoneClass();
	}




	public int getLeftX() {
		return leftX;
	}




	public int getLeftY() {
		return leftY;
	}




	public int getRightX() {
		return rightX;
	}




	public int getRightY() {
		return rightY;
	}
	
	

}
