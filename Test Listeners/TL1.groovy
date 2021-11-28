import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext

import internal.GlobalVariable

class TL1 {
	
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseStatus()
		if (testCaseContext.getTestCaseStatus() == "FAILED") {
			GlobalVariable.ONE_OR_MORE_TESTCASES_FAILED = true
		}
	}
}