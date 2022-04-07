import org.openqa.selenium.WebElement
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil

String checkFor = "$ncheckFor"
Boolean haveToBeZero = "$nhaveToBeZero"

//count table rows, can be reuse
//count table rows, can be reuse
//count table rows, can be reuse
TestObject selectorContentGLTable = new TestObject()
selectorContentGLTable.addProperty('xpath', ConditionType.EQUALS, '//table//tbody/tr')

// find the row header of result table elements
List<WebElement> selectorContentGLTableList = WebUI.findWebElements(selectorContentGLTable, 30)
println(selectorContentGLTableList.size())

sumAmountVerification(checkFor, haveToBeZero, selectorContentGLTableList)

def sumAmountVerification(String paramCheckFor, Boolean paramhaveToBeZero, List<WebElement> paramSelectorContentGLTableList) {
	String for_column = ''
	String wording_for = ''
	Integer sumCount = 0
	String summaryLastRow = ''
	
	switch (paramCheckFor) {
		case 'Amount':
			for_column = '9'
			wording_for = 'Amount'
			summaryLastRow = 'table > tfoot > tr > td:nth-child(2)'
			break

		case 'AmountInLC':
			for_column = '10'
			wording_for = 'Amount in LC'
			summaryLastRow = 'table > tfoot > tr > td:nth-child(3)'
			break
	}
	
	for (int i = 2; i <= (paramSelectorContentGLTableList.size()); i++) {
		String new_xpath = "//table//tbody/tr[$i]/td[$for_column]"

		TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)
		println(WebUI.getText(dynamicObject))

		sumCount = sumCount + currencyConverter(WebUI.getText(dynamicObject))
	}
	
	String el = 'return document.querySelector(\"' + "$summaryLastRow" + '\").textContent;'
	String summaryLastRowResult = WebUI.executeJavaScript(el, null, FailureHandling.OPTIONAL)
	Integer summaryLastRowResultInteger = currencyConverter(summaryLastRowResult)
	
	println(sumCount.getClass())
	println(summaryLastRowResultInteger.getClass())
	
	if (!summaryLastRowResultInteger.equals(sumCount)) {
		KeywordUtil.markFailedAndStop("$wording_for Summary Validation: Expected Result and rendered table result are NOT equal, Unmatch summary")
	}
	
	if (paramhaveToBeZero.equals(true)) {
		if (!summaryLastRowResultInteger.equals(0)) {
			KeywordUtil.markFailedAndStop("$wording_for Summary Validation: Expected Result >> Calculation sum amount have to be zero, Rendered result >> not zero ")
		}
	}
	
	KeywordUtil.markPassed("$wording_for Summary Validation : Expected Result and rendered table result are equal")	
}


def Integer currencyConverter(String paramRawString) {
	Boolean isMinus = false;
	
	if (paramRawString.contains("-")) {
		isMinus = true;
	}

	String cleanNumber = paramRawString.replaceAll("[^0-9]+", "");
	Integer cleanNumberInteger = Integer.parseInt(cleanNumber);
	if (isMinus) {
		cleanNumberInteger = cleanNumberInteger * -1;
	}
	return cleanNumberInteger;
}