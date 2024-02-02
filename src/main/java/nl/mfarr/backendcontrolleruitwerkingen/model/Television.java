package nl.mfarr.backendcontrolleruitwerkingen.model;

public class Television {

    private Long id;
    private String type;
    private String name;
    private String brand;
    private int price;
    private int[] availableSizes;
    private int refreshRate;
    private String screenType;
    private String screenQuality;
    private boolean smartTv;
    private String sourceImg;
    public class Option {
        private String name;
        private boolean applicable;

        public Option(String name, boolean applicable) {
            this.name = name;
            this.applicable = applicable;
        }

        public String getName() {
            return name;
        }

        public boolean isApplicable() {
            return applicable;
        }

    }


    private int originalStock;
    private int sold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int[] getAvailableSizes() {
        return availableSizes;
    }

    public void setAvailableSizes(int[] availableSizes) {
        this.availableSizes = availableSizes;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }

    public String getSourceImg() {
        return sourceImg;
    }

    public void setSourceImg(String sourceImg) {
        this.sourceImg = sourceImg;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }


}
