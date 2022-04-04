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

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/input GL Account'))

WebUI.setText(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/input GL Account'), '8991600000')

WebUI.callTestCase(findTestCase('Scenario/SINC-11862 - As a Cashier Input n Search GL Account/mod/verifyGLSugesstion'), 
    [('nKeyword') : GlobalVariable.InputFourDigit], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/option select Account 8991600000 - Other IncomeCharges Payment Difference'), 
    GlobalVariable.waitPresentTimeout)

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/option select Account 8991600000 - Other IncomeCharges Payment Difference'))

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/input Start Date'))

WebUI.setText(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/input Start Date'), '01-02-2022')

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/input End Date'))

WebUI.setText(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/input End Date'), '28-02-2022')

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/input End Date'), Keys.chord(Keys.ENTER))

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/button Show Result Enable'))

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/button Show Result Enable'))

WebUI.callTestCase(findTestCase('Scenario/SINC-12845 - As a Cashier, View n Maintain GL Line Account/mod/verify GL Line Page'), 
    [('ndocStatus') : 'all', ('ndocType') : 'postedItem', ('nmaxRowItem') : '1000', ('nselectDateRangeStartDate') : '0', ('nselectDateRangeEndDate') : '0'
        , ('nGLAccountNumber') : '8991600000'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Scenario/SINC-12845 - As a Cashier, View n Maintain GL Line Account/mod/verify GL Line Data Result'), 
    [('nGLAccountNumber') : '8991600000', ('ndebitCredit') : 'DebitCredit', ('npostingNumberFrom') : '0', ('npostingNumberTo') : '0'
        , ('ndocReferenceFrom') : '0', ('ndocReferenceTo') : '0', ('npostingDateFrom') : '0', ('npostingDateTo') : '0', ('ndocDateFrom') : '01-02-2022'
        , ('ndocDateTo') : '28-02-2022', ('ncostCenter') : '0', ('nprofitCenter') : '0'], FailureHandling.STOP_ON_FAILURE)

