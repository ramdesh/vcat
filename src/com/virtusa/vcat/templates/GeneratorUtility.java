package com.virtusa.vcat.templates;

/**
 * Generator utility for Velocity templating. Corresponds to the $utility object within Velocity.
 * 
 *
 */
public final class GeneratorUtility {
	public String toUpperCase(String string) {
		return string.toUpperCase();
	}

	public String firstToUpperCase(String string) {
		String post = string.substring(1, string.length());
		String first = ("" + string.charAt(0)).toUpperCase();
		return first + post;
	}
	
	public String toLowerCase(String string) {
		return string.toLowerCase();
	}
	
	public String stringfyNulls(String string) {
		if ( string.equals(null) ) {
			return "";
		}
		else return string;
	}
	/**
	 * Returns the period character. Helps avoid confusion with dot notation during templating.
	 * @return the "." character
	 */
	public String getPeriod() {
		return ".";
	}
	/**
	 * Returns the underscore character.
	 * @return the "_" character
	 */
	public String getUnderscore() {
	   return "_"; 
	}
}
