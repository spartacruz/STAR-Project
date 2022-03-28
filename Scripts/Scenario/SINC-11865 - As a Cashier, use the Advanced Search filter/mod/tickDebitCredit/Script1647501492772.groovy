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

if (choice == 'DebitCredit') {
    try {
        WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Debit unticked'), 
            FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Credit unticked'), 
            FailureHandling.STOP_ON_FAILURE)
    }
    catch (Exception e) {
        KeywordUtil.logInfo('Debit atau kredit masih ter-tick atau elemen tidak ada')

        KeywordUtil.markFailedAndStop('Debit atau kredit masih ter-tick atau elemen tidak ada')
    } 
    
    WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Debit unticked'))

    WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Credit unticked'))

    WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Debit ticked'))

    WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Credit ticked'))

    WebUI.verifyElementNotVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div DebitCredit_warning'))

} else if ('DebitOnly') {
	try {
		WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Debit unticked'),
			FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Credit unticked'),
			FailureHandling.STOP_ON_FAILURE)
	}
	catch (Exception e) {
		KeywordUtil.logInfo('Debit atau kredit masih ter-tick atau elemen tidak ada')

		KeywordUtil.markFailedAndStop('Debit atau kredit masih ter-tick atau elemen tidak ada')
	}
	
	WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Debit unticked'))
	
	WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Debit ticked'))
	
	WebUI.verifyElementNotVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div DebitCredit_warning'))
} else if ('CreditOnly') {
	try {
		WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Debit unticked'),
			FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Credit unticked'),
			FailureHandling.STOP_ON_FAILURE)
	}
	catch (Exception e) {
		KeywordUtil.logInfo('Debit atau kredit masih ter-tick atau elemen tidak ada')

		KeywordUtil.markFailedAndStop('Debit atau kredit masih ter-tick atau elemen tidak ada')
	}
	
	WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Credit unticked'))
	
	WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Credit ticked'))
	
	WebUI.verifyElementNotVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div DebitCredit_warning'))
}

