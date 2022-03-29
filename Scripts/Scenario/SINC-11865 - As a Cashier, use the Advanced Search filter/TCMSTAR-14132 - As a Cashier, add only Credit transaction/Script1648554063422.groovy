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

WebUI.callTestCase(findTestCase('Scenario/SINC-11865 - As a Cashier, use the Advanced Search filter/TCMSTAR-14128 - As a Cashier, click Advanced Search button'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Scenario/SINC-11865 - As a Cashier, use the Advanced Search filter/mod/tickDebitCredit'), 
    [('nKeyword') : 'CreditOnly'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/button Terapkan Filter enabled'))

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/button Terapkan Filter enabled'))

WebUI.verifyElementClickable(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/button Show Result Enable'))

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/button Show Result Enable'))

WebUI.callTestCase(findTestCase('Scenario/SINC-12845 - As a Cashier, View n Maintain GL Line Account/mod/verify GL Line Page'), 
    [('ndocStatus') : 'all', ('ndocType') : 'postedItem', ('nmaxRowItem') : '1000', ('nselectDateRangeStartDate') : '0', ('nselectDateRangeEndDate') : '0'
        , ('nGLAccountNumber') : '0'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Scenario/SINC-12845 - As a Cashier, View n Maintain GL Line Account/mod/verify GL Line Data Result'), 
    [('nGLAccountNumber') : '0', ('ndebitCredit') : 'creditOnly'], FailureHandling.STOP_ON_FAILURE)

