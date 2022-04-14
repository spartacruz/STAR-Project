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

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Advanced Search modal/input documentReferenceFrom'))

WebUI.setText(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Advanced Search modal/input documentReferenceFrom'), 
    'H390-2022000001')

WebUI.delay(GlobalVariable.delayStep)

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Advanced Search modal/input documentReferenceTo enabled'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Advanced Search modal/input documentReferenceTo enabled'), 
    Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Advanced Search modal/input documentReferenceTo enabled'), 
    'R')

WebUI.setText(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Advanced Search modal/input documentReferenceTo enabled'), 
    'andom')

WebUI.callTestCase(findTestCase('Scenario/SINC-11865 - As a Cashier, use the Advanced Search filter/mod/tickDebitCredit'), 
    [('nKeyword') : 'DebitCredit'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Advanced Search modal/div documentReferenceTo_warning'))

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Advanced Search modal/button Terapkan Filter disabled'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementNotClickable(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Advanced Search modal/button Terapkan Filter enabled'))

