package lec13;

public class nokiakeypadcombinations {

	public static void main(String[] args) {

	}

	public String getcode(char cc) {
		String retVal = "";
		switch (cc) {
		case '1':
			retVal = "abc";
		case '2':
			retVal = "def";
		case '3':
			retVal = "ghi";
		case '4':
			retVal = "jkl";
		case '5':
			retVal = "mno";
		case '6':
			retVal = "pqr";
		case '7':
			retVal = "stu";
		case '8':
			retVal = "vwx";
		case '9':
			retVal = "yz";
		case '0':
			retVal = ",;";
		default:
			retVal = "";

		}
		return retVal;
	}
}
