package pl.friscotest.utils;

public class XPathPagesConstants {

    public static final class CartPageXPaths {
        public final static String SUBTRACT_PRODUCT_XPATH = "//parent::div[@class='products-by-category']//div[@class='cart-button_minus']";
        public final static String RECOMMENDED_PRODUCTS_XPATH = "//div[@class='cart-button_add button primary alone']";
        public final static String ADD_PRODUCTS_XPATH = "//parent::div[@class='products-by-category']//div[@class='cart-button_plus']";
        public final static String REMOVE_PRODUCTS_XPATH = "//div[@class='mini-product-box_remove']";
        public final static String UNDO_CHANGES_XPATH = "//a[@class='button-undo'and contains(text(),'Cofnij')]";
        public final static String CLOSE_POPUP_XPATH = "//a[@class='button-undo'and contains(text(),'Zamknij')]";
        public final static String SAVING_CHEVRON_XPATH = "//div[@class='icon-comp Chevron']";
    }

    public static final class AlertsPageXPaths {
        public final static String SAVING_COUNTER_TITLE_XPATH = "//div[@class='saving-counter_title']";

    }

    public static final class MainShopPageXPaths {
        public static final String ADD_RECOMMENDED_PRODUCTS_XPATH = "//div[@class='cart-button_add button primary alone']";
        public static final String CLEAR_SIDE_CART_XPATH = "//a[@class='cart-side-box_actions_clear-cart']";
        public static final String FRESH_SUBCAT_HOVER_XPATH = "//a[contains(text(),'Świeże')]";
        public static final String CHEVRON_EXPAND_XPATH = "//div[@class='saving-counter_chevron']/div[@class='icon-comp Chevron']";

    }

    public static final class LogInAndRegisterPageXPaths {
        public final static String ALL_CONSENTS_CHECKBOX_XPATH = "//span[@class='form-checkbox-n_label' and text()='Zaznacz wszystkie zgody']";
        public final static String ACCEPT_CONDITIONS_CHECKBOX_XPATH = "//input[@name='acceptRules']";
        public final static String NEWSLETTER_AGREEMENT_CHECKBOX_XPATH = "//input[@name='consents.39e67ff8-e8d5-475d-9744-d849b43bb21b']";
        public final static String PROMO_INFO_CHECKBOX_XPATH = "//input[@name='consents.39e67ff9-439a-481c-a9f7-fce40af3f394']";
        public final static String MAIL_NEWSLETTER_CHECKBOX_XPATH = "//input[@name='consents.39e67ff9-5886-4f42-ae11-e12d041b0ff6']";
        public final static String BOTTOM_BAR_TEXT_MESSAGE_XPATH = "//textarea[@class='_hj-AwaE7__styles__textarea _hj-EZqbk__styles__inputField _hj-P-UNr__styles__inputField  _hj-yr300__styles__dark']";
        public final static String PROCEED_BUTTON_BOTTOM_BAR_XPATH = "//button[@class='_hj-81Zzt__styles__surveyActionButton _hj-O-7CS__styles__surveysPrimaryButton _hj-SU8LU__styles__primaryButton']";
        public final static String EXPAND_BOTTOM_BAR = "//span[@class='_hj-BfLwc__styles__openStateToggleIcon _hj-mtJG6__styles__surveyIcons']";
    }

}
