import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

if (GlobalVariable.ONE_OR_MORE_TESTCASES_FAILED) {
	WebUI.comment("TC1 abandoned")
	return;
}

WebUI.comment("TC1 ran")

for (int i in 1..3) {
	WebUI.comment("TC1 is doing a heavy task: ${i}")
}