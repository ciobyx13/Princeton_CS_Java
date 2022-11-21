
public class Bar implements Comparable<Bar>{

	private String _name;
	private String _category;
	private int _value;
	
	
    // Creates a new bar.
    public Bar(String name, int value, String category) {
    	if (name == null || category == null || value < 0) throw new IllegalArgumentException();
    	_name = name;
    	_category = category;
    	_value = value;
    }

    // Returns the name of this bar.
    public String getName() {
    	return _name;
    }

    // Returns the value of this bar.
    public int getValue() {
    	return _value;
    }

    // Returns the category of this bar.
    public String getCategory() {
    	return _category;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
    	if (that == null) throw new NullPointerException();
    	if (_value < that._value) return -1;
    	if (_value > that._value) return 1;
    	return 0;
    }


}
