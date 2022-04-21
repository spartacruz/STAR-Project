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

WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/TCMSTAR-13381 - Cashier, Use Filter feature'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting startDate'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting startDate'), 
    '17-04-2022')

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting startDate'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting endDate'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting endDate'), 
    '20-04-2022')

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting endDate'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/button Terapkan Filter'))

def objPostingStartDate = findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting startDate')

def objPostingEndDate = findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting endDate')

String postingStartDate = WebUI.getAttribute(objPostingStartDate, 'value', FailureHandling.STOP_ON_FAILURE)

String postingEndDate = WebUI.getAttribute(objPostingEndDate, 'value', FailureHandling.STOP_ON_FAILURE)

println(postingStartDate)

println(postingEndDate)

WebUI.waitForElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Verify Filter Result - Date'), 
    [('ndocDateFrom') : 0, ('ndocDateTo') : 0, ('npostingDateFrom') : postingStartDate, ('npostingDateTo') : postingEndDate
        , ('nchoice') : 'Tgl.Posting'], FailureHandling.STOP_ON_FAILURE)

