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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.VerifyElementPresentKeyword as VerifyElementPresentKeyword
import com.kms.katalon.core.webui.keyword.builtin.WaitForElementVisibleKeyword as WaitForElementVisibleKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

boolean gagalLogin = WebUI.verifyElementNotPresent(findTestObject('Home - Dashboard/Notice Gagal Login'), 5)

if (!gagalLogin) {
    KeywordUtil.logInfo('Gagal Login')

    KeywordUtil.markFailed('Gagal Login') //    WebUI.waitForElementPresent(findTestObject('Home - Dashboard/Header/icon bell'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Home - Dashboard/Header/icon email'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Home - Dashboard/Sider/Sider Agama AHM'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Claim Management'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Dealer'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Dealer Group'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Hobi'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Home'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Hubungan dengan Pemakai AHM'), 
    //        GlobalVariable.waitPresentTimeout, FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Incoming Payment'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider KabupatenKota'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Kecamatan'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Kelurahan'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Kendaraan'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Lokasi'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Lokasi Unit'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Mapping CDB'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Mapping Pit dan Mekanik'), 
    //        GlobalVariable.waitPresentTimeout, FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Material'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Order Suku Cadang'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Part Sales Management'), 
    //        GlobalVariable.waitPresentTimeout, FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Pekerjaan AHM'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Pekerjaan HSO'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Penerimaan Suku Cadang'), 
    //        GlobalVariable.waitPresentTimeout, FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Permohonan Persetujuan'), 
    //        GlobalVariable.waitPresentTimeout, FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Pit'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Promosi'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Provinsi'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Range DP'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Region'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Sales Management'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Sales Performance'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Service Management'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Staff'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Status Rumah AHM'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Stok Suku Cadang'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
    //
    //    WebUI.waitForElementPresent(findTestObject('Object Repository/Home - Dashboard/Sider/Sider Support Company'), GlobalVariable.waitPresentTimeout, 
    //        FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.waitForElementPresent(findTestObject('Home - Dashboard/Footer/Footer star'), GlobalVariable.waitPresentTimeout, 
        FailureHandling.CONTINUE_ON_FAILURE)
}

