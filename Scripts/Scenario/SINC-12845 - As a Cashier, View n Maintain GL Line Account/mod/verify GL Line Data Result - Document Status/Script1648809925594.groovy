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

WebUI.waitForElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'), GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'), 
    GlobalVariable.waitPresentTimeout)

WebUI.waitForElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/div no data'), GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/div no data'),
	GlobalVariable.waitPresentTimeout)

String documentStatus = "$ndocumentStatus" ?: 'all'


//count table rows, can be reuse

Integer countPage = 1
//row result counter
List<WebElement> selectorContentGLTableList = tableListGenerator('//table//tbody/tr')

String xpath_nextPage = '//li[@class=\'ant-pagination-next\']/button[@class=\'ant-pagination-item-link\']'
String xpath_previousPage ='//li[@class=\'ant-pagination-prev\']/button[@class=\'ant-pagination-item-link\']'

List<WebElement> buttonNextPageEnabled = tableListGenerator(xpath_nextPage)
List<WebElement> buttonPreviousPageEnabled = tableListGenerator(xpath_previousPage)

if (buttonPreviousPageEnabled.size() > 0) {
	
	//while previous page can be clicked
	while (buttonPreviousPageEnabled.size() > 0) {
		WebUI.callTestCase(findTestCase('Scenario/SINC-12848 - As a Cashier, see Data Document Details (Doc. Overview)/mod/click with javascript'),
			[('ntestObject') : 'Object Repository/Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/btn previous page enabled'], FailureHandling.STOP_ON_FAILURE)
		
		buttonPreviousPageEnabled = tableListGenerator(xpath_previousPage)
	}
}

//if there is a data
if (selectorContentGLTableList.size() > 2) {
	if (documentStatus.equals('all')) {
		//no validation on document status
		assert true
	} else {
		//only checking until page 10 for now
		while (buttonNextPageEnabled.size() > 0 && countPage < 10) {	
			WebUI.callTestCase(findTestCase('Scenario/SINC-12848 - As a Cashier, see Data Document Details (Doc. Overview)/mod/click with javascript'),
				[('ntestObject') : 'Object Repository/Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/btn next page enabled'], FailureHandling.STOP_ON_FAILURE)
			
			documentStatusValidation(documentStatus, selectorContentGLTableList)
			
			countPage = countPage + 1
			KeywordUtil.logInfo("Iterating page: $countPage")
			
			buttonNextPageEnabled = tableListGenerator('//li[@class=\'ant-pagination-next\']/button[@class=\'ant-pagination-item-link\']')
		}
	}	
}



/*
 *
 whole function start from here
 *
 * */

def tableListGenerator(String xpathLocation) {
	//count table rows, can be reuse
	TestObject selectorContentGLTable = new TestObject()
	selectorContentGLTable.addProperty('xpath', ConditionType.EQUALS, xpathLocation)
	
	// find the row header of result table elements
	List<WebElement> selectorContentGLTableList = WebUI.findWebElements(selectorContentGLTable, 10)
	
	println(selectorContentGLTableList.size())
	return selectorContentGLTableList
}

public static void documentStatusValidation(String paramDocumentStatus, List<WebElement> paramSelectorContentGLTableList) {
	
	String wording_for = 'Document Status'
	String for_column = '15'
	String compareStatus = ''
	
	switch (paramDocumentStatus) {
		case 'openItem':
			compareStatus = 'Open'
			break
			
		case 'clearItem':
			compareStatus = 'Clear'
			break
	}
	
	//i start from 2, because the first tr is nbsp
	for (int i = 2; i <= (paramSelectorContentGLTableList.size()); i++) {
		String new_xpath = "//table//tbody/tr[$i]/td[$for_column]"
		TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)

		println(WebUI.getText(dynamicObject))

		if (compareStatus.equals(WebUI.getText(dynamicObject))) {
			KeywordUtil.markPassed("$wording_for Validation : Expected Result and rendered table result are equal")
		} else {
			KeywordUtil.markFailedAndStop("$wording_for Validation : Expected Result and rendered table result are NOT equal")
		}
	}
}



