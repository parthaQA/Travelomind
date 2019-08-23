package pageObjectConfiguation;

public class Configuration {


    //BookAflight page

    public static final String flight = "//*[@id=\"header\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]";
    public static final String los="//*[contains(text(),'Los Angeles (LAX)')";
    public static final String mia="//*[contains(text(),'Miami (MIA)')";
    public static final String select="//img[@src='../../../assets/select.png']";
    public static final String searchPageFare = "body > app-root > div > app-all-flights > div.boundaryCheck > div > div > div.row.noMargin.contentBar > div.noPadding.contentPanel > div.tabPanel > div > div > div:nth-child(2) > div.flightDtl.relative.cursor.cheapest > div.row.priceHeader > div.col-md-6 > span.finalPrice";

    //FlightList

    public static final String flightList= "ng-star-inserted";

    //FilterYourPreferences

    public static final String airport="collapseAirport";
    public static final String sameAirport= "sameairport";
    public static final String returnAirport= "//span[contains(text(),'Same Departing / Returning Airport')]";
    public static final String departingFrom = "//div[@id='collapseAirport']//div[3]";
    public static final String airlineName = "airlineName";
    public static final String arrivingAt = "//div[@id='collapseAirport']//div[4]";
    public static final String airlines = "//div[@id='collapseAirline']";
    public static final String airlineList = "airline";


    //HomePageLinks

    public static final String link = "link";
    public static final String anchor = "a";
    public static final String image = "img";


    //Itinerary

    public static final String firstName = "nm0";
    public static final String middleName = "//input[@type='text]'";
    public static final String lastName = "lm0";
    public static final String gender = "#gender0";
    public static final String countryCode = "contry";
    public static final String phoneNumber = "phn";
    public static final String email = "eml";
    public static final String cardNumber = "crdno1";
    public static final String cardHolderName = "nmeOnCd1";
    public static final String month = "month1";
    public static final String year = "year1";
    public static final String cvv = "cvv1";
    public static final String billCountry = "#cntry";
    public static final String billAddress = "billAddr";
    public static final String billCity = "cty";
    public static final String billState = "#st";
    public static final String zipCode = "zipCode";
    public static final String billPhNumber = "phnNumber";
    public static final String dateOfBirth = "dob0";
    public static final String selectYear = "//select[@title='Select year']";
    public static final String selectMonth = "//select[@title='Select month']";
    public static final String selectDay = "#traveller > div > form > div:nth-child(2) > div > div:nth-child(3) > div:nth-child(1) > div.input-group > ngb-datepicker > div.ngb-dp-months > div > ngb-datepicker-month-view > div:nth-child(4) > div:nth-child(4) > div";
    public static final String verifyAmt = "#traveller > div > form > div.row.ng-star-inserted > table > tbody > tr:nth-child(3) > td.ng-star-inserted";
    public static final String book = "//*[@id=\"traveller\"]/div/form/div[11]/div/button";
    public static final String error = "#traveller > div > form > div:nth-child(2) > div > div:nth-child(2) > div:nth-child(3) > div.inlineErrMgs.ng-star-inserted > span";


    //ModifySearch


    public static final String imagewait = "//div[contains(@class,'noMargin headerBar relative')]//img[contains(@class,'callImage')]";
    public static final String radio = "//div[@id='round_trip']";
    public static final String rButtons = "input";
    public static final String oneWayButton = "//div[@id='round_trip']//input[1]";
    public static final String roundTripButton = "//body//input[2]";
    public static final String origin = "//input[contains(@placeholder,'Origin')]";
    public static final String originTmenu = "//div[@id='traveller_menu']";
    public static final String originAirpot = "//div[contains(@class,'filterSidePanel')]//div[contains(@class,'row')]//div[2]//div[1]//span[3]";
    public static final String destination = "//input[contains(@placeholder,'Destination')]";
    public static final String destionationTmenu = "//div[@id='traveller_menu2']";
    public static final String depart = "//input[@placeholder='Depart']";
    public static final String retrn = "//input[contains(@placeholder,'Return')]";
    public static final String modifyMonth = "//select[@title='Select month']";
    public static final String modifyYear = "//select[@title='Select year']";
    public static final String date = "//div[@class='btn-light ng-star-inserted'][contains(text(),'28')]";
    public static final String returnjourneydate = "//ngb-datepicker-navigation-select[contains(@class,'ngb-dp-navigation-select')]";
    public static final String retrnMonth = "div.container-fluid.noPaddingOnMobile div.boundaryCheck:nth-child(1) div.container-fluid.noPadding div.containerClass div.row.noMargin.contentBar:nth-child(4) div.noPadding.filterSidePanel:nth-child(2) div.filterWrapper form.ng-valid.ng-dirty.ng-touched div.row.mt-3:nth-child(3) div.col-sm-6.col-md-6:nth-child(2) div.input-group ngb-datepicker.dropdown-menu.show div.ngb-dp-header.bg-light ngb-datepicker-navigation:nth-child(1) ngb-datepicker-navigation-select.ngb-dp-navigation-select:nth-child(2) > select.custom-select:nth-child(1)";
    public static final String retrnYear = "div.container-fluid.noPaddingOnMobile div.boundaryCheck:nth-child(1) div.container-fluid.noPadding div.containerClass div.row.noMargin.contentBar:nth-child(4) div.noPadding.filterSidePanel:nth-child(2) div.filterWrapper form.ng-valid.ng-dirty.ng-touched div.row.mt-3:nth-child(3) div.col-sm-6.col-md-6:nth-child(2) div.input-group ngb-datepicker.dropdown-menu.show div.ngb-dp-header.bg-light ngb-datepicker-navigation:nth-child(1) ngb-datepicker-navigation-select.ngb-dp-navigation-select:nth-child(2) > select.custom-select:nth-child(2)";
    public static final String retrnDate = "//div[@class='btn-light ng-star-inserted'][contains(text(),'30')]";
    public static final String searchOnline = "//button[contains(text(),'Search Online')]";
    public static final String allResult ="//span[contains(text(),'All Results')]";





    //VoiceOfCustomer

    public static final String voc = "//*[@id=\"navbar\"]/div[7]/span";
    public static final String americanAir = "//*[@id=\"reviewContainer\"]/div/div[2]/div[2]/p";
    public static final String forwardArrow = "//*[@id=\"domestic\"]/img[2]";

}
