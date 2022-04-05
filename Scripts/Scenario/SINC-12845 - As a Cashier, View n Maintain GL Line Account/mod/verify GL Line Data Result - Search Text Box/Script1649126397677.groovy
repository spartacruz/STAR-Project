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
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'),
	GlobalVariable.waitPresentTimeout)

String searchQuery = "$nsearchQuery" ?: ''

//count table rows, can be reuse
//count table rows, can be reuse
//count table rows, can be reuse
TestObject selectorContentGLTable = new TestObject()
selectorContentGLTable.addProperty('xpath', ConditionType.EQUALS, '//table//tbody/tr')

// find the row header of result table elements
List<WebElement> selectorContentGLTableList = WebUI.findWebElements(selectorContentGLTable, 30)

println(selectorContentGLTableList.size())

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
/*
	Integer row_counter = 0
	Boolean checkPreviousPage = false
	Boolean checkNextPage = false
	
	try {
		checkPreviousPage = WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/btn previous page enabled'))
	} catch (Exception e) {
		checkPreviousPage = false
	}
	
	//if not the first page, system will click previous until the first one
	while (checkPreviousPage.equals(true)) {

//		String el = 'return document.querySelector("//li[contains(@class, \'ant-pagination-next\')]/button[@class=\'ant-pagination-item-link\']")[0].click();'
//		WebUI.executeJavaScript(el, null, FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/btn previous page enabled'))
		
		try {
			checkPreviousPage = WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/btn previous page enabled'))
		} catch (Exception e) {
			checkPreviousPage = false
		}
	}
	
	row_counter = row_counter + paramSelectorContentGLTableList.size()
	
	
	try {
		checkNextPage = WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/btn next page enabled'))
	} catch (Exception e) {
		checkNextPage = false
	}
	
	//if button next enable
	while (checkNextPage.equals(true)) {		
		WebUI.click(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/btn next page enabled'))
		
		try {
			checkNextPage = WebUI.verifyElementVisible(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/btn next page enabled'))
		} catch (Exception e) {
			checkNextPage = false
		}
		row_counter = row_counter + paramSelectorContentGLTableList.size()
		
		println(row_counter)
	}
	
	if (row_counter - 1 > Integer.parseInt(paramMaxRowItem)) {
		KeywordUtil.markFailedAndStop('Max Row Item Count Validation : Expected Result and rendered table head are NOT equal')
	} else {
		KeywordUtil.markPassed('Max Row Item Validation : Expected Result and rendered table head are equal')
	}
	*/
}

if (!searchQuery.equals('')) {
	searchQueryValidation(searchQuery, ,selectorContentGLTableList)
}
