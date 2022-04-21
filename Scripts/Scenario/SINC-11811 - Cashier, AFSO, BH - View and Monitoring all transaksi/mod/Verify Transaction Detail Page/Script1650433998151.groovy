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

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/button back to monitoring'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title No. Kuitansi'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value NoKuitansi'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title Tgl. Kuitansi'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value TglKuitansi'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title No. Posting'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value NoPosting'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title Tgl. Posting'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value TglPosting'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title KasBank'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value KasBank'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title No. BKU Reference'), 
    2, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value NoBKU Reference'), 
    2, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value status'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/h3 Data Pelanggan'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title Data Pelanggan_No. Pelanggan'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value Data Pelanggan_No. Pelanggan'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title Data Pelanggan_Nama Pelanggan'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value Data Pelanggan_Nama Pelanggan'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title Data Pelanggan_Alamat'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value Data Pelanggan_Alamat'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title Data Pelanggan_Kota'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value Data Pelanggan_Kota'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title Data Pelanggan_No HP'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value Data Pelanggan_No HP'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title Data Pelanggan_No. KTP'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value Data Pelanggan_No. KTP'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/title Data Pelanggan_No. NPWP'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value Data Pelanggan_No. NPWP'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/h3 Riwayat Pembayaran'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/h3 Penerimaan Pembayaran'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/Detail Penerimaan'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/Detail Penerimaan_Subtotal title'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/Detail Penerimaan_Subtotal value'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/Detail Penerimaan_Total Penerimaan title'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/Detail Penerimaan_Total Penerimaan value'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/Metode Penerimaan'), 
    GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

