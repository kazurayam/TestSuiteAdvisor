package com.kazurayam.ks.main

import java.nio.file.Files
import java.nio.file.Path

import com.kms.katalon.core.context.TestCaseContext

import groovy.json.JsonSlurper


public class TestSuiteProgress {

	private List<TestSuiteProgressEntry> entries

	TestSuiteProgress() {
		this.entries = new ArrayList<TestSuiteProgressEntry>()
	}

	TestSuiteProgress(Path testCaseBinding) {
		this.entries = loadFile(testCaseBinding)
	}

	private List<TestSuiteProgressEntry> loadFile(Path testCaseBinding) {
		Objects.requireNonNull(testCaseBinding)
		assert Files.exists(testCaseBinding)
		List<TestSuiteProgressEntry> entries = new ArrayList<TestSuiteProgressEntry>()
		testCaseBinding.toFile().eachLine { String line ->
			JsonSlurper slurper = new JsonSlurper()
			Map object = slurper.parseText(line)
			TestSuiteProgressEntry entry
			if (object.bindedValues) {
				entry = new TestSuiteProgressEntry(object.testCaseName, object.testCaseId)
			} else {
				entry = new TestSuiteProgressEntry(object.testCaseName, object.testCaseId, object.bindedValues)
			}
			entries.add(entry)
		}
		return entries
	}

	void afterTestCase(int index, TestCaseContext testCaseContext) {
		if (index < entries.size()) {
			if (testCaseContext.getTestCaseStatus() == "FAILED") {
				this.entries.get(index).setPassed(false)
			} else {
				this.entries.get(index).setPassed(true)
			}
		} else {
			println "index=${index} exceeds the size of entries=${entries.size()}"
		}
	}

	boolean oneOrMorePreviousTestCasesHaveFailed() {
		return (this.entries.stream()
				.filter({ !it.isPassed() })
				.collect()
				.size() > 0)
	}
}
