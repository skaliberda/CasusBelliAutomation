package com.infinitios.casusbelli.ru.testcases.space;

import org.testng.annotations.Test;

import com.infinitios.casusbelli.core.TestCase;
import com.infinitios.casusbelli.utils.Utils;
import com.infinitios.casusbelli.web.ru.components.*;
import com.infinitios.casusbelli.web.structure.ru.pages.*;

public class TC_DockTutorial extends TestCase {
	
//	@Test(groups = { "smoke" })
	@Test(groups = { "dev" })
	public void test() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.verify();
		homePage.switchToRuLanguage();
		RegisterPage registerPage = homePage.signUp();
		registerPage.verify();
		registerPage.enterEmail(Utils.getUniqueNameForEmail() + "@mailinator.com");
		DockPage dockPage = registerPage.playForFree();
		dockPage.verify();
		currentPage.verifyPrecenceOfMsg("������ ���� ���, ��� ������� ���� ����� ����� ������.");
		dockPage.enterCharacterName("Test_" + Utils.getUniqueUserName());
		currentPage.verifyPrecenceOfMsg("����� �� ������! ����� ����� ������� ������� � �������!");
		dockPage.nextTutorial();
		currentPage.verifyPrecenceOfMsg("������ � ������ ����� ������� ������! ������ �������� � ��������� ������� �� ���� ������ �������.");
		dockPage.nextTutorial();
		currentPage.verifyPrecenceOfMsg("� ������� ����� ����� ��������� � �������� ����� ������ � ��������!");
		dockPage.nextTutorial();
		currentPage.verifyPrecenceOfMsg("�����! ������ ����� �������������� �������!");
		dockPage.nextTutorial();		
		currentPage.verifyPrecenceOfMsg("������ ������� � ���� ���� �������� ���������.# �������: 500 �������!");
		ShopComponent shopComponent =  dockPage.openShop();
		currentPage.verifyPrecenceOfMsg("������ ��������� '������ � �������� ���������'.");
		shopComponent.openTurretsAndLaunchers();
		currentPage.verifyPrecenceOfMsg("������ ��������� '�������� �������� ���������'.");
		shopComponent.openMissileLaunchers();
		currentPage.verifyPrecenceOfMsg("������ � ���� �������� ���������. ����� ������������ ������� ������ - ���������.");
		shopComponent.selectMissileLauncherL1();
		currentPage.verifyPrecenceOfMsg("����� ��� ������, ����� ������ ���� �������� ���������.");
		shopComponent.buyItem();
		currentPage.verifyPrecenceOfMsg("������ ������� ������� ������ �������������.");
		shopComponent.confirmBuying();
		currentPage.verifyPrecenceOfMsg("������ ��������� '���������� � ������'.");
		shopComponent.openAmmunitionAndProjectiles();
		currentPage.verifyPrecenceOfMsg("������ ��������� '������ � �������'.");
		shopComponent.openMissilesAndTorpedoes();
		currentPage.verifyPrecenceOfMsg("����� ������ ����� �����. ��������� �� � ����.");
		shopComponent.selectRocketL1();
		currentPage.verifyPrecenceOfMsg("��� ������ ������ �� ������, ��� ����� ���� �� ������ �������.");
		shopComponent.buyItem();
		currentPage.verifyPrecenceOfMsg("������� �� �� �������� ���� �������. ������ ����� ��������� ���� ������ �������.");
		shopComponent.confirmBuying();
		currentPage.verifyPrecenceOfMsg("������ ����� ��������� ������ � ��� �������. ������ ������������ � ����� ���� '�����'!");
		ConfiguratorComponent configuratorComponent =  dockPage.openConfigurator();
		currentPage.verifyPrecenceOfMsg("������ ������ �� '�������� ��������� t.Co l1' ����� ���������� � ���� ����������.");
		configuratorComponent.selectMissileLauncher();
		currentPage.verifyPrecenceOfMsg("�������� '������ l1' � ���� ����������.");
		configuratorComponent.equipRocketL1();
		currentPage.verifyPrecenceOfMsg("�����! ������ ������ '� ������!' � ������ ������ ������� �����!");
		dockPage.toSpace();
		currentPage.verifyPrecenceOfMsg("�� ���� �������� ���� ���� ���������� ������ ��� ��������� ��������. ����� ������ - ������� �� ������ � ������!");
	}
}
