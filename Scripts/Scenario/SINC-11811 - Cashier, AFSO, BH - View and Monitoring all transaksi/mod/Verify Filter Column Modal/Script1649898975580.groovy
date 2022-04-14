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

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/title Filter Search'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/button close modal'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/label No.Kuitansi'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Kuitansi documentNumberFrom'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Kuitansi documentNumberTo'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/label Tgl.Kuitansi'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input Tgl.Kuitansi startDate'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input Tgl.Kuitansi endDate'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/label No.Posting'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Posting postingNumberFrom'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input No.Posting postingNumberTo'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/label Tgl.Posting'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting startDate'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/input TglPosting endDate'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/label Status'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Empty UNticked'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Open UNticked'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status Posted UNticked'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status CANCELLED UNticked'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/checkbox Status DELETED UNticked'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/button Reset Filter'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Filter Column Modal/button Terapkan Filter'), 
    GlobalVariable.waitPresentTimeout)

