import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

if (GlobalVariable.ONE_OR_MORE_TESTCASES_FAILED) {
	WebUI.comment("TC3 abandoned")
	return;
}

WebUI.comment("TC3 ran")

for (int i in 1..3) {
	WebUI.comment("TC3 is doing a heavy task: ${i}")
}