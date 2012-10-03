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
		currentPage.verifyPrecenceOfMsg("Напиши свое имя, под которым тебя будут знать другие.");
		dockPage.enterCharacterName("Test_" + Utils.getUniqueUserName());
		currentPage.verifyPrecenceOfMsg("Следи за зонами! Здесь видно сколько пилотов в космосе!");
		dockPage.nextTutorial();
		currentPage.verifyPrecenceOfMsg("Деньги – важная часть карьеры пилота! Пройди обучение и заработай серебро на свои первые покупки.");
		dockPage.nextTutorial();
		currentPage.verifyPrecenceOfMsg("С помощью опыта можно открывать и покупать новое оружие в магазине!");
		dockPage.nextTutorial();
		currentPage.verifyPrecenceOfMsg("Пилот! Теперь нужно укомплектовать корабль!");
		dockPage.nextTutorial();		
		currentPage.verifyPrecenceOfMsg("Открой Магазин и купи одну Ракетную установку.");
		ShopComponent shopComponent =  dockPage.openShop();
		currentPage.verifyPrecenceOfMsg("Выбери категорию 'Орудия и пусковые установки'.");
		shopComponent.openTurretsAndLaunchers();
		currentPage.verifyPrecenceOfMsg("Выбери категорию 'Ракетные пусковые установки'.");
		shopComponent.openMissileLaunchers();
		currentPage.verifyPrecenceOfMsg("Выбери и купи Ракетную установку. Любое оборудование первого уровня - бесплатно.");
		shopComponent.selectMissileLauncherL1();
		currentPage.verifyPrecenceOfMsg("Нажми эту кнопку, чтобы купить одну Ракетную установку.");
		shopComponent.buyItem();
		currentPage.verifyPrecenceOfMsg("Каждая покупка требует твоего подтверждения.");
		shopComponent.confirmBuying();
		currentPage.verifyPrecenceOfMsg("Выбери категорию 'Боеприпасы и заряды'.");
		shopComponent.openAmmunitionAndProjectiles();
		currentPage.verifyPrecenceOfMsg("Выбери категорию 'Ракеты и торпеды'.");
		shopComponent.openMissilesAndTorpedoes();
		currentPage.verifyPrecenceOfMsg("Любые заряды стоят денег. Используй их с умом.");
		shopComponent.selectRocketL1();
		currentPage.verifyPrecenceOfMsg("Чем дороже оружие ты выбрал, тем круче урон ты можешь нанести.");
		shopComponent.buyItem();
		currentPage.verifyPrecenceOfMsg("Наконец то ты закончил свой шоппинг. Теперь давай оборудуем твой первый корабль.");
		shopComponent.confirmBuying();
		currentPage.verifyPrecenceOfMsg("Теперь давай установим оружие в наш корабль. Открой Конфигуратор и найди блок 'Склад'!");
		ConfiguratorComponent configuratorComponent =  dockPage.openConfigurator();
		currentPage.verifyPrecenceOfMsg("Кликни дважды на 'Ракетная установка t.Co l1' чтобы установить в слот Вооружение.");
		configuratorComponent.selectMissileLauncher();
		currentPage.verifyPrecenceOfMsg("Перетяни 'Ракета l1' в слот Вооружение.");
		configuratorComponent.equipRocketL1();
//		/////////////////////////
		currentPage.verifyPrecenceOfMsg("Пилот! Кликай кнопку 'В космос!' и сделай первый учебный вылет!");
		SpacePage spacePage = dockPage.toSpace();
//		First tutorial quest 
		spacePage.waitForVelocity();
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
		currentPage.verifyPrecenceOfMsg("Похоже к нам приближается вражеский корабль");
		spacePage.seeEnemyCharacteristics();
		spacePage.verifyPrecenceOfEnemyCharacteristics();
		currentPage.verifyPrecenceOfMsg("Слева отображаются характеристики противника. Слабоват, как по мне, и медленно двигается.");
		spacePage.continueTutorial();
//		currentPage.verifyPrecenceOfMsg("Чтобы открыть огонь, поверни корабль в сторону противника");
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
		spacePage.goToDock();
//		spacePage.goToOuterSpace();
//		spacePage.logOutFromSpace();		
	}
}
