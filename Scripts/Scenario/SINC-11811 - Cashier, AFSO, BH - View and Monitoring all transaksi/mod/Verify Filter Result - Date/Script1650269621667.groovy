import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

//Tanggal kuitansi == Document Date
String docDateFrom = "$ndocDateFrom"
String docDateTo = "$ndocDateTo"

String postingDateFrom = "$npostingDateFrom"
String postingDateTo = "$npostingDateTo"
String choice = "$nchoice"
Integer countPage = 1

//row result counter
List<WebElement> selectorContentGLTableList = tableListGenerator('//div[contains(@class, \'ResultMonitoringIncoming\')]//table//tbody/tr')

println(selectorContentGLTableList.size())

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
	
	if (choice.equals("Tgl.Kuitansi")) {
		postingAndDocDateValidation(docDateFrom, docDateTo, selectorContentGLTableList, choice)
		
	} else if (choice.equals("Tgl.Posting")) {
		postingAndDocDateValidation(postingDateFrom, postingDateTo, selectorContentGLTableList, choice)
		
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
		if (choice.equals("Tgl.Kuitansi")) {
			postingAndDocDateValidation(docDateFrom, docDateTo, selectorContentGLTableList, choice)
		
		} else if (choice.equals("Tgl.Posting")) {
			postingAndDocDateValidation(postingDateFrom, postingDateTo, selectorContentGLTableList, choice)
		
		} else {
			KeywordUtil.markFailedAndStop("Invalid param nChoice input")
		}
		
		countPage = countPage + 1
		KeywordUtil.logInfo("Iterating page: $countPage")
		
		buttonNextPageEnabled = tableListGenerator(xpath_nextPage)
	}
}

public static void postingAndDocDateValidation(String paramFromDate, String paramEndDate, List<WebElement> paramSelectorContentGLTableList, String option) {
	
	String choice = option
	String scan_column = ''
	String wording_invalid_range = ''
	String wording_valid_render = ''
	String wording_invalid_render = ''
	Boolean withinDateRange = true
	
	switch (choice) {
		case 'Tgl.Posting':
			scan_column = 'Tgl.Posting'
			wording_invalid_range = 'Posting Date (Advanced Search) validation : Invalid range Posting Date from params'
			wording_valid_render = 'Posting Date (Advanced Search) validation : Expected Result and rendered result are equal'
			wording_invalid_render = 'Posting Date (Advanced Search) validation : Expected Result and rendered result are NOT equal'
			break
		
		case 'Tgl.Kuitansi':
			scan_column = 'Tgl.Kuitansi'
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
		for (int i = 1; i <= (paramSelectorContentGLTableList.size()); i++) {
						
			TestObject result = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'),
				[('nrow') : i.toString(), ('nwhichColumn') : scan_column], FailureHandling.STOP_ON_FAILURE)
			
			withinDateRange = isWithinDateRange(paramFromDate, paramEndDate, WebUI.getText(result))
	
			if (withinDateRange) {
				KeywordUtil.markPassed(wording_valid_render)
			} else {
				KeywordUtil.markFailedAndStop(wording_invalid_render)
			}
		}
	}
}

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

def tableListGenerator(String xpathLocation) {
	//count table rows, can be reuse
	TestObject selectorContentGLTable = new TestObject()
	selectorContentGLTable.addProperty('xpath', ConditionType.EQUALS, xpathLocation)
	
	// find the row header of result table elements
	List<WebElement> selectorContentGLTableList = WebUI.findWebElements(selectorContentGLTable, 10)
	
	println(selectorContentGLTableList.size())
	return selectorContentGLTableList
}