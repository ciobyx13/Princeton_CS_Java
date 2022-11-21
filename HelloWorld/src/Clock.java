
public class Clock {
	
	private int _h;
	private int _m;
	
	// Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
    	if (h < 0 || h > 23 || m < 0 || m > 59) throw new IllegalArgumentException();
    	_h = h;
    	_m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
    	if (s.substring(2, 3).equals(":") && s.length()==5) {
    		try {
    			int h = Integer.parseInt(s.substring(0,2));
        	    int m = Integer.parseInt(s.substring(3,5));
        	    if (h < 0 || h > 23 || m < 0 || m > 59) throw new IllegalArgumentException();
        	    _h = h;
        	    _m = m;
    		}
    		catch (NumberFormatException e){
    			throw new IllegalArgumentException();
    		}
    	}
    	else throw new IllegalArgumentException();
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
    	return String.format("%02d", _h)+":"+String.format("%02d", _m);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
    	return (_h * 60 + _m < that._h * 60 + that._m);
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
    	_m++;
    	if (_m == 60) {
    		_m = 0;
    		_h++;
    		if (_h == 24) _h = 0;
    	}
    	
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
    	_m += delta % 60;
    	_h += delta / 60;
    	if (_m >= 60) {
    		_m -= 60;
    		_h++;
    	}
		if (_h >= 24) _h = _h % 24;
    	
    }

    // Test client (see below).
	public static void main(String[] args) {
		Clock myClock = new Clock(5, 6);
		StdOut.println(myClock);
		myClock.tic();
		StdOut.println(myClock);
		myClock.toc(30000);
		StdOut.println(myClock);
		StdOut.println(new Clock ("11:59"));
		StdOut.println(myClock.isEarlierThan(new Clock ("04:24")));

	}

}
