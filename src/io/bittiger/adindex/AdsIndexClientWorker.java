package io.bittiger.adindex;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

public class AdsIndexClientWorker extends Thread{
    private static final Logger logger = Logger.getLogger(AdsIndexClientWorker.class.getName());
    protected AdsSelectionResult result = null;
    private String adsIndexServer;
    private int adsIndexServerPortal;
    private List<io.bittiger.adindex.Query> queryList;
    public AdsIndexClientWorker(List<io.bittiger.adindex.Query> queryList, String adsIndexServer,int adsIndexServerPortal,AdsSelectionResult result) {
    	this.result = result;
    	this.queryList = queryList;
    	this.adsIndexServer = adsIndexServer;
    	this.adsIndexServerPortal = adsIndexServerPortal;
    }
    public void start()   {
    	io.bittiger.adindex.AdsIndexClient adsIndexClient = new io.bittiger.adindex.AdsIndexClient(adsIndexServer,adsIndexServerPortal);
    	//TODO : timeout and return partial list of ads
        List<io.bittiger.adindex.Ad> adsList = adsIndexClient.GetAds(queryList);
        result.add(adsList);
    }
}
