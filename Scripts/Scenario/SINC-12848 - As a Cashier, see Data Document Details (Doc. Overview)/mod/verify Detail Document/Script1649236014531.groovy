import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/btn BackButton'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/div Document Overview heading text'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/h4 Detail Document text'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/h4 Doc Number Title'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/p Doc Number Value'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/h4 Doc. Date Title'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/p Doc. Date Value'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/h4 Posting Number Title'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/p Posting Number Value'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/h4 Posting Date Title'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/p Posting Date Value'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/h4 SAP Doc Number Title'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/p SAP Doc Number Value'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/input Search Box'), 
    GlobalVariable.waitPresentTimeout)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/table content'), 
    GlobalVariable.waitPresentTimeout)

String docNumber = "$ndocNumber"
String docDate = "$ndocDate"
String postingNumber = "$npostingNumber"
String postingDate = "$npostingDate"
String SAPDocNumber = "$nSAPDocNumber"

TestObject objDocNumber = findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/p Doc Number Value')
TestObject objDocDate = findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/p Doc. Date Value')
TestObject objPostingNumber = findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/p Posting Number Value')
TestObject objPostingDate = findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/p Posting Date Value')
TestObject objSAPDocNumber = findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/document overview details/p SAP Doc Number Value')


String docDetailDocNumber = WebUI.getText(objDocNumber, FailureHandling.STOP_ON_FAILURE)
String docDetailDocDate = WebUI.getText(objDocDate, FailureHandling.STOP_ON_FAILURE)
String docDetailPostingNumber = WebUI.getText(objPostingNumber, FailureHandling.STOP_ON_FAILURE)
String docDetailPostingDate = WebUI.getText(objPostingDate, FailureHandling.STOP_ON_FAILURE) 
String docDetailSAPDocNumber = WebUI.getText(objSAPDocNumber, FailureHandling.STOP_ON_FAILURE)

if (!docDetailDocNumber.equals(docNumber)) {
	KeywordUtil.markFailedAndStop("Document Detail Head Validation : Expected DocNumber and rendered details are NOT equal")
}

if (!docDetailDocDate.equals(docDate)) {
	KeywordUtil.markFailedAndStop("Document Detail Head Validation : Expected DocDate and rendered details are NOT equal")
}

if (!docDetailPostingNumber.equals(postingNumber)) {
	KeywordUtil.markFailedAndStop("Document Detail Head Validation : Expected Posting Number and rendered details are NOT equal")
}

if (!docDetailPostingDate.equals(postingDate)) {
	KeywordUtil.markFailedAndStop("Document Detail Head Validation : Expected Posting Date and rendered details are NOT equal")
}

if (!docDetailSAPDocNumber.equals(SAPDocNumber)) {
	KeywordUtil.markFailedAndStop("Document Detail Head Validation : Expected Posting Date and rendered details are NOT equal")
}

KeywordUtil.markPassed("Document Detail Head Validation : Expected Result and rendered table head are equal")






