public class Caretaker {

	public static void main(String[] arg) {
		Originator originator = new Originator();
		
		Memento m0 = new Memento(originator); // keep the state in m0
		originator.action(); // the action changes originator's state
		originator.action();
		System.out.println("state = " + originator.getState());
		m0.restore(); // restore originator's state 
		System.out.println("state after restore = " + originator.getState());
	}

}