import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

String row = "$nrow"
String whichColumn = "$nwhichColumn"
//println(whichColumn)

getAttribRow(row, whichColumn)

String getAttribRow(def defrow, def defwhichColumn) {
    Integer x1 = Integer.parseInt(defrow) + 1

    Integer for_column = 0

    switch (defwhichColumn) {
        case 'docNumber':
            for_column = 7
            break
			
        case 'docDate':
            for_column = 8
            break
			
        case 'postingNumber':
            for_column = 5
            break
			
        case 'postingDate':
            for_column = 6
            break
    }
    
    String new_xpath = "//table//tbody/tr[$x1]/td[$for_column]"

    TestObject dynamicObject = new TestObject('dynamicObject').addProperty('xpath', ConditionType.EQUALS, new_xpath)

    println(WebUI.getText(dynamicObject))

    return WebUI.getText(dynamicObject)
}

