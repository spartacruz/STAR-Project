import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.*;
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

//nparamMonitoringDetailInfo param thrown from Get Data Pelanggan Info

def transactionDetailInfo = [:]

WebUI.waitForElementNotPresent(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/loading spinning Data Pelanggan'), GlobalVariable.waitPresentTimeout, FailureHandling.STOP_ON_FAILURE)

(transactionDetailInfo['NoPelanggan']) = WebUI.getText(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value Data Pelanggan_No. Pelanggan'))

(transactionDetailInfo['NamaPelanggan']) = WebUI.getText(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value Data Pelanggan_Nama Pelanggan'))

(transactionDetailInfo['NoKuitansi']) = WebUI.getText(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value NoKuitansi'))

(transactionDetailInfo['TglKuitansi']) = WebUI.getText(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value TglKuitansi'))

(transactionDetailInfo['NoPosting']) = WebUI.getText(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value NoPosting'))

(transactionDetailInfo['TglPosting']) = WebUI.getText(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value TglPosting'))

(transactionDetailInfo['Status']) = WebUI.getText(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value status'))

transactionDetailInfo['KodeKasBank'] = WebUI.getText(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value KasBank'))

Boolean isBKUReferenceElementExist = false

try {
	isBKUReferenceElementExist = WebUI.verifyElementVisible(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value NoBKU Reference'), 1)
} catch(Exception e) {
	assert true
}

if (isBKUReferenceElementExist.equals(true)) {
	//No Posting BKU (Monitoring) or No. BKU Reference (Transaction Detail)
	transactionDetailInfo['NoPostingBKU'] = WebUI.getText(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/value NoBKU Reference'))
}

(transactionDetailInfo['PenerimaanPembayaranSubtotal']) = WebUI.getText(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/Detail Penerimaan_Subtotal value'))

(transactionDetailInfo['DetailPenerimaanTotal']) = WebUI.getText(findTestObject('Object Repository/Sider/Sider Inc Payment Menu/Finance - Penerimaan (Incoming Payment)/Monitoring Incoming Sub menu/_Transaction Detail Pelanggan/Detail Penerimaan_Total Penerimaan value'))

compareValues(nparamMonitoringDetailInfo['NoPelanggan'], transactionDetailInfo['NoPelanggan'], "No. Pelanggan")
compareValues(nparamMonitoringDetailInfo['NamaPelanggan'], transactionDetailInfo['NamaPelanggan'], "Nama Pelanggan")
compareValues(nparamMonitoringDetailInfo['NoKuitansi'], transactionDetailInfo['NoKuitansi'], "No Kuitansi")
compareValues(nparamMonitoringDetailInfo['TglKuitansi'], transactionDetailInfo['TglKuitansi'], "Tgl Kuitansi")
compareValues(nparamMonitoringDetailInfo['NoPosting'], transactionDetailInfo['NoPosting'], "No Posting")
compareValues(nparamMonitoringDetailInfo['TglPosting'], transactionDetailInfo['TglPosting'], "Tgl Posting")
compareValues(nparamMonitoringDetailInfo['Status'], transactionDetailInfo['Status'], "Status")
compareValues(nparamMonitoringDetailInfo['KodeKasBank'], transactionDetailInfo['KodeKasBank'], "Kode Kas/Bank")

if (isBKUReferenceElementExist.equals(true)) {
	//No Posting BKU (Monitoring) or No. BKU Reference (Transaction Detail)
	compareValues(nparamMonitoringDetailInfo['NoPostingBKU'], transactionDetailInfo['NoPostingBKU'], "No. Posting BKU")
}

compareValues(nparamMonitoringDetailInfo['Nilai'], transactionDetailInfo['PenerimaanPembayaranSubtotal'], "Nilai vs Penerimaan Pembayaran Subtotal")
compareValues(nparamMonitoringDetailInfo['Nilai'], transactionDetailInfo['DetailPenerimaanTotal'], "Nilai vs Detail Penerimaan Total")

KeywordUtil.markPassed("Transaction Detail Validation : All information from Monitoring Page are equal to Transaction Detail")

def compareValues(monitoringValue, transDetailValue, String wording_for) {
	if (wording_for.contains("Tgl")) {
		
		//if no date provided (- or dash symbol)
		if (monitoringValue.equals("-")) {
			//skip dateConverter
			assert true
		} else {
			//convert from e.g. "23 Feb 2022" -> "23 Februari 2022"
			monitoringValue = dateConverter(monitoringValue)
		}
	}
	
	if (wording_for.contains("Status")) {
		//convert from e.g. "POSTED" -> "Posted"
		monitoringValue = monitoringValue.toLowerCase()
		monitoringValue = monitoringValue.substring(0, 1).toUpperCase() + monitoringValue.substring(1)
	}
	
	if (wording_for.contains("Nilai")) {
		// match with all char except digits
		String regex = "[^0-9]"
		//Remove all non-digit characters
		monitoringValue = monitoringValue.replaceAll(regex, "")
		transDetailValue = transDetailValue.replaceAll(regex, "")
	}
	
	println(monitoringValue)
	println(transDetailValue)
	
	//validation for "Kode Kas/Bank" have to use 'contains' since there is a discrepancy
	// e.g. "Cash Operation vs Operation" || "Cash Collection vs Collection"
	//Need to immediate return, to skip 'equals' validation
	if (wording_for.contains("Kode Kas/Bank")) {
		if (monitoringValue.toLowerCase().contains("transfer")) {
			if (transDetailValue.equals("Collection") || transDetailValue.equals("Operation")) {
				KeywordUtil.markPassed("Transaction Detail Validation - $wording_for : Expected Result and rendered page result are equal")
			}
			
			return true
		}
		
		if ( !(monitoringValue.contains(transDetailValue)) ) {
			KeywordUtil.markFailedAndStop("Transaction Detail Validation - $wording_for : Expected Result and rendered page result are NOT equal")
		} else {
			KeywordUtil.markPassed("Transaction Detail Validation - $wording_for : Expected Result and rendered page result are equal")
		}
		
		return true
	}
	
	if ( !(monitoringValue.equals(transDetailValue)) ) {
		KeywordUtil.markFailedAndStop("Transaction Detail Validation - $wording_for : Expected Result and rendered page result are NOT equal")
	} else {
		KeywordUtil.markPassed("Transaction Detail Validation - $wording_for : Expected Result and rendered page result are equal")
	}
}

public static String dateConverter(String paramTargetDate) {
    //19 Apr 2022 - input
    //23 Feb 2022
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
    String targetDate = paramTargetDate;
    LocalDate localDate_targetDate = LocalDate.parse(targetDate, formatter);

    Locale indonesia = new Locale("ID"); //month locale in indonesian
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd MMMM yyyy").withLocale(indonesia);
    paramTargetDate = formatter2.format(localDate_targetDate);

    return paramTargetDate.toString();
    //19 April 2022 expected result
    //23 Februari 2022
}

