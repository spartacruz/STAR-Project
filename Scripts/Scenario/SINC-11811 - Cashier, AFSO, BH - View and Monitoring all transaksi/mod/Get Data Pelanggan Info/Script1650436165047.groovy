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

String row = "$nrow"
Map monitoringDetailInfo = [:]

WebUI.waitForElementNotPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/div loading spin'), GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

TestObject objNoPelanggan = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'), 
    [('nrow') : row, ('nwhichColumn') : 'No.Pelanggan'], FailureHandling.STOP_ON_FAILURE)

TestObject objNamaPelanggan = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'), 
    [('nrow') : row, ('nwhichColumn') : 'NamaPelanggan'], FailureHandling.STOP_ON_FAILURE)

TestObject objNoKuitansi = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'), 
    [('nrow') : row, ('nwhichColumn') : 'No.Kuitansi'], FailureHandling.STOP_ON_FAILURE)

TestObject objTglKuitansi = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'), 
    [('nrow') : row, ('nwhichColumn') : 'Tgl.Kuitansi'], FailureHandling.STOP_ON_FAILURE)

TestObject objNoPosting = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'), 
    [('nrow') : row, ('nwhichColumn') : 'No.Posting'], FailureHandling.STOP_ON_FAILURE)

TestObject objTglPosting = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'), 
    [('nrow') : row, ('nwhichColumn') : 'Tgl.Posting'], FailureHandling.STOP_ON_FAILURE)

TestObject objStatus = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'), 
    [('nrow') : row, ('nwhichColumn') : 'Status'], FailureHandling.STOP_ON_FAILURE)

TestObject objKodeKasBank = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'), 
    [('nrow') : row, ('nwhichColumn') : 'Kode Kas/Bank'], FailureHandling.STOP_ON_FAILURE)

TestObject objNoPostingBKU = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'), 
    [('nrow') : row, ('nwhichColumn') : 'No.PostingBKU'], FailureHandling.STOP_ON_FAILURE)

TestObject objNilai = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'), 
    [('nrow') : row, ('nwhichColumn') : 'Nilai'], FailureHandling.STOP_ON_FAILURE)

TestObject objDetailTransaction = WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Get Object Row from Monitoring Incoming Table'), 
    [('nrow') : row, ('nwhichColumn') : 'DetailTransaction'], FailureHandling.STOP_ON_FAILURE)

(monitoringDetailInfo['NoPelanggan']) = getStringValueFromObject(objNoPelanggan)

(monitoringDetailInfo['NamaPelanggan']) = getStringValueFromObject(objNamaPelanggan)

(monitoringDetailInfo['NoKuitansi']) = getStringValueFromObject(objNoKuitansi)

(monitoringDetailInfo['TglKuitansi']) = getStringValueFromObject(objTglKuitansi)

(monitoringDetailInfo['NoPosting']) = getStringValueFromObject(objNoPosting)

(monitoringDetailInfo['TglPosting']) = getStringValueFromObject(objTglPosting)

(monitoringDetailInfo['Status']) = getStringValueFromObject(objStatus)

(monitoringDetailInfo['KodeKasBank']) = getStringValueFromObject(objKodeKasBank)

(monitoringDetailInfo['NoPostingBKU']) = getStringValueFromObject(objNoPostingBKU)

(monitoringDetailInfo['Nilai']) = getStringValueFromObject(objNilai)

WebUI.click(objDetailTransaction)

WebUI.waitForElementNotPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/loading spinning Data Pelanggan'), GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Verify Transaction Detail Page'),
//	[:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Scenario/SINC-11811 - Cashier, AFSO, BH - View and Monitoring all transaksi/mod/Verify Transaction Detail Data'), 
    [('nparamMonitoringDetailInfo') : monitoringDetailInfo], FailureHandling.STOP_ON_FAILURE)

def getStringValueFromObject(def theObject) {
    return WebUI.getText(theObject)
}

