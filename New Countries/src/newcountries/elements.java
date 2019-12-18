package newcountries;
public  class elements {
	
	static  String  search = "//input[@name='q']";
	static String clickonSaerchButton ="//form[@id='search-form']//button[@type='submit']";
	static String SelectProducts = "//div[@class='body-content clearfix']//div[@class='row']//div[1]//div[1]//div[1]//a[1]//img[1]";
//	static String AddToCart  ="//form[@id='product_addtocart_form']/div[4]/button";
	static String AddToCart  ="//*[@class='add-to-cart-btn add-to-cart-button' or @id='add-to-cart-btn']";
	 //String AddToCart  ="//*[@id='add-to-cart-btn' and @class='add-to-cart-btn']";
	static String PopUp=".//*[@class='view-cart-and-checkout']";
	 static String ProceedToCheckOut ="//div[@class='totals']//ul[@class='checkout-types']//li//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]";
	 static String UserName =".//*[@id='login-email']";
	 static String Password =".//*[@id='login-password']";
	 static String LoginButton = ".//*[@id='login-form']/div/button";
	 static String NewAdress ="//label[contains(text(),'New Address')]";
	// String NewAdress ="//*[@class='address-select input-rdo' and @id='addr_id_']";
	 	 static String FirstNAme=".//*[@id='billing:firstname']";
	 static String LAstName =".//*[@id='billing:lastname']";
	 static String TelephoneNumber ="//input[@id='billing:telephone']";
	 
	 static String State ="//select[@id='billing:region']";
	 
	 static String state1 ="//select[@id='billing:city']";
	 
	 static String City ="//input[@id='billing:city']";
	 
	 static String House ="//input[@id='billing:address_house_no']";
	 static String Street ="//input[@id='billing:address_street']";
	 static String Zip ="//input[@id='billing:postcode']";
	 static String ContinueButton =".//*[@id='billing_save_button']";
	 
	 static String ShippingSelect ="//label[contains(text(),'Ubuy Super Express 3-6 Business days (Customs dela')]";
	 static String ContinueFromShipping ="//div[@id='shipping-method-buttons-container']//button[@class='next_btn'][contains(text(),'Continue')]";
	 
	 static String VisaMAsterCard ="//body/div/main/section[@class='container-lg']/div[@class='cell checkout']/div[@class='canvas']/div[@id='opc-payment']/div[@class='payment-information a-item']/div[@id='step-form-payment']/form[@id='co-payment-form']/fieldset/ul[@id='checkout-payment-method-load']/li[3]/label[1] ";
	 static String CardType =".//*[@id='cybersecure_cc_type']";
	 static String cardtypeStrip="//div[@id='cryozonic-stripe-card-number']";
	 static String CardNumber =".//*[@id='cybersecure_cc_number']";
	 static String ExpiryMonth =".//*[@id='cybersecure_expiration']";
	 static String ExpiryYear =".//*[@id='cybersecure_expiration_yr']";
	 static String CardVerificationNumber =".//*[@id='cybersecure_cc_cid']";
	 static String ContinueFromPaymentOption ="//div[@id='payment-buttons-container']//button[@class='next_btn'][contains(text(),'Continue')]";	 
	 static String PlaceOrderFinal ="//button[contains(text(),'Place Order')]";

}





/*package retriveURL;
public  class Elements_Locaters {
	
	static  String  search = "//input[@name='q']";
	static String clickonSaerchButton ="//form[@id='search-form']//button[@type='submit']";
	static String SelectProducts = "//body/div[@class='section search-content']/div[@class='container-fluid']/div[@class='row']/div[@id='usstore-product-block-section']/div[@id='store']/div[@id='usstore-products']/div[1]";
//	static String AddToCart  ="//form[@id='product_addtocart_form']/div[4]/button";
	static String AddToCart  ="//*[@class='add-to-cart-btn add-to-cart-button' or @id='add-to-cart-btn']";
	 //String AddToCart  ="//*[@id='add-to-cart-btn' and @class='add-to-cart-btn']";
	static String PopUp=".//*[@class='view-cart-and-checkout']";
	 static String ProceedToCheckOut ="//div[@class='totals']//ul[@class='checkout-types']//li//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]";
	 static String UserName =".//*[@id='login-email']";
	 static String Password =".//*[@id='login-password']";
	 static String LoginButton = ".//*[@id='login-form']/div/button";
	 static String NewAdress ="//label[contains(text(),'New Address')]";
	// String NewAdress ="//*[@class='address-select input-rdo' and @id='addr_id_']";
	 	 static String FirstNAme=".//*[@id='billing:firstname']";
	 static String LAstName =".//*[@id='billing:lastname']";
	 static String TelephoneNumber ="//input[@id='billing:telephone']";
	 
	 static String State ="//select[@id='billing:region']";
	 
	 
	 
	 static String state1 =" //select[@id='billing:city']";
	 
	 
	 
	 static String City ="//input[@id='billing:city']";
	 
	 static String House ="//input[@id='billing:address_house_no']";
	 static String Street ="//input[@id='billing:address_street']";
	 
	 static String Zip ="//input[@id='billing:postcode']";
	 
	 static String ContinueButton =".//*[@id='billing_save_button']";
	 
	 static String ShippingSelect ="//label[contains(text(),'Ubuy Super Express 3-6 Business days (Customs dela')]";
	 static String ContinueFromShipping ="//div[@id='shipping-method-buttons-container']//button[@class='next_btn'][contains(text(),'Continue')]";
	 
	 static String VisaMAsterCard ="//body/div/main/section[@class='container-lg']/div[@class='cell checkout']/div[@class='canvas']/div[@id='opc-payment']/div[@class='payment-information a-item']/div[@id='step-form-payment']/form[@id='co-payment-form']/fieldset/ul[@id='checkout-payment-method-load']/li[1]/label[1]  ";
	 static String CardType =".//*[@id='cybersecure_cc_type']";
	 static String CardNumber =".//*[@id='cybersecure_cc_number']";
	 static String ExpiryMonth =".//*[@id='cybersecure_expiration']";
	 static String ExpiryYear =".//*[@id='cybersecure_expiration_yr']";
	 static String CardVerificationNumber =".//*[@id='cybersecure_cc_cid']";
	 static String ContinueFromPaymentOption ="//div[@id='payment-buttons-container']//button[@class='next_btn'][contains(text(),'Continue')]";	 
	 static String PlaceOrderFinal ="//button[contains(text(),'Place Order')]";

}
*/