package research;

public class Tech {
	
	private String name;	// Name of the Tech
	private String desc;	// Description of the Tech
	private double diff;	// Difficulty to Research the Tech
	private String[] comp;	// Component Techs of the Tech
	
	/**
	 * Create a Tech Object
	 * @param name Name of the Tech
	 * @param desc Description of the Tech
	 * @param diff Difficulty of the Tech (double)
	 * @param comp Component Techs as a String Array
	 */
	public Tech(String name, String desc, double diff, String[] comp) {
		this.name = name;
		this.desc = desc;
		this.diff = diff;
		this.comp = comp;
	}
	
	public String name() 	{ return name; }
	public String desc() 	{ return desc; }
	public double diff() 	{ return diff; }
	public String[] comp() 	{ return comp; }
	
	@Override
	public String toString() { return name(); }
	public boolean equals(Tech t) { return t.name.equals(name); }
	public boolean equals(String n) { return n.equals(name); }
	
}
