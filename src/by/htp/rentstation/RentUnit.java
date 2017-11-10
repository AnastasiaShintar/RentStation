package by.htp.rentstation;

import java.util.Arrays;
import java.util.Date;

public class RentUnit {
	private Equipment[] units = new Equipment[18];
	private int cost;
	private String clientName;
	private int idNum;
	private Date rentDate;


	public RentUnit(String clientName, int idNum, Date rentDate) {
		this.clientName = clientName;
		this.idNum = idNum;
		this.rentDate = rentDate;
	}

	public Equipment[] getUnits() {
		return units;
	}

	public int getCost() {
		return cost;
	}

	public String getClientName() {
		return clientName;
	}

	public int getIdNum() {
		return idNum;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void addEquipment(Equipment eq) {
		for (int i = 0; i < units.length; i++) {
			if(units[i] == null) {
				units[i] = eq;
				break;
			}
		}
	}
	
	public String showUnits() {
		String result = "";
		for (int i = 0; i < units.length; i++) {
			if(units[i] != null) {
				result += "\n" + units[i];
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Заказ № " + idNum +  " от " + rentDate + " клиента " + clientName + " :" + showUnits();
	}
	
	

}
