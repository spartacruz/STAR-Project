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
WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'), 
    GlobalVariable.waitPresentTimeout)

String GLAccountNumber = "$nGLAccountNumber"
String debitCredit = "$ndebitCredit"
String postingNumberFrom = "$npostingNumberFrom"
String postingNumberTo = "$npostingNumberTo"
String docReferenceFrom = "$ndocReferenceFrom"
String docReferenceTo = "$ndocReferenceTo"

//columns validation
//columns validation
//columns validation
//total 26 columns + 1 blank column on Frontend
//expected result on Thead GL Line Data
String[] dataGLLineItemColumns = ['No', 'GL Account', 'GL Description', 'PK', 'Posting Number', 'Posting Date', 'Doc. Reference'
    , 'Doc. Date', 'Amount', 'BA Code', 'Cost Center', 'Profit Center', 'Clearing No.', 'Clearing Date', 'Status', 'Baseline Date'
    , 'Assignment', 'Text', 'Tax Code', 'Division', 'Notice/Unotice', 'Header Text', 'Fiscal Year', 'Period', 'Doc. Currency'
    , 'Doc. Type', '']

//String selectedObjXpathSelector = "//table//thead/tr/th"
//String iterateObjXpathSelector = "//table//thead/tr/th[\${i}]"
////String iterateObjXpathSelector = "//table//thead/tr/th[${i}]"
//iterator(selectedObjXpathSelector, dataGLLineItemColumns, iterateObjXpathSelector)
TestObject selectorTheadGLTable = new TestObject()

selectorTheadGLTable.addProperty('xpath', ConditionType.EQUALS, '//table//thead/tr/th')

// find the row header of result table elements
List<WebElement> selectorTheadGLTableList = WebUI.findWebElements(selectorTheadGLTable, 30)

println(selectorTheadGLTableList.size())

if (dataGLLineItemColumns.length == selectorTheadGLTableList.size()) {
    KeywordUtil.markPassed('Count Table head GL Account : Expected Result and rendered table head are equal')
} else {
    KeywordUtil.markFailedAndStop('Count Table head GL Account : Expected Result and rendered table head are NOT equal')
}

//iterating each Thead GL Account List, to be matched with expected result
for (int i = 1; i <= selectorTheadGLTableList.size(); i++) {
    String new_xpath = "//table//thead/tr/th[$i]"

    TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)

    println(WebUI.getText(dynamicObject))

    if (WebUI.getText(dynamicObject).equals(dataGLLineItemColumns[(i - 1)])) {
        KeywordUtil.markPassed('Table head GL Account Name : Expected Result and rendered table head are equal')
    } else {
        KeywordUtil.markFailedAndStop('Table head GL Account Name : Expected Result and rendered table head are NOT equal')
    }
}

//count table rows, can be reuse
//count table rows, can be reuse
//count table rows, can be reuse
TestObject selectorContentGLTable = new TestObject()
selectorContentGLTable.addProperty('xpath', ConditionType.EQUALS, '//table//tbody/tr')

// find the row header of result table elements
List<WebElement> selectorContentGLTableList = WebUI.findWebElements(selectorContentGLTable, 30)

println(selectorContentGLTableList.size())


//GL Account validation
//GL Account validation
//GL Account validation
//Need param :
//String GLAccountNumber = "$nGLAccountNumber"
if (GLAccountNumber == '0') {
    //pass, no validation
    assert true 
	
	
} else {
    String[] GLAccountNumberArray = new String[50]
    GLAccountNumberArray = GLAccountNumber.split(',')

	
	//collect GL Account from params, and convert it into Array
	//iterating each GL Account Row, to be matched with expected result
	//i start from 2, because the first tr is nbsp
    for (int i = 2; i <= (selectorContentGLTableList.size()); i++) {
        String new_xpath = "//table//tbody/tr[$i]/td[2]"

        TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)

        println(WebUI.getText(dynamicObject))

        if (GLAccountNumberArray.contains(WebUI.getText(dynamicObject))) {
            KeywordUtil.markPassed('GL Account Validation : Expected Result and rendered table head are equal')
        } else {
            KeywordUtil.markFailedAndStop('GL Account Validation : Expected Result and rendered table head are NOT equal')
        }
    }
}


