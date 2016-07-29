/**
 * 
 */
package com.catsvie.libra.log.filters;

import java.util.Arrays;
import java.util.List;

import com.catsvie.libra.log.NoLogging;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @author Peng Wang <br/>
 *         Jun 7, 2016
 * @version 1.0 <br/>
 */
@NoLogging
public class ThreadOutFilter<E> extends AbstractMatcherFilter<E> {

	/* (non-Javadoc)
	 * @see ch.qos.logback.core.filter.Filter#decide(java.lang.Object)
	 */
	@Override
	public FilterReply decide(E event) {
		if (!isStarted()) {
			return FilterReply.NEUTRAL;
		}

		LoggingEvent loggingEvent = (LoggingEvent) event;

		List<String> excludThreads = Arrays.asList("ServerDBTasks", "LocalAdminTasks");
		if (!excludThreads.contains(loggingEvent.getThreadName())) {
			return FilterReply.NEUTRAL;
		} else {
			return FilterReply.DENY;
		}
	}

}
