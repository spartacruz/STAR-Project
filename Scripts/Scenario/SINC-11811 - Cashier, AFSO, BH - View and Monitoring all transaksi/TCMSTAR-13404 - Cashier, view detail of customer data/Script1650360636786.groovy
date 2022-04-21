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
import java.util.Random as Random

WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/TCMSTAR-13355 - Cashier, go to submenu Monitoring'), 
    [:], FailureHandling.STOP_ON_FAILURE)

Boolean isOk = false
String num = '1'
String temp = ''


//while (isOk.equals(false)) {
//	num = randomNum().toString()
//	TestObject objNoKuitansi = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'),
//		[('nrow') : num, ('nwhichColumn') : 'DetailTransaction'], FailureHandling.STOP_ON_FAILURE)
//
//	temp = WebUI.getText(objNoKuitansi)
//	
//	//escaping broken dataseeder
//	if ( !( (temp.contains("20229999")) || (temp.contains("BKU")) ) ) {
//		isOk = true
//	}
//}

println(num)

WebUI.waitForElementNotPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/div loading spin'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Data Pelanggan Info'), 
    [('nrow') : num], FailureHandling.STOP_ON_FAILURE)

def randomNum() {
	Random rand = new Random();
	int upperbound = 10;
	
	//generate random values from 0-10
	int int_random = rand.nextInt(upperbound)
	if (int_random == 0) {
		int_random = 1
	}
	return int_random
}

