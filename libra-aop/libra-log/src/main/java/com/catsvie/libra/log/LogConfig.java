/**
 * 
 */
package com.catsvie.libra.log;

import org.slf4j.event.Level;

/**
 * @author Peng Wang <br/>
 *         Jun 15, 2016
 * @version 1.0 <br/>
 */
public class LogConfig {
	private static Level fileOutFilterLevel = Level.INFO;
	private static boolean stdToConsole = true;
	
	/**
	 * @return the fileOutFilterLevel
	 */
	public static Level getFileOutFilterLevel() {
		return fileOutFilterLevel;
	}
	
	/**
	 * @param fileOutFilterLevel
	 *            the fileOutFilterLevel to set
	 */
	@NoLogging
	public static void setFileOutFilterLevel(Level fileOutFilterLevel) {
		LogConfig.fileOutFilterLevel = fileOutFilterLevel;
	}

	/**
	 * @return the stdToConsole
	 */
	public static boolean isStdToConsole() {
		return stdToConsole;
	}

	/**
	 * @param stdToConsole
	 *            the stdToConsole to set
	 */
	@NoLogging
	public static void setStdToConsole(boolean stdToConsole) {
		LogConfig.stdToConsole = stdToConsole;
	}

}
