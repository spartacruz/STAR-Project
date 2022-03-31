import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.time.LocalDate
import java.time.format.DateTimeFormatter

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

String GLAccountNumber = "$nGLAccountNumber"
String debitCredit = "$ndebitCredit"
String postingNumberFrom = "$npostingNumberFrom"
String postingNumberTo = "$npostingNumberTo"
String docReferenceFrom = "$ndocReferenceFrom"
String docReferenceTo = "$ndocReferenceTo"
String postingDateFrom = "$npostingDateFrom"
String postingDateTo = "$npostingDateTo"
String docDateFrom = "$ndocDateFrom"
String docDateTo = "$ndocDateTo"
String costCenter = "$ncostCenter"
String profitCenter = "$ncostCenter"

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


public static void glAccountCostAndProfitCenterValidation(String paramCOAorCost, List<WebElement> selectorContentGLTableList, String option) {
	
	String wording_for = ''
	String for_column = ''
	
	switch (option) {
		case 'GLAccount':
			wording_for = 'GL Account'
			for_column = '2'
			break
		
		case 'costCenter':
			wording_for = 'Cost Center'
			for_column = '10'
			break
		
		case 'profitCenter':
			wording_for = 'Profit Center'
			for_column = '11'
			break
		
	}
	
	if (paramCOAorCost == '0') {
		//pass, no validation
		assert true
		
		
	} else {
		String[] GLOrCoaArray = new String[50]
		GLOrCoaArray = paramCOAorCost.split(',')
	
		
		//collect GL Account from params, and convert it into Array
		//iterating each GL Account Row, to be matched with expected result
		//i start from 2, because the first tr is nbsp
		for (int i = 2; i <= (selectorContentGLTableList.size()); i++) {
			String new_xpath = "//table//tbody/tr[$i]/td[$for_column]"
	
			TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)
	
			println(WebUI.getText(dynamicObject))
	
			if (GLOrCoaArray.contains(WebUI.getText(dynamicObject))) {
				KeywordUtil.markPassed("$wording_for Validation : Expected Result and rendered table head are equal")
			} else {
				KeywordUtil.markFailedAndStop("$wording_for Validation : Expected Result and rendered table head are NOT equal")
			}
		}
	}
}

//GL Account validation
//GL Account validation
//GL Account validation
//Need param :
//String GLAccountNumber = "$nGLAccountNumber"
glAccountCostAndProfitCenterValidation(GLAccountNumber, selectorContentGLTableList, 'GLAccount')

//Cost Center (Advanced Search) validation
//Cost Center (Advanced Search) validation
//Cost Center (Advanced Search) validation
glAccountCostAndProfitCenterValidation(costCenter, selectorContentGLTableList, 'costCenter')

//Cost Center (Advanced Search) validation
//Cost Center (Advanced Search) validation
//Cost Center (Advanced Search) validation
glAccountCostAndProfitCenterValidation(profitCenter, selectorContentGLTableList, 'profitCenter')




//Debit/Credit validation
//Debit/Credit validation
//Debit/Credit validation
//Need param :
//String debitCredit = "$ndebitCredit"

public static void debitAndCreditValidation(String paramDebitCredit, List<WebElement> selectorContentGLTableList) {
	if (paramDebitCredit == 'DebitCredit') {
		//pass, no validation
		assert true
		
	} else {
		
		String[] debitCreditArray = new String[2]
		String postingKey = ''
		String minusAmount = '-'
		Boolean canMinusAmount = true
		
		switch (paramDebitCredit) {
			case 'debitOnly':
				postingKey = "01,40,05,09,29,50,21"
				canMinusAmount = false
			
			case 'creditOnly':
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
}

debitAndCreditValidation(String debitCredit, List<WebElement> selectorContentGLTableList)


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

public static void postingAndDocRefValidation(String postingNumberFrom, String postingNumberTo, String[] postingNumberArray, List<WebElement> selectorContentGLTableList, String option) {
	
	String choice = option
	int scan_column = 0
	String wording_invalid_range = ''
	String wording_valid_render = ''
	String wording_invalid_render = ''
	
	switch (choice) {
		case 'postingNumber':
			scan_column = 5
			wording_invalid_range = 'Posting Number (Advanced Search) validation : Invalid range posting number from params'
			wording_valid_render = 'Posting Number (Advanced Search) validation : Expected Result and rendered result are equal'
			wording_invalid_render = 'Posting Number (Advanced Search) validation : Expected Result and rendered result are NOT equal'
			break
		
		case 'docReference':
			scan_column = 7
			wording_invalid_range = 'Doc. Reference (Advanced Search) validation : Invalid range posting number from params'
			wording_valid_render = 'Doc. Reference (Advanced Search) validation : Expected Result and rendered result are equal'
			wording_invalid_render = 'Doc. Reference (Advanced Search) validation : Expected Result and rendered result are NOT equal'
			break
	}
	
	if (postingNumberFrom == '0' && postingNumberTo != '0') {
		KeywordUtil.markFailedAndStop(wording_invalid_range)
	}
	
	if (postingNumberFrom != '0' && postingNumberTo == '0') {
		KeywordUtil.markFailedAndStop(wording_invalid_range)
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
			
			String new_xpath = "//table//tbody/tr[$i]/td[$scan_column]"
	
			TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)
	
			println(WebUI.getText(dynamicObject))
	
			if (postingNumberArray.contains(WebUI.getText(dynamicObject))) {
				KeywordUtil.markPassed(wording_valid_render)
			} else {
				KeywordUtil.markFailedAndStop(wording_invalid_render)
			}
		}
	}
}

