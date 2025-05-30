package com.utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

class AppointmentHelper {

	@Keyword
	def fillBasicAppointmentForm(String facilityValue, boolean readmission, String program, String visitDate, String comment) {


		WebUI.selectOptionByValue(
				findTestObject('Object Repository/Page_CURA Healthcare Service/select_Tokyo CURA Healthcare Center        _5b4107'),
				facilityValue, true)


		if (readmission) {
			WebUI.check(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Apply for hospital readmission_hospit_63901f'))
		} else {
			WebUI.uncheck(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Apply for hospital readmission_hospit_63901f'))
		}


		switch(program.toLowerCase()) {
			case 'medicare':
				WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Medicare_programs'))
				break
			case 'medicaid':
				WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Medicaid_programs'))
				break
			case 'none':
				WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/input_None_programs'))
				break
			default:
				throw new IllegalArgumentException("Unsupported program: ${program}")
		}

		WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Visit Date (Required)_visit_date'), visitDate)

		findTestObject('Object Repository/Page_CURA Healthcare Service/input_Visit Date (Required)_visit_date')


		WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/textarea_Comment_comment'), comment)

		WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Book Appointment'))
	}

	@Keyword
	def verifyAppointmentConfirmation(String expectedFacility, String expectedProgram, String expectedDate, String expectedComment) {


		WebUI.verifyElementText(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Appointment Confirmation'), 'Appointment Confirmation')

		WebUI.verifyElementText(findTestObject('Object Repository/Page_CURA Healthcare Service/p_Facility'), expectedFacility)

		WebUI.verifyElementText(findTestObject('Object Repository/Page_CURA Healthcare Service/p_Program'), expectedProgram)

		WebUI.verifyElementText(findTestObject('Object Repository/Page_CURA Healthcare Service/p_VisitDate'), expectedDate)

		WebUI.verifyElementText(findTestObject('Object Repository/Page_CURA Healthcare Service/p_Comment'), expectedComment)
	}
}