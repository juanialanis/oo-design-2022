package state.gumballmachine;

public class GumballMachine {

    State state = new SoldOutState(this);
    int count = 0;

    public GumballMachine(int numberGumballs) {

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = new NoQuarterState(this);
        }
    }

    public void insertQuarter() {
        try {
            state.insertQuarter();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void insertQuarter(int n) {
        try {
            state.insertQuarter(n);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void ejectQuarter() {
        try {
            state.ejectQuarter();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }

    public void turnCrank() {
        try {
            state.turnCrank();
            state.dispense();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count = count - 1;
        }
    }

    int getCount() {
        return count;
    }

    void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; its new count is: " + this.count);
        state.refill();
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
