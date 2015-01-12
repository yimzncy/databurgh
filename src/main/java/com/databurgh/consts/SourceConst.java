package com.databurgh.consts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.databurgh.enums.DocSourceEnum;

public class SourceConst {
	
	public static final List<DocSourceEnum> sourceList = new ArrayList<DocSourceEnum>(
			Arrays.asList(
					DocSourceEnum._36KR
//					DocSourceEnum.IFANR,
//					DocSourceEnum.HUXIU,
//					DocSourceEnum.CYZONE,
//					DocSourceEnum.FREEBUF
					));

	public static final Map<DocSourceEnum, String> sourceMap = new HashMap<DocSourceEnum, String>() {
		private static final long serialVersionUID = 1L;
	{
		put(DocSourceEnum._36KR, "http://www.36kr.com/feed");
		put(DocSourceEnum.IFANR, "http://www.ifanr.com/feed");
		put(DocSourceEnum.HUXIU, "http://www.huxiu.com/rss/0.xml");
		put(DocSourceEnum.CYZONE, "http://www.cyzone.cn/rss");
		put(DocSourceEnum.FREEBUF, "http://www.freebuf.com/feed");
	}};
}
