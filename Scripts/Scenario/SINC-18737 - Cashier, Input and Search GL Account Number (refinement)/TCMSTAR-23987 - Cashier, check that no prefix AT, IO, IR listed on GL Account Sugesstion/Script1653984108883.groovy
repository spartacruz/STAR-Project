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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Scenario/SINC-11862 - As a Cashier Input n Search GL Account/TCMSTAR-14816 - As a Cashier I Want to See GL Line Item Page'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/input GL Account'))

String[] inputedText = ['AT-0010000', 'IO-4000000', 'IO-5000000', 'IR-7001000', 'IR-7000800']

for (String item : inputedText) {
	addAndDeleteGLAccount(item)
}

def addAndDeleteGLAccount(inputData) {
	WebUI.setText(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/input GL Account'), inputData)
	
	WebUI.delay(2)
	
	WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/option select Account GL No Data'),
		GlobalVariable.waitPresentTimeout)
	
	WebUI.delay(2)
	
	WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/input GL Account'), Keys.chord(Keys.CONTROL,
			'a'))
	
	WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/input GL Account'), Keys.chord(Keys.BACK_SPACE))
	WebUI.delay(2)
}

