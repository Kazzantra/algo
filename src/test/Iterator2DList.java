package test;

import java.util.ArrayList;
import java.util.List;

public class Iterator2DList<T> {
	int list;
	int index;
	List<List<T>> cont;
	//Iterator<T> itr;
	Iterator2DList() {
		list = 0;
		index = -1;
		cont = new ArrayList<List<T>>();
		List<T> temp = new ArrayList<T>();
		cont.add(temp);
	}
	Iterator2DList(List<List<T>> cont) {
		list = -1;
		index = -1;
		this.cont = cont;
		if(this.cont == null)
			throw new RuntimeException("null initial contents");
		for(int i = 0; i < this.cont.size(); i++) {
			if(this.cont.get(i) != null && this.cont.get(i).size() > 0) {
				list = i;
				break;
			}
		}
		if(list > -1 && this.cont.get(list).size() > 0)
			index = 0;
	}
	public boolean hasNext() {
		if(list < 0 || index < 0)
			return false;
		if(index + 1 >= cont.get(list).size() && list + 1 >= cont.size())
			return false;
		return true;
	}
	public T next() {
		if(hasNext()) {
			if(index + 1 >= cont.get(list).size()) {
				index = 0;
				list++;
			} else {
				index++;
			}
			return cont.get(list).get(index);
		} else {
			throw new RuntimeException("end of contents");
		}
	}
}
