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

	public int getEvailableEquipmentCount() { // ���������� ���������� ���������� ����������
		int count = 0;
		for (int i = 0; i < equipments.length; i++) {
			if (equipments[i].getStatus().equals(Status.AVAILABLE)) {
				count++;
			}
		}
		return count;
	}

	public void showAllEquipment() { // ������ ����� ���������� �� ������

		for (int i = 0; i < equipments.length; i++) {

			System.out.println(equipments[i].toString());
		}
	}

	public void showEvailableEquipment() { // ������ ���������� ����������

		for (int i = 0; i < equipments.length; i++) {
			if (equipments[i].getStatus().equals(Status.AVAILABLE)) {
				System.out.println(equipments[i].toString());
			}

		}

	}

	public void showRentedEquipment() { // ������ ������������� ����������

		for (int i = 0; i < equipments.length; i++) {
			if (equipments[i].getStatus().equals(Status.RENTED)) {
				System.out.println(equipments[i].toString());
			}

		}

	}

	public Equipment getEquipmentByName(String title) { // ����� ���������� ���������� �� ������������
		Equipment result = null;
		for (int i = 0; i < equipments.length; i++) {
			if (equipments[i].getStatus().equals(Status.AVAILABLE) && equipments[i].getTitle().equals(title)) {
				result = equipments[i];
				break;
			}
		}
		return result;
	}

	public void processRentUnit() { // ������� ���������� ������
		System.out.println("��������! ����� ������������ ������ ������� 'exit'!");
		System.out.println();
		System.out.println("�������� ���������� �� ������������� ������ ����:");
		showEvailableEquipment();

		if (getEvailableEquipmentCount() > 0) {
			System.out.println("������� ������� � ��� �������: ");
			Scanner in = new Scanner(System.in);
			String clientName = in.nextLine();

			RentUnit order = new RentUnit(clientName, getRentIdNum(), new Date()); // ������� ������ ������

			int outfitCount = 0; // ������� ������������ � ������
			String equipmentName = null; // ���������� ��� ������ ���������� �� ������������

			do {
				System.out.println("������� ������������ ������: "); //
				equipmentName = in.nextLine();
				if (equipmentName.equals("exit")) {
					break;
				}

				Equipment eqElement = getEquipmentByName(equipmentName);
				if (eqElement == null) {
					System.out.println("������� ���������� �������� �� ������������ ���������");
					continue;
				}

				if (eqElement instanceof Outfit) {
					if (outfitCount < 3) {
						outfitCount++;
					} else {
						System.out.println("�� �� ������ ����� ������ ���� ������ ����������. �������� ����������.");
						continue;
					}
				}

				eqElement.setStatus(Status.RENTED);

				order.addEquipment(eqElement);

				System.out.println("� ����� �������� ���������: " + eqElement);
			}

			while (getEvailableEquipmentCount() > 0);

			if (getEvailableEquipmentCount() == 0) {
				System.out.println("��� ����� �����������. ������ ��� ���������� ������������.");
			} else {
				System.out.println("��� ����� �����������.");
			}
			rented[getRentIdNum()] = order;

		} else {
			System.out.println("��� ���������� ������������!");
		}
	}

	public void showOrders() { // �������� ��� ������. �� ��������!!
		for (int i = 0; i < this.rented.length; i++) {
			if (this.rented[i] != null) {
				System.out.println(rented[i]);
			}
		}
	}
}
