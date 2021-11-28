import com.kazurayam.ks.main.ShouldBreak
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

if (ShouldBreak.check()) return;

WebUI.comment("TC2 ran")

KeywordUtil.markFailed("TC2 failed")