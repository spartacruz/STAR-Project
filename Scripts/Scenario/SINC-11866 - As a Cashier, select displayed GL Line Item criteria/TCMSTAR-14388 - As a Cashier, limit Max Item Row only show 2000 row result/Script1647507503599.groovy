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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as Helper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Scenario/SINC-11862 - As a Cashier Input n Search GL Account/TCMSTAR-14121 - Input 4 Digit (exist) and Select The Sugesstion'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/input Max Row Item'))

WebUI.setText(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/input Max Row Item'), '2000')

WebUI.sendKeys(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/input Max Row Item'), Keys.chord(
        Keys.ENTER))

String el = 'return document.querySelector("input[name=\'maxRowItem\']").value;'
String result = WebUI.executeJavaScript(el, null, FailureHandling.OPTIONAL)

System.out.println(result)

if (!result.equals('200')) {
    KeywordUtil.logInfo('Field input \'Max Row Item\' bisa diisi lebih dari 1000')
    KeywordUtil.markFailedAndStop('Field input \'Max Row Item\' bisa diisi lebih dari 1000')
} else {
    KeywordUtil.markPassed('Field tidak bisa diisi lebih dari 1000')
}

