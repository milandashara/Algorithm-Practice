package morgan_mickley;

public class Username {
	public static boolean validate(String username) {
		if(username.length() < 6 || username.length() >16){
			return false;
		}

		if (!Character.isLetter(username.charAt(0))){
			return false;
		}

		if (username.charAt(username.length()-1) == '-'){
			return false;
		}

		boolean hasLetter = false;
		boolean hasNumber = false;

		for (int i=0;i<username.length();i++){
			char c = username.charAt(i);

			if (Character.isLetter(c)){
				hasLetter = true;
			}

			if (Character.isDigit(c)){
				hasNumber = true;
			}

			if (!Character.isLetter(c) && !Character.isDigit(c) && c !='-'){
				return false;
			}
		}

		if (hasLetter && hasNumber)
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		System.out.println(validate("Mike-Standish")); // Valid username
		System.out.println(validate("Mike Standish")); // Invalid username
	}
}
