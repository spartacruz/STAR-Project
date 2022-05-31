import org.openqa.selenium.WebElement
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import internal.GlobalVariable as GlobalVariable

WebUI.waitForElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'),
	GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Fin - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'),
	GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

String postingNumberFrom = "$npostingNumberFrom"
String postingNumberTo = "$npostingNumberTo"
String docReferenceFrom = "$ndocReferenceFrom"
String docReferenceTo = "$ndocReferenceTo"
String choice = "$nchoice"
int countPage = 1

String[] numberArray = new String[1]

//row result counter
List<WebElement> selectorContentGLTableList = tableListGenerator('//div[contains(@class, \'ResultMonitoringIncoming\')]//table//tbody/tr')

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
	///put the function here
	
	if (choice.equals("No.Kuitansi")) {
		postingAndDocRefValidation(docReferenceFrom, docReferenceTo, numberArray, selectorContentGLTableList, 'No.Kuitansi')
	
	} else if (choice.equals("No.Posting")) {
		postingAndDocRefValidation(postingNumberFrom, postingNumberTo, numberArray, selectorContentGLTableList, 'No.Posting')
	
	} else {
		KeywordUtil.markFailedAndStop("Invalid param nChoice input")
	}
	
	
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
		
		selectorContentGLTableList = tableListGenerator('//div[contains(@class, \'ResultMonitoringIncoming\')]//table//tbody/tr')
		
		///put the function here
		if (choice.equals("No.Kuitansi")) {
			postingAndDocRefValidation(docReferenceFrom, docReferenceTo, numberArray, selectorContentGLTableList, 'No.Kuitansi')
	
		} else if (choice.equals("No.Posting")) {
			postingAndDocRefValidation(postingNumberFrom, postingNumberTo, numberArray, selectorContentGLTableList, 'No.Posting')
	
		} else {
			KeywordUtil.markFailedAndStop("Invalid param nChoice input")
		}
		
		countPage = countPage + 1
		KeywordUtil.logInfo("Iterating page: $countPage")
		
		buttonNextPageEnabled = tableListGenerator(xpath_nextPage)
	}
}







public static void postingAndDocRefValidation(String postingNumberFrom, String postingNumberTo, String[] postingNumberArray, List<WebElement> paramselectorContentGLTableList, String option) {
	
	String choice = option
	String scan_column = ''
	String wording_invalid_range = ''
	String wording_valid_render = ''
	String wording_invalid_render = ''
	
	switch (choice) {
		case 'No.Posting':
			scan_column = 'No.Posting'
			wording_invalid_range = 'Posting Number (Advanced Search) validation : Invalid range posting number from params'
			wording_valid_render = 'Posting Number (Advanced Search) validation : Expected Result and rendered result are equal'
			wording_invalid_render = 'Posting Number (Advanced Search) validation : Expected Result and rendered result are NOT equal'
			break
		
		case 'No.Kuitansi':
			scan_column = 'No.Kuitansi'
			wording_invalid_range = 'No. Kuitansi (Advanced Search) validation : Invalid range posting number from params'
			wording_valid_render = 'No. Kuitansi (Advanced Search) validation : Expected Result and rendered result are equal'
			wording_invalid_render = 'No. Kuitansi (Advanced Search) validation : Expected Result and rendered result are NOT equal'
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
		for (int i = 1; i <= (paramselectorContentGLTableList.size()); i++) {

			TestObject dynamicObject = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'),
			[('nrow') : i.toString(), ('nwhichColumn') : scan_column], FailureHandling.STOP_ON_FAILURE)
			
			println(WebUI.getText(dynamicObject))
	
			if (postingNumberArray.contains(WebUI.getText(dynamicObject))) {
				KeywordUtil.markPassed(wording_valid_render)
			} else {
				KeywordUtil.markFailedAndStop(wording_invalid_render)
			}
		}
	}
}


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

def tableListGenerator(String xpathLocation) {
	//count table rows, can be reuse
	TestObject selectorContentGLTable = new TestObject()
	selectorContentGLTable.addProperty('xpath', ConditionType.EQUALS, xpathLocation)
	
	// find the row header of result table elements
	List<WebElement> selectorContentGLTableList = WebUI.findWebElements(selectorContentGLTable, 10)
	
	println(selectorContentGLTableList.size())
	return selectorContentGLTableList
}