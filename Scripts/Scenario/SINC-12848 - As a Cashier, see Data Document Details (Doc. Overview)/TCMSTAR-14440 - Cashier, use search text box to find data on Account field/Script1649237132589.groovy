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

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingNumberFrom'))

WebUI.setText(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingNumberFrom'), 
    'H765-GR-21000466')

WebUI.delay(GlobalVariable.delayStep)

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingNumberTo enabled'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingNumberTo enabled'), 
    Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingNumberTo enabled'), 
    'H')

WebUI.setText(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingNumberTo enabled'), 
    '765-GR-21000466')

WebUI.callTestCase(findTestCase('Scenario/SINC-11865 - As a Cashier, use the Advanced Search filter/mod/tickDebitCredit'), 
    [('nKeyword') : 'DebitCredit'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/button Terapkan Filter enabled'))

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/button Terapkan Filter enabled'))

WebUI.delay(GlobalVariable.delayStep)

WebUI.verifyElementClickable(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/button Show Result Enable'))

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/button Show Result Enable'))

WebUI.callTestCase(findTestCase('Scenario/SINC-12845 - As a Cashier, View n Maintain GL Line Account/mod/verify GL Line Page'), 
    [('ndocStatus') : 'all', ('ndocType') : 'postedItem', ('nmaxRowItem') : '1000', ('nselectDateRangeStartDate') : '0', ('nselectDateRangeEndDate') : '0'
        , ('nGLAccountNumber') : '0'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Scenario/SINC-12845 - As a Cashier, View n Maintain GL Line Account/mod/verify GL Line Data Result'), 
    [('nGLAccountNumber') : '0', ('ndebitCredit') : 'DebitCredit', ('npostingNumberFrom') : 'H765-GR-21000466', ('npostingNumberTo') : 'H765-GR-21000466'
        , ('ndocReferenceFrom') : '0', ('ndocReferenceTo') : '0', ('npostingDateFrom') : '0', ('npostingDateTo') : '0', ('ndocDateFrom') : '0'
        , ('ndocDateTo') : '0', ('ncostCenter') : '0', ('nprofitCenter') : '0'], FailureHandling.STOP_ON_FAILURE)

String docNumber = WebUI.callTestCase(findTestCase('Scenario/SINC-12848 - As a Cashier, see Data Document Details (Doc. Overview)/mod/get Attrib Row from GL Item Show Result'), 
    [('nrow') : 1, ('nwhichColumn') : 'docNumber'], FailureHandling.STOP_ON_FAILURE)

String docDate = WebUI.callTestCase(findTestCase('Scenario/SINC-12848 - As a Cashier, see Data Document Details (Doc. Overview)/mod/get Attrib Row from GL Item Show Result'), 
    [('nrow') : 1, ('nwhichColumn') : 'docDate'], FailureHandling.STOP_ON_FAILURE)

String postingNumber = WebUI.callTestCase(findTestCase('Scenario/SINC-12848 - As a Cashier, see Data Document Details (Doc. Overview)/mod/get Attrib Row from GL Item Show Result'), 
    [('nrow') : 1, ('nwhichColumn') : 'postingNumber'], FailureHandling.STOP_ON_FAILURE)

String postingDate = WebUI.callTestCase(findTestCase('Scenario/SINC-12848 - As a Cashier, see Data Document Details (Doc. Overview)/mod/get Attrib Row from GL Item Show Result'), 
    [('nrow') : 1, ('nwhichColumn') : 'postingDate'], FailureHandling.STOP_ON_FAILURE)

String SAPDocNumber = '-'

WebUI.callTestCase(findTestCase('Scenario/SINC-12845 - As a Cashier, View n Maintain GL Line Account/mod/click Document Details'), 
    [('nrowNo') : '1'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Scenario/SINC-12848 - As a Cashier, see Data Document Details (Doc. Overview)/mod/verify Detail Document'), 
    [('ndocNumber') : docNumber, ('ndocDate') : docDate, ('npostingNumber') : postingNumber, ('npostingDate') : postingDate
        , ('nSAPDocNumber') : SAPDocNumber], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/input search box'))

WebUI.setText(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/input search box'), 
    '1310400000')

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/input search box'), 
    Keys.chord(Keys.ENTER))

String inputSearchBoxObj = 'Object Repository/Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/input search box'

String searchquery = WebUI.getAttribute(findTestObject(inputSearchBoxObj), 'value', FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Scenario/SINC-12848 - As a Cashier, see Data Document Details (Doc. Overview)/mod/verify Table Head Data Document Result'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Scenario/SINC-12848 - As a Cashier, see Data Document Details (Doc. Overview)/mod/verify Data Document Result - Search Text Box'), 
    [('nsearchQuery') : searchquery, ('nsearchFor') : 'Account'], FailureHandling.STOP_ON_FAILURE)

