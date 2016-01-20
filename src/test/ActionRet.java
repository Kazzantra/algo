package test;

public interface ActionRet<T, R> extends Action<T> {
	public R actNReturn(T obj);
}
