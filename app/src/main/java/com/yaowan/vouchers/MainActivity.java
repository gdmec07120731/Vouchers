package com.yaowan.vouchers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SimpleAdapter mSimpleAdapter;
    ArrayList<SparseArray<String>> mList;

    ArrayList<String> sList1;
    ArrayList<String> sList2;
    String str = "{\n" +
            "    \"resultcode\": 200,\n" +
            "    \"message\": \"查询成功！\",\n" +
            "    \"prepayFlag\": null,\n" +
            "    \"page\": 2,\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"vouchers\": [\n" +
            "                {\n" +
            "                    \"useNum\": 3,\n" +
            "                    \"pNum\": 10,\n" +
            "                    \"isHad\": 0,\n" +
            "                    \"picUrl\": \"/uploads/vouchers/2016/03/02/10/6985562b-f0e7-46bf-a755-ed830b3a6fe8.png\",\n" +
            "                    \"vouchersId\": 11\n" +
            "                },\n" +
            "                {\n" +
            "                    \"useNum\": 3,\n" +
            "                    \"pNum\": 5,\n" +
            "                    \"isHad\": 0,\n" +
            "                    \"picUrl\": \"/uploads/vouchers/2016/03/02/10/49a4a8de-28e4-4033-81db-ed94e80b9226.png\",\n" +
            "                    \"vouchersId\": 12\n" +
            "                },\n" +
            "                {\n" +
            "                    \"useNum\": 3,\n" +
            "                    \"pNum\": 5,\n" +
            "                    \"isHad\": 0,\n" +
            "                    \"picUrl\": \"/uploads/vouchers/2016/03/02/10/a29ace73-4c91-49a8-8881-62721e0ec1dd.png\",\n" +
            "                    \"vouchersId\": 13\n" +
            "                },\n" +
            "                {\n" +
            "                    \"useNum\": 3,\n" +
            "                    \"pNum\": 50,\n" +
            "                    \"isHad\": 0,\n" +
            "                    \"picUrl\": \"/uploads/vouchers/2016/03/02/10/bfa600d3-8b8f-42c6-ab4f-97f9d7a98934.png\",\n" +
            "                    \"vouchersId\": 14\n" +
            "                },\n" +
            "                {\n" +
            "                    \"useNum\": 0,\n" +
            "                    \"pNum\": 132,\n" +
            "                    \"isHad\": 0,\n" +
            "                    \"picUrl\": \"/uploads/vouchers/2016/03/07/17/67f3b555-2694-4e23-8bf2-370547430449.png\",\n" +
            "                    \"vouchersId\": 16\n" +
            "                }\n" +
            "            ],\n" +
            "            \"entId\": 31,\n" +
            "            \"shopName\": \"会吃店铺\",\n" +
            "            \"logoUrl\": \"/uploads/profile/2016/01/11/09/b3939abb-61b6-4075-a890-1a391a23813a.png\",\n" +
            "            \"focus\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"vouchers\": [\n" +
            "                {\n" +
            "                    \"useNum\": 3,\n" +
            "                    \"pNum\": 20,\n" +
            "                    \"isHad\": 0,\n" +
            "                    \"picUrl\": \"/uploads/vouchers/2016/03/02/14/a3d7b2ee-64e4-4dfc-bf90-e9eb31525085.png\",\n" +
            "                    \"vouchersId\": 15\n" +
            "                }\n" +
            "            ],\n" +
            "            \"entId\": 28,\n" +
            "            \"shopName\": \"会玩\",\n" +
            "            \"logoUrl\": \"/uploads/profile/2016/01/11/09/b3939abb-61b6-4075-a890-1a391a23813a.png\",\n" +
            "            \"focus\": 0\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        mList = new ArrayList<>();
        sList1 = new ArrayList<>();
        sList2 = new ArrayList<>();
        try {
            JSONObject a = new JSONObject(str);
            JSONArray b = a.getJSONArray("data");
            for (int i = 0; i < b.length(); i++) {
                JSONObject c = b.getJSONObject(i);
                JSONArray d = c.getJSONArray("vouchers");
                SparseArray slist = new SparseArray<>();
                Log.i("picUrl",b.length()+"");
                for (int j = 0; j < d.length(); j++) {
                    JSONObject e = d.getJSONObject(j);

                    slist.put(j,e.getString("picUrl"));
                   Log.i("picUrl",e.getString("picUrl"));
                    Log.i("picUrl",".");

                }
                mList.add(slist);
            }


            for (int i = 0; i < mList.size(); i++) {
                for (int j = 0; j < mList.get(i).size(); j++) {
                    Log.d("list", mList.get(i).get(j).toString());
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        mSimpleAdapter = new SimpleAdapter(MainActivity.this, mList);
        listView.setAdapter(mSimpleAdapter);


    }
}
