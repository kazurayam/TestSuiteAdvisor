import com.kazurayam.ks.testsuite.Advisor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

if (Advisor.shouldBreak()) return;

WebUI.comment("TC2 ran")

for (int i in 1..3) {
	WebUI.comment("TC2 is doing a heavy task: ${i}")
}