package com.kazurayam.ks.common

import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable

public class ShouldContinue {

	@Keyword
	void check(Closure closure) {
		if (GlobalVariable.ONE_OR_MORE_TESTCASES_FAILED != null &&
		GlobalVariable.ONE_OR_MORE_TESTCASES_FAILED == true) {
			closure.call();
		}
	}
}
