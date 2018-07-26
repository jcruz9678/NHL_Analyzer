package edu.wit.mobileapp.nhl_analyzer;

import java.util.ArrayList;

public class player {
    public String playername;
    public int age;
    public String team;
    public String pos;
    public int gp;
    public int CF;
    public int CA;
    public double CFpercent;
    public double CFpercentRel;
    public int FF;
    public int FA;
    public double FFpercent;
    public double FFpercentRel;
    public double oiSHpercent;
    public double oiSVpercent;
    public double PDO;
    public double oZSpercent;
    public double dZSpercent;
    public String TOI60;
    public String TOIEV;
    public int TK;
    public int GV;
    public double Eplusminus;
    public int Satt;
    public double thrupercent;

    public player(String pname, int page, String pteam, String ppos, int pgp, int pCF, int pCA, double pCFpercent, double pCFpercentRel, int pFF, int pFA, double pFFpercent, double pFFpercentRel, double poiSHpercent,
    double poiSVpercent, double pPDO, double poZSpercent, double pdZSpercent, String pTOI60, String pTOIEV, int pTK, int pGV, double pEplusminus, int pSatt, double pthrupercent){
        playername = pname;
        age = page;
        team = pteam;
        pos = ppos;
        gp = pgp;
        CF = pCF;
        CA = pCA;
        CFpercent = pCFpercent;
        CFpercentRel = pCFpercentRel;
        FF = pFF;
        FA = pFA;
        FFpercent = pFFpercent;
        FFpercentRel = pFFpercentRel;
        oiSHpercent = poiSHpercent;
        oiSVpercent = poiSVpercent;
        PDO = pPDO;
        oZSpercent = poZSpercent;
        dZSpercent = pdZSpercent;
        TOI60 = pTOI60;
        TOIEV = pTOIEV;
        TK = pTK;
        GV = pGV;
        Eplusminus = pEplusminus;
        Satt = pSatt;
        thrupercent = pthrupercent;
    }

}
