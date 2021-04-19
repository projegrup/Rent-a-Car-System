import java.util.ArrayList;
public class Admin implements User {
	private final int MAX_EMP_SIZE = 1000;
	private String name;
	private String lastname;
	private String id;


	public Admin() {

	}

	public Admin(String name, String lastname, String id) {
		setName(name);
		setLastname(lastname);
		setId(id);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public String getLastname() {
		return this.lastname;
	}

	public String getId() {
		return this.id;
	}

	public boolean addVehicle(ServiceBranch sBranch) {
		System.out.println("Please choose the vehicle. \n"+
			"1. Car\n"+
			"2. Bike\n"+
			"Choice: ");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (choice < 1 || choice > 2) {
			System.out.println("Invalid entry. Try again later.")
			return false;
		}
		Vehicle vehicle;
		if (choice == 1) {
			vehicle = new Car();
		}
		else
			vehicle = new Bike();
		System.out.println("Please choose color. \n"+
			"1. Black\n"+
			"2. Blue\n"+
			"3.Red\n"
			"Choice: ");
		choice = scan.nextInt();
		if (choice < 1 || choice > 3) {
			System.out.println("Invalid entry. Try again later.")
			return false;
		}
		if (balance < vehicle.getPrice()) {
			System.out.println("You can not afford that. Returning to menu.");
			return false;
		}
		vehicle.setColor(choice);
		sBranch.addVehicle(vehicle);
		return true;
	}

	public boolean removeVehicle(ServiceBranch sBranch) {
		sBranch.listVehicles();
		System.out.println("Please choose the vehicle that you want to remove");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (choice < 0 || choice > sBranch.getSize()) {
			System.out.println("Invalid entry.");
			return false;
		}
		sBranch.removeVehicle(choice);

		return true;
	}

	public boolean addRentalBranch(ArrayList<RentalBranch> rBranches) {
		RentalBranch rb = new RentalBranch();
		System.out.println("Please type the name of the new rental branch: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		rb.setName(name);
		rBranches.add(rb);

		return true;
	}

	public boolean removeRentalBranch(ArrayList<RentalBranch> rBranches) {
		int i;
		for (i = 0; i < rBranches.size();i++) {
			System.out.println(""+rBranches.get(i).getName());
		}
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (choice < 0 || choice > rBranches.size()) {
			System.out.println("Invalid entry.");
			return false;
		}
		rBranches.remove(choice);

		return true;
	}

	public boolean addServiceBranch(ArrayList<ServiceBranch> sBranches) {
		ServiceBranch sb = new ServiceBranch();
		System.out.println("Please type the name of the new service branch: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		sb.setName(name);
		sBranches.add(sb);

		return true;
	}

	public boolean removeServiceBranch(ArrayList<ServiceBranch> sBranches) {
		int i;
		for (i = 0; i < sBranches.size();i++) {
			System.out.printf("%d. %s\n", i+1, sBranches.get(i).getName());
		}
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (choice < 0 || choice > sBranches.size()) {
			System.out.println("Invalid entry.");
			return false;
		}
		sBranches.remove(choice);

		return true;
	}

	public boolean addSalesManager(ArrayList<SalesManager> sManagers) {
		if (sManagers.size() == MAX_EMP_SIZE) {
			System.out.println("You can not add more SalesManager.");
			return false;
		}

		SalesManager sm = new SalesManager();
		System.out.println("Please type the name of the new sales manager: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		sm.setName(name);
		sm.setId(createId('S', sManagers.size()));
		sManagers.add(sm);

		return true;
	}	

	public boolean removeSalesManager(ArrayList<SalesManager> sManagers) {
		if (sManagers.size() == 0) {
			System.out.println("There is no sales manager in the company.");
			return false;
		}

		int i;
		for (i = 0; i < sManagers.size();i++) {
			System.out.printf("%d. %s\n", i+1, sManagers.get(i).getName());
		}
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (choice < 0 || choice > sManagers.size()) {
			System.out.println("Invalid entry.");
			return false;
		}
		sManagers.remove(choice);

		return true;
	}

	public boolean addTransportPersonnel(ArrayList<TransportPersonnel> tPersonnel) {
		if (tPersonnel.size() == MAX_EMP_SIZE) {
			System.out.println("You can not add more transportation personnel");
			return false;
		}

		TransportPersonnel tp = new TransportPersonnel();
		System.out.println("Please type the name of the new transportation personnel: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		tp.setName(name);
		tp.setId(createId('t', tPersonnel.size()));
		tPersonnel.add(tp);

		return true;
	}

	public boolean removeTransportPersonnel(ArrayList<TransportPersonnel> tPersonnel) {
		if (tPersonnel.size() == 0) {
			System.out.println("There is no transport personnel in the company.");
			return false;
		}

		int i;
		for (i = 0; i < tPersonnel.size();i++) {
			System.out.printf("%d. %s\n", i+1, tPersonnel.get(i).getName());
		}
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (choice < 0 || choice > tPersonnel.size()) {
			System.out.println("Invalid entry.");
			return false;
		}
		tPersonnel.remove(choice);

		return true;
	}

	public boolean addTechnician(ArrayList<Technician> technicians) {
		if (technicians.size() == MAX_EMP_SIZE) {
			System.out.println("You can not add more technician.");
			return false;
		}

		Technician t = new Technician();
		System.out.println("Please type the name of the new sales manager: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		t.setName(name);
		t.setId(createId('T', technicians.size()));
		technicians.add(t);

		return true;
	}

	public boolean removeTechnician(ArrayList<Technician> technicians) {
		if (technicians.size() == 0) {
			System.out.println("There is no technician in the company.");
			return false;
		}

		int i;
		for (i = 0; i < technicians.size();i++) {
			System.out.printf("%d. %s\n", i+1, technicians.get(i).getName());
		}
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (choice < 0 || choice > technicians.size()) {
			System.out.println("Invalid entry.");
			return false;
		}
		technicians.remove(choice);

		return true;
	}

	// Creates id, adds the type of the user to head of ID.
	// Checks for t because there is to t's/(Technician, Transportation Personnel)
	// If its admin, and there is already 5 admins, ID will be "A006", if 14 admins it will be "A015".

	public String createId(char code, int size) {
		String id = "";
		if (code == 't') //To seperate T with TP.
			id += "TP";
		else
			id += code;
		
        for (i = 1; i < 3; i++) { //This loop for add '0' to id if digit is small.
        	if (size+1 < Math.pow(10, 3-i))
        		id += "0";
        }
        id += Integer.toString(size+1);
        return id;
	}

}






