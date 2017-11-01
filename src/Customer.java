public class Customer
{
    private String phoneNum;
    private String name;
    private String address;
    private String chargeType;
    private String specialInfo;

    public Customer(String phoneNum, String name, String address, String chargeType, String specialInfo)
    {
        this.phoneNum = phoneNum;
        this.name = name;
        this.address = address;
        this.chargeType = chargeType;
        this.specialInfo = specialInfo;
    }

    public String getPhoneNum()
    {
        return phoneNum;
    }

    public String getName()
    {
        return name;
    }

    public String getChargeType()
    {
        return chargeType;
    }

    public String getAddress()
    {
        return address;
    }

    public String getSpecialInfo()
    {
        return specialInfo;
    }

    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setChargeType(String chargeType)
    {
        this.chargeType = chargeType;
    }

    public void setSpecialInfo(String specialInfo)
    {
        this.specialInfo = specialInfo;
    }
}
