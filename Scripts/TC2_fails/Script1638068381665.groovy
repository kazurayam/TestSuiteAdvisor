import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

if (GlobalVariable.ONE_OR_MORE_TESTCASES_FAILED) {
	KeywordUtil.markWarning("abandoned")
	return;
}

WebUI.comment("TC2 ran")

KeywordUtil.markFailed("TC2 failed")