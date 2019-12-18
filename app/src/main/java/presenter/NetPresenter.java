package presenter;

import com.example.xiaoshixunlianxi.ListBeen;

import java.util.List;

import model.NetModel;
import view.NetView;

public class NetPresenter implements NetModel.CallBack {
    private NetView netView;
    private NetModel netModel;

    public NetPresenter(NetView netView) {
        this.netView = netView;
        this.netModel=new NetModel();
    }

    public void getData(){
        if (netModel!=null){
            netModel.getData(this);
        }
    }

    @Override
    public void setSueecss(List<ListBeen.ResultsBean> list) {
        if (netView!=null){
            netView.setData(list);
        }
    }

    @Override
    public void setFail(String str) {
        if (netView==null){
            netView.showToast(str);
        }
    }
}
