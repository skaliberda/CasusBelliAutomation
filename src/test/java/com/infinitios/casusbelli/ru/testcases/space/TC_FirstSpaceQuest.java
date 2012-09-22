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
		currentPage.verifyPrecenceOfMsg("Пилот! Кликай кнопку 'В космос!' и сделай первый учебный вылет!");
		SpacePage spacePage = dockPage.toSpace();
//		First tutorial quest            
		currentPage.verifyPrecenceOfMsg("Измени масштаб, чтобы увидеть весь полигон.");
		spacePage.zoomTheSpace();
		currentPage.verifyPrecenceOfMsg("Обрати внимание на размеры полигона.");
		spacePage.continueTutorial();
		currentPage.verifyPrecenceOfMsg("Твое задание - пролети через контрольную точку.");
		spacePage.goToTheCheckPoint();
		currentPage.verifyPrecenceOfMsg("Отлично! Ты выполнил задание.");
		spacePage.continueTutorial();
//		Second tutorial quest
		currentPage.verifyPrecenceOfMsg("Пару полезных советов.");
		spacePage.lookArround();
		currentPage.verifyPrecenceOfMsg("Пролети через все контрольные точки на полигоне.");
		spacePage.goToTheCheckPoint();		
		spacePage.goToTheCheckPoint();
		currentPage.verifyPrecenceOfMsg("Ты справился с заданием.");
		spacePage.continueTutorial();
//		Third tutorial
		currentPage.verifyPrecenceOfMsg("После каждого выстрела требуется несколько секунд для перезарядки орудий.");
		spacePage.launchTheMissileByPressKey1();
		currentPage.verifyPrecenceOfMsg("Теперь ты должен научиться разворачивать корабль.");
		spacePage.turnTheShip();
		currentPage.verifyPrecenceOfMsg("Стреляй, когда я подсвечу тебе точку пересечения траекторий полета контрольной точки и твоих ракет.");
		spacePage.LaunchMissileOnTarget();
		currentPage.verifyPrecenceOfMsg("Следи за количеством зарядов. Ты не сможешь пополнить их запас в космосе.");
		spacePage.LaunchMissileOnTarget();
//		Fourth tutorial 
		currentPage.verifyPrecenceOfMsg("Щелкни по нему, чтобы увидеть его характеристики и траекторию полета.");
		spacePage.seeEnemyCharacteristics();
		spacePage.verifyPrecenceOfEnemyCharacteristics();
		currentPage.verifyPrecenceOfMsg("Слева отображаются характеристики противника. Слабоват, как по мне, и медленно двигается.");
		spacePage.continueTutorial();
		currentPage.verifyPrecenceOfMsg("Чтобы открыть огонь, поверни корабль в сторону противника");
		spacePage.turnTheShipToTheEnemy();
		currentPage.verifyPrecenceOfMsg("Стреляй, когда я подсвечу тебе точку пересечения траекторий полета вражеского корабля и твоих ракет.");
		spacePage.killEnemy();
		currentPage.verifyPrecenceOfMsg("Все чисто! Ты его уничтожил.");
		spacePage.continueTutorial();
//		Fifth tutorial
		currentPage.verifyPrecenceOfMsg("Кажется у нас гость. Уничтожь его.");
		spacePage.seeEnemyCharacteristics();
		spacePage.killEnemy();
		currentPage.verifyPrecenceOfMsg("Ты выполнил последнее задание.");
		spacePage.goToOuterSpace();
		spacePage.logOutFromSpace();		
	}
}