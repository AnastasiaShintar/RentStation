package by.htp.rentstation;

import java.util.Date;
import java.util.Scanner;

public class RentStation {

	private Equipment[] equipments = new Equipment[18]; // массив всего, что есть на складе
	private int equipmentCount = 0;

	public RentUnit[] rented = new RentUnit[18]; // массив всех заказов

	public RentStation(int number) {
		this.equipments = new Equipment[number];
	}

	public void addEquipment(Equipment equipment) {
		equipments[this.equipmentCount] = equipment;
		equipmentCount++;
	}

	public int getRentIdNum() { // найти свободную ячейку в массиве всех заказов
		int id = 0;
		for (int i = 0; i < rented.length; i++) {
			if (rented[i] == null) {
				id = i;
			}
			break;
		}
		return id;
	}

	public int getEvailableEquipmentCount() { // посмотреть количество доступного снаряжения
		int count = 0;
		for (int i = 0; i < equipments.length; i++) {
			if (equipments[i].getStatus().equals(Status.AVAILABLE)) {
				count++;
			}
		}
		return count;
	}

	public void showAllEquipment() { // список всего снаряжения на складе

		for (int i = 0; i < equipments.length; i++) {

			System.out.println(equipments[i].toString());
		}
	}

	public void showEvailableEquipment() { // список доступного снаряжения

		for (int i = 0; i < equipments.length; i++) {
			if (equipments[i].getStatus().equals(Status.AVAILABLE)) {
				System.out.println(equipments[i].toString());
			}

		}

	}

	public void showRentedEquipment() { // список арендованного снаряжения

		for (int i = 0; i < equipments.length; i++) {
			if (equipments[i].getStatus().equals(Status.RENTED)) {
				System.out.println(equipments[i].toString());
			}

		}

	}

	public Equipment getEquipmentByName(String title) { // поиск свободного снаряжения по наименованию
		Equipment result = null;
		for (int i = 0; i < equipments.length; i++) {
			if (equipments[i].getStatus().equals(Status.AVAILABLE) && equipments[i].getTitle().equals(title)) {
				result = equipments[i];
				break;
			}
		}
		return result;
	}

	public void processRentUnit() { // процесс оформления заказа
		System.out.println("ВНИМАНИЕ! После формирования заказа введите 'exit'!");
		System.out.println();
		System.out.println("Выберете снаряжение из предложенного списка ниже:");
		showEvailableEquipment();

		if (getEvailableEquipmentCount() > 0) {
			System.out.println("Введите фамилию и имя клиента: ");
			Scanner in = new Scanner(System.in);
			String clientName = in.nextLine();

			RentUnit order = new RentUnit(clientName, getRentIdNum(), new Date()); // создаем объект заказа

			int outfitCount = 0; // счетчик оборудования в заказе
			String equipmentName = null; // переменная для поиска снаряжения по наименованию

			do {
				System.out.println("Введите наименование товара: "); //
				equipmentName = in.nextLine();
				if (equipmentName.equals("exit")) {
					break;
				}

				Equipment eqElement = getEquipmentByName(equipmentName);
				if (eqElement == null) {
					System.out.println("Введите правильное название из предложенных вариантов");
					continue;
				}

				if (eqElement instanceof Outfit) {
					if (outfitCount < 3) {
						outfitCount++;
					} else {
						System.out.println("Вы не можете взять больше трех единиц снаряжения. Выберите аксессуары.");
						continue;
					}
				}

				eqElement.setStatus(Status.RENTED);

				order.addEquipment(eqElement);

				System.out.println("В заказ добавлен инвентарь: " + eqElement);
			}

			while (getEvailableEquipmentCount() > 0);

			if (getEvailableEquipmentCount() == 0) {
				System.out.println("Ваш заказ сформирован. Больше нет доступного оборудования.");
			} else {
				System.out.println("Ваш заказ сформирован.");
			}
			rented[getRentIdNum()] = order;

		} else {
			System.out.println("Нет доступного оборудования!");
		}
	}

	public void showOrders() { // показать все заказы. Не работает!!
		for (int i = 0; i < this.rented.length; i++) {
			if (this.rented[i] != null) {
				System.out.println(rented[i]);
			}
		}
	}
}