//Posting Number (Advanced Search) validation
//Need param :
//String postingNumberFrom = "$npostingNumberFrom"
//String postingNumberTo = "$npostingNumberTo"
String[] postingNumberArray = new String[1]
postingAndDocRefValidation(postingNumberFrom, postingNumberTo, postingNumberArray, selectorContentGLTableList, 'postingNumber')

//Doc. Reference (Advanced Search) validation
//Need param :
//String docReferenceFrom = "$ndocReferenceFrom"
//String docReferenceTo = "$ndocReferenceTo"
String[] DocReferenceArray = new String[1]
postingAndDocRefValidation(docReferenceFrom, docReferenceTo, DocReferenceArray, selectorContentGLTableList, 'docReference')



//for convert string_date to java format date and check whether target date is :
//in between or equal
//will return boolean true if (in between or equal). Otherwise, false
public static Boolean isWithinDateRange(String paramRange1, String paramRange2, String paramTargetDate) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
	String targetDate = paramTargetDate;
	LocalDate localDate_targetDate = LocalDate.parse(targetDate, formatter);

	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String range1 = paramRange1;
	String range2 = paramRange2;
	LocalDate localDate_range1 = LocalDate.parse(range1, formatter2);
	LocalDate localDate_range2 = LocalDate.parse(range2, formatter2);

	boolean isAfter = localDate_targetDate.isAfter(localDate_range1);
	boolean isBefore = localDate_targetDate.isBefore(localDate_range2);

	if (isAfter && isBefore) {
		return true;
	}

	boolean isEqualStart = localDate_targetDate.isEqual(localDate_range1);
	boolean isEqualEnd = localDate_targetDate.isEqual(localDate_range2);

	if (isEqualStart || isEqualEnd) {
		return true;
	} else {
		return false;
	}
}

public static void postingAndDocDateValidation(String paramFromDate, String paramEndDate, List<WebElement> selectorContentGLTableList, String option) {
	
	String choice = option
	int scan_column = 0
	String wording_invalid_range = ''
	String wording_valid_render = ''
	String wording_invalid_render = ''
	Boolean withinDateRange = true
	
	switch (choice) {
		case 'postingDate':
			scan_column = 6
			wording_invalid_range = 'Posting Date (Advanced Search) validation : Invalid range Posting Date from params'
			wording_valid_render = 'Posting Date (Advanced Search) validation : Expected Result and rendered result are equal'
			wording_invalid_render = 'Posting Date (Advanced Search) validation : Expected Result and rendered result are NOT equal'
			break
		
		case 'docDate':
			scan_column = 8
			wording_invalid_range = 'Doc. Date (Advanced Search) validation : Invalid range Doc. Date from params'
			wording_valid_render = 'Doc. Date (Advanced Search) validation : Expected Result and rendered result are equal'
			wording_invalid_render = 'Doc. Date (Advanced Search) validation : Expected Result and rendered result are NOT equal'
			break
	}
	
	if (paramFromDate == '0' && paramEndDate != '0') {
		KeywordUtil.markFailedAndStop(wording_invalid_range)
	}
	
	if (paramFromDate != '0' && paramEndDate == '0') {
		KeywordUtil.markFailedAndStop(wording_invalid_range)
	}
	
	if (paramFromDate == '0' && paramEndDate == '0') {
		//pass, no validation
		assert true
		
	} else {
	
		//iterating each Posting Number Row, to be matched with expected result
		//i start from 2, because the first tr is nbsp
		for (int i = 2; i <= (selectorContentGLTableList.size()); i++) {
			String new_xpath = "//table//tbody/tr[$i]/td[$scan_column]"
			TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)
			println(WebUI.getText(dynamicObject))
			
			withinDateRange = isWithinDateRange(paramFromDate, paramEndDate, WebUI.getText(dynamicObject))
	
			if (withinDateRange) {
				KeywordUtil.markPassed(wording_valid_render)
			} else {
				KeywordUtil.markFailedAndStop(wording_invalid_render)
			}
		}
	}
}

//Posting Date (Advanced Search) validation
//Posting Date (Advanced Search) validation
//Posting Date (Advanced Search) validation
//Need param :
//String postingDateFrom = "$npostingDateFrom"
//String postingDateTo = "$npostingDateTo"
postingAndDocDateValidation(postingDateFrom, postingDateTo, selectorContentGLTableList, 'postingDate')

//Doc. Date (Advanced Search) validation
//Doc. Date (Advanced Search) validation
//Doc. Date (Advanced Search) validation
//Need param :
//String docDateFrom = "$ndocDateFrom"
//String docDateTo = "$ndocDateTo"
postingAndDocDateValidation(docDateFrom, docDateTo, selectorContentGLTableList, 'docDate')

