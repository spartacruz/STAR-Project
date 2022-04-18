import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.codehaus.groovy.tools.shell.completion.KeywordSyntaxCompletor
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType


import internal.GlobalVariable as GlobalVariable

WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'),
	GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)


WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/div No Data Shown'),
	GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)


String searchQuery = "$nsearchQuery" ?: ''
String searchFor = "$nsearchFor" ?: ''
Integer countPage = 1

List<WebElement> selectorContentGLTableList = tableListGenerator('//table//tbody/tr')
println(selectorContentGLTableList.size())


TestObject temp_xpath_previousPage = findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Previous Page Enabled')
String xpath_previousPage = temp_xpath_previousPage.findPropertyValue('xpath')
println(xpath_previousPage)

TestObject temp_xpath_nextPage = findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Next Page Enabled')
String xpath_nextPage = temp_xpath_nextPage.findPropertyValue('xpath')
println(xpath_nextPage)

List<WebElement> buttonNextPageEnabled = tableListGenerator(xpath_nextPage)
List<WebElement> buttonPreviousPageEnabled = tableListGenerator(xpath_previousPage)

if (buttonPreviousPageEnabled.size() > 0) {
	
	//while previous page can be clicked
	while (buttonPreviousPageEnabled.size() > 0) {
		WebUI.callTestCase(findTestCase('Scenario/SINC-12848 - As a Cashier, see Data Document Details (Doc. Overview)/mod/click with javascript'),
			[('ntestObject') : 'Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Previous Page Enabled'], FailureHandling.STOP_ON_FAILURE)
		
		buttonPreviousPageEnabled = tableListGenerator(xpath_previousPage)
	}
}

if (selectorContentGLTableList.size() > 0) {
	if (searchQuery.equals('')) {
		KeywordUtil.markFailedAndStop("Search Box Validation: No string inputed on search box")
	} else {
		
		searchQueryValidation(searchQuery, searchFor, selectorContentGLTableList)
		
		//only checking until page 10 for now
		while (buttonNextPageEnabled.size() > 0 && countPage < 10) {
			WebUI.callTestCase(findTestCase('Scenario/SINC-12848 - As a Cashier, see Data Document Details (Doc. Overview)/mod/click with javascript'),
				[('ntestObject') : 'Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/button Next Page Enabled'], FailureHandling.STOP_ON_FAILURE)
			
			WebUI.waitForElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'),
				GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
			WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'),
				GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
			
			WebUI.waitForElementNotPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/div No Data Shown'),
				GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
			WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/div No Data Shown'),
				GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
			
			selectorContentGLTableList = tableListGenerator('//table//tbody/tr')
			
			searchQueryValidation(searchQuery, searchFor, selectorContentGLTableList)
			
			countPage = countPage + 1
			KeywordUtil.logInfo("Iterating page: $countPage")
			
			buttonNextPageEnabled = tableListGenerator(xpath_nextPage)
		}
	}
}

public static boolean searchQueryValidation(String paramSearchQuery, String paramSearchFor, List<WebElement> paramSelectorContentGLTableList) {

	String for_column = ''
	String wording_for = ''
	switch (paramSearchFor) {
		case 'No.Pelanggan':
			for_column = '2'
			wording_for = 'No. Pelanggan'
			break
		
		case 'NamaPelanggan':
			for_column = '3'
			wording_for = 'Nama Pelanggan'
			break
			
		case 'No.Kuitansi':
			for_column = '4'
			wording_for = 'No. Kuitansi'
			break
			
		case 'No.Posting':
			wording_for = 'No. Posting'
			for_column = '6'
			break
		
		case 'expectedNoData':
			//2 means row table head + blank row on FE aka no row data result
			if (paramSelectorContentGLTableList.size().equals(1)) {
				KeywordUtil.markPassed("Search Box Validation (unexist data): Expected Result and rendered table result are equal")
				return true
			} else {
				KeywordUtil.markFailedAndStop("Search Box Validation (unexist data): Expected Result and rendered table result NOT equal")
				return false
			}
	}
	
	for (int i = 1; i <= (paramSelectorContentGLTableList.size()); i++) {
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

def tableListGenerator(String xpathLocation) {
	//count table rows, can be reuse
	TestObject selectorContentGLTable = new TestObject()
	selectorContentGLTable.addProperty('xpath', ConditionType.EQUALS, xpathLocation)
	
	// find the row header of result table elements
	List<WebElement> selectorContentGLTableList = WebUI.findWebElements(selectorContentGLTable, 10)
	
	println(selectorContentGLTableList.size())
	return selectorContentGLTableList
}

//if (!searchQuery.equals('')) {
//	searchQueryValidation(searchQuery, searchFor, selectorContentGLTableList)
//} else {
//	KeywordUtil.markFailedAndStop("Search Box Validation: No string inputed on search box")
//}
