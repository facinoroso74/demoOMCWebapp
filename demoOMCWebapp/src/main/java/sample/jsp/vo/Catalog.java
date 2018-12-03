package sample.jsp.vo;

import java.io.Serializable;
import java.util.Arrays;

public class Catalog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1976210212951640181L;
	
	private Shoes[] shoesArray;

	public Shoes[] getShoesArray() {
		return shoesArray;
	}

	public void setShoesArray(Shoes[] shoesArray) {
		this.shoesArray = shoesArray;
	}

	@Override
	public String toString() {
		
		return "Catalog [shoesArray=" + Arrays.toString(shoesArray) + "]";
	}
	
	
}
