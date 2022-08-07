package Processes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Screens.Catalog;
import Screens.DeliveryInformation;
import Screens.OrderConfirmation;
import Screens.OrderProcessed;
import Screens.PaymentInformation;
import Screens.ProductSheet;
import Screens.ShoppingCart;
import Screens.SignIn;

public class Process {
	
	private static final Duration ESPERA = Duration.ofSeconds(10);
	private WebDriverWait wait;
	private WebDriver driver;
	
	public Catalog catalog;
	public ProductSheet productSheet;
	public ShoppingCart shoppinCart;
	public SignIn signIn;
	public DeliveryInformation deliveryInformation;
	public PaymentInformation paymentInformation;
	public OrderConfirmation orderConfirmation;
	public OrderProcessed orderProcessed;
	
	public Process(WebDriver driver) {
		this.driver=driver;
		
		catalog = new Catalog(driver);
		productSheet = new ProductSheet(driver);
		shoppinCart = new ShoppingCart(driver);
		signIn = new SignIn(driver);
		deliveryInformation = new DeliveryInformation(driver);
		paymentInformation = new PaymentInformation(driver);
		orderConfirmation = new OrderConfirmation(driver);
		orderProcessed = new OrderProcessed(driver);
		
		wait = new WebDriverWait(driver, ESPERA);
	}
	
	public void enterSite(String url) {
		driver.get(url);
	}
	
	public void selectProduct(String product) {
		if(product.equals("Samsung")) {
			catalog.clickSamsungGalaxyTab(wait);
		}
		if (product.equals("Beloved")) {
			catalog.clickBeloved(wait);
		}
	}
	
	public void updateQuantity(String quantity) {
		shoppinCart.updateQuantity(wait, quantity);
		shoppinCart.clickCheckout(wait);
	}
	
	public void addToCart() {
		productSheet.addToCart(wait);
	}
	
	public void signInProcess() {
		signIn.enterUserCredentials(wait, "firstname.lastname@domain.com", "pr2#@10Kfkf!08IBGqk$%oi@p&");
		deliveryInformation.clickContinue(wait);
	}
	
	public void processOrderAndConfirm() {
		paymentInformation.selectPaymentMethod(wait);
		orderConfirmation.orderPayment(wait);
		orderProcessed.verifyOrder(wait, "Your Order Has Been Processed!");
	}

}
