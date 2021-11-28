import com.kazurayam.ks.main.ShouldBreak
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

if (ShouldBreak.check()) return;

WebUI.comment("TC1 ran")

for (int i in 1..3) {
	WebUI.comment("TC1 is doing a heavy task: ${i}")
}