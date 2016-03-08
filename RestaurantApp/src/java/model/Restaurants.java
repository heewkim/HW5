
package model;

/**
 *
 * @author Kim
 */
public class Restaurants {
    private int resID;
    private String resName;
    private String resPhonenumber;
    private String resAddress;
    private String resSigMenu;

    public Restaurants() {
        this.resID = 0;
        this.resName = "";
        this.resPhonenumber = "";
        this.resAddress = "";
        this.resSigMenu = "";
    }
     public Restaurants(int resID, String resName, String resPhonenumber, String resAddress, String resSigMenu) {
        this.resID = resID;
        this.resName = resName;
        this.resPhonenumber = resPhonenumber;
        this.resAddress = resAddress;
        this.resSigMenu = resSigMenu;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResPhonenumber() {
        return resPhonenumber;
    }

    public void setResPhonenumber(String resPhonenumber) {
        this.resPhonenumber = resPhonenumber;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }

    public String getResSigMenu() {
        return resSigMenu;
    }

    public void setResSigMenu(String resSigMenu) {
        this.resSigMenu = resSigMenu;
    }

    @Override
    public String toString() {
        return "Restaurants{" + "resID=" + resID + ", resName=" + resName + ", resPhonenumber=" + resPhonenumber + ", resAddress=" + resAddress + ", resSigMenu=" + resSigMenu + '}';
    }
    
    
     
     
     
     
}
