package a;

public class BlueDrug extends Drug {
    private int addMagic;

    public BlueDrug(String size) {
        super(size);

        switch (size) {
            case "Large":
                addMagic = 100;
                break;
            case "Medium":
                addMagic = 60;
                break;
            case "Small":
                addMagic = 30;
                break;
            default:
                throw new IllegalArgumentException("藥水大小錯誤");
        }
    }

    public int getAddMagic() {
        return addMagic;
    }
}
