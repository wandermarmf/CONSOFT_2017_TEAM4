package br.gov.ufms.SGCteam04.models;

public class CheckOption {

	public static boolean isField(String paramName, String findName) {
		if ((findName == null) || (paramName == null))
			return false;
		
		if (paramName.length() < findName.length())
			return false;
		
		return paramName.substring(0, findName.length()).toLowerCase().equals(findName) == true;
	}

}