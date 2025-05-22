package Run;

public class HashMap {
	private String[] set;

	public HashMap() {
		set = new String[10];
	}

	public void add(String value) {
		set[hashFunction(value)] = value;
	}

	public int hashFunction(String value) {
		int sumOfChars = 0;
		for (int i = 0; i < value.length(); i++) {

			sumOfChars += (int) (value.charAt(i));
		}
		sumOfChars = sumOfChars % 10;
		return sumOfChars;
	}

	public String toString() {
		String res = "";
		for (int i = 0; i < set.length; i++) {
			res += set[i] + " ";
		}
		return res;
	}

	public boolean contains(String value) {
		return set[hashFunction(value)] == value;
	}

	public void delete(String value) {
		set[hashFunction(value)] = null;
	}
}
