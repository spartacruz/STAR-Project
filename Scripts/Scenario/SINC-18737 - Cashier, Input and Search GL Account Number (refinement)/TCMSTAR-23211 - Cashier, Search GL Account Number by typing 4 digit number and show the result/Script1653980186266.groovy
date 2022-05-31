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

WebUI.callTestCase(findTestCase('Scenario/SINC-18737 - Cashier, Input and Search GL Account Number (refinement)/TCMSTAR-23205 - Input 4 Digit (exist) and Select The Sugesstion'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/button Show Result Enable'))

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/button Show Result Enable'))

WebUI.callTestCase(findTestCase('Scenario/SINC-18737 - Cashier, Input and Search GL Account Number (refinement)/_mod/verify GL Line Page_v02'),
	[('ndocStatus') : 'all', ('ndocType') : 'postedItem', ('nmaxRowItem') : '1000', ('nselectDateRangeStartDate') : '0', ('nselectDateRangeEndDate') : '0'
		, ('nGLAccountNumber') : '1002100000'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Scenario/SINC-18737 - Cashier, Input and Search GL Account Number (refinement)/_mod/verify GL Line Data Result_v02'),
	[('nGLAccountNumber') : '1002100000', ('ndebitCredit') : 'DebitCredit', ('npostingNumberFrom') : '0', ('npostingNumberTo') : '0'
		, ('ndocReferenceFrom') : '0', ('ndocReferenceTo') : '0', ('npostingDateFrom') : '0', ('npostingDateTo') : '0', ('ndocDateFrom') : '0'
		, ('ndocDateTo') : '0', ('ncostCenter') : '0', ('nprofitCenter') : '0'], FailureHandling.STOP_ON_FAILURE)

