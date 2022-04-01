import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import com.github.kklisura.cdt.protocol.types.runtime.Evaluate as Evaluate
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'),
	GlobalVariable.waitPresentTimeout)

String documentStatus = "$ndocumentStatus" ?: 'all'


//count table rows, can be reuse
//count table rows, can be reuse
//count table rows, can be reuse
TestObject selectorContentGLTable = new TestObject()
selectorContentGLTable.addProperty('xpath', ConditionType.EQUALS, '//table//tbody/tr')

// find the row header of result table elements
List<WebElement> selectorContentGLTableList = WebUI.findWebElements(selectorContentGLTable, 30)

println(selectorContentGLTableList.size())

public static void documentStatus(String paramDocumentStatus, List<WebElement> paramSelectorContentGLTableList) {
	
}
