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

class LoginHelper {

	@Keyword
	def openCuraHomePage() {
		WebUI.comment("Opening Cura homepage: ${GlobalVariable.baseURL}")
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.baseURL)
	}


	@Keyword
	def performLogin(String username, String encryptedPassword) {
		WebUI.comment("Attempting to log in as: ${username}")
		WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/i_CURA Healthcare_fa fa-bars'))
		WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/a_Login'))
		WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Username_username'), username)
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Password_password'), encryptedPassword)
		WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Login'))
	}

	@Keyword
	def logout() {
		WebUI.comment("Logging out of Cura system")
		WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/a_CURA Healthcare_menu-toggle'))
		WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/a_Logout'))
	}

	@Keyword
	def closeBrowser() {
		WebUI.comment("Closing browser")
		WebUI.closeBrowser()
	}
}
