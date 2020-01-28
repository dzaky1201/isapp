package com.dzaky.isapp.ApiClient;

import com.dzaky.isapp.Adapter.RetrofitClient;
import com.dzaky.isapp.apihelper.BaseApiService;

public class UtilsApi {
    // 10.0.2.2 ini adalah localhost.
    public static final String BASE_URL_API = "https://api.dzakyhdr.com/isapp/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
