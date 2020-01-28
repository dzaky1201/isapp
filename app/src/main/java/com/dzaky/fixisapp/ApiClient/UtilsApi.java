package com.dzaky.fixisapp.ApiClient;

import com.dzaky.fixisapp.apihelper.BaseApiService;
import com.dzaky.fixisapp.Adapter.RetrofitClient;

public class UtilsApi {
    // 10.0.2.2 ini adalah localhost.
    public static final String BASE_URL_API = "https://api.dzakyhdr.com/isapp/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
