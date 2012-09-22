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
		currentPage.verifyPrecenceOfMsg("Открой Магазин и купи одну Ракетную установку.# Награда: 500 серебра!");
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
		currentPage.verifyPrecenceOfMsg("Пилот! Кликай кнопку 'В космос!' и сделай первый учебный вылет!");
		dockPage.toSpace();
		currentPage.verifyPrecenceOfMsg("На твой почтовый ящик было отправлено письмо для активации аккаунта. Начни играть - перейди по ссылке в письме!");
	}
}
