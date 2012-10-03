package com.infinitios.casusbelli.ru.testcases.space;

import org.testng.annotations.Test;

import com.infinitios.casusbelli.core.TestCase;
import com.infinitios.casusbelli.utils.Utils;
import com.infinitios.casusbelli.web.ru.components.*;
import com.infinitios.casusbelli.web.structure.ru.pages.*;

public class TC_Tutorial extends TestCase {
	
//	@Test(groups = { "smoke" })
//	@Test(groups = { "dev" })
	public void test() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.verify();
		homePage.switchToRuLanguage();
		RegisterPage registerPage = homePage.signUp();
		registerPage.verify();
		registerPage.enterEmail(Utils.getUniqueNameForEmail() + "@mailinator.com");
		registerPage.enterPassword("password1");
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
		currentPage.verifyPrecenceOfMsg("������ ������� � ���� ���� �������� ���������.");
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
//		/////////////////////////
		currentPage.verifyPrecenceOfMsg("�����! ������ ������ '� ������!' � ������ ������ ������� �����!");
		SpacePage spacePage = dockPage.toSpace();
//		First tutorial quest 
		spacePage.waitForVelocity();
		currentPage.verifyPrecenceOfMsg("������ �������, ����� ������� ���� �������.");
		spacePage.zoomTheSpace();
		currentPage.verifyPrecenceOfMsg("������ �������� �� ������� ��������.");
		spacePage.continueTutorial();
		currentPage.verifyPrecenceOfMsg("���� ������� - ������� ����� ����������� �����.");
		spacePage.goToTheCheckPoint();
		currentPage.verifyPrecenceOfMsg("�������! �� �������� �������.");
		spacePage.continueTutorial();
//		Second tutorial quest
		currentPage.verifyPrecenceOfMsg("���� �������� �������.");
		spacePage.lookArround();
		currentPage.verifyPrecenceOfMsg("������� ����� ��� ����������� ����� �� ��������.");
		spacePage.goToTheCheckPoint();		
		spacePage.goToTheCheckPoint();
		currentPage.verifyPrecenceOfMsg("�� ��������� � ��������.");
		spacePage.continueTutorial();
//		Third tutorial
		currentPage.verifyPrecenceOfMsg("����� ������� �������� ��������� ��������� ������ ��� ����������� ������.");
		spacePage.launchTheMissileByPressKey1();
		currentPage.verifyPrecenceOfMsg("������ �� ������ ��������� ������������� �������.");
		spacePage.turnTheShip();
		currentPage.verifyPrecenceOfMsg("�������, ����� � �������� ���� ����� ����������� ���������� ������ ����������� ����� � ����� �����.");
		spacePage.LaunchMissileOnTarget();
		currentPage.verifyPrecenceOfMsg("����� �� ����������� �������. �� �� ������� ��������� �� ����� � �������.");
		spacePage.LaunchMissileOnTarget();
//		Fourth tutorial 
		currentPage.verifyPrecenceOfMsg("������ � ��� ������������ ��������� �������");
		spacePage.seeEnemyCharacteristics();
		spacePage.verifyPrecenceOfEnemyCharacteristics();
		currentPage.verifyPrecenceOfMsg("����� ������������ �������������� ����������. ��������, ��� �� ���, � �������� ���������.");
		spacePage.continueTutorial();
//		currentPage.verifyPrecenceOfMsg("����� ������� �����, ������� ������� � ������� ����������");
		spacePage.turnTheShipToTheEnemy();
		currentPage.verifyPrecenceOfMsg("�������, ����� � �������� ���� ����� ����������� ���������� ������ ���������� ������� � ����� �����.");
		spacePage.killEnemy();
		currentPage.verifyPrecenceOfMsg("��� �����! �� ��� ���������.");
		spacePage.continueTutorial();
//		Fifth tutorial
		currentPage.verifyPrecenceOfMsg("������� � ��� �����. �������� ���.");
		spacePage.seeEnemyCharacteristics();
		spacePage.killEnemy();
		currentPage.verifyPrecenceOfMsg("�� �������� ��������� �������.");
		spacePage.goToDock();
//		spacePage.goToOuterSpace();
//		spacePage.logOutFromSpace();		
	}
}
