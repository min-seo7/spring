package com.yedam.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class ListMapTest {

	@Test
	public void test1() {
		//테이블 1개 -> VO 1개 (1대1 매핑)
		//테이블 조인 select 할때마다 VO를 생성하게 되는데 그걸 대한하기 위해 map을 사용.
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("empno", "100");
		map.put("ename", "홍길동");
		map.put("dname", "인사");
		
		list.add(map);
	}
}
