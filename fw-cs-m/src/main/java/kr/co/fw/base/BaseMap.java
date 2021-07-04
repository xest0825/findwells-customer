package kr.co.fw.base;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap을 상속받아 null일 때 빈값을 넣기 위해 만들어진 클래스
 * mapper에서 HashMap으로 리턴 시 null 값인 경우 화면에서 따로 null 처리를 해주어야 하기 때문에 생성
 * put, get시 null을 빈값으로 세팅
 * @author KIMDONGUK
 *
 */
public class BaseMap extends HashMap<String, Object> {

	private final Map<String, String> lowerCaseMap = new HashMap<String, String>();

	/**
	 * Required for serialization support.
	 *
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = -2848100435296897392L;


	@Override
	public boolean containsKey(Object key) {
		return super.containsKey(key.toString());
	}

	@Override
	public Object get(Object key) {
		Object obj = super.get(key);
		
		if(obj instanceof String) obj = obj == null ? "" : obj;
		
		return obj;
	}

	@Override
	public Object put(String key, Object value) {
		value = value == null ? "" : value;
		
		return super.put(key, value);
	}


	@Override
	public void putAll(Map<? extends String, ?> m) {
		for (Map.Entry<? extends String, ?> entry : m.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			value = value == null ? "" : value;
			this.put(key, value);
		}
	}

	@Override
	public Object remove(Object key) {
		Object realKey = lowerCaseMap.remove(key.toString());
		return super.remove(realKey);
	}
}
