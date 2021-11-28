import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

if (GlobalVariable.ONE_OR_MORE_TESTCASES_FAILED) {
	KeywordUtil.markWarning("abandoned")
	return;
}

WebUI.comment("TC1 ran")

for (int i in 1..3) {
	WebUI.comment("TC1 is doing a heavy task: ${i}")
}