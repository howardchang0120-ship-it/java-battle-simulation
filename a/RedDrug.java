package a;

public class RedDrug extends Drug {
    private int addLife;

    public RedDrug(String size) {
        super(size);

        switch (size) {
            case "Large":
                addLife = 120;
                break;
            case "Medium":
                addLife = 80;
                break;
            case "Small":
                addLife = 50;
                break;
            default:
                throw new IllegalArgumentException("藥水大小錯誤");
        }
    }

    public int getAddLife() {
        return addLife;
    }
}
