import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/TCMSTAR-13381 - Cashier, Use Filter feature'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Kuitansi documentNumberFrom'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Kuitansi documentNumberFrom'), 
    'H383-2022000001')

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Kuitansi documentNumberTo'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Kuitansi documentNumberTo'), 
    'H383-2022000003')

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input Tgl.Kuitansi startDate'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input Tgl.Kuitansi startDate'), 
    '15-04-2022')

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input Tgl.Kuitansi startDate'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input Tgl.Kuitansi endDate'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input Tgl.Kuitansi endDate'), 
    '17-04-2022')

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input Tgl.Kuitansi endDate'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Posting postingNumberFrom'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Posting postingNumberFrom'), 
    'H383-I-22000001')

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Posting postingNumberTo'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Posting postingNumberTo'), 
    'H383-I-22000003')

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting startDate'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting startDate'), 
    '16-04-2022')

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting startDate'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting endDate'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting endDate'), 
    '18-04-2022')

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting endDate'), 
    Keys.chord(Keys.ENTER))

WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/tick Filter Status'), 
    [('nKeyword') : 'Posted'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/button Reset Filter'))

try {
    WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Posted ticked'), 
        GlobalVariable.waitPresentTimeout)
}
catch (Exception e) {
    KeywordUtil.markFailedAndStop('Reset Button Validation: Failed to reset - one or more field still have a value')
} 

def objKuitansiFrom = findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Kuitansi documentNumberFrom')

def objNoPostingto = findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Posting postingNumberTo')

String kuitansiStartFrom = WebUI.getAttribute(objKuitansiFrom, 'value', FailureHandling.STOP_ON_FAILURE)

String kuitansiEndDate = WebUI.getAttribute(objNoPostingto, 'value', FailureHandling.STOP_ON_FAILURE)

if (!(kuitansiStartFrom.equals('')) || !(kuitansiEndDate.equals(''))) {
    KeywordUtil.markFailedAndStop('Reset Button Validation: Failed to reset - one or more field still have a value')
}

KeywordUtil.markPassed('Reset Button Validation: Successfully reset the entire field')

