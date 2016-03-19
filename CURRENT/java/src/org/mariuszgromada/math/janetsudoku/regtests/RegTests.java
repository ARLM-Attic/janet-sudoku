/*
 * @(#)RegTests.java        1.0.0    2016-03-19
 *
 * You may use this software under the condition of "Simplified BSD License"
 *
 * Copyright 2016 MARIUSZ GROMADA. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY <MARIUSZ GROMADA> ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of MARIUSZ GROMADA.
 *
 * If you have any questions/bugs feel free to contact:
 *
 *     Mariusz Gromada
 *     mariusz.gromada@mathspace.pl
 *     http://mathspace.pl/
 *     http://mathparser.org/
 *     http://github.com/mariuszgromada/java-utils
 *     http://github.com/mariuszgromada/MathParser.org-mXparser
 *     http://mariuszgromada.github.io/MathParser.org-mXparser/
 *     http://mxparser.sourceforge.net/
 *     http://bitbucket.org/mariuszgromada/mxparser/
 *     http://mxparser.codeplex.com/
 *
 *                              Asked if he believes in one God, a mathematician answered:
 *                              "Yes, up to isomorphism."
 */

package org.mariuszgromada.math.janetsudoku.regtests;
import org.mariuszgromada.janetutils.DateTimeX;
import org.mariuszgromada.math.janetsudoku.SudokuStore;

/**
 * Starts all regression tests.
 *
 * @author         <b>Mariusz Gromada</b><br/>
 *                 <a href="mailto:mariusz.gromada@mathspace.pl">mariusz.gromada@mathspace.pl</a><br>
 *                 <a href="http://mathspace.pl/" target="_blank">MathSpace.pl</a><br>
 *                 <a href="http://mathparser.org/" target="_blank">MathParser.org - mXparser project page</a><br>
 *                 <a href="http://github.com/mariuszgromada/java-utils" target="_blank">Java-Utils on GitHub</a><br>
 *                 <a href="http://github.com/mariuszgromada/MathParser.org-mXparser" target="_blank">mXparser on GitHub</a><br>
 *                 <a href="http://mariuszgromada.github.io/MathParser.org-mXparser/" target="_blank">mXparser on GitHub pages</a><br>
 *                 <a href="http://mxparser.sourceforge.net/" target="_blank">mXparser on SourceForge</a><br>
 *                 <a href="http://bitbucket.org/mariuszgromada/mxparser/" target="_blank">mXparser on Bitbucket</a><br>
 *                 <a href="http://mxparser.codeplex.com/" target="_blank">mXparser on CodePlex</a><br>
 *
 * @version        1.0.0
 *
 * @see SudokuSolver
 */
public class RegTests {
	/**
	 * Start all regression tests.
	 *
	 * @param threadsNumber  Threads number.
	 * @return               Number of tests with error result.
	 */
	public static int start(int threadsNumber) {
		SudokuStore.consolePrintln("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		SudokuStore.consolePrintln("All regression tests - starting.");
		SudokuStore.consolePrintln("  - RegTestsSolver.start()");
		SudokuStore.consolePrintln("  - RegTestsGenerator.start()");
		SudokuStore.consolePrintln("  - RegTestsStore.start()");
		SudokuStore.consolePrintln("  - RegTestsApi.start()");
		SudokuStore.consolePrintln("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		long startTime = DateTimeX.currentTimeMillis();
		int solverErrors = RegTestsSolver.start(threadsNumber);
		int generatorErrors = RegTestsGenerator.start(threadsNumber);
		int storeErrors = RegTestsStore.start(threadsNumber);
		int apiErrors = RegTestsApi.start(threadsNumber);
		long endTime = DateTimeX.currentTimeMillis();
		double computingTime = (endTime - startTime) / 1000.0;
		int totalErrors = solverErrors + generatorErrors + storeErrors + apiErrors;
		SudokuStore.consolePrintln("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		SudokuStore.consolePrintln("All regression tests - finished.");
		SudokuStore.consolePrintln("Errors: " + totalErrors);
		SudokuStore.consolePrintln("  - RegTestsSolver errors: " + solverErrors);
		SudokuStore.consolePrintln("  - RegTestsGenerator errors: " + generatorErrors);
		SudokuStore.consolePrintln("  - RegTestsStore errors: " + storeErrors);
		SudokuStore.consolePrintln("  - RegTestsApi errors: " + apiErrors);
		SudokuStore.consolePrintln("");
		SudokuStore.consolePrintln("Computing time: " + computingTime + " s.");
		SudokuStore.consolePrintln("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		return totalErrors;
	}
	/**
	 * Start all regression tests with default number of threads.
	 *
	 * @return               Number of tests with error result.
	 */
	public static int start() {
		return start( Runtime.getRuntime().availableProcessors() );
	}
	/**
	 * Start all regression tests.
	 * @param args     Optional first argument with threads number,
	 *                 otherwise default threads number is used.
	 */
	public static void main(String[] args) {
		if (args != null) {
			if (args.length > 0)
				if (args[0] != null) {
					int threadsNumber = Integer.parseInt(args[0]);
					if (threadsNumber > 0) {
						start(threadsNumber);
						return;
					}
				}
		}
		start();
	}
}
