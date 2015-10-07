package monster.com.parkurself;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by Administrator on 10/7/2015.
 */

@DynamoDBTable(tableName = "LoginInfo")
public class Login{
    private String Name;
    private String Password;
    @DynamoDBHashKey(attributeName = "Name")
    public String getName(){
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
    @DynamoDBRangeKey(attributeName = "Password")
    public String getPassword(){
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}
