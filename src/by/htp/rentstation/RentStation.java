package by.htp.rentstation;

import java.util.Date;
import java.util.Scanner;

public class RentStation {

	private Equipment[] equipments = new Equipment[18]; // ������ �����, ��� ���� �� ������
	private int equipmentCount = 0;

	public RentUnit[] rented = new RentUnit[18]; // ������ ���� �������

	public RentStation(int number) {
		this.equipments = new Equipment[number];
	}

	public void addEquipment(Equipment equipment) {
		equipments[this.equipmentCount] = equipment;
		equipmentCount++;
	}

	public int getRentIdNum() { // ����� ��������� ������ � ������� ���� �������
		int id = 0;
		for (int i = 0; i < rented.length; i++) {
			if (rented[i] == null) {
				id = i;
			}
			break;
		}
		return id;
	}

	public int getEvailableEquipmentCount() { // ���������� ���������� ���������� ������������
		int count = 0;
		for (int i = 0; i < equipments.length; i++) {
			if (equipments[i].getStatus().equals(Status.AVAILABLE)) {
				count++;
			}

		}
		return count;
	}

	public void processRentUnit() { // ������� ���������� ������
		if (getEvailableEquipmentCount() > 0) {
			System.out.println("������� ������� � ��� �������: ");
			Scanner in = new Scanner(System.in);
			String clientName = in.nextLine();

			RentUnit order = new RentUnit(clientName, getRentIdNum(), new Date());
			System.out.println("������� ������������ ������: ");
			int outfitCount = 0;
			String equipmentName = null;
			do {
				equipmentName = in.nextLine();

			} while (getEvailableEquipmentCount() > 0 && !equipmentName.equals("exit"));

		} else {
			System.out.println("��� ���������� ������������!");
		}
	}
}
