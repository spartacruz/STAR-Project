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

String choice = "$nKeyword"

try {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Empty UNticked'),
		5)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Open UNticked'),
		5)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Posted UNticked'),
		5)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status CANCELLED UNticked'),
		5)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status DELETED UNticked'),
		5)
}
catch (Exception e) {
	KeywordUtil.logInfo('One or more Status is already ticked or element is not exist')
	KeywordUtil.markFailedAndStop('One or more Status is already ticked or element is not exist')
}

String[] keywordArray = new String[50]
keywordArray = choice.split(',')

println(keywordArray.size())
if (keywordArray.size() > 1) {
	
	for (int i = 0; i <= keywordArray.size() - 1; i++) {
		tickChoice(keywordArray[i])
	}
	
} else {
	tickChoice(keywordArray[0])
}

def tickChoice (paramChoice) {
	switch (paramChoice) {
		case 'Empty':
			WebUI.click(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Empty UNticked'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Empty ticked'),5)
			return
		
		case 'Open':
			WebUI.click(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Open UNticked'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Open ticked'),5)
			return
			
		case 'Posted':
			WebUI.click(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Posted UNticked'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Posted ticked'),5)
			return
			
		case 'Cancelled':
			WebUI.click(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status CANCELLED UNticked'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status CANCELLED ticked'),5)
			break
			
		case 'Deleted':
			WebUI.click(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status DELETED UNticked'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status DELETED ticked'),5)
			return
	}
}