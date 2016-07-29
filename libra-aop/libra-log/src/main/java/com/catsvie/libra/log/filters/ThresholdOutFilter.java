/**
 * 
 */
package com.catsvie.libra.log.filters;

import com.catsvie.libra.log.LogConfig;
import com.catsvie.libra.log.NoLogging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @author Peng Wang <br/>
 *         Jun 7, 2016
 * @version 1.0 <br/>
 */
@NoLogging
public class ThresholdOutFilter<E> extends AbstractMatcherFilter<E> {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.qos.logback.core.filter.Filter#decide(java.lang.Object)
	 */
	@Override
	public FilterReply decide(E event) {
		if (!isStarted()) {
			return FilterReply.NEUTRAL;
		}

		LoggingEvent loggingEvent = (LoggingEvent) event;

		int threshold = getThresholdIntValue(LogConfig.getFileOutFilterLevel());
		if (loggingEvent.getLevel().toInt() >= threshold) {
			return FilterReply.NEUTRAL;
		} else {
			return FilterReply.DENY;
		}
	}

	/**
	 * TODO: JAVADOC METHOD
	 * 
	 * @param fileOutFilterLevel
	 * @return
	 */
	private int getThresholdIntValue(org.slf4j.event.Level fileOutFilterLevel) {
		switch (fileOutFilterLevel) {
			case ERROR:
				return Level.ERROR_INT;
			case WARN:
				return Level.WARN_INT;
			case DEBUG:
				return Level.DEBUG_INT;
			case TRACE:
				return Level.TRACE_INT;
			case INFO:
			default:
				return Level.INFO_INT;
		}
	}

}
