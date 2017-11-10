package by.htp.rentstation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Outfit skiing = new Outfit(Category.WINTER, "skiing", Status.AVAILABLE, 12);
		Outfit snowboard = new Outfit(Category.WINTER, "snowboard", Status.AVAILABLE, 13);
		Outfit skates = new Outfit(Category.WINTER, "skates", Status.AVAILABLE, 12);
		Outfit tubing = new Outfit(Category.WINTER, "tubing", Status.AVAILABLE, 11);
		Outfit waterSkiing = new Outfit(Category.WATER, "water skiing", Status.AVAILABLE, 12);
		Outfit wakeboard = new Outfit(Category.WATER, "wakeboard", Status.AVAILABLE, 14);
		Outfit bycicle = new Outfit(Category.SUMMER, "bycicle", Status.AVAILABLE, 17);
		Outfit scooter = new Outfit(Category.SUMMER, "scooter", Status.AVAILABLE, 15);
		Outfit ball = new Outfit(Category.SUMMER, "ball", Status.AVAILABLE, 3);
		Outfit rollers = new Outfit(Category.SUMMER, "rollers", Status.AVAILABLE, 7);

		Accessory helmet = new Accessory(Category.WINTER, "helmet", Status.AVAILABLE, 4);
		Accessory kneepads = new Accessory(Category.SUMMER, "knee pads", Status.AVAILABLE, 2);
		Accessory elbowpads = new Accessory(Category.SUMMER, "elbow pads", Status.AVAILABLE, 2);
		Accessory skipoles = new Accessory(Category.WINTER, "ski poles", Status.AVAILABLE, 3);
		Accessory skiboots = new Accessory(Category.WINTER, "ski boots", Status.AVAILABLE, 3);
		Accessory snowboardboots = new Accessory(Category.WINTER, "snowboard boots", Status.AVAILABLE, 4);
		Accessory lifevest = new Accessory(Category.WATER, "lifevest", Status.AVAILABLE, 1);
		Accessory bikehelmet = new Accessory(Category.SUMMER, "bike helmet", Status.AVAILABLE, 4);

		RentStation rentstation = new RentStation(18);
		rentstation.addEquipment(skiing);
		rentstation.addEquipment(bikehelmet);
		rentstation.addEquipment(lifevest);
		rentstation.addEquipment(snowboardboots);
		rentstation.addEquipment(skiboots);
		rentstation.addEquipment(skipoles);
		rentstation.addEquipment(elbowpads);
		rentstation.addEquipment(kneepads);
		rentstation.addEquipment(helmet);
		rentstation.addEquipment(rollers);
		rentstation.addEquipment(ball);
		rentstation.addEquipment(scooter);
		rentstation.addEquipment(bycicle);
		rentstation.addEquipment(wakeboard);
		rentstation.addEquipment(waterSkiing);
		rentstation.addEquipment(tubing);
		rentstation.addEquipment(skates);
		rentstation.addEquipment(snowboard);

		System.out.println("Для получения списка снаряжения введите 1.\n"
				+ "Для получения списка снаряжения, доступного к прокату, введите 2.\n"
				+ "Для получения списка снаряжения, взятого в прокат, введите 3\n" 
				+ "Чтобы оформить заказ, введите 4\n"
				+ "Чтобы просмотреть сформированные заказы, введите 5\n"
				+ "Чтобы завершить работу программы, введите 0");
		Scanner in = new Scanner(System.in);
		int choice;

		while ((choice = in.nextInt()) != 0) {

			switch (choice) {
			case 1:
				System.out.println("Снаряжение на баланте ПП:");
				rentstation.showAllEquipment();
				break;
			case 2:
				System.out.println("Снаряжение, доступное к прокату:");
				rentstation.showEvailableEquipment();
				break;
			case 3:
				System.out.println("Снаряжение, на руках у клиента");
				rentstation.showRentedEquipment();
				break;
			case 4:
				System.out.println("Оформление заказа:");
				rentstation.processRentUnit();
				break;
			case 5:
				rentstation.showOrders();			// формируется только последний заказ
				break;
			default:
				System.out.println("Введите правильное значение!");
			}
		}
		System.out.println("Всего хорошего!");
	}
}
