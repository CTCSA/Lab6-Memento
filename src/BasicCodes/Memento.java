public class Memento {
	private int state; // for keeping originatorís state
	Originator orig;
	
	public Memento(Originator o) {
		orig = o;
		state = orig.state; // save originatorís state
	}

	public void restore() {
		orig.state = this.state;
	}
}