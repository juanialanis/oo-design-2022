package composite.staff;

public class DevelopersTestDrive {
	public static void main(String args[]) {
		
		DeveloperComponent allDevelopers = new Developer("Jeff", "CEO");
		DeveloperComponent seniorOne = new Developer("Laura", "SENIOR MANAGER");
		DeveloperComponent seniorTwo = new Developer("Ravi", "SENIOR MANAGER");
		DeveloperComponent seniorThree = new Developer("Grant", "SENIOR MANAGER");
    allDevelopers.add(seniorOne);
    allDevelopers.add(seniorTwo);
    allDevelopers.add(seniorThree);

    DeveloperComponent managerOne = new Developer("Remy", "MANAGER");
    DeveloperComponent managerTwo = new Developer("Remy", "MANAGER");
    DeveloperComponent managerThree = new Developer("Remy", "MANAGER");
    seniorOne.add(managerOne);
    seniorOne.add(managerTwo);
    seniorOne.add(managerThree);
    managerOne.add(new DeveloperItem("Juan", "DEVELOPER"));
    managerOne.add(new DeveloperItem("Luca", "DEVELOPER"));
		CompanyStaff staff = new CompanyStaff(allDevelopers);
   
		staff.printStaff();
    System.out.println(staff.existPerson("Juan"));
    System.out.println(staff.existPerson("Remy"));
    System.out.println(staff.existPerson("Grant"));
    System.out.println(staff.existDependency("Juan","Remy"));
    System.out.println(staff.existDependency("Juan","Laura"));
    System.out.println(staff.existDependency("Luca","Laura"));
		// staff.printAllDevelopers();
 
	}
}
