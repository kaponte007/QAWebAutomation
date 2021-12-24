package entities;

public class DriverEntity {

	private static String name, lastName, email, vehiclePlate;

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		DriverEntity.email = email;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastName) {
		DriverEntity.lastName = lastName;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		DriverEntity.name = name;
	}

	public static String getVehiclePlate() {
		return vehiclePlate;
	}

	public static void setVehiclePlate(String vehiclePlate) {
		DriverEntity.vehiclePlate = vehiclePlate;
	}
}
