from urllib.request import urlopen
from bs4 import BeautifulSoup
import mysql.connector

url = "https://www.hockey-reference.com/leagues/NHL_2018_skaters-advanced.html"
page = urlopen(url)
parsed = BeautifulSoup(page, 'html.parser')

name = parsed.findAll("td", {"data-stat" : "player"})
age = parsed.findAll("td", {"data-stat" : "age"})
team = parsed.findAll("td", {"data-stat" : "team_id"})
pos = parsed.findAll("td", {"data-stat" : "pos"})
games_played = parsed.findAll("td", {"data-stat" : "games_played"})
corsi_for = parsed.findAll("td", {"data-stat" : "corsi_for"})
corsi_against = parsed.findAll("td", {"data-stat" : "corsi_against"})
corsi_pct = parsed.findAll("td", {"data-stat" : "corsi_pct"})
corsi_rel_pct = parsed.findAll("td", {"data-stat" : "corsi_rel_pct"})
fenwik_for = parsed.findAll("td", {"data-stat" : "fenwick_for"})
fenwik_against = parsed.findAll("td", {"data-stat" : "fenwick_against"})
fenwik_pct = parsed.findAll("td", {"data-stat" : "fenwick_pct"})
fenwik_pct_rel = parsed.findAll("td", {"data-stat" : "fenwick_rel_pct"})
on_ice_shot_pct = parsed.findAll("td", {"data-stat" : "on_ice_shot_pct"})
on_ice_sv_pct = parsed.findAll("td", {"data-stat" : "on_ice_sv_pct"})
pdo = parsed.findAll("td", {"data-stat" : "pdo"})
zs_offense_pct = parsed.findAll("td", {"data-stat" : "zs_offense_pct"})
zs_defense_pct = parsed.findAll("td", {"data-stat" : "zs_defense_pct"})
toi_pbp_per_60_all = parsed.findAll("td", {"data-stat" : "toi_pbp_per_60_all"})
toi_pbp_per_60_ev = parsed.findAll("td", {"data-stat" : "toi_pbp_per_60_ev"})
takeaways = parsed.findAll("td", {"data-stat" : "takeaways"})
giveaways = parsed.findAll("td", {"data-stat" : "giveaways"})
expected_plsmns = parsed.findAll("td", {"data-stat" : "expected_plsmns"})
total_shots_attempted_all = parsed.findAll("td", {"data-stat" : "total_shots_attempted_all"})
shot_thru_percentage = parsed.findAll("td", {"data-stat" : "shot_thru_percentage"})

teams_established = []
looplength = len(shot_thru_percentage)
loopcount=0
teamlen = 0
#connecting to database
user = "root"
password = "password"
host = "localhost"
database = "playerdb"
cnx = mysql.connector.connect(user=user, password=password, host=host, database=database)
cursor = cnx.cursor()
while loopcount < looplength:
    teamloc = 0
#    try:
#        teamloc = teams_established.index(team[loopcount].getText())
#    except:
#        teams_established.append(team[loopcount].getText())
#        teamlen = teamlen+1
#        teamloc = teamlen
#        teamvalue = (team[loopcount].getText(),)
#        addteam = ("INSERT INTO teams " "(name) " "VALUES (%s)")
#        cursor.execute(addteam, teamvalue)
#        cnx.commit()
    thrupercent = shot_thru_percentage[loopcount].getText()
    if thrupercent == '':
        thrupercent ='0'
    shotsattempt = total_shots_attempted_all[loopcount].getText()
    if shotsattempt == '':
        shotsattempt = '0'
    values = (name[loopcount].getText(), age[loopcount].getText(), team[loopcount].getText(), pos[loopcount].getText(), games_played[loopcount].getText(), corsi_for[loopcount].getText(), corsi_against[loopcount].getText(), corsi_pct[loopcount].getText(), corsi_rel_pct[loopcount].getText(), fenwik_for[loopcount].getText(), fenwik_against[loopcount].getText(), fenwik_pct[loopcount].getText(), fenwik_pct_rel[loopcount].getText(), on_ice_shot_pct[loopcount].getText(), on_ice_sv_pct[loopcount].getText(), pdo[loopcount].getText(), zs_offense_pct[loopcount].getText(), zs_defense_pct[loopcount].getText(), toi_pbp_per_60_all[loopcount].getText(), toi_pbp_per_60_ev[loopcount].getText(), takeaways[loopcount].getText(), giveaways[loopcount].getText(), expected_plsmns[loopcount].getText(), shotsattempt, thrupercent)
    addvalues = (
       "INSERT INTO players " "(name, age, team, pos, gp, CF, CA, CFpercent, CFpercentRel, FF, FA, FFpercent, FFpercentRel, oiSHpercent, oiSVpercent, PDO, oZSpercent, dZSpercent, TOI60, TOIEV, TK, GV, Eplusminus, Satt, Thrupercent) " "VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)")
    #print(addvalues, values)
    cursor.execute(addvalues, values)
    loopcount = loopcount+1
cnx.commit()
cursor.close()
cnx.close()