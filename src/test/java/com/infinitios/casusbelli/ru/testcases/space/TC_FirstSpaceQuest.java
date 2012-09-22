package com.infinitios.casusbelli.ru.testcases.space;

import org.testng.annotations.Test;

import com.infinitios.casusbelli.core.TestCase;
import com.infinitios.casusbelli.web.structure.ru.pages.*;

public class TC_FirstSpaceQuest extends TestCase {

//	@Test(groups = { "dev" })
	public void test() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.verify();
		homePage.login("oypu@mailinator.com", "password1");
		homePage.switchToRuLanguage();
		DockPage dockPage = homePage.play();
		currentPage.verifyPrecenceOfMsg("�����! ������ ������ '� ������!' � ������ ������ ������� �����!");
		SpacePage spacePage = dockPage.toSpace();
//		First tutorial quest            
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
		currentPage.verifyPrecenceOfMsg("������ �� ����, ����� ������� ��� �������������� � ���������� ������.");
		spacePage.seeEnemyCharacteristics();
		spacePage.verifyPrecenceOfEnemyCharacteristics();
		currentPage.verifyPrecenceOfMsg("����� ������������ �������������� ����������. ��������, ��� �� ���, � �������� ���������.");
		spacePage.continueTutorial();
		currentPage.verifyPrecenceOfMsg("����� ������� �����, ������� ������� � ������� ����������");
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
		spacePage.goToOuterSpace();
		spacePage.logOutFromSpace();		
	}
}