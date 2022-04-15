import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import org.openqa.selenium.Keys
import org.codehaus.groovy.tools.shell.completion.KeywordSyntaxCompletor
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.waitForElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'), GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'), 
    GlobalVariable.waitPresentTimeout)

WebUI.waitForElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/div no data'), GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/div no data'),
	GlobalVariable.waitPresentTimeout)

String searchQuery = "$nsearchQuery" ?: ''
String searchFor = "$nsearchFor" ?: ''

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

if (selectorContentGLTableList.size() > 2) {
	if (searchQuery.equals('')) {
		//no validation
		assert true
	} else {
		
		searchQueryValidation(searchQuery, searchFor, selectorContentGLTableList)
		
		//only checking until page 10 for now
		while (buttonNextPageEnabled.size() > 0 && countPage < 10) {
			WebUI.callTestCase(findTestCase('Scenario/SINC-12848 - As a Cashier, see Data Document Details (Doc. Overview)/mod/click with javascript'),
				[('ntestObject') : 'Object Repository/Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/btn next page enabled'], FailureHandling.STOP_ON_FAILURE)
			
			WebUI.waitForElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'), GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
			WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'),
				GlobalVariable.waitPresentTimeout)
			
			WebUI.waitForElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/div no data'), GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
			WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/div no data'),
				GlobalVariable.waitPresentTimeout)
			
			selectorContentGLTableList = tableListGenerator('//table//tbody/tr')
			searchQueryValidation(searchQuery, searchFor, selectorContentGLTableList)
			
			countPage = countPage + 1
			KeywordUtil.logInfo("Iterating page: $countPage")
			
			buttonNextPageEnabled = tableListGenerator('//li[@class=\'ant-pagination-next\']/button[@class=\'ant-pagination-item-link\']')
		}
	}
}

def tableListGenerator(String xpathLocation) {
	//count table rows, can be reuse
	TestObject selectorContentGLTable = new TestObject()
	selectorContentGLTable.addProperty('xpath', ConditionType.EQUALS, xpathLocation)
	
	// find the row header of result table elements
	List<WebElement> selectorContentGLTableList = WebUI.findWebElements(selectorContentGLTable, 10)
	
	println(selectorContentGLTableList.size())
	return selectorContentGLTableList
}

public static boolean searchQueryValidation(String paramSearchQuery, String paramSearchFor, List<WebElement> paramSelectorContentGLTableList) {

	String for_column = ''
	String wording_for = ''
	switch (paramSearchFor) {
		case 'GLAccount':
			for_column = '2'
			wording_for = 'GL Account'
			break
		
		case 'GLDescription':
			for_column = '3'
			wording_for = 'GL Description'
			break
			
		case 'postingNumber':
			for_column = '5'
			wording_for = 'Posting Number'
			break
		
		case 'docReference':
			wording_for = 'Doc Reference'
			for_column = '7'
			break
		
		case 'expectedNoData':
			//2 means row table head + blank row on FE aka no row data result
			if (paramSelectorContentGLTableList.size().equals(2)) {
				KeywordUtil.markPassed("Search Box Validation (unexist data): Expected Result and rendered table result are equal")
				return true
			} else {
				KeywordUtil.markFailedAndStop("Search Box Validation (unexist data): Expected Result and rendered table result NOT equal")
				return false
			}
	}
	
	for (int i = 2; i <= (paramSelectorContentGLTableList.size()); i++) {
		String new_xpath = "//table//tbody/tr[$i]/td[$for_column]"

		TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)
		println(WebUI.getText(dynamicObject))

		if (WebUI.getText(dynamicObject).contains(paramSearchQuery)) {
			KeywordUtil.markPassed("$wording_for Search Box Validation : Expected Result and rendered table result are equal")
		} else {
			KeywordUtil.markFailedAndStop("$wording_for Search Box Validation: Expected Result and rendered table result are NOT equal")
		}
	}
	
	return true
}

