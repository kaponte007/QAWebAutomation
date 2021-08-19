package pojo;

public class DriverPojo {

	private static String name, lastName, email, vehiclePlate;

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		DriverPojo.email = email;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastName) {
		DriverPojo.lastName = lastName;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		DriverPojo.name = name;
	}

	public static String getVehiclePlate() {
		return vehiclePlate;
	}

	public static void setVehiclePlate(String vehiclePlate) {
		DriverPojo.vehiclePlate = vehiclePlate;
	}
}
