import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//columns validation
//columns validation
//columns validation
//total 12 columns
//expected result on Thead Document Over view
String[] dataDocumentDetailColumns = ['Itm', 'PK', 'Bus A', 'G/L', 'Account', 'Account Short Text', 'Cost Center'
	, 'Clearing Doc.', 'Amount', 'Amount in LC', 'Assigment', 'Text']

TestObject selectorTheadGLTable = new TestObject()

selectorTheadGLTable.addProperty('xpath', ConditionType.EQUALS, '//table//thead/tr/th')

// find the row header of result table elements
List<WebElement> selectorTheadGLTableList = WebUI.findWebElements(selectorTheadGLTable, 30)

println(selectorTheadGLTableList.size())

if (dataDocumentDetailColumns.length == selectorTheadGLTableList.size()) {
	KeywordUtil.markPassed('Count Table head Data Document : Expected Result and rendered table head are equal')
} else {
	KeywordUtil.markFailedAndStop('Count Table head Data Document : Expected Result and rendered table head are NOT equal')
}

//iterating each Thead GL Account List, to be matched with expected result
for (int i = 1; i <= selectorTheadGLTableList.size(); i++) {
	String new_xpath = "//table//thead/tr/th[$i]"
	
	TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)

	println(WebUI.getText(dynamicObject))

	if (!WebUI.getText(dynamicObject).equals(dataDocumentDetailColumns[(i - 1)])) {
		KeywordUtil.markFailedAndStop('Table head Data Document : Expected Result and rendered table head are NOT equal')
	}
}

KeywordUtil.markPassed('Table head Data Document : Expected Result and rendered table head are equal')