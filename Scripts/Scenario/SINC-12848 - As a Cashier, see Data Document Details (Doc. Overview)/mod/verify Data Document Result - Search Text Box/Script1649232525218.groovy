import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'),
	GlobalVariable.waitPresentTimeout)

String searchQuery = "$nsearchQuery" ?: ''
String searchFor = "$nsearchFor" ?: ''

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
		case 'BusA':
			for_column = '3'
			wording_for = 'BusA'
			break
		
		case 'GL':
			for_column = '4'
			wording_for = 'GL'
			break
			
		case 'Account':
			for_column = '5'
			wording_for = 'Account'
			break
		
		case 'AccountShortText':
			wording_for = 'Account Short Text'
			for_column = '6'
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

if (!searchQuery.equals('')) {
	searchQueryValidation(searchQuery, searchFor, selectorContentGLTableList)
} else {
	KeywordUtil.markFailedAndStop("Search Box Validation: No string inputed on search box")
}
