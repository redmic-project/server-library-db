package es.redmic.db.geodata.tracking.common.model;

public enum LocationClass {
	
	
	ARGOS_G("G"),
	ARGOS_3("3"),
	ARGOS_2("2"),
	ARGOS_1("1"),
	ARGOS_0("0"),
	ARGOS_A("A"),
	ARGOS_B("B"),
	ARGOS_Z("Z");
	
	private final String value;
	
	private LocationClass(final String newValue) {
		value = newValue;
	}
	
	public String getValue() { return value; }
	

	public static LocationClass find(String newValue) {
		for (LocationClass locationClass : LocationClass.values()) {
            if (locationClass.getValue() == newValue) return locationClass;
        }
		return null;  
	}
}
