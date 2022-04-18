import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//columns validation
//columns validation
//columns validation
//total 11 columns + 1 blank from FE
//expected result on Thead Monitoring Incoming
String[] dataDocumentDetailColumns = ['No', 'No. Pelanggan', 'Nama Pelanggan', 'No.Kuitansi', 'Tgl.Kuitansi', 'No.Posting', 'Tgl.Posting'
	, 'Status', 'Kode Kas/Bank', 'No.Posting BKU', 'Nilai', '']

TestObject selectorTheadGLTable = new TestObject()

selectorTheadGLTable.addProperty('xpath', ConditionType.EQUALS, '//table//thead/tr/th')

// find the row header of result table elements
List<WebElement> selectorTheadGLTableList = WebUI.findWebElements(selectorTheadGLTable, 30)

println(selectorTheadGLTableList.size())

if (dataDocumentDetailColumns.length == selectorTheadGLTableList.size()) {
	KeywordUtil.markPassed('Count Table head : Expected Result and rendered table head are equal')
} else {
	KeywordUtil.markFailedAndStop('Count Table head : Expected Result and rendered table head are NOT equal')
}

//iterating each Thead List, to be matched with expected result
for (int i = 1; i <= selectorTheadGLTableList.size(); i++) {
	String new_xpath = "//table//thead/tr/th[$i]"
	
	TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)

	println(WebUI.getText(dynamicObject))

	if (!WebUI.getText(dynamicObject).equals(dataDocumentDetailColumns[(i - 1)])) {
		KeywordUtil.markFailedAndStop('Table head : Expected Result and rendered table head are NOT equal')
	}
}

KeywordUtil.markPassed('Table head : Expected Result and rendered table head are equal')