//Debit/Credit validation
//Debit/Credit validation
//Debit/Credit validation
//Need param :
//String debitCredit = "$ndebitCredit"
if (debitCredit == 'DebitCredit') {
	//pass, no validation
	assert true 
	
} else {
	
	String[] debitCreditArray = new String[2]
	String postingKey = ''
	String minusAmount = '-'
	Boolean canMinusAmount = true
	
	if (debitCredit == 'debitOnly') {
		postingKey = "01,40,05,09,29,50,21"
		canMinusAmount = false
		
	} else if (debitCredit == 'creditOnly') {
		postingKey = "11,15,19,39,50"
		canMinusAmount = true
	}
	
	debitCreditArray = postingKey.split(',')
	
	//collect GL Account from params, and convert it into Array
	//iterating each GL Account Row, to be matched with expected result
	//i start from 2, because the first tr is nbsp
	
	//Compare Posting key
	for (int i = 2; i <= (selectorContentGLTableList.size()); i++) {
		String new_xpath = "//table//tbody/tr[$i]/td[4]"
		TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)

		println(WebUI.getText(dynamicObject))

		if (debitCreditArray.contains(WebUI.getText(dynamicObject))) {
			KeywordUtil.markPassed('Debit Credit Validation (Posting Key): Expected Result and rendered result are equal')
		} else {
			KeywordUtil.markFailedAndStop('Debit Credit Validation (Posting Key): Expected Result and rendered result are NOT equal')
		}
	}
	
	//Compare Amount (plus or minus depends on D/C)
	for (int i = 2; i <= (selectorContentGLTableList.size()); i++) {
		String new_xpath = "//table//tbody/tr[$i]/td[9]"
		TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)

		println(WebUI.getText(dynamicObject))

		
		if (WebUI.getText(dynamicObject).contains(minusAmount) == canMinusAmount) {
			KeywordUtil.markPassed('Debit Credit Validation (Amount): Expected Result and rendered result are equal')
		} else {
			KeywordUtil.markFailedAndStop('Debit Credit Validation (Amount): Expected Result and rendered result are NOT equal')
		}
	}
	
	//Check amount summary value (plus or minus depends on D/C)
	String new_xpath = "//table//tfoot[contains(@class, 'summary')]//td[2]"
	TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)

	println(WebUI.getText(dynamicObject))
	
	if (WebUI.getText(dynamicObject).contains(minusAmount) == canMinusAmount) {
		KeywordUtil.markPassed('Debit Credit Validation (Amount Summary): Expected Result and rendered result are equal')
	} else {
		KeywordUtil.markFailedAndStop('Debit Credit Validation (Amount Summary): Expected Result and rendered result are NOT equal')
	}
	
}


//for counting range eg. H383-I-22000002 to H383-I-22000010
//will return string with comma : H383-I-22000002,H383-I-22000003,H383-I-22000004,H383-I-22000005,H383-I-22000006,H383-I-22000007,H383-I-22000008,H383-I-22000009,H383-I-22000010
public static String rangeStartEnd(String startRange, String endRange){
	String variable1 = startRange;
	String variable2 = endRange;

	String[] temp1 = variable1.split("-");
	String[] temp2 = variable2.split("-");

	Integer last1 = Integer.parseInt(temp1[temp1.length - 1]);
	Integer last2 = Integer.parseInt(temp2[temp1.length - 1]);

	Integer prefix_length = variable1.length() - String.valueOf(last1).length();
	String concat_prefix = variable1.substring(0, prefix_length);

	Integer temporary = last1;
	String temporary_string = "";
	Integer count_array = 0;

	while (temporary <= last2){
		temporary_string = temporary_string + concat_prefix + String.valueOf(temporary);
		if (temporary < last2) {
			temporary_string = temporary_string + ",";
		}
		temporary = temporary + 1;
		count_array = count_array + 1;
	}

	return temporary_string;
}

public static void postingAndDocRefValidation(String postingNumberFrom, String postingNumberTo, String[] postingNumberArray, List<WebElement> selectorContentGLTableList) {
	
	if (postingNumberFrom == '0' && postingNumberTo != '0') {
		KeywordUtil.markFailedAndStop('Posting Number or Doc. Ref (Advanced Search) validation : Invalid range posting number from params')
	}
	
	if (postingNumberFrom != '0' && postingNumberTo == '0') {
		KeywordUtil.markFailedAndStop('Posting Number or Doc. Ref (Advanced Search) validation : Invalid range posting number from params')
	}
	
	if (postingNumberFrom == '0' && postingNumberTo == '0') {
		//pass, no validation
		assert true
		
	} else {
		
		//if user wants to find the same posting number
		if (postingNumberFrom == postingNumberTo) {
			postingNumberArray[0] = postingNumberFrom
			
		} else {
			postingNumberArray = rangeStartEnd(postingNumberFrom, postingNumberTo).split(",")
			
		}
	
		//iterating each Posting Number Row, to be matched with expected result
		//i start from 2, because the first tr is nbsp
		for (int i = 2; i <= (selectorContentGLTableList.size()); i++) {
			String new_xpath = "//table//tbody/tr[$i]/td[5]"
	
			TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)
	
			println(WebUI.getText(dynamicObject))
	
			if (postingNumberArray.contains(WebUI.getText(dynamicObject))) {
				KeywordUtil.markPassed('Posting Number or Doc. Ref (Advanced Search) validation : Expected Result and rendered table head are equal')
			} else {
				KeywordUtil.markFailedAndStop('Posting Number or Doc. Ref (Advanced Search) validation : Expected Result and rendered table head are NOT equal')
			}
		}
	}
}

//Posting Number (Advanced Search) validation
//Posting Number (Advanced Search) validation
//Posting Number (Advanced Search) validation
//Need param :
//String postingNumberFrom = "$npostingNumberFrom"
//String postingNumberTo = "$npostingNumberTo"
String[] postingNumberArray = new String[1]
postingAndDocRefValidation(postingNumberFrom, postingNumberTo, postingNumberArray, selectorContentGLTableList)


//Doc. Reference (Advanced Search) validation
//Doc. Reference (Advanced Search) validation
//Doc. Reference (Advanced Search) validation
//Need param :
//String docReferenceFrom = "$ndocReferenceFrom"
//String docReferenceTo = "$ndocReferenceTo"
String[] DocReferenceArray = new String[1]
postingAndDocRefValidation(docReferenceFrom, docReferenceTo, DocReferenceArray, selectorContentGLTableList)




