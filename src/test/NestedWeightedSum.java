package test;

import tools.io;

public class NestedWeightedSum {
	public static NWSContainer createRandContainer(int maxLevel) {
		NWSContainer ret = new NWSContainer();
		if(maxLevel > 0) {
			int lvl = 1 + io.rnd(maxLevel);
			for(int i = 0; i < lvl; i++) {
				int isValue = io.rnd(3);
				if(isValue != 0) {
					ret.container.add(new NWSContainer(io.rnd(maxLevel) + 1));
				} else {
					ret.container.add(createRandContainer(maxLevel - 1));
				}
			}
		} else {
			ret.isValue = true;
			ret.value = io.rnd(10);
		}
		return ret;
	}
	public static int weightedSum(NWSContainer c) {
		if(c == null)
			return 0;
		return weightedSumHelper(c, 1);
	}
	private static int weightedSumHelper(NWSContainer c, int level) {
		if(c == null)
			return 0;
		if(c.isValue)
			return c.value * level;
		int sum = 0;
		for(NWSContainer nwsc : c.container)
			sum += nwsc.isValue ? nwsc.value : weightedSumHelper(nwsc, level + 1);
		return sum * level;
	}
	public static int reverseWS(NWSContainer c) {
		return reverseWSDFS(c, reverseWSHelper(c, 1));
	}
	private static int reverseWSDFS(NWSContainer c, int maxLevel) {
		if(c.isValue)
			return c.value;
		int sum = 0;
		for(NWSContainer nwsc : c.container) {
			if(nwsc.isValue)
				sum += nwsc.value;
			else
				sum += reverseWSDFS(nwsc, maxLevel - 1);
		}
		return sum * maxLevel;
	}
	private static int reverseWSHelper(NWSContainer c, int level) {
		int maxLevel = level;
		if(!c.isValue) {
			for(NWSContainer nwsc : c.container) {
				if(!nwsc.isValue) {
					int tempMaxLevel = reverseWSHelper(nwsc, level + 1);
					if(tempMaxLevel > maxLevel)
						maxLevel = tempMaxLevel;
				}
			}
		}
		return maxLevel;
	}	
	public static void main(String[] args) {
		NWSContainer nwsc = createRandContainer(5);
		io.p(nwsc.toString());
		io.p(" = ");
		io.pl(weightedSum(nwsc));
		io.p(nwsc.toString());
		io.p(" = ");
		io.p(reverseWS(nwsc));
	}
}
