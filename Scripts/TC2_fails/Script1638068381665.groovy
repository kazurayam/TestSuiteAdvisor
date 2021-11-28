import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

if (GlobalVariable.ONE_OR_MORE_TESTCASES_FAILED) {
	WebUI.comment("TC2 abandoned")
	return;
}

WebUI.comment("TC2 ran")

KeywordUtil.markFailed("TC2 failed")