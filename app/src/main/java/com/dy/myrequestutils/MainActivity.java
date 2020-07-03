package com.dy.myrequestutils;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vise.xsnow.base.MyCallBackInterface;
import com.vise.xsnow.base.MyCallBackListener;
import com.vise.xsnow.common.ViseConfig;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;
import com.vise.xsnow.http.callback.UCallback;
import com.vise.xsnow.http.config.HttpGlobalConfig;
import com.vise.xsnow.http.exception.ApiException;
import com.vise.xsnow.http.exception.IBaseRequestErroLitener;
import com.vise.xsnow.http.mode.DownProgress;
import com.vise.xsnow.permission.OnPermissionCallback;
import com.vise.xsnow.permission.PermissionManager;

import java.io.File;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button bt;
    private Button btUpload;
    private Button btGet;
    private Button btDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionManager.instance().request(this, new OnPermissionCallback() {
            @Override
            public void onRequestAllow(String permissionName) {
                showTs( "权限请求"+
                        "成功获取了权限："+ "\n" + permissionName);
            }

            @Override
            public void onRequestRefuse(String permissionName) {
                showTs( "权限请求"+
                        "权限被拒绝："+ "\n" + permissionName);
            }

            @Override
            public void onRequestNoAsk(String permissionName) {
                showTs("权限请求"+
                        "权限无法获取："+ "\n" + permissionName);
            }
        }, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);
        bt = (Button) findViewById(R.id.bt);
        btUpload = (Button) findViewById(R.id.bt_upload);
        btGet = (Button) findViewById(R.id.bt_get);
        btDown = (Button) findViewById(R.id.bt_down);
        initHttpRequest();
        ViseHttp.CONFIG().setNeedShowLoading(true);
        ViseHttp.CONFIG().setOnRequestWatingDialogListener(new HttpGlobalConfig.OnRequestWatingDialogListener() {
            @Override
            public void onTimeOverToShowLoading() {
                Log.v("测试","此时应该显示转圈圈");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showTs("此时应该显示转圈圈");
                    }
                });

            }

            @Override
            public void onRequestOverLoadingNeedClose() {
                Log.w("测试","此时应该关闭转圈圈");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showTs("此时应该关闭转圈圈");
                    }
                });

            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViseHttp.POST("api/tourist_login")
                        .tag(getClass().getSimpleName())
                        .addParam("source", "android")
                        .request(new ACallback<TokenInfo>() {
                            @Override
                            public void onSuccess(TokenInfo data) {
                                showTs( "操作成功"+data.toString());
                                String token=data.getData().getAccess_token();
                                HashMap<String,String> maps=new HashMap<>();
                                maps.put("Authorization",  data.getData().getToken_type()+" "+token);
                                ViseHttp.CONFIG().globalHeaders(maps);
                            }

                            @Override
                            public void onFail(int errCode, String errMsg) {
                                showTs( "操作失败"+errMsg);
                            }
                        });
            }
        });

        btUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String dirName = ViseConfig.DEFAULT_DOWNLOAD_DIR;
                 String fileName = "莲银aa.jpg";
                String rootName = getDiskCachePath(ViseHttp.getContext());
                File file = new File(rootName + File.separator + dirName + File.separator + fileName);
                ViseHttp.UPLOAD("api/admin/common/upload",new UCallback(){
                    @Override
                    public void onProgress(long currentLength, long totalLength, float percent) {
                        Log.i(ViseHttp.CONFIG().getTag(), "正在上传:"+currentLength+"/"+totalLength+","+percent+"%");
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        Log.e(ViseHttp.CONFIG().getTag(), "上传失败了！");
                    }
                }).addParam("filename",file.getName())
                        .addFile("file", file).request(new ACallback<BaseOkInfo>() {
                    @Override
                    public void onSuccess(BaseOkInfo data) {
                        Log.i(ViseHttp.CONFIG().getTag(), "上传成功了！");
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        Log.i(ViseHttp.CONFIG().getTag(), "上传失败了！");
                    }
                });



            }
        });
        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //可以自己设置IView回调，IView继承接口MyCallBackImp<T>
                ViseHttp.GET("api/module/app_module")
                        .tag(getClass().getSimpleName())
                        .request(new MyCallBackListener(new MyCallBackInterface<AppModuleInfo>() {
                            @Override
                            public void onRequestSuccess(AppModuleInfo data) {
//                                showTs("获取结果成功");
                            }

                            @Override
                            public void onRequestFail(int errCode, String errMsg) {
                                showTs(errMsg);
                            }
                        }) {
                        });
            }
        });

        btDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViseHttp.DOWNLOAD("dmfd/160_90_/t0177b9f09bbe34dc82.jpg?size=700x570")
                        .setRootName("")
                        .setDirName("")
                        .baseUrl("http://p0.qhimgs4.com/")
                        .setFileName("莲银aa.jpg")
                        .request(new ACallback<DownProgress>() {
                            @Override
                            public void onSuccess(DownProgress downProgress) {
                                if (downProgress == null) {
                                    return;
                                }
                                Log.i(ViseHttp.CONFIG().getTag(),"下载进度：down progress currentLength:" + downProgress.getDownloadSize() + ",totalLength:" + downProgress.getTotalSize());
                                if (downProgress.isDownComplete()) {
                                   showTs("下载提示"+"下载成功");
                                }
                            }

                            @Override
                            public void onFail(int errCode, String errMsg) {
                                Log.i(ViseHttp.CONFIG().getTag(),"down errorCode:" + errCode + ",errorMsg:" + errMsg);
                            }
                        });
            }
        });
    }
    private String getDiskCachePath(Context context) {
        String cachePath;
        if ((Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable())
                && context.getExternalCacheDir() != null) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return cachePath;
    }


    public void showTs(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void initHttpRequest() {
        ViseHttp.init(this,"http://6vdapi.hzyyd.top");
        ViseHttp.CONFIG().httpErroListener(new IBaseRequestErroLitener(){
            @Override
            public void onHttpErro(ApiException e) {

            }
        });
        ViseHttp.CONFIG().responseInfoListener(new HttpGlobalConfig.OnResponseInfoGetLitener() {
            @Override
            public <T> void onInfoGet(T data) {
                if(data instanceof AppModuleInfo){
                    AppModuleInfo moduleInfo= (AppModuleInfo) data;
                    showTs("响应码为："+moduleInfo.getCode());
                }
            }
        });
    }


}
