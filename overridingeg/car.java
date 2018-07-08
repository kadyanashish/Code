package overridingeg;

public class car implements Comparable<car> {

	int price;
	int speed;

	public car(int p, int s) {
		this.price = p;
		this.speed = s;
	}

	@Override
	public int compareTo(car o) {
		// TODO Auto-generated method stub
		return this.price - o.price;
	}

	@Override
	public String toString() {
		return (String) (this.price + " " + this.speed);
	}
}
