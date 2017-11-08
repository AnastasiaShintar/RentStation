package by.htp.rentstation;

import java.util.Date;

public class RentUnit {
	private Equipment[] units;
	private int cost;
	private String clientName;
	private int idNum;
	private Date rentDate;
//	private int outfitCount;

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

//	public int getOutfitCount() {
//		
//		return outfitCount;
//	}

//	public void incrementOutfitCount() {
//		this.outfitCount++;
//	}

}
