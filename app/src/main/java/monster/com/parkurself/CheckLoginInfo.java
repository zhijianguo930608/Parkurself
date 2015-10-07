package monster.com.parkurself;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

/**
 * Created by Administrator on 10/5/2015.
 */
public class CheckLoginInfo extends AsyncTask< LoginInfo, Void, Boolean>{

    private String account;
    private boolean queryResult;
    private String password;
    private AmazonDynamoDBClient ddbClient=null;
    private DynamoDBMapper mapper;
    private Login result=new Login();

    public void initDynamoDB(){
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                MyApplication.getContext(),
                "us-east-1:e1c66782-98f1-47bb-a462-d309657ef305",// Identity Pool ID
                Regions.US_EAST_1 // Region
        );
        ddbClient=new AmazonDynamoDBClient(credentialsProvider);
        mapper=new DynamoDBMapper(ddbClient);
    }

    @Override
    protected Boolean doInBackground(LoginInfo... params) {
        initDynamoDB();
        account=params[0].account;
        password=params[0].password;
        Log.d("Parkurself", "The name parameter is" + account);
        Log.d("Parkurself", "The password parameter is" + password);
        result=mapper.load(result.getClass(),account,password);
        if(result==null){
            queryResult=false;
            Log.d("Parkurself","Info is incorrect");
        }else{
            queryResult=true;
            Log.d("Parkurself","Info is correct");
        }
        return queryResult;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if(aBoolean==true){
            Log.d("Parkurself", "Login is successful");
            Toast.makeText(MyApplication.getContext(),"Login is successfull",Toast.LENGTH_LONG).show();
        }else{
            Log.d("Parkurself", "Login is unsuccessful");
            Toast.makeText(MyApplication.getContext(),"Login is unsuccessfull",Toast.LENGTH_LONG).show();
        }
        return;
    }
}
