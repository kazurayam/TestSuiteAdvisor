import java.nio.file.Path
import java.nio.file.Paths

import com.kazurayam.ks.main.TestSuiteProgress
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import internal.GlobalVariable

class TestSuiteProgressMonitor {
	
	private int index
	
	TestSuiteProgressMonitor() {
		Path bunchDir = Paths.get(RunConfiguration.getReportFolder())
		Path testCaseBinding = bunchDir.resolve("testCaseBinding")
		GlobalVariable.PROGRESS = new TestSuiteProgress(testCaseBinding)
		assert GlobalVariable.PROGRESS != null
		index = 0
	}
	
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		//println testCaseContext.getTestCaseId()
		//println testCaseContext.getTestCaseVariables()	
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		// testCaseContext.getTestCaseId()
		// testCaseContext.getTestCaseStatus()
		((TestSuiteProgress)GlobalVariable.PROGRESS).afterTestCase(index, testCaseContext)
		index += 1
	}

	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		// testSuiteContext.getTestSuiteId()
	}

	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		// testSuiteContext.getTestSuiteId()
	}
}