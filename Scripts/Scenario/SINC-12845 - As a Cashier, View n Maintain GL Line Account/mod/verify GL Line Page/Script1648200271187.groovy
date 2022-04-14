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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject

/* This validation needs 6 param as a
 * Param Type : Map
 * Value Type : Map
 * 
 * (String) $ndocStatus : 
 * 		Value have to be one of this : 'all', 'openItem', 'clearItem'
 * 
 * (String) $ndocType : 
 * 		Value have to be one of this : 'postedItem' (parkeditem is not developed yet)
 * 
 * (String) $nmaxRowItem : 
 * 		count of Max Row. 0 < x <= 1000
 * 
 * (String) $nselectDateRangeStartDate : 
 * 		Value have to be one of this : (1)dd-mm-yyyy OR (2)0 for no validation
 * 
 * (String) $nselectDateRangeEndDate : 
 * 		Value have to be one of this : (1)dd-mm-yyyy OR (2)0 for no validation
 * 
 * (String) $nGLAccountNumber" : 
 * 		list of inputted GL Account. If more than 1 GL, separate it with comma. No space.
 * 		WARNING: order matters! if the first GL insert are x and followed by y, then the param have to follow it as well (x comma y)
 * 		eg. 1002100100,2120102000
 * 
 * */

String docStatus = "$ndocStatus"
String docType = "$ndocType"
String maxRowItem = "$nmaxRowItem"
String selectDateRangeStartDate = "$nselectDateRangeStartDate"
String selectDateRangeEndDate = "$nselectDateRangeEndDate"
String GLAccountNumber = "$nGLAccountNumber"

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/btn BackButton'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/strong Data GL Line Item title'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/strong GL Account Selection sub title'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/strong GL Account text'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/strong Line Account Selection Title'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/strong Document Status text'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/strong Select Date Range text'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/strong Document Type text'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/strong Max Row Item text'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/input search box'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/div table content'), 
    GlobalVariable.waitPresentTimeout)

//Document Status Validation
switch (docStatus) {
    case 'all':
        WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/radioButton All item ticked'), 
            GlobalVariable.waitPresentTimeout)
        break
		
    case 'openItem':
        WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/radioButton Open Item ticked'), 
            GlobalVariable.waitPresentTimeout)
        break
		
    case 'clearItem':
        WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/radioButton Clear Item ticked'), 
            GlobalVariable.waitPresentTimeout)
        break
}

//Document Type Validation
switch (docType) {
    case 'postedItem':
        WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/radioButton Posted item ticked'), 
            GlobalVariable.waitPresentTimeout)
        break
}

//Max Row Item Validation
String maxRowItemValue = WebUI.getAttribute(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/input Max Row Item Disabled'), 'value')
println(maxRowItemValue)

if (maxRowItemValue == maxRowItem) {
	KeywordUtil.markPassed("Max Row Item awal dan show result sama")
} else {
	KeywordUtil.markFailedAndStop("Max Row Item awal dan show result TIDAK sama")
}

//Select Date Range Validation
String selectDateRangeStartDateValue = WebUI.getAttribute(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/input Select Date Range Start Date disabled'), 'value')
println(selectDateRangeStartDateValue)

String selectDateRangeEndDateValue = WebUI.getAttribute(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/input Select Date Range End Date disabled'), 'value')
println(selectDateRangeEndDateValue)

if (selectDateRangeStartDate == "0") {
	//pass, no validation
	assert true;
} else {
	
	if (selectDateRangeStartDate == selectDateRangeStartDateValue) {
		KeywordUtil.markPassed("select Date Range StartDate : awal dan show result sama")
	} else {
		KeywordUtil.markFailedAndStop("select Date Range StartDate : awal dan show result TIDAK sama")
	}
}

if (selectDateRangeEndDate == "0") {
	//pass, no validation
	assert true;
} else {
	
	if (selectDateRangeEndDate == selectDateRangeEndDateValue) {
		KeywordUtil.markPassed("select Date Range EndDate : awal dan show result sama")
	} else {
		KeywordUtil.markFailedAndStop("select Date Range EndDate : awal dan show result TIDAK sama")
	}
}

//GL Account Validation
String[] GLAccountNumberArray = new String[50]
GLAccountNumberArray = GLAccountNumber.split(",")
println(GLAccountNumberArray.length)

if (GLAccountNumber == "0") {
	//pass, no validation
	assert true;
} else {
	
	TestObject selectorTagGLAccount = new TestObject()
	selectorTagGLAccount.addProperty("xpath", ConditionType.EQUALS, "//div[contains(@class, 'DisplayGLLineitem_wrapper')]//span[contains(@class, 'DisplayGLLineitem_tag-gl-account')]")
	
	// find the list of tagGLAccountList elements
	List<WebElement> tagGLAccountList = WebUI.findWebElements(selectorTagGLAccount, 30)
	println(tagGLAccountList.size())
	
	//iterating each Tag GL Account List, to be matched with GL Account Param(s)
	for (int i = 1; i <= tagGLAccountList.size(); i++) {
		String new_xpath = "//div[contains(@class, 'DisplayGLLineitem_wrapper')]//div[@class='ant-space-item'][${i}]//span[contains(@class, 'DisplayGLLineitem_tag-gl-account')]"
		TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)
	
		println(WebUI.getText(dynamicObject))
		
		if (WebUI.getText(dynamicObject).contains(GLAccountNumber[i-1])) {
			KeywordUtil.markPassed("List COA GL Account : Awal and Show Result equal")
		} else {
			KeywordUtil.markFailedAndStop("List COA GL Account : Awal and Show Result NOT equal")
		}
	}
}
