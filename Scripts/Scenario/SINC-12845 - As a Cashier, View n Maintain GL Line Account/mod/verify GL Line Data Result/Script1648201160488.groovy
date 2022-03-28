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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Boolean isDebit = "$nisDebit"
//Boolean isCredit = "$nisCredit"

//kolom debit credit
//$("div.ant-table-content tbody tr:nth-child(2) > td:nth-child(15)").textContent

//kolom amount
//$("div.ant-table-content tbody tr:nth-child(2) > td:nth-child(9)").textContent

static void debitCredit() {
	System.out.println("I just got executed!");
}

//lanjutin debit & creditnya. count baris dan next page nya

for (int i = 2; i < 11; i++) {
//	String el = 'return document.querySelector("input[name=\'maxRowItem\']").value;'	
	String el = String.format('return document.querySelector(\"div.ant-table-content tbody tr:nth-child(%d) > td:nth-child(15)\").textContent;', i)
	println(el)
	
	String result = WebUI.executeJavaScript(el, null, FailureHandling.OPTIONAL)
	println(result)
}