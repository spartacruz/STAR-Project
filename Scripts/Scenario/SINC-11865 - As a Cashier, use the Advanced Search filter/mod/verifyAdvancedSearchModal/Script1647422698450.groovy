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

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/title Advanced Search'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/button close Advanced Search'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label Posting Number'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingNumberFrom'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingNumberTo disabled'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label Posting Date'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingDateStartDate'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingDateEndDate'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label Document Reference'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input documentReferenceFrom'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input documentReferenceTo disabled'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label Document Date'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input documentDateStartDate'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input documentDateEndDate'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label Cost Center'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input costCenterTo'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input costCenterFrom'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label Profit Center'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input profitCenterFrom'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input profitCenterTo'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label DebitCredit'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Debit unticked'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Credit unticked'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div DebitCredit_warning'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/button Reset Filter'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/button Terapkan Filter disabled'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementClickable(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/button Reset Filter'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/title Advanced Search'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/button close Advanced Search'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label Posting Number'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingNumberFrom'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingNumberTo disabled'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label Posting Date'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingDateStartDate'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input postingDateEndDate'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label Document Reference'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input documentReferenceFrom'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input documentReferenceTo disabled'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label Document Date'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input documentDateStartDate'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input documentDateEndDate'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label Cost Center'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input costCenterTo'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input costCenterFrom'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label Profit Center'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input profitCenterFrom'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/input profitCenterTo'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/label DebitCredit'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Debit unticked'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div Credit unticked'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/div DebitCredit_warning'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/button Reset Filter'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Advanced Search modal/button Terapkan Filter disabled'), 
    FailureHandling.STOP_ON_FAILURE)

