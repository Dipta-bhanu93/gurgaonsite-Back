package com.dipta.project.utility;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Ashish.Patel
 *
 *CharacterAdapter allows you to convert one type of object to another for the purposes of marshalling/unmarshalling for Character value
 */
public class CharacterAdapter extends XmlAdapter<String, Character> {


		@Override
	    public Character unmarshal(String v) throws Exception {
	        return v.charAt(0);
	    }

	    @Override
	    public String marshal(Character v) throws Exception {
	        return new String(new char[] {v});
	    }
}
