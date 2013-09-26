/** 
 * Copyright (c) 2012-2015 Wonders Information Co.,Ltd. All Rights Reserved.
 * 5/F 1600 Nanjing RD(W), Shanghai 200040, P.R.C 
 *
 * This software is the confidential and proprietary information of Wonders Group.
 * (Public Service Division / Research & Development Center). You shall not disclose such
 * Confidential Information and shall use it only in accordance with 
 * the terms of the license agreement you entered into with Wonders Group. 
 *
 * Distributable under GNU LGPL license by gun.org
 */
package com.wondersgroup.push;

import com.wondersgroup.eda.core.Event;
import com.wondersgroup.eda.core.EventPullSource;

public class EventPushletRegister {
	
	static public class HelloWorldEvent extends EventPullSource {
		/**
	     * 设置休眠时间
	     */
	    @Override
	    protected long getSleepTime() {
	        return 1000;
	    }
	
	    /**
	     * 创建事件
	     * 
	     * 业务部分写在pullEvent()方法中，这个方法会被定时调用。
	     */
	    @Override
	    protected Event pullEvent() {
	        Event event = Event.createDataEvent("/wondersgroup/pushdemo");
	        event.setField("pushdemo", "HelloWorld!!!!");
	        return event;
	    }
	}
	
	/**
	 * Produces an event related to the JVM status.
	 */
	static public class SystemStatusEventPullSource extends EventPullSource {
		Runtime runtime = Runtime.getRuntime();

		public long getSleepTime() {
			return 4000;
		}

		public Event pullEvent() {
			Event event = Event.createDataEvent("/system/jvm");
			event.setField("totalMemory", "" + runtime.totalMemory());
			event.setField("freeMemory", "" + runtime.freeMemory());
			event.setField("maxMemory", "" + runtime.maxMemory());
			int activeCount = Thread.activeCount();
			event.setField("threads", "" + activeCount);

			return event;
		}
	}
}
