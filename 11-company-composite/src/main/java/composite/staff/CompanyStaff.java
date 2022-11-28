package composite.staff;

import java.util.Iterator;
  
public class CompanyStaff {
	DeveloperComponent developers;
 
	public CompanyStaff(DeveloperComponent developers) {
		this.developers = developers;
	}
 
	public void printStaff() {
		developers.print();
	}
  
	public void printAllDevelopers() {
		Iterator<DeveloperComponent> iterator = developers.createIterator();

		System.out.println("\n ALL DEVELOPERS STAFF\n----");
		while (iterator.hasNext()) {
			DeveloperComponent developerComponent = iterator.next();
			try {
        developerComponent.print();
				
			} catch (UnsupportedOperationException e) {}
		}
	}

  public boolean existPerson(String name) {
		Iterator<DeveloperComponent> iterator = developers.createIterator();

		while (iterator.hasNext()) {
			DeveloperComponent developerComponent = iterator.next();
			try {
        if(developerComponent.getName().equals(name)){
          return true;
        }
				
			} catch (UnsupportedOperationException e) {}
		}
    return false;
	}

  public boolean existDependency(String depends, String of) {
		Iterator<DeveloperComponent> iterator = developers.createIterator();

		while (iterator.hasNext()) {
			DeveloperComponent developerComponent = iterator.next();
			try {
        if(developerComponent.getName().equals(of)){
          Iterator<DeveloperComponent> substaff = developerComponent.createIterator();
          while (substaff.hasNext()) {
            DeveloperComponent substaffComponent = substaff.next();
            try {
              if(substaffComponent.getName().equals(depends)){
                return true;
              }
              
            } catch (UnsupportedOperationException e) {}
          }
          return false;
        }
				
			} catch (UnsupportedOperationException e) {}
		}
    return false;
	}

}
