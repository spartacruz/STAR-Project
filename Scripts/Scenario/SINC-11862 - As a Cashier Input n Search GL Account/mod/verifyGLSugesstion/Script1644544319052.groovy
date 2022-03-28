import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String keywordSearch = "$nKeyword"

String nCase = keywordSearch

int keywordCount = nCase.length()

if (keywordCount < 3) {
	//Jika input kurang dari tiga, maka sistem tidak menampilkan sugestion
	
	try {
		WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/option GL Account List'),
			GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
	} catch (Exception e) {
		KeywordUtil.logInfo("element GL Account dropdown tampil - seharusnya tidak tampil")
		KeywordUtil.markFailedAndStop("element GL Account dropdown tampil - seharusnya tidak tampil")
	}

} else {
	//Jika input lebih atas sama dengan tiga, maka sistem menampilkan sugestion
	try {
		WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/option GL Account List'),
			GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
	} catch (Exception e) {
		KeywordUtil.logInfo("element GL Account dropdown tidak tampil/kosong - seharusnya tampil")
		KeywordUtil.markFailedAndStop("element GL Account dropdown tidak tampil/kosong - seharusnya tampil")
	}
	
}

