/**
 * 
 */
package com.dipta.project.utility.constants;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Aditya.Julka
 * @version 1.1
 * This class is used to replace special character recieved as input to execute in php file.
 */


public enum PhpScriptReplaceConstants {

	BACKSLASH("\\\\"," \\\\\\\\\\\\\\\\"),
	ESCAPECHARACTER("(\\r|\\n|\\r\\n)+"," . "),
	SINGLRQUOTE("\'"," \\\\\'"),
	DOUBLEQUOTES("\""," \\\\\"");


	@Getter
	@Setter
	private String regexToReplaceWith;

	@Getter
	@Setter
	private String regexToReplace;
	/**
	 * 
	 * @param regexToReplace
	 * @param regexToReplaceWith
	 */
	private PhpScriptReplaceConstants(String regexToReplace,String regexToReplaceWith) {
		setRegexToReplaceWith(regexToReplaceWith);
		setRegexToReplace(regexToReplace);

	}







}