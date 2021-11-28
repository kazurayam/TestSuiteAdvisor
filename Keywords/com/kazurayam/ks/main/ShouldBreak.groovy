package com.kazurayam.ks.main

import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil


public class ShouldBreak {
	
	@Keyword
	static boolean check() {
		boolean oneOrMoreFailures = ((TestSuiteProgress)GlobalVariable.PROGRESS).oneOrMorePreviousTestCasesHaveFailed()
		if (oneOrMoreFailures) {
			KeywordUtil.markWarning("should break")
		}
	}
}
