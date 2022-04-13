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

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text Header Monitoring GL Line Item'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text Header Monitoring GL Line Item'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text GL Account Selection Section'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text GL Account Selection Section'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text GL Account'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text GL Account'), GlobalVariable.waitPresentTimeout, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/input GL Account'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/input GL Account'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text cari n pilih lebih dari satu GL Account'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text cari n pilih lebih dari satu GL Account'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/button Advanced Search'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/button Advanced Search'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text LA Selection - Document Status'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text LA Selection - Document Status'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

'Validasi awal - By default hanya Radio Button \'All\' yang tertick'
WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/radioButton Open Item Un-ticked'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

'Validasi awal - By default hanya Radio Button \'All\' yang tertick'
WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/radioButton Open Item Un-ticked'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

'Validasi awal - By default hanya Radio Button \'All\' yang tertick'
WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/radioButton Clear Item Un-ticked'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

'Validasi awal - By default hanya Radio Button \'All\' yang tertick'
WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/radioButton Clear Item Un-ticked'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

'Validasi awal - By default hanya Radio Button \'All\' yang tertick'
WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/radioButton All item ticked'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

'Validasi awal - By default hanya Radio Button \'All\' yang tertick'
WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/radioButton All item ticked'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text LA Selection - Select Date Range'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text LA Selection - Select Date Range'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text LA Selection - Document Type'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text LA Selection - Document Type'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text LA Selection - Max Row Item'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/text LA Selection - Max Row Item'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/input Max Row Item'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/input Max Row Item'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/button Show Result Disable'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/button Show Result Disable'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/button Advanced Search'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

