import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.kklisura.cdt.protocol.types.runtime.Evaluate
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject

//static void iterator(String selectedObjXpathSelector, String[] dataGLLineItemColumns, String iterateObjXpathSelector) {
////	System.out.println("I just got executed!");
//	
//	TestObject selectorTheadGLTable = new TestObject()
//	selectorTheadGLTable.addProperty("xpath", ConditionType.EQUALS, selectedObjXpathSelector)
//	
//	// find the row header of result table elements
//	List<WebElement> selectorTheadGLTableList = WebUI.findWebElements(selectorTheadGLTable, 30)
//	println(selectorTheadGLTableList.size())
//	
//	if (dataGLLineItemColumns.length == selectorTheadGLTableList.size()) {
//		KeywordUtil.markPassed("Count Table head GL Account : Expected Result and rendered table head are equal")
//	} else {
//		KeywordUtil.markFailedAndStop("Count Table head GL Account : Expected Result and rendered table head are NOT equal")
//	}
//	
//	iterateObjXpathSelector = iterateObjXpathSelector.replace("\\", "")
//	
//	//iterating each Thead GL Account List, to be matched with expected result
//	for (int i = 1; i <= selectorTheadGLTableList.size(); i++) {
//		String new_xpath = Eval.me(iterateObjXpathSelector)
//		TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)
//	
//		println(WebUI.getText(dynamicObject))
//		
//		if (WebUI.getText(dynamicObject).equals(dataGLLineItemColumns[i-1])) {
//			KeywordUtil.markPassed("Table head GL Account Name : Expected Result and rendered table head are equal")
//		} else {
//			KeywordUtil.markFailedAndStop("Table head GL Account Name : Expected Result and rendered table head are NOT equal")
//		}
//	}
//}

String GLAccountNumber = "$nGLAccountNumber"

//columns validation
//columns validation
//columns validation
//total 26 columns + 1 blank column on Frontend
//expected result on Thead GL Line Data
String[] dataGLLineItemColumns = ['No', 'GL Account', 'GL Description', 'PK', 'Posting Number', 'Posting Date', 'Doc. Reference', 'Doc. Date',
	'Amount', 'BA Code', 'Cost Center', 'Profit Center',  'Clearing No.', 'Clearing Date', 'Status', 'Baseline Date', 'Assignment',
	'Text', 'Tax Code', 'Division', 'Notice/Unotice', 'Header Text', 'Fiscal Year', 'Period', 'Doc. Currency', 'Doc. Type', '']

//String selectedObjXpathSelector = "//table//thead/tr/th"
//String iterateObjXpathSelector = "//table//thead/tr/th[\${i}]"
////String iterateObjXpathSelector = "//table//thead/tr/th[${i}]"
//iterator(selectedObjXpathSelector, dataGLLineItemColumns, iterateObjXpathSelector)

TestObject selectorTheadGLTable = new TestObject()
selectorTheadGLTable.addProperty("xpath", ConditionType.EQUALS, "//table//thead/tr/th")

// find the row header of result table elements
List<WebElement> selectorTheadGLTableList = WebUI.findWebElements(selectorTheadGLTable, 30)
println(selectorTheadGLTableList.size())

if (dataGLLineItemColumns.length == selectorTheadGLTableList.size()) {
	KeywordUtil.markPassed("Count Table head GL Account : Expected Result and rendered table head are equal")
} else {
	KeywordUtil.markFailedAndStop("Count Table head GL Account : Expected Result and rendered table head are NOT equal")
}

//iterating each Thead GL Account List, to be matched with expected result
for (int i = 1; i <= selectorTheadGLTableList.size(); i++) {
	String new_xpath = "//table//thead/tr/th[${i}]"
	TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)

	println(WebUI.getText(dynamicObject))
	
	if (WebUI.getText(dynamicObject).equals(dataGLLineItemColumns[i-1])) {
		KeywordUtil.markPassed("Table head GL Account Name : Expected Result and rendered table head are equal")
	} else {
		KeywordUtil.markFailedAndStop("Table head GL Account Name : Expected Result and rendered table head are NOT equal")
	}
}



//GL Account validation
//GL Account validation
//GL Account validation

TestObject selectorContentGLTable = new TestObject()
selectorContentGLTable.addProperty("xpath", ConditionType.EQUALS, "//table//tbody/tr")

// find the row header of result table elements
List<WebElement> selectorContentGLTableList = WebUI.findWebElements(selectorContentGLTable, 30)
println(selectorContentGLTableList.size())

if (nGLAccountNumber == "0") {
	//pass, no validation
	assert true;
} else {
	
	//collect GL Account from params, and convert it into Array
	String[] GLAccountNumberArray = new String[50]
	GLAccountNumberArray = GLAccountNumber.split(",")
	
	//iterating each GL Account Row, to be matched with expected result
	//i start from 2, because the first tr is nbsp
	for (int i = 2; i <= selectorContentGLTableList.size() - 1; i++) {
		String new_xpath = "//table//tbody/tr[${i}]/td[2]"
		TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)
	
		println(WebUI.getText(dynamicObject))		
		
		if (GLAccountNumberArray.contains(WebUI.getText(dynamicObject))) {
			KeywordUtil.markPassed("GL Account Validation : Expected Result and rendered table head are equal")
		} else {
			KeywordUtil.markFailedAndStop("GL Account Validation : Expected Result and rendered table head are NOT equal")
		}
	}
	
}



//Boolean isDebit = "$nisDebit"
//Boolean isCredit = "$nisCredit"

//kolom debit credit
//$("div.ant-table-content tbody tr:nth-child(2) > td:nth-child(15)").textContent

//kolom amount
//$("div.ant-table-content tbody tr:nth-child(2) > td:nth-child(9)").textContent

//static void debitCredit() {
//	System.out.println("I just got executed!");
//}
//
////lanjutin debit & creditnya. count baris dan next page nya
//
//for (int i = 2; i < 11; i++) {
////	String el = 'return document.querySelector("input[name=\'maxRowItem\']").value;'	
//	String el = String.format('return document.querySelector(\"div.ant-table-content tbody tr:nth-child(%d) > td:nth-child(15)\").textContent;', i)
//	println(el)
//	
//	String result = WebUI.executeJavaScript(el, null, FailureHandling.OPTIONAL)
//	println(result)
//}

