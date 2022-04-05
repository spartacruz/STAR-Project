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
import org.openqa.selenium.Keys
import org.codehaus.groovy.tools.shell.completion.KeywordSyntaxCompletor
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.verifyElementNotPresent(findTestObject('Sider/Sider Inc Payment Menu/Inc - MR - Mon GL Line Item/btn Show Result/span dot spinning_fetching data'),
	GlobalVariable.waitPresentTimeout)

String expectedPage = "$nexpectedPage" ?: ''

//count table rows, can be reuse
//count table rows, can be reuse
//count table rows, can be reuse
TestObject selectorContentGLTable = new TestObject()
selectorContentGLTable.addProperty('xpath', ConditionType.EQUALS, '//table//tbody/tr')

// find the row header of result table elements
List<WebElement> selectorContentGLTableList = WebUI.findWebElements(selectorContentGLTable, 30)

println(selectorContentGLTableList.size())

public static void pageCountValidation(String paramExpectedCountPage, List<WebElement> paramSelectorContentGLTableList) {
	Integer expectedCountPage = Integer.parseInt(paramExpectedCountPage)
	Integer rowPerPage = 10
	String for_column = '1'
	String new_xpath = "//table//tbody/tr[last()]/td[$for_column]"
	Integer lastRowNo = 0
	Integer currentPage = 0
	
	TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)
	println(WebUI.getText(dynamicObject)) //25
	lastRowNo = Integer.parseInt(WebUI.getText(dynamicObject))
	
	Integer calculate1 = lastRowNo % rowPerPage
	if (calculate1.equals(lastRowNo)) {
		currentPage = 1
	}

	if (calculate1.equals(0)) {
		currentPage = lastRowNo / rowPerPage
	} else {
		currentPage = calculate1 + 1
	}
	
	if (currentPage.equals(expectedCountPage)) {
		KeywordUtil.markPassed("Page Count Validation : Expected Result and rendered table result equal (Expected Page: $expectedCountPage, Currently on page: $currentPage)")
	} else {
		KeywordUtil.markFailedAndStop("Page Count Validation : Expected Result and rendered table result equal (Expected Page: $expectedCountPage, Currently on page: $currentPage)")
	}
}

if (!expectedPage.equals('')) {
	pageCountValidation(expectedPage, selectorContentGLTableList)
}
