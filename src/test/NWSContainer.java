package test;

import java.util.ArrayList;
import java.util.List;

public class NWSContainer {
	public List<NWSContainer> container;
	public boolean isValue;
	public int value;
	public NWSContainer(int value) {
		isValue = true;
		this.value = value;
	}
	public NWSContainer() {
		isValue = false;
		this.container = new ArrayList<NWSContainer>();
	}
	@Override
	public String toString() {
		if(isValue) {
			return String.valueOf(value);
		} else {
			String ret = "{";
			for(NWSContainer c : container) {
				if(ret.length() > 1)
					ret += ",";
				ret += c.toString();
			}
			ret += "}";
			return ret;
		}
	}
}